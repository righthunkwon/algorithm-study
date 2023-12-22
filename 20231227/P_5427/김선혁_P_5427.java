import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static Queue<node> q;
	static boolean[][] flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			// 테스트 케이스만큼 반복
			M = sc.nextInt();
			N = sc.nextInt();
			arr = new int[N][M];
			q = new LinkedList<>();
			flag = new boolean[N][M];
			// 미리 다 초기화 시키기
			int x = 0;
			int y= 0;			
			for(int i=0;i<N;i++) {
				String tmp = sc.next();
				for(int j =0;j<M;j++) {
					String word = tmp.substring(j,j+1);
					// 현재 입력되는 것을 word로 쪼개서
					// 길이면 0, 벽이면 10, 불은 1
					// 벽
					if(word.equals("#")) {
						arr[i][j] = 10;
					}
					// 불
					else if(word.equals("*")) {
						arr[i][j] = 1;
						q.add(new node(i,j,false,0));
						flag[i][j] = true;
					}
					// 시작점
					// 불이 진행하는 곳도 못가기때문에 시작점은
					// 큐에 나중에 추가하여준다.
					else if(word.equals("@")) {
						x = i;
						y = j;
						flag[i][j] = true;
					}
					// 나머지는 0
				}
			}
			// 입력 끝
			q.add(new node(x,y,true,0));
			
			solve();

		}

	}
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void solve() {
		while(true) {
			node n = q.poll();
			// 큐에서 하나 꺼내서 이제 4방향 탐색 시작
			// 만약 벽끝이라면 게임 종료라 
			// 조건에 만족하는지 검사한다.
			if(n.human && ( n.x == N-1 || n.x ==0 || n.y == 0 || n.y ==M-1)) {
				System.out.println(n.dis+1);
				return;
			}
			for(int in = 0;in<4;in++) {
				int nx = n.x + dx[in];
				int ny = n.y + dy[in];
				// 범위를 벗어나면 continue
				if(nx >=N || nx==-1 || ny>=M || ny ==-1) {
					continue;
				}
				// 좌표가 0이고 방문x이면 
				// 불이든 사람이든 관계없이
				// 큐에 추가하고 true 처리하기
				if(arr[nx][ny] == 0 && !flag[nx][ny]) {
					q.add(new node(nx,ny,n.human,n.dis+1));
					flag[nx][ny] = true;
					if(!n.human) {
						arr[nx][ny]=1;
					}
				}
			} // for

			if(q.size()==0) {
				System.out.println("IMPOSSIBLE");
				return;
			}
		}


	}




	// x와 y좌표와 사람이 지나가는거면 human true 변수를 하나 만듬
	static class node{
		private int x;
		private int y;
		private boolean human;
		private int dis;
		public node(int x, int y, boolean human, int dis) {
			super();
			this.x = x;
			this.y = y;
			this.human = human;
			this.dis = dis;
		}
		public node(int x, int y, boolean human) {
			super();
			this.x = x;
			this.y = y;
			this.human = human;
		}	

	}
}	

