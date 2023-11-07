package _20231108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1103_게임 {
	static int N, M, ans, max;
	static char[][] arr;
	static int[][] dp;
	static boolean[][] visited;
	static boolean infinite;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		N = Integer.parseInt(s.split(" ")[0]);
		M = Integer.parseInt(s.split(" ")[1]);
		arr=new char[N][M];
		dp=new int[N][M];
		visited = new boolean[N][M];
		infinite=false;
		max=0; ans=0;
		for(int i=0;i<N;i++) {
			s = br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j]=s.charAt(j);
//				if(arr[i][j]=='H') arr[i][j]=-1;
//				else arr[i][j]=arr[i][j]-'0';
			}
		}//입력끝
//		System.out.println(Arrays.deepToString(arr));
		
		visited[0][0]=true;
		moving(0,0,1);
//		if(ans==-1) System.out.println(ans);			
		if(infinite) System.out.println(-1);			
		else System.out.println(max);

	}
	static void moving(int x, int y, int cnt) {
		if(cnt > max) {
			max = cnt;
		}
		dp[x][y]=cnt;
		for(int i=0;i<4;i++) {
			int nr = x + dr[i] * (arr[x][y]-'0');
			int nc = y + dc[i] * (arr[x][y]-'0');
			if(nr>=0 && nc>=0 && nr<N && nc<M && arr[nr][nc]!='H') {
				if(visited[nr][nc]) { // 방문했던 곳 다시 방문하면 무한루프, -1출력
//					ans = -1;
					infinite =true;
					return;
				}
				if(dp[nr][nc]>cnt) {
					continue;
				}
				visited[nr][nc]=true;
				moving(nr, nc, cnt+1);
				visited[nr][nc]=false;
				
			}
			continue;
		}
		
		
		
	}//moving

}
