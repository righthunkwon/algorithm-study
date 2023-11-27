import java.util.ArrayList;
import java.util.Scanner;

public class Main {	
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] flag;
	static int ans;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		M = sc.nextInt(); 
		arr = new int[N][M];
		int x = 0;
		int y = 0;
		for(int i =0;i<N;i++) {
			String line = sc.next();
			for(int j=0;j<M;j++) {
				String tmp = line.substring(j,j+1);
				if(tmp.equals("O")) {
					arr[i][j] = 0;
				}
				else if(tmp.equals("X")) {
					arr[i][j] = 1;
				}
				else if(tmp.equals("I")) {
					x = i;
					y = j;
					// 시작좌표는 x, y로 지정해놓는다.
				}
				else {
					arr[i][j] = 10;
				}
				
			}
		}
//		for(int i =0;i<N;i++) {
//			for(int j =0;j<M;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		flag = new boolean[N][M];
		ans = 0;
		max = 0;
		// 입력 끝
		// 10이면 사람, 
		// 0이면 공간
		// 1이면 벽이다.\
		
		// 이제 시작
		solve(x,y);
		if(max==0) {
			System.out.println("TT");
		}
		else {
			System.out.println(max);
		}
		
		
	}
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void solve(int i, int j) {
			int x = i;
			int y = j;		
			// 일단 들어가있는 좌표를 꺼내서
			//dfs 가즈아 
			for(int in=0;in<4;in++) {
				int nx = x+dx[in];
				int ny = y+dy[in];
				if(nx<0 || ny<0 || nx>=N || ny>=M || arr[nx][ny] ==1 || flag[nx][ny]) {
					continue;
				}
				// 조건에 맞지않으면 바로 continue
				// 그게아니면 dfs 실행
				flag[nx][ny] = true;
				if(arr[nx][ny]==10) {
					max++;
				}
					solve(nx,ny);
			}
			
			
	}
		
	
}
