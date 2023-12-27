package level_23_dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 작업
public class P_2056_dp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine()); // 작업의 수
		int[] dp = new int[n + 1]; // 각 작업을 수행하는 데 걸린 시간을 저장할 배열

		int ans = 0; // 걸린 시간
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken()); // 해당 작업에 걸리는 시간
			int cnt = Integer.parseInt(st.nextToken()); // 선행 작업들의 개수

			dp[i] = time; // 해당 작업 시간 대입
			
			// 선행 작업 중 긴 시간이 소요되는 작업시간 갱신
			for (int j = 0; j < cnt; j++) {
				int tmp = Integer.parseInt(st.nextToken());

				// 가장 긴 수행 시간으로 설정해야 함.
				dp[i] = Math.max(dp[i], dp[tmp] + time);
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}
