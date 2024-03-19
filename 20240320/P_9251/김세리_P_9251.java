package _20240320;

import java.util.*;
import java.io.*;

public class _9251_LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int[][] dp = new int [s1.length()+1][s2.length()+1];
		for(int i=1;i<=s1.length();i++) {
			for(int j=1;j<=s2.length();j++) {
				// 글자 하나씩 비교해서 같으면 그 앞의 dp+1을 해준다
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j]= dp[i-1][j-1]+1;
				}
				else {
				// 안같을 땐 그 앞에 있던 dp값중에 더 큰걸 넣어준다
					dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[s1.length()][s2.length()]);
	}//main

}
