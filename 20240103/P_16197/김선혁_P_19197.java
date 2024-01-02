import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class node {
		int x1;
		int y1;
		int x2;
		int y2;
		node(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
	static int N;
	static int M;
	static int[][] arr;
	public static int[][][][] flag;
    public static Queue<node> q = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		flag = new int[N][M][N][M]; // 첨에 boolean했다가 몇번째 위치인지 확인하기 위해 int로
		
		boolean input = false; // 지금 입력되는 동전이
		// 첫번째인지 두번째인지 알기위해
		int x = 0;
		int y = 0;
		for(int i =0;i<N;i++) {
			String tmp = sc.next();
			for(int j =0;j<M;j++) {
				String a = tmp.substring(j,j+1);
				if(a.equals("#")) {
					// 벽을 만나면 1으로 기록
					arr[i][j] = 1;
				}
				else if(a.equals("o")) {
					if(input) {
						// 두번째입력이면 4개의 좌표를 큐에다가 추가하고
						// 방문처리
						int x2 = i;
						int y2 = j;
						q.add(new node(x,y,x2,y2));
						flag[x][y][x2][y2] = 1;
					}
					else {
						// 처음입력되는 경우면
						// 첫번째 동전의 좌표 저장
						x = i;
						y = j;
						input = true;
					}
				}
				// 나머지 경우는 생각안해도됨( 0 자동저장)
			}
		}// i for
		// 입력끝
		solve();
		
		
		
	}
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void solve() {
		// 여기선 이제 큐에 저장된 좌표를 꺼내서
		// 둘중에 하나의 동전만 떨어지게 되는 경우를
		// 직접 bfs를 통해서 돌려봄
		while(true) {
			node n = q.poll();
			for(int in = 0;in<4;in++) {
				int x1 = n.x1 + dx[in];
				int y1 = n.y1 + dy[in];
				int x2 = n.x2 + dx[in];
				int y2 = n.y2 + dy[in];
				// 4개의 좌표모두 각각 dx와 dy만큼 +해주고
				// 이제 범위벗어나는지 판단 가자
				
				// 범위가 둘중 하나만 벗어나야 함
				int tmp = 0;
				// 첫번째 동전이 범위 벗어나면
				// 일단 +1해주고 하나는 벗어난 상태
				if(x1<0 || x1>=N || y1<0 || y1>=M) {
					tmp++;
				}
				// 여기서 두번째 동전이 벗어나면
				// 둘다 벗어난 거라 x 
				if(x2<0 || x2>=N || y2<0 || y2>=M) {
					tmp++;
				}
//				System.out.println(tmp);
//				System.out.println(x1 +" "+y1 +" "+x2+" "+y2);
				// 만약 1이라면 횟수가 10넘는지확인 (넘으면 -1출력)
				if(tmp == 1) {
					// 방금전까지 10번이면 지금 11번째이므로 등호붙이고 
					//  10이상이면 -1출력
					if(flag[n.x1][n.y1][n.x2][n.y2] > 10) {
						System.out.println(-1);
					}
					else {
						// 10보다 작으면 +1해준체로 출력
						System.out.println(flag[n.x1][n.y1][n.x2][n.y2]);
					}
					System.exit(0);
				}
				// 둘다 벗어난거면 방문처리 필요 x
				// 추가로 그전의 좌표로 돌려줌
				else if(tmp ==2) {
					continue;
				}
				if(arr[x1][y1] ==1) {
					x1 = n.x1;
					y1 = n.y1;
				}
				if(arr[x2][y2] == 1) {
					x2 = n.x2;
					y2 = n.y2;
				}
				// 그리고 이제 현재의 동전 두개의 좌표 방문처리
				if(flag[x1][y1][x2][y2] == 0) {
					// 시간은 +1 해주고 큐에 추가
					flag[x1][y1][x2][y2] = flag[n.x1][n.y1][n.x2][n.y2]+1; 
					q.add(new node(x1,y1,x2,y2));
				}
				
			} // in for
			if(q.size()==0) {
				System.out.println(-1);
				return;
			}
			
		}
		
		
		
	}
	
	
}
