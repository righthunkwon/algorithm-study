package _20240207;

import java.util.*;
import java.io.*;

public class _2410_2의멱수의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		int MOD = 1000000000;
		// 아무것도 선택하지 않는 것 하나
		dp[0] = 1;
		// 2의 멱수에 대해 반복
        for (int i=1;i<=N;i*=2) {
        	// i에서 2의 j번째 멱수를 뺀 값에 대한 방법의 수를 더한거
            for (int j=i;j<=N;j++) {
                dp[j] = (dp[j] + dp[j-i]) % MOD;
            }
        }
        System.out.println(dp[N]);
	}//main

}
