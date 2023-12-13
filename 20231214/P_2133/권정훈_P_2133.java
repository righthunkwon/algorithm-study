package level_23_dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 타일 채우기
// n이 짝수일 때만 처리 가능
// dp는 열심히 그림 그리면서 규칙을 찾는 게 빠르다
public class P_2133 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];

		// 예외처리
		if (n % 2 != 0) {
			System.out.println(0);
			return;
		}

		// 초기값 세팅
		dp[0] = 1; // 아무것도 채우지 않는 경우의 수
		dp[1] = 0;
		dp[2] = 3;

		// dp
		for (int i = 4; i <= n; i += 2) {
			dp[i] = 3 * dp[i - 2];
			for (int j = i - 4; j >= 0; j -= 2) {
				dp[i] += 2 * dp[j];
			}
		}

		// 정답 출력
		System.out.println(dp[n]);
	}
}
