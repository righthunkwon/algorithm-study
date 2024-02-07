import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[N + 1];
		int num = 4;
		for (int i = 1; i < N + 1; i++) {
			// 2의 제곱수들만 dp[i]+1하면 되는데 ,,,,
			if (i == 1 || i == 2) {
				dp[i] = i;
				continue;
			}
			if (i % 2 == 1) {
				dp[i] = dp[i - 1];
			} else {
				dp[i] = (dp[i - 1] * 2 - (i / 2 - 1)) % 1000000000;
				if (i == num) {
					dp[i]++;
					num *= 2;
				}
			}
		}
		System.out.println(dp[N]);
	}
}
