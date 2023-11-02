package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Q17404_RGB거리2 {

	static int N;
	static int[][] arr;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];

		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력끝

		dp(0);
		dp(1);
		dp(2);
		
		System.out.println(ans);

	}

	public static void dp(int a) { // 첫번째 집 색 a 인 경우 dp ( a 0 : red, 1:green , 2:blue)

		int[][] tmp = new int[N][3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				tmp[i][j] = arr[i][j];
			}
		} //원본 배열 복사
		
		//첫집이 red인 경우, 첫집을 green이나 blue로 칠하는 비용과 N번째 집을 red로 칠하는 비용을 
        //100만으로 넣어서 dp를 했을때 절대 선택되지 않도록 만들어줌
		//동일 로직으로 첫집이 green, blue인 경우로 나눠서 3번 dp돌림
		if (a == 0) { 
			tmp[0][1] = 1000000;
			tmp[0][2] = 1000000;
			tmp[N-1][0] = 1000000;
		} else if (a == 1) {
			tmp[0][0] = 1000000;
			tmp[0][2] = 1000000;
			tmp[N-1][1] = 1000000;
		} else if (a == 2) {
			tmp[0][0] = 1000000;
			tmp[0][1] = 1000000;
			tmp[N - 1][2] = 1000000;
		}

		int[][] dp = new int[N][3];

		dp[0][0] = tmp[0][0];
		dp[0][1] = tmp[0][1];
		dp[0][2] = tmp[0][2];

		for (int i = 1; i < N; i++) {
			dp[i][0] = tmp[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = tmp[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = tmp[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		
		for (int i = 0; i < 3; i++) {
			ans = Math.min(ans, dp[N - 1][i]);
		}

	}

}
