
import java.io.*;
import java.util.*;

// 앱
// 해당 비용만큼 썼을 때 최대로 줄일 수 있는 메모리 크기
public class P_7579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] memory = new int[N];
		int[] cost = new int[N];
		int[] dp = new int[10001];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		// 각 앱을 순회하며 판단
		for (int i = 0; i < N; i++) {
			for (int j = 10000; j >= cost[i]; j--) {
				// 이미 저장된 값과 비교하여 큰 값으로 갱신
				dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
			}
		}

		// 제일 먼저 나오는 값이 비용이 제일 작으므로 정답 
		for (int i = 0; i < 10001; i++) {
			if (dp[i] >= M) {
				System.out.println(i);
				return;
			}
		}

	}
}
