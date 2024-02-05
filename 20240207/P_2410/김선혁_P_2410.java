import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		//			N=1 -> 1 
		//			N=2 -> 1+1, 2
		//			N=3 -> 1+1+1, 2+1
		//			N=4 -> 1+1+1+1, 2+1+1, 2+2, 4
		//			N=5 -> 1+1+1+1+1, 2+1+1+1, 2+2+1, 4+1
//		 수가 1 ,2 , 2 ,4, 4, 6, 6 
//			홀수는 이전짝수와 똑같고, 짝수는 전에 항에다가 현재 index/2의 dp값을 더한것
		int[] dp = new int[1000001];
		dp[1] = 1;
		dp[2] = 2;
		// 이제 3부터 진행
		for(int i =3;i<1000001;i++) {
			if(i % 2 ==0) {
				dp[i] = (dp[i-1] + dp[i/2])% 1000000000;
			}
			// 짝수면 전에항 2개더한거( 1억으로 나눈 나머지)
			// 홀수면 그대로
			else {
				dp[i] = dp[i-1];
			}
		}
		System.out.println(dp[N]);


	}
}
