
import java.io.*;

public class Pro_2579_계단오르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int stair = Integer.parseInt(br.readLine());
		int[] score = new int[stair];
		for (int i = 0; i < stair; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		int[][] dp = new int[stair][2];// 바로 전꺼 밟고, 전꺼 안밟고
		for (int i = 0; i < stair; i++) {
			if (i == 0) {
				dp[i][0] = score[i];
				dp[i][1] = score[i];
			} else if (i == 1) {
				dp[i][0] = score[i - 1] + score[i];
				dp[i][1] = score[i];
			} else if (i > 1) {
				dp[i][0] = dp[i - 1][1] + score[i];// 바로 전꺼 밟으면 전 계단은 무조건 전전꺼 안밟아야함
				dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + score[i];// 전꺼 안밟았을 때는 전전계단의 점수 최대값 +현재 계단 점수
			}
		}

		System.out.println(Math.max(dp[stair - 1][0], dp[stair - 1][1]));
	}
}
