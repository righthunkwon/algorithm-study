import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		long[][] dp=new long[N][2];
		dp[0][0]=1;dp[0][1]=1;
		if(N>=2){dp[1][0]=3;dp[1][1]=3;}
		for(int i=2;i<N;i++) {
			dp[i][0]=(dp[i-2][1]+dp[i-1][1]*2+1)%9901;
			dp[i][1]=(dp[i-2][0]+dp[i-1][0]*2+1)%9901;
		}
		System.out.println((dp[N-1][0]+dp[N-1][1]+1)%9901);
	}
}
