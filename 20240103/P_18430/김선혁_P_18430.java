import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] flag;
	static int ans;
	static int sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
			
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				arr[i][j] =sc.nextInt();
			}
		}
		// 입력끝
		ans = 0 ;
		flag = new boolean[N][M];
		solve(0,0);
		System.out.println(ans);
	
	
	}
	
	static void solve(int cnt, int sum) {
		if(cnt == N * M) {
			// 모든 좌표 탐색이 끝나면
			// cnt는 자연스럽게 n*m의 값만큼 오게됨
			ans = Math.max(ans, sum);
			return;
		}
		// 하나씩 좌표 전진 
		// 0 0 -> 0 1 -> 0 2 -> 1 0 이런식
		int x = cnt / M;
		int y = cnt % M;
		
		// 먼저 현재의 좌표를 방문한적이 없으면
		if(!flag[x][y]) {
			// 4개의 부메랑 방향모두 탐색해서
			// 각각의 부메랑이 방문하지 않았으면 dfs 돌리고
			// 방문했으면 그냥 패스
			if(x-1>=0 && y-1>=0 && !flag[x-1][y] && !flag[x][y-1]) {
				flag[x-1][y] = true;
				flag[x][y-1] = true;
				flag[x][y] = true;
				// 모두 true로 바꾸고 dfs
				solve(cnt+1, sum+arr[x-1][y]+arr[x][y-1]+2*arr[x][y]);
				flag[x-1][y] = false;
				flag[x][y-1] = false;
				flag[x][y] = false;		
			}
			if(x+1 <N && y-1>=0 && !flag[x+1][y] && !flag[x][y-1]) {
				flag[x+1][y] = true;
				flag[x][y-1] = true;
				flag[x][y] = true;
				// 모두 true로 바꾸고 dfs
				solve(cnt+1, sum+arr[x+1][y]+arr[x][y-1]+2*arr[x][y]);
				flag[x+1][y] = false;
				flag[x][y-1] = false;
				flag[x][y] = false;		
			}
			if(x-1>=0 && y+1<M && !flag[x-1][y] && !flag[x][y+1]) {
				flag[x-1][y] = true;
				flag[x][y+1] = true;
				flag[x][y] = true;
				// 모두 true로 바꾸고 dfs
				solve(cnt+1, sum+arr[x-1][y]+arr[x][y+1]+2*arr[x][y]);
				flag[x-1][y] = false;
				flag[x][y+1] = false;
				flag[x][y] = false;		
			}
			if(x+1 <N && y+1<M && !flag[x+1][y] && !flag[x][y+1]) {
				flag[x+1][y] = true;
				flag[x][y+1] = true;
				flag[x][y] = true;
				// 모두 true로 바꾸고 dfs
				solve(cnt+1, sum+arr[x+1][y]+arr[x][y+1]+2*arr[x][y]);
				flag[x+1][y] = false;
				flag[x][y+1] = false;
				flag[x][y] = false;
			}
		}
		// 모든 위치를 탐색했을 때 
		// 현재 좌표는 다 검사했으면
		// cnt+1을 진행
		solve(cnt+1 , sum);
		
	}
	
}
