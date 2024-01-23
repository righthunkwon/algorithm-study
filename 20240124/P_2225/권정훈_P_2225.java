package level_23_dynamic_programming;

import java.io.*;
import java.util.*;

// 합분해
// 문제를 잘 읽자(0도 더해줘야 했다)
// 특별히 고민 안 해도 점화식 세워서 열심히 규칙 찾으면 금방 푸는 문제(성실하자)

// dp 그래프 구조
// 1 2 3
// 1 3 6
// 1 4 10
// 1 5 15
// 1 6 21
public class P_2225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int dp[][] = new int[N + 1][K + 1];

		// 초기화
		for (int i = 0; i <= N; i++) {
			dp[i][1] = 1;
		}
		for (int i = 0; i <= K; i++) {
			dp[1][i] = i;
		}
		
		// dp
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= K; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
			}
		}
		System.out.println(dp[N][K]);
	}
}
