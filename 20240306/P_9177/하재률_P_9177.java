package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9177_단어섞기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= n; tc++) {
			st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			String s3 = st.nextToken();
			
			boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
			if(s1.charAt(0) == s3.charAt(0)) dp[1][0] = true;
			if(s2.charAt(0) == s3.charAt(0)) dp[0][1] = true;
			
			for(int i = 0; i <= s1.length(); i++) {
				for(int j = 0; j <= s2.length(); j++) {
					if(i >= 1 && dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) dp[i][j] = true;
					if(j >= 1 && dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) dp[i][j] = true;
				}
			}
			
//			for(int i = 0; i <= s1.length(); i++) {
//				for(int j = 0; j <= s2.length(); j++) {
//					System.out.print(dp[i][j]?"t ":"f ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			System.out.println(dp[s1.length()][s2.length()] ? "Data set "+ tc + ": yes" : "Data set "+ tc + ": no");
		}
	}
}
