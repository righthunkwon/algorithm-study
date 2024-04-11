package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2602_돌다리건너기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String duru = br.readLine();
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int[][][] dp = new int[duru.length()][str1.length()+1][2];
		
		for(int j = 1; j <= str1.length(); j++) {
            dp[0][j][0] = (duru.charAt(0) == str1.charAt(j-1) ? 1 : 0) + dp[0][j-1][0];
            dp[0][j][1] = (duru.charAt(0) == str2.charAt(j-1) ? 1 : 0) + dp[0][j-1][1];
        }
		for(int i = 1; i < duru.length(); i++) {
            for(int j = 1; j <= str1.length(); j++) {
                dp[i][j][0] = (duru.charAt(i) == str1.charAt(j-1) ? dp[i-1][j-1][1] : 0) + dp[i][j-1][0];
                dp[i][j][1] = (duru.charAt(i) == str2.charAt(j-1) ? dp[i-1][j-1][0] : 0) + dp[i][j-1][1];
            }
        }
//		for(int k = 0; k <2; k++) {
//			for(int i = 0; i < duru.length(); i++) {
//				for(int j = 0; j <= str1.length(); j++) {
//					System.out.print(dp[i][j][k] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		System.out.println(dp[duru.length()-1][str1.length()][0] + dp[duru.length()-1][str1.length()][1]); 
		
	}
}
