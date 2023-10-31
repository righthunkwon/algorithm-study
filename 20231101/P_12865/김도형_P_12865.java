import java.util.Scanner;

public class Main {
//dfs로 풀어보니 시간초과가 떴따.. .ㅠㅠㅠㅠ
	static int max;
	static int[][] arr;
	static int N, K;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 물품의 수
		K = sc.nextInt(); // 버틸 수 있는 최대 무게

		int [] Weight = new int[N+1];
		int [] Value = new int[N+1];
		int [][] dp = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			Weight[i] = sc.nextInt(); // 무게
			Value[i] = sc.nextInt(); // 가치
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				
				if(Weight[i]>j) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-Weight[i]]+Value[i]);
				}
				
				
			}
		}
		
		


		System.out.println(dp[N][K]);

	}// main

}// class
