package _20240110;

import java.util.*;
import java.io.*;

public class _5582_공통부분문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		int a = s1.length();
		
		String s2 = br.readLine();
		int b = s2.length();
		
		int[][] dp = new int[a+1][b+1];
		int ans =0;
		
		for(int i=1;i<=a;i++) {
			for(int j=1;j<=b;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}
		System.out.println(ans);
		
	}//main

}
