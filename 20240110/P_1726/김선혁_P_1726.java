import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class robot {
		int x, y, dir, cnt, move;
		public robot(int x, int y, int dir, int cnt, int move) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
			this.move = move;
		}
		// move는 이전 움직임이 똑같다면 +1해줄거임 
		// 3번까지는 cnt 1로 치기때문
	}
	static int N;
	static int M;
	static int[][] arr;
	static int ans;
	static int ansx;
	static int ansy;
	static int ansdir;
	static int[][] flag;
	static Queue<robot> q = new LinkedList<robot>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 N = sc.nextInt();
		 M = sc.nextInt();
		 arr = new int[N][M];
		 flag = new int[N][M];
		for(int i =0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
				flag[i][j] = Integer.MAX_VALUE;
			}
		}
		// 입력끝
		int x = sc.nextInt()-1;
		int y = sc.nextInt()-1;
		int dir = sc.nextInt();
		q.add(new robot(x,y,dir,0,3));
		ansx = sc.nextInt()-1;
		ansy = sc.nextInt()-1;
		ansdir = sc.nextInt();
		// 현재 시작하는 위치를
		// 큐에다가 추가하고 
		// 방문처리해줌
		ans = 987654321;
		solve();
//		for(int i =0;i<N;i++) {
//			for(int j =0;j<M;j++) {
//				System.out.print(flag[i][j]+" ");
//			}
//			System.out.println();
//		}
	
		System.out.println(ans);
	}
	static int[] dx = {0,0,0,1,-1};
	static int[] dy = {0,1,-1,0,0};
	// 순서대로 동 서 남 북
	public static void solve() {
		while(true) {
			if(q.size()==0) {
				break;
			}
			robot r = q.poll();
			// r은 현재 위치
//			System.out.println(r.x+" "+r.y+" "+r.cnt+" "+r.dir);
			// 정답의 위치인지 확인
			if(r.x==ansx && ansy == r.y) {
				if(ansdir != r.dir) {
					ans =Math.min(ans, r.cnt + dir(ansdir, r.dir));
				}
				else {
					ans = Math.min(ans, r.cnt);
				}
				continue;
			}
			// 4방향 탐색으로 0이 있는 위치로 큐에다가 추가함
			for(int in =1;in<5;in++) {
				int nx = r.x+dx[in];
				int ny = r.y+dy[in];
				// 범위 탐색 + 방문 안했고 + 갈수있는지
				if(nx>=0 && ny >=0 && nx<N && ny<M && arr[nx][ny]==0) {
					// 방향이 같을 때 이전에 몇번왔는지에 따라 큐에 따로 추가함
//					System.out.println(nx+" "+ny+" "+r.cnt+" "+r.dir+" "+in);
					if(r.dir == in && flag[nx][ny]>=r.cnt) {
						// 만약 2번이하로 같은 방향이면 cnt 그대로
						if(r.move<2) {
							q.add(new robot(nx,ny,in,r.cnt,r.move+1));
							flag[nx][ny]= r.cnt; 
						}
						// 3번이상 같은 방향 이동했으면 cnt+1을 해준다
						else {
							q.add(new robot(nx,ny,in,r.cnt+1,0));
							flag[nx][ny]= r.cnt+1; 
						}
					}
					// 방향이 다르면 방향만큼 cnt도 +해줘야함
					else if(r.dir != in && flag[nx][ny]>r.cnt) {
						int tmp = dir(r.dir, in);
						q.add(new robot(nx,ny,in,r.cnt+tmp+1,0));
						flag[nx][ny]= r.cnt+1+tmp; 
					}
				}
			}
		}
		
	}
	// 현재 방향과 가야하는 방향의 차이 구해주는 메서드
	public static int dir(int a, int b) {
		if(a == 1) {
			if(b == 2) {
				return 2;
			}
			return 1;
		}
		else if(a== 2) {
			if(b==1) {
				return 2;
			}
			return 1;
		}
		else if (a ==3) {
			if(b==4) {
				return 2;
			}
			return 1;
		}
		else {
			if(b==3) {
				return 2;
			}
			return 1;
		}
		
	}
	
	
}

