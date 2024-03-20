import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] a = br.readLine().toCharArray();
		char[] b = br.readLine().toCharArray();
		int[][] dp = new int[b.length][a.length];

		if (a[0] == b[0])
			dp[0][0] = 1;
		// 초기 세팅
		for (int i = 1; i < a.length; i++) {
			if (b[0] == a[i])
				dp[0][i] = 1;
			else {
				dp[0][i] = dp[0][i - 1];
			}
		}
		for (int i = 1; i < b.length; i++) {
			if (a[0] == b[i])
				dp[i][0] = 1;
			else {
				dp[i][0] = dp[i - 1][0];
			}
		}

		for (int i = 1; i < b.length; i++) {
			
			for (int j = 1; j < a.length; j++) {
				if (b[i] == a[j] ) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				
				} else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		System.out.println(dp[b.length - 1][a.length - 1]);
	}
}
