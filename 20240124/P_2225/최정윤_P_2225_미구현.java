
import java.io.*;
import java.util.*;

public class Pro_2225_합분해dp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		long[][] dp = new long[K + 1][N + 1];
			for (int i = 1; i < K + 1; i++) {
				for (int j = 0; j < N + 1; j++) {
				if (i == 1 || j == 0)
					dp[i][j] = 1;
				else {
					for (int k = 0; k <= j; k++) {
						dp[i][j] += dp[i-1][j-k];
					}
				}
			}
		}
		System.out.println(dp[K][N] % 1000000000);
	}
}
