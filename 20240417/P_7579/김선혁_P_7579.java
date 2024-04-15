import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] on = new int[N+1];
		// on에는 활성화 되어있는
		// 메모리의 값을 입력
		// off는 비활성화상태일 때 입력받음
		int[] off = new int[N+1];
		for(int i = 1 ;i<=N;i++) {
			on[i] = sc.nextInt();
		}
		// M만큼의 메모리를 활성화하기 위해서 
		// 비활성화해야하는 메모리의 최소값을 구해야함
		// --> 
		// dp로 1. 현재 앱의 비활성화 값보다 여태까지의 비활성화 값이 크면
		// 그지점이 on일때의 값과 off일였을떄까지의 값 중 최대값을 저장
		// 2. 어차피 작으면 나두는게 
		
		for(int i = 1 ;i<=N;i++) {
			off[i] = sc.nextInt();
		}
		// 입력끝
		
		// dp 선언
		int[][] dp = new  int[N+1][10001]; // 100x100 = 10000이 최대값
		
		// i번째 하나를 찝고 for문으로 0에서 10000까지 
		// 이 지점을 off값보다 현재 비활성화값이 높은 값이라면
		// 이 지점을 off했을 떄와 on 했을 때 비교해서 값 갱신
		for(int i = 1 ; i< N+1;i++) {
			for(int j = 0;j<=10000;j++) {
				if(j>=off[i]) {
					dp[i][j] = Math.max(on[i] + dp[i-1][j-off[i]], dp[i-1][j]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		for(int j = 0 ;j<10001;j++) {
			if(dp[N][j] >= M) {
				System.out.println(j);
				break;
			}
		}
		
	}

}
