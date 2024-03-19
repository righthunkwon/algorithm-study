package level_23_dynamic_programming;

import java.io.*;
import java.util.*;

// LCS
// 최장공통부분수열
public class P_9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		// 초기값 세팅
		// 공집합과 부분수열의 공통부분수열은 공집합
		for (int i = 0; i < s1.length(); i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < s2.length(); i++) {
			dp[0][i] = 0;
		}
		
		// dp
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				// 이전 순서에 검사하는 문자가 같다면
				// 이는 무조건 추가하는 게 이득이므로 현재 값에 1을 더해준다.
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} 
				// 동일한 순서에 검사하는 문자가 같지 않다면
				// 왼쪽 값과 오른쪽 값 중 더 큰 값으로 현재 값을 갱신해준다.
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[s1.length()][s2.length()]);
	}

}

