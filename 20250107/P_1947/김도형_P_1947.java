import java.util.Scanner;

public class BOJ_G3_1947_선물_전달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[]dp = new long[1000001];
		dp[1]=0;
		dp[2]=1;
		dp[3]=2;
//		dp[4]=9; 
//		dp[5]=44; (n-1)* (dp[i-1]+dp[i-2])
		for(int i=4;i<=n;i++) {
			dp[i]= ((i-1)*(dp[i-1]+dp[i-2]))%1000000000;
		}
		System.out.println(dp[n]);
	}
}
