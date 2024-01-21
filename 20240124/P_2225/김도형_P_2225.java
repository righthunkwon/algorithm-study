import java.util.*;

public class BOJ_Q2225_합분해 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int [][]dp = new int[201][201];
		for(int i=0;i<=200;i++) {
			dp[i][1]=1;
			dp[0][i]=1;
		}
		for(int i=1;i<=N;i++) {
			for(int j=2;j<=K;j++) {
				dp[i][j]=dp[i-1][j]+dp[i][j-1];
				if(dp[i][j]>1000000000) {
					dp[i][j]=dp[i][j]%1000000000;
				}
			}
		}
		System.out.println(dp[N][K]);
	}//main
}

/*
    0   1   2   3   4   5   6   K
0   0   1   1   1   1   1   1 
1   0   1   2   3   4
2   0   1   3   6  10
3   0   1   4  10  20
4   0   1   5  15  35
5   0   1   6  21  56
6   0   1   7  28  84
N

*/
