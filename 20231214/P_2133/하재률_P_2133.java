package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2133_타일채우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// N이 홀수일 때는 경우의 수가 존재하지 않음
		/*	그림을 그려보면
			N = 2 일때는 => 3가지
			N = 4 일때는 f(2) * f(2) + 특수한 경우 2가지 => 11가지
			N = 6 일때는 f(2) * f(4) 
							+ 4 2 로 나눴을때 발생하는 특수한 경우 f(2) * 2 => 6 가지 
							+ 특수한 경우 2가지
							=> 총 41가지
			N = 8 일때는 f(2) * f(6) 
							+ 6 2 로 나눴을때 발생하는 특수한 경우 f(2) * 2 = 6
							+ 4 4 로 나눴을때 발생하는 특수한 경우 f(4) * 2 = 22 
							+ 특수한 경우 2가지
							=> 총 153가지
			점화식 f(n) = f(2)*f(n-2) + ( sum k=1 to ((n/2)-2) 2k ) * 2 + 2
		*/
		int[] dp = new int[16];
		dp[1] = 3; dp[2] = 11;
		int tmp = 0;
		for(int i = 3; i <= 15; i++) dp[i] = dp[1] * dp[i-1] + (tmp += dp[i-2]) * 2 + 2;
		
		System.out.println(N % 2 == 0 ? dp[N/2] : 0);
	}
}
