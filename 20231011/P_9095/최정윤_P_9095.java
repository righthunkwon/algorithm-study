package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro_9095_123더하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			dp = new int[n + 1];
			dp(n);
			System.out.println(dp[n]);
		}
	}

	static int[] dp;

	private static void dp(int n) {
		for (int i = 1; i <= n; i++) {
			if (i == 1)
				dp[i] = 1;
			else if (i == 2)
				dp[i] = 2;
			else if (i == 3)
				dp[i] = 4;
			else {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
				//1원 더하기 +2원더하기 +3원더하기
			}
		}
	}

}
