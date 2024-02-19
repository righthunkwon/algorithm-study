package _20240207;

import java.util.*;
import java.io.*;

public class _1309_동물원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int MOD = 9901;
		
		// 0: 사자가 배치되지 않는 경우
		// 1: 사자가 왼쪽에 배치되는 경우
		// 2: 사자가 오른쪽에 배치되는 경우
		int[][] dp = new int[N+1][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i=2;i<=N;i++) {
        	// i번째 열에 사자가 없는 경우 i-1번째 열에는 사자가 없거나 오른쪽에만 있을 수 있다
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            // i번째 열 왼쪽에 사자가 있는 경우 i-1번째 열에는 사자가 없거나 왼쪽에만 있을 수 있다
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            // i번째 열 오른쪽에 사자가 없는 경우 i-1번째 열에는 사자가 없거나 왼쪽쪽에만 있을 수 있다
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }

        int res = (dp[N][0] + dp[N][1] + dp[N][2]) % MOD;
        
        System.out.println(res);
	}//main

}
