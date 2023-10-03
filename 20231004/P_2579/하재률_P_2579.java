package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579_계단오르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1]; // 계단 점수 저장용 
		int[] dp = new int[N+1]; // 각 지점에 도착했을 때 가장 큰 값을 저장
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}// 입력 완
		
		dp[1] = arr[1];
		
		if(N >= 2) { // N = 1이 있을 수 있음
			dp[2] = arr[1] + arr[2];
		}
		
		for(int i = 3; i <= N; i++) {
			// 4번째 계단의 dp값은
			// 2번째 계단의 dp값 + 4번째 계단의 값 (3번째 계단을 건너뜀.. 연속 3개 밟을 수 없으므로)
			// 1번째 계단의 dp값 + 3번째 계단 + 4번째 계단의 값 (2번째 계단을 건너뜀.. 연속 3개 X) 
			// 중에 큰 것
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
		}
		
		System.out.println(dp[N]);
	}
}
