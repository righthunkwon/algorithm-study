package baek;

import java.io.*;
import java.util.*;

public class Pro_17404_RGB거리2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[N][3];
		int MaxValue = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		// 첫 집 지정 ㄱㄱ
		// 1.R
		dp[1][0] = MaxValue;// 선택되지 않을 어마무시하게 큰값으로 바꾸기
		dp[1][1] =cost[0][0] + cost[1][1];
		dp[1][2] =cost[0][0]+ cost[1][2];
		for (int i = 2; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + cost[i][2];
		}
		// 마지막에 GB를 선택한 것만
		min = Math.min(Math.min(min, dp[N - 1][1]), dp[N - 1][2]);

		// 1.G
		dp[1][1] = MaxValue;// 선택되지 않을 어마무시하게 큰값으로 바꾸기
		dp[1][0] = cost[0][1] + cost[1][0];
		dp[1][2] = cost[0][1] + cost[1][2];
		for (int i = 2; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + cost[i][2];
		}
		// 마지막에 RB를 선택한 것만
		min = Math.min(Math.min(min, dp[N - 1][0]), dp[N - 1][2]);

		// 1.B
		dp[1][2] = MaxValue;// 선택되지 않을 어마무시하게 큰값으로 바꾸기
		dp[1][0] = cost[0][2] + cost[1][0];
		dp[1][1] = cost[0][2] + cost[1][1];
		for (int i = 2; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + cost[i][2];
		}
		// 마지막에 RG를 선택한 것만
		min = Math.min(Math.min(min, dp[N - 1][0]), dp[N - 1][1]);
		
		System.out.println(min);
	}
}
