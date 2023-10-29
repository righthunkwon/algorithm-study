package baek;
import java.io.*;
import java.util.*;

public class Pro_12865_평범한배낭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N][K + 1];
		int[] W = new int[N];
		int[] V = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= K; j++) {
				if (i == 0) {
					if (j >= W[i])
						dp[i][j] = V[i];
				} else {
					if (j - W[i] >= 0)
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
					else
						dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[N - 1][K]);
	}
}
