package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465_스티커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][N];
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}// 입력 완

			// 왼쪽 대각선 값과 나를 더한 값, 같은 low의 바로 전 값 중 큰것을 저장.

			int[][] dp = new int[2][N+1]; // -1 인덱스를 참고해야 하기 때문에 N+1 크기의 dp테이블을 만들어요
			for(int j = 1; j <= N; j++) { // 왼쪽부터 채워가야 하기 때문에
				for(int i = 0; i < 2; i++) { // 이렇게 순회하자
					if(i == 0) dp[i][j] = dp[1][j-1] + arr[i][j-1] > dp[i][j-1] ? dp[1][j-1] + arr[i][j-1] : dp[i][j-1];
					else dp[i][j] = dp[0][j-1] + arr[i][j-1] > dp[i][j-1] ? dp[0][j-1] + arr[i][j-1] : dp[i][j-1];
				}
			}
			int res = dp[0][N] > dp[1][N] ? dp[0][N] : dp[1][N];
			System.out.println(res);
		}
	}
}