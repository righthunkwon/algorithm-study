package level_23_dynamic_programming_easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스티커
// bottom-up
// 작은 부분해의 최적은 큰 해의 최적
// 영향을 미치는 범위는 2*3칸이라고 생각

// O의 입장에서 최대값에 영향을 미치는 요소
// 어디에서 왔을 때 현재 값이 최댓값이 될지를 파악

// 	-	-	O	-	-	
// 	?	?	-	-	-

// 	?	?	-	-	-
//	-	-	O	-	-

public class P_9465 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n + 1];
			int[][] dp = new int[2][n + 1];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 초기값(n=1)
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            // 점화식
            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}
}
