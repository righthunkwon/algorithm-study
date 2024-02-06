
import java.io.*;
import java.util.*;

// 2의 멱수의 합
public class P_2410 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] dp = new int[1000001];
		int ans = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < 1000001; i++) {
			if (i % 2 == 0) {
				dp[i] = (dp[i - 1] + dp[i / 2]) % 1000000000;
			} else {
				dp[i] = dp[i - 1];
			}
		}
		System.out.println(dp[n]);
	}
}
