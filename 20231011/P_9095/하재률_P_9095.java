package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_123더하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine()); // 1 ~ 10
			// n=5 정도까지 잘 적어보면.. 아래의 점화식을 도출 가능
			// dp[n] = dn[n-1] + dp[n-2] + dp[n-3]
			int[] dp = new int[11]; // n이 1 ~ 10 까지니까
			dp[1] = 1; dp[2] = 2; dp[3] = 4;
			for(int i = 4; i <= n; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			System.out.println(dp[n]);
		}
	}
}
