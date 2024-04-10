package level_23_dynamic_programming;

import java.io.*;
import java.util.*;

// 돌다리 건너기
public class P_2602 {
	public static final int DEVIL = 0, ANGEL = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String ms = br.readLine(); // 마법 두루마리
		String de = br.readLine(); // 악마 돌다리
		String an = br.readLine(); // 천사 돌다리
		int lenS = ms.length(); // 두루마리 길이
		int lenB = de.length(); // 돌다리 길이

		int[][][] dp = new int[2][lenB][lenS];

		// 초기값
		if (de.charAt(0) == ms.charAt(0)) dp[DEVIL][0][0] = 1;
		if (an.charAt(0) == ms.charAt(0)) dp[ANGEL][0][0] = 1;

		// dp
		for (int i = 1; i < lenB; i++) {
			if (an.charAt(i) == ms.charAt(0)) {
				dp[ANGEL][i][0] = dp[ANGEL][i - 1][0] + 1;
			} else {
				dp[ANGEL][i][0] = dp[ANGEL][i - 1][0];
			}
			for (int j = 1; j < lenS; j++) {
				if (an.charAt(i) == ms.charAt(j)) {
					dp[ANGEL][i][j] = dp[ANGEL][i - 1][j] + dp[DEVIL][i - 1][j - 1];
				} else {
					dp[ANGEL][i][j] = dp[ANGEL][i - 1][j];
				}
			}

			if (de.charAt(i) == ms.charAt(0)) {
				dp[DEVIL][i][0] = dp[DEVIL][i - 1][0] + 1;
			} else {
				dp[DEVIL][i][0] = dp[DEVIL][i - 1][0];
			}
			for (int j = 1; j < lenS; j++) {
				if (de.charAt(i) == ms.charAt(j)) {
					dp[DEVIL][i][j] = dp[DEVIL][i - 1][j] + dp[ANGEL][i - 1][j - 1];
				} else {
					dp[DEVIL][i][j] = dp[DEVIL][i - 1][j];
				}
			}
		}

		System.out.println(dp[DEVIL][lenB - 1][lenS - 1] + dp[ANGEL][lenB - 1][lenS - 1]);
	}
}
