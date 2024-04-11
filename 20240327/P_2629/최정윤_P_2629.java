package study_240410;

import java.io.*;
import java.util.*;

public class Pro_2629_양팔저울 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] w = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			w[i] = Integer.parseInt(st.nextToken());
		}

		// 그 구슬들의 합, 구슬들의 차, 가능
		boolean[][] dp = new boolean[40001][N];

		int max = w[0];
		dp[w[0]][0] = true;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= max; j++) {
				if (dp[j][i - 1]) {//구슬이 있다면
					max = Math.max(j + w[i], max);
					dp[j][i] = true; //본인
					dp[j + w[i]][i] = true; //본인과 있는 구슬 합
					dp[Math.abs(j - w[i])][i] = true; //본인과 있는 구슬 차
				}
			}
			dp[w[i]][i] = true;
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			int marble = Integer.parseInt(st.nextToken());
			if (dp[marble][N - 1])
				System.out.println("Y");
			else
				System.out.println("N");
		} // 입력 끝
	}
}
