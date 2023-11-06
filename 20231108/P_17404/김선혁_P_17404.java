import java.util.Scanner;

public class Main {
	static int N;	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 값을 입력받고 서로 다르게 해놓음
		// dp를 통해 누적값이 
		int[][] color = new int[N][3];
		int[][] dp = new int[N][3];
		// 3가지 경우 생각함 
		// 
		for(int i = 0;i<N;i++) {
			for(int j =0;j<3;j++) {
				color[i][j] = sc.nextInt();
			}
		}
		// 입력끝
		int ans = 987654321;
		// 최소값을 구할것이므로 정답은 최대한 높게 설정
		
		// k는 색 하나씩 ex) 빨 초 파 
		for(int k = 0;k<3;k++) {	
		// 전부다 최대값 해놓고 현재 시작하는 위치만
		// 값 설정해놓음
		for(int i =0;i<N;i++) {
			for(int j =0;j<3;j++) {
				dp[i][j] = 987654321;
			}
		}
		dp[0][k] = color[0][k];
		
			// ㅑ는 몇번째를 칠한건지 결정
			for(int i=1;i<N;i++) {
				// 현재 칠해야하는 색은 그전항에서 다른 두가지 색중 더 작은 값에 현재 값 더한것
				dp[i][0] = Math.min(dp[i-1][1], dp[i - 1][2]) + color[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i - 1][2]) + color[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i - 1][1]) + color[i][2];					
			}
			// 다입력했을 때 첫항과 마지막항이 달라야함
			for(int i = 0;i<3;i++) {
				// 첫항과 마지막항의 색이 다를때만
				if(i !=k) {	
					// 2개 비교
					ans = Math.min(ans,dp[N-1][i]);
				}
			}
			
		}
		// 여기까지 각각 모두 최소값을 넣어놨으니
		// 이 3개중 최소값 구해야함
		System.out.println(ans);
	}

}
