package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2225_합분해 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int billion = 1000000000;
		
		// K == 0 일때 모두 0
		// N == 0 && K > 0 일때 모두 1
		// 위에 왼쪽 더하기
		
		int[][] dp = new int[K+1][N+1];
		for(int i = 1; i < K+1; i++) dp[i][0] = 1;
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < K+1; j++) {
				dp[j][i] = (dp[j-1][i]+dp[j][i-1]) % billion;
			}
		}
		
		System.out.println(dp[K][N]);
	}
}
