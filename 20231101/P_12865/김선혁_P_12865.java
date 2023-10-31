import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N+1];
		int[] cost = new int[N+1]; 
		// 첫항은 각물건의 무게
		// 두번째 항은 각물건의 가치
		for(int i = 1;i<=N;i++) {
			arr[i] = sc.nextInt();
			cost[i] = sc.nextInt();
		}	
		// 입력완료
		int[][] dp = new int[N+1][K+1];
		// 0부터 K까지의 값에서 최대의 가치를 저장할 거임
		for(int i =1;i<=N;i++) {
			// j가 0일땐 어차피 0 
			for(int j = 1;j<K+1;j++) {
					if(arr[i] > j) {
						// 아무것도 못담는 경우
						dp[i][j] = dp[i-1][j];
						// 그전항 값 그대로
					}
					// 담을 수 있는경우 
					else {
						// 그 윗항의 값어치와 , 현재 물건을 포함했을 때의 무게중 큰값
						dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-arr[i]]+cost[i]);
					}					

			} // j for

		} // i for
//		for(int i = 1;i<=N;i++) {
//			for(int j =1;j<=K;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(dp[N][K]);


	}


}
