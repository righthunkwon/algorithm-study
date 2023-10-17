package AlgoStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_Q9465_스티커 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0;tc<T;tc++) {
			
			int n = Integer.parseInt(br.readLine());
			
			int[][]arr = new int[2][n+2];
			for(int i = 0;i<2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=2;j<n+2;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}//입력 끝
			
			int[][]dp = new int[2][n+2];

			int max = 0;
			for(int i = 2;i<n+2;i++) {
				dp[0][i] = arr[0][i]+Math.max(dp[1][i-2], dp[1][i-1]);
				dp[1][i] = arr[1][i]+Math.max(dp[0][i-2], dp[0][i-1]);
			}
			
			
			sb.append(Math.max(dp[0][n+1], dp[1][n+1])).append('\n');
			
		}//tc
		
		System.out.println(sb);
		
	}//main
	
}//class
