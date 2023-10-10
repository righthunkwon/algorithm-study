import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static class pos{
		int x;
		int y;
		int dis;
		boolean wall;
		public pos(int x, int y, int dis,boolean wall) {
			super();
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.wall = wall;
		}

	}
	static int N;
	static int M;
	static int[][] arr;
	static boolean[] flag;
	static Queue<pos> q;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			String tmp = sc.next();
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(tmp.substring(j,j+1));
			}
		}
		q = new LinkedList<>();
		min = 987654231;
		bfs();
		if(min==987654231) min = -1;
		System.out.println(min);

	}



	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void bfs() {
		q.add(new pos(0,0,1,false));
		// 일단 0,0을 넣고 시작
		// boolean타입도 설정
		boolean[][][] flag = new boolean[2][N][M]; // 방문했는지 
		// (2번째항은 벽을 깼을 경우의 경로)
		while(true) {
			pos p = q.poll();
			int x =p.x;
			int y =p.y;
			// 현재 도착지점에 도착했을경우
			// 지금의 거리값과 min값을 비교하여
			// 더 작은 값으로 갱신
			if(x==N-1 && y==M-1) {
				min = Math.min(min, p.dis);
				return;
			}
			// 현재 거리가 이미 min을
			// 넘어섰으면 그냥 break
			if(p.dis>=min) {
				return;
			}
			for(int in=0;in<4;in++) {
				int nx = x+dx[in];
				int ny = y+dy[in];
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
//					System.out.println(p.x+" "+p.y+" "+p.wall);
					if(arr[nx][ny]==0) {
						// 일단 0인경우 벽을 뚫었는지 안뚫었는지 판단해야함
						// 우선 향하는 곳이 길이고, 벽을 뚫었는지 유무에  따라
						// 뚫었으면 그냥 패스해야하고
						// 뚫지 않았으면 벽을 뚫고 간다.
						if (!p.wall) { 
							// 벽을 뚫은 경우 
							// 그냥 끝낸다.
							if (flag[0][nx][ny]) {
								continue; 
							}
							// 아직 방문하지 않은 곳이면 방문처리하고
							// 큐에 추가
							flag[0][nx][ny] = true; 
							q.add(new pos(nx, ny, p.dis+1, false));
						} 
						else {
							// 현재 벽을 뚫은 상태라면 
							// 벽을 뚫은 상태로 방문한 것이면 continue로 패스하고
							// 목적지가 아직 방문하지 않은 곳이면  방문처리
							if (flag[1][nx][ny]) continue; 
							flag[1][nx][ny] = true; // 벽 부순 방문처리
							q.add(new pos(nx, ny, p.dis+1, true));
						}
					}			
					// 목적지가 벽이고 벽을 뚫지 않았다면
					// 큐에추가하고 벽을 뚫은 것으로 간주
					else if(arr[nx][ny] ==1 && !p.wall) {
						q.add(new pos(nx,ny,p.dis+1,true));
						flag[1][nx][ny]= true;
					}
				}
			}

			if(q.size()==0) {
				return; // size가 0이면 break
			}
		}



	}
}
