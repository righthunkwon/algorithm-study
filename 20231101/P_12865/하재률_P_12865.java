package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// DP(Bottom-Up) 방식을 사용
public class BOJ_12865_평범한배낭 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] W = new int[N + 1]; // 무게
		int[] V = new int[N + 1]; // 가치
		int[][] dp = new int[N + 1][K + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				
				// i번째 무게를 더 담을 수 없는 경우
				if(j < W[i]) dp[i][j] = dp[i - 1][j];
				// i번째 무게를 담을 수 있는 경우
				else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
			}
		}
	}
}
