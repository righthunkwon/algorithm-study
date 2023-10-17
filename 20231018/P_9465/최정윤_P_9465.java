package baek;

import java.io.*;
import java.util.*;

public class Pro_9465_스티커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
            
			int[][] dp = new int[2][n];
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];
			for (int i = 1; i < n; i++) {
				if (i == 1) {
					dp[0][i] = dp[1][0] + sticker[0][i];
					dp[1][i] = dp[0][0] + sticker[1][i];
				} else {
					dp[0][i] = Math.max(Math.max(dp[1][i - 1], dp[1][i - 2]), dp[0][i - 2]) + sticker[0][i];
					dp[1][i] = Math.max(Math.max(dp[0][i - 1], dp[0][i - 2]), dp[1][i - 2]) + sticker[1][i];
				}
			}
			System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
		}
	}
}
