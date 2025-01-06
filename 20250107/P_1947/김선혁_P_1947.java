package 백준;

import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			N = sc.nextInt(); 
			// 1000000까지 dp로 더하기
			
			// 둘이 교환할 경우 , a가 b한테 주지만 b는 또다른사람에게 주는경우
			// 1번은 그냥 dp[i-2] , 2번은 n-1만큼의 경우의수
			long[] dp = new long[1000001];
			dp[0] = 0;
			dp[1] = 0;
			dp[2] = 1; // 둘이교환
			for(int i = 3;i<=N;i++) {
				dp[i] = (i-1)* (dp[i-2] + dp[i-1]);
				dp[i] %= 1000000000;
			}
			System.out.println(dp[N]);
		
	}
	
}
