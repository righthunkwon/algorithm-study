import java.util.Scanner;


public class Main {
	static int N;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr= new int[N+1]; // 1부터 N까지 선언

		for(int i =1;i<=N;i++) {
			arr[i] = sc.nextInt();
		}
		dp = new int[N+1];
		// 계단에서의 누적합을 해보자 
		
		// 제출했을때 런타임 에러 발생
		// if문 대입
		dp[0] = 0;
		if(N>0)
		dp[1] = arr[1];
		if(N>1)
		dp[2] = dp[1] + arr[2];
		// 일단 0번째랑 1번째, 2번째 먼저 setting 해놓고
		solve();
		//	System.out.println(Arrays.toString(dp));

		// 마지막까지의 최대 누적값 출력
		System.out.println(dp[N]);

	}	
	public static void solve() {
		// 재귀보다 이방법이 쉬운듯?
		// for문으로 2번째부터
		// 포함하는것이 더 높을지 
		// 이 계단을 스킵하는 것이 높을지 판단
		for(int i =3;i<=N;i++) {
			// 전계단 스킵한거 먼저, 포함한거 나중
			// 포함한것은 i-3번째까지의 누적값에 현재의 cost와 바로전 cost
			// 스킵은 i-2번째까지의 누적합 + 현재의 cost( 전계단 스킵)
			dp[i] = Math.max(dp[i-2]+arr[i], arr[i-1]+arr[i]+dp[i-3]);		
		}


	}

}
