package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2631_줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());
		
		// 가장 긴 증가하는 부분수열 구해서 N에서 빼주면 답이당
		int dp[] = new int[N+1];
		int max = 0;
		
		for(int i = 1; i <= N; i++) {
			dp[i] = 1;
			for(int j = 1; j <= i; j++) {
				if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j]+1);
				max = max > dp[i] ? max : dp[i];
			}
		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(N-max);
		
		
	}
}
