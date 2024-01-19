import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int K = sc.nextInt();
		int[][] dp = new int[N+1][K+1];
		for (int i = 1; i <= K; i++) {
			dp[0][i] = 1;
		}
		for (int i = 0; i <= N; i++) {
			dp[i][1] = 1;
		}
		// 일단 1개하는 경우는 어차피 1이니 모두 1로 채워두고 
		// 0개로하는 경우도 없으니모두 0으로 채워놓음

		// 2이상 합인 것부터 
		// 하나씩 늘어날 때마다 전항 두개를 더해줌
		for (int j = 2; j <= K; j++) {
			for (int i = 1; i <= N; i++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
				dp[i][j] %= 1000000000;
				// 10억으로 나눈 나머지 넣어놓음
			}
		}
		System.out.println(dp[N][K]);

	}
}
