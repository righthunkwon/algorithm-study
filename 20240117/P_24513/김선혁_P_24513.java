import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static Queue<node> q;
	static int[][] flag;
	static class node{
		int x;
		int y;
		int cnt;
		boolean one; // true면 1번에 감염
		public node(int x, int y, int cnt, boolean one) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.one = one;
		}
	}
	static int ans1;
	static int ans2;
	static int ans3;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		q = new LinkedList<node>();
		flag = new int[N][M];
		// 1번에 감염된 좌표를 큐에다 넣고 그 좌표를 중심으로
		// 만약 주변에 2번에 감염된게 있으면 3번으로 값을 넣음
		// 없으면 그냥 큐에 추가
		ans1 = 0;
		ans2 = 0;
		ans3 = 0;

		for(int i = 0;i<N;i++) {
			for(int j=0;j<M;j++){
				arr[i][j] = sc.nextInt();
				// 1번애들 만나면 true로 큐에다가 추가
				// ans1 ++하고 1값 넣기
				if(arr[i][j] ==1) {
					q.add(new node(i,j,1,true));
					ans1 ++;
					flag[i][j] = 1;
				}
				// 2번바이러스도 1번처럼 하기
				else if(arr[i][j] ==2) {
					q.add(new node(i,j,1,false));
					ans2++;
					flag[i][j] = 1;
				}
			}
		}
		// 입력 끝
		solve();
		System.out.println(ans1+" "+ans2+" "+ans3);




	}
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void solve() {
		while(true) {
			if(q.size()==0) {
				break;
			}
			node n = q.poll();
			for(int in = 0 ;in<4;in++) {
				int x = n.x + dx[in];
				int y = n.y + dy[in];
				// 일단 범위 벗어나면 continue;
				if(x>=N || x<0 || y>=M || y<0 || arr[x][y] !=0) {
					continue;
				}
				// 1. 1번 바이러스
				// 2. 2번바이러스 
				if(n.one) {
					// 만약 가는 위치에서
					// 주변에 2번이 있는 경우와 없는경우
					// 있는 경우는 false고 cnt가 같으면 3번에 +
					boolean tmp = false;
					for(int index= 0;index<4;index++) {
						int nx = x+dx[index];
						int ny = y+dy[index];
						// 범위 먼저 확인
						if(nx>=N || nx<0 || ny>=M || ny<0) {
							continue;
						}
						// 같은 시간에 2로 변할 애들
						if(arr[nx][ny]==2 && n.cnt == flag[nx][ny]) {
							arr[x][y] =3;
							ans3 ++;
							flag[x][y] = n.cnt+1;
							tmp = true;
							break;
						}
					}
					// 주변에 2가 없는경우
					if(!tmp) {
						arr[x][y] = 1;
						flag[x][y] = n.cnt+1;
						q.add(new node(x,y,n.cnt+1,true));
						ans1 ++;
					}
				}
				//2번 바이러스도 1번처럼
				// 퍼져나갈 곳의 좌표에서
				// 큐로한번 더 확인해서
				// 같은시간에 1인애들이 있으면
				// 3으로 갱신 
				else {
					boolean tmp = false;
					for(int index= 0;index<4;index++) {
						int nx = x+dx[index];
						int ny = y+dy[index];
						// 범위 먼저 확인
						if(nx>=N || nx<0 || ny>=M || ny<0) {
							continue;
						}
						// 같은 시간에 1로 변할 애들
						if(arr[nx][ny]==1 && n.cnt == flag[nx][ny]) {
							arr[x][y] =3;
							ans3 ++;
							flag[x][y] = n.cnt+1;
							tmp = true;
							break;
						}
					}
					if(!tmp) {
						arr[x][y] = 2;
						flag[x][y] = n.cnt+1;
						q.add(new node(x,y,n.cnt+1,false));
						ans2++;
					}
				}
			}


		}




	}

}
