package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 위상정렬을 사용해야 한다.
// 근데 dp로도 풀 수 있을거같아요 ?
public class BOJ_2056_작업 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N];
		
		int res = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken()); // 걸리는 시간
			int pre = Integer.parseInt(st.nextToken()); // 선행 작업 개수
			
			dp[i] = time;
			
			// 선행 작업들을 다 끝마친 가장 긴 시간으로 업데이트
			for(int j = 0; j < pre; j++) {
				int input = Integer.parseInt(st.nextToken());
				dp[i] = dp[i] > dp[input-1] + time ? dp[i] : dp[input-1] + time;
			}
			
			res = res > dp[i] ? res : dp[i];
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(res);
		
	}
}
