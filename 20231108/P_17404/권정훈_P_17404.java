package dp;

import java.util.Scanner;

// RGB 거리 2
// 첫번째 집을 칠한 뒤 마지막 집과 일치하는지를 비교한다.
public class P_17404 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n + 1][n + 1]; // 비용 배열
		int[][] dp = new int[n + 1][3]; // dp 배열(0:빨강, 1:초록, 2:파랑)
		int[] min = new int[n + 1]; // 첫 집의 색에 따라 나오는 최소비용

		// 비용 배열 요소 입력
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		// dp(누적합)
		// 먼저 첫 번째 집에 i를 색칠
		for (int i = 0; i < 3; i++) { 
			// 색들을 준비
			for (int j = 0; j < 3; j++) { 
				
				// 첫 집일 경우
				// 예정대로 첫 집에 i색을 칠함
				if (i == j) {
					dp[1][j] = arr[1][j]; 
				} 
				
				// 첫 집이 아닐 경우
				// 나머지 색은 색칠하지 않기 위해 최댓값을 넘어가는 1001로 설정
				else {
					dp[1][j] = 1001; 
				}
			}

			// 이후 두 번째 집부터 차례대로 색칠
			for (int j = 2; j <= n; j++) {
				dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
				dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
				dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2];
				
				// 마지막 집일 때
				// 마지막 집과 첫 집의 색은 달라야 한다
				if (j == n) { 
					if (i == 0) { // 첫집이 빨간색일 경우 마지막은 초록색 혹은 파란색 중 최소
						min[i] = Math.min(dp[n][1], dp[n][2]);
					}
					if (i == 1) { // 첫집이 초록색일 경우 마지막은 빨간색 혹은 파란색 중 최소
						min[i] = Math.min(dp[n][0], dp[n][2]);
					}
					if (i == 2) { // 첫집이 파란색일 경우 마지막은 초록색 혹은 빨간색 중 최소
						min[i] = Math.min(dp[n][0], dp[n][1]);
					}
				}
			}
		}

		// 전체의 최소값을 구한 뒤 정답 출력
		System.out.print(Math.min(min[0], Math.min(min[1], min[2])));
	}

}
