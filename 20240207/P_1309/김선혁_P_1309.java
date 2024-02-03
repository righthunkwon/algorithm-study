import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			// 딱봐도 dp문제..
			// 경우의수 세자
			// 일단 사자를 한줄에 하나만 배치 가능(안할수도있음)
			
			// 1. 둘다 사자가 없는경우 2가지가능
			// 2. 왼쪽에 있는경우는 안두거나 오른쪽 가능
			// 3. 오른쪽 있는 경우는 안두거나 왼쪽 가능
			long[][] dp = new long[N][3];
	        dp[0][0] = dp[0][1] = dp[0][2] = 1;
			// 첫번째항 1으로 채워놓은다음
			// 2번째부터 둘지 안둘지 설정 
	        for(int i = 1;i<N;i++) {
	        	// 안도는거는 3가지 모두 가능
	        	dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
	        	// 왼쪽있으면 오른쪽이나 안두거나
	            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
	            // 오른쪽있으면 왼쪽이나 안두거나
	            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
	        }
	        // 9901 나눈나머지 출력 (위에 안쓰면 왜 틀리지)
	        System.out.println((dp[N-1][0] +dp[N-1][1] + dp[N-1][2]) % 9901);	        
	}
}
