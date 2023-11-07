package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17404_RGB거리2 {
	static final int MAX = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		// 0: 빨 1: 초 2: 파
		int[][] arr = new int[N][3];
		int[][] dp = new int[N][3];
		int res = MAX;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < 3; i++) {
			// 첫번째 집을 색칠했으면 나머지 집은 선택되지 않도록 큰 값
			if(i == 0) {
				dp[0][0] = arr[0][0];
				dp[0][1] = MAX;
				dp[0][2] = MAX;
			} else if(i == 1) {
				dp[0][0] = MAX;
				dp[0][1] = arr[0][1];
				dp[0][2] = MAX;
			} else {
				dp[0][0] = MAX;
				dp[0][1] = MAX;
				dp[0][2] = arr[0][2];
			}
			// 다른 색으로 칠하는 경우 모두 저장
			for(int j = 1; j < N; j++) {
				dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + arr[j][0];
				dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + arr[j][1];
				dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + arr[j][2];
				// 마지막 집은 첫 집과 같은 색 X
				if(j == N-1) dp[j][i] = MAX;
			}
			// 최소값 구해주기
			for(int j = 0; j < 3; j++) {
				res = res < dp[N-1][j] ? res : dp[N-1][j];
			}
			
//			for(int j = 0; j < N; j++) {
//				for(int k = 0; k < 3; k++) {
//					System.out.print(dp[j][k] + " ");
//				}
//				System.out.println();
//			}
		}
		
		System.out.println(res);
		
		
		
	}
}
