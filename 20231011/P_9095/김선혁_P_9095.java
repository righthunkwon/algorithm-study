import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int T = sc.nextInt();
		
		// N=1 -> 1개
		// N=2 -> 2개
		// N=3 -> 4개(1,1,1 / 1,2 / 2,1 / 3)
		// N=4 -> 7개

		// 5의경우는 5 = 1+4 / 2+3 / 3+2 이렇게 볼 수 있음
		// 4일때에 +1, 2일때에 +3, 3일때 +2로 볼 수 있다.
		// N=5 -> 13개 
		// ===> N번쨰 수는 N-3 + N-2 + N-1번째 항의 합과 같다고 볼 수 있음
			
		
		//N은 우선 양수이며 11보다 작기때문에
		int[] dp = new int[12];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4;i<12;i++) {
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		}
		for(int tc=1;tc<=T;tc++) {
			int N =sc.nextInt();
			System.out.println(dp[N]);
			
		}
		
		
		
	}
	

}
