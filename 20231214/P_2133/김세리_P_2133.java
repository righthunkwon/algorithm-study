package _20231214;

import java.util.*;
import java.io.*;

public class _2133_타일채우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans=0;
		int[]dp = new int[16];
		if (N%2 == 0) {
			int k = N/2;
			dp[0]=0;
			dp[1]=3;
			dp[2]=11;
			dp[3]=41;
			for(int i=4;i<=15;i++) {
				dp[i]=dp[i-1]*3 + (dp[i-1]-dp[i-2]*3)*4 -(dp[i-2]-dp[i-3]*3);
			}
			ans = dp[k];
		}
//		for(int i=0;i<16;i++) {
//			System.out.println(i+": "+dp[i]);
//		}
		System.out.println(ans);
	}//main

}
