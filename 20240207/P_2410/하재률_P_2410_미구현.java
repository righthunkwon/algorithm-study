package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2410_2의멱수의합 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		
		dp[0] = 1;
		dp[1] = 2;
		
		for(int i = 2; i <= N; i++) {
			// N이홀수인경우 => 전이랑 같음
			if(i%2==0) dp[i] = dp[i-1]%1000000;
			// 짝수 => 전 + /2 개수
			else dp[i] = (dp[i-1] + dp[i/2])%1000000;
		}
		System.out.println(dp[N-1]);
		
	}
}
