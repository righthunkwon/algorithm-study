package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9251_LCS {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		// 공집합 표현을 위해 길이 + 1로 dp배열을 선언
		int[][] dp = new int[str1.length + 1][str2.length + 1];
		
		// index 0은 공집합이므로 1부터 시작
		for(int i = 1; i <= str1.length; i++) {
			for(int j = 1; j <= str2.length; j++) {
				
				// (i-1)번째와 (j-1)번째 문자 비교
				if(str1[i-1] == str2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
					
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
//		for(int i = 0; i < str1.length+1; i++) {
//			for(int j = 0; j < str2.length+1; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(dp[str1.length][str2.length]);

	}
}
