package _20240124;

import java.util.*;
import java.io.*;

public class _2225_합분해 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// 행은 숫자의 갯수이고, 열은 구하고자 하는 수이다
		long[][] dp = new long[K][N+1];
		
		// N이 0 일 때(실제로 N의 범위는 1이상이지만 dp 계산을 위해서 가정)
		// i개의 숫자로 만들 수 있는 경우는 0이 i개 있을 때이므로 모두 1로 채워준다
		for(int i=1;i<K;i++) {
			dp[i][0]=1;
		}
		// K가 0일 때(실제 K의 범위는 1 이상이지만 dp계산을 위해 가정함)
		// 숫자 j를 만들 수 있는 경우의 수는 j로 만들 때 이므로 모두 1로 채워준다
		for(int j=1;j<N+1;j++) {
			dp[0][j] = 1;
		}
		
		// dp계산을 해주고, 어차피 답은 1,000,000,000으로 나눈 나머지를 원하므로
		// 계산할 때부터 나머지를 계산해서 넣어준다
		for(int i=1;i<K;i++) {
			for(int j=1;j<N+1;j++) {
				dp[i][j]= (dp[i-1][j] + dp[i][j-1])%1000000000;
			}
		}
//		System.out.println(Arrays.deepToString(dp));
		
		System.out.println(dp[K-1][N]);
	}//main
}
