package AlgoStudy;

import java.io.*;
import java.util.*;

public class BOJ_Q2631_줄세우기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N+1];
		int [] dp = new int[N+1];
		int ans = 1;
		for (int i = 1; i <= N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		// 증가하는 부분 수열 가장 긴거 길이 구해서 빼주면 될듯??
		for(int i=1;i<=N;i++) {
			dp[i]=1;
			for(int j=1;j<i;j++) {
				if(arr[j]<arr[i]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(N-ans);
	}// main
}// class
