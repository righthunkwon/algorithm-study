package AlgoStudy;

import java.util.Scanner;

public class BaekJoon_Q2579_계단_오르기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 계단 수 입력
		
		int [] stair = new int[10001]; // stair[0]은 시작점(점수0)
		int [] dp = new int[10001];
		
		for(int i = 1 ; i<N+1;i++) {
			stair[i]=sc.nextInt(); //1층~N층 각 계단의 점수 입력받기
		}
		
		dp[0] = 0;
		
		dp[1] = stair[1]; //계단 1개면 첫번째 계단 값이 최대
		
		dp[2] = stair[1]+stair[2]; //2개면 1,2번째 점수 합이 최대
		
		
		/*2가지 경우의 수가 존재함
		 * ?OXN -> N-2번째의 dp값과 n번째의 점수 합
		 * OXON -> N-3번째의 dp값과 n-1번쨰의 점수, n번째의 점수 합
		 * 
		 * 위 두 경우 중 비교해서 더 큰 값이 그때의 dp값이 된다
		 * */
		for(int i=3;i<N+1;i++) {
			dp[i]= Math.max((dp[i-3]+stair[i-1]+stair[i]),(dp[i-2]+stair[i]));
		}
		
		System.out.println(dp[N]);
		
		
	}
	
}
