import java.util.Scanner;

public class Main {
	
	static int [] dp;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		dp[4] = 7;
		
		for(int i = 5; i<=11; i++) {
			dp[i] = 2*dp[i-1] - dp[i-4];
		}
		
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			System.out.println(dp[N]);
		}
    
	}//main
}//clas
