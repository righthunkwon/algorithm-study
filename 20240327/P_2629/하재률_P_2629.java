package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2629_양팔저울 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] chu = new int[n];
		for (int i = 0; i < n; i++) {
			chu[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] ball = new int[m];
		for (int i = 0; i < m; i++)
			ball[i] = Integer.parseInt(st.nextToken());

		boolean[][] dp = new boolean[n + 1][40001];

		dp[0][0] = true;

		for (int i = 1; i <= n; i++) {
			int w = chu[i - 1];
			for (int j = 0; j <= 40000; j++) {
				if (dp[i - 1][j]) {
					dp[i][j] = true;
					if (j + w <= 40000)
						dp[i][j + w] = true; // 더하기
					if (Math.abs(j - w) >= 0)
						dp[i][Math.abs(j - w)] = true; // 빼기
				}
			}
		}
//		for(int i = 0; i <= n; i++) {
//			for(int j = 0; j < sum+1; j++) {
//				System.out.print((dp[i][j] ? 1 : 0) + " ");
//			}
//			System.out.println();
//		}

		for (int i = 0; i < m; i++) {
			System.out.print(dp[n][ball[i]] ? "Y " : "N ");
		}
	}
}
