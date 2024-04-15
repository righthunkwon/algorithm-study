import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class node implements Comparable<node> { 
		int x;
		int y;
		int cnt;
		public node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Main.node o) {
			return this.cnt - o.cnt;
		}
	}
	static int N;
	static int[][] arr;
	static int[][] array;
	static PriorityQueue<node> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while(true) {
			N = sc.nextInt();
			if(N==0) {
				System.exit(0);
			}
			// 잃을 수 있는 최소 금액 ==> 
			// 다이스트라로 N-1지점까지의 최소값을 구하면됨
			arr = new int[N][N];
			for(int i = 0 ; i < N ; i++ ) {
				for(int j = 0 ;j<N;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// 입력 끝

			// 이제 모든 지점을 최대점으로 도배하고 
			// 시작점부터 bfs통해서 갱신
			array = new int[N][N];
			for(int i = 0 ; i < N ; i++ ) {
				for(int j = 0 ;j<N;j++) {
					array[i][j] = 987654321;
				}
			}
			solve();
			System.out.println("Problem "+tc+": "+array[N-1][N-1]);
			tc++;
		}
	}
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,-1,1};
	static void solve() {
		q = new PriorityQueue<Main.node>();
		q.add(new node(0,0,arr[0][0]));
		boolean[][] flag = new boolean[N][N];
		// 큐에 0,0을 넣어놓고 방문처리 배열 선언
		while(true) { 
			if(q.size()==0) {
				break;
			}
			node n = q.poll();
			if(n.cnt > array[n.x][n.y]) {
				continue;
			}
			//현재 저장된 값보다 크다면 continue
			
			array[n.x][n.y] = n.cnt; 
			
			for(int in = 0; in < 4;in++) {
				int x = n.x + dx[in];
				int y = n.y + dy[in];
				if(x >=N || y >=N || x <0 || y <0 || flag[x][y]) {
					continue;
				}
				// 범위를 확인하고
				// 현재의 값이 저장되어 있는 값보다 적다면
				// true바꿔주고 최소값으로 갱신
				if(array[x][y] > n.cnt + arr[x][y]) {
					flag[x][y] = true;
					array[x][y] = n.cnt + arr[x][y];
					q.add(new node(x,y,array[x][y]));
				}
			}
			
		}
		
		

	}

}
