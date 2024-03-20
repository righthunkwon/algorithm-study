package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Q9251_LCS {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		int [][]dp = new int[a.length()+1][b.length()+1];
		
		for(int i =1;i<=a.length();i++) {
			for(int j=1;j<=b.length();j++) {
				if(a.charAt(i-1)==b.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1]+1;
				}else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		int A = a.length();
		int B = b.length();
		
		while(A>0 && B>0) {
			if(a.charAt(A-1)==b.charAt(B-1)) {
				sb.append(a.charAt(A-1));
				A--;
				B--;
			}else if(dp[A-1][B]>dp[A][B-1]) {
				A--;
			}else
				B--;
		}
		
		
		System.out.println(dp[a.length()][b.length()]);
		System.out.println(sb.reverse().toString());
		
	}//main
}//class
