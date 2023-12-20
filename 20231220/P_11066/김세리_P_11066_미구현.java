package _20231220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11066_파일합치기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N+1];
			int[][] dp = new int[N+1][N+1];
			arr[1] = Integer.parseInt(st.nextToken());
			for(int i=2;i<N+1;i++) {
				// 누적합으로 저장
				arr[i]=Integer.parseInt(st.nextToken())+arr[i-1];
			}
			
			for(int dum=1;dum<N;dum++) {
				for(int j =1;j+dum<N;j++) {
					int ed = j + dum;
					dp[j][ed] = Integer.MAX_VALUE;
					for(int mid=j;mid<ed;mid++) {
						dp[j][ed] = Math.min(dp[j][ed], dp[j][mid]+dp[mid+1][ed]+arr[ed]-arr[j-1]);
					}
				}
			}
			System.out.println(dp[1][N]);
			
		}//T
	}//main

}
