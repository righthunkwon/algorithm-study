package _20240110;

import java.util.*;
import java.io.*;

public class _5582_공통부분문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문자열 1, 2를 저장하고, 각각의 문자열 길이를 토대로 dp배열을 만든다
		String s1 = br.readLine();
		int a = s1.length();
		
		String s2 = br.readLine();
		int b = s2.length();
		// 문자열 숫자를 1부터 시작할거기 때문에 dp 배열도 1씩 크게 만든다
		int[][] dp = new int[a+1][b+1];
		int ans =0;
		
		for(int i=1;i<=a;i++) {
			for(int j=1;j<=b;j++) {
				// s1과 s2의 문자가 일치한다면 그 앞에 문자들의 dp배열에 1을 더한걸
				// 해당 dp 배열 위치에 기록한다
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
					// dp배열에서 가장 큰 값을 ans에 저장한다
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}
		System.out.println(ans);
		
	}//main

}
