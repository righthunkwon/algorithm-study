import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2579_계단오르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 계단의 개수
		int N = Integer.parseInt(br.readLine());
		// 계단에 쓰여 있는 점수  (계산 편의를 위해 N+1 크기의 배열을 만든다)
		int stairs[] = new int [N+1];
		// dp 배열  (계산 편의를 위해 N+1 크기의 배열을 만든다)
		int dp[] = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			stairs[i]= Integer.parseInt(br.readLine());
		}
		// 계단 개수가 1 이상일 때 dp[1]은 첫번째 계단의 점수와 같다
		if(N>=1) {
			dp[1] = stairs[1];
		}
		// 계단 개수가 2 이상일 때 dp[2]는 첫번째 계단 점수와 두번째 계단 점수를 합한 값과 같다
		if(N>=2) {
			dp[2] = stairs[1]+stairs[2];
		}
		// 계단 개수가 3일 때부턴
		// [i-3]번째 계단을 밟고 [i-1],[i] 번째 계단을 밟는 경우와
		// [i-2]번째 계단을 밟고 [i] 번째 계단을 밟는 경우
		// 이 두 경우 중에 더 큰 값을 dp[i]에 저장한다.
		
		// 이 때, [i-3]과 [i-2]는 dp배열에서 가져오면 그 때까지의 최대 점수를 반영하게 된다
		for(int i=3;i<=N;i++) {
			dp[i] = Math.max(dp[i-2] +stairs[i],  dp[i-3] +stairs[i-1]+stairs[i]);
		}
		
		System.out.println(dp[N]);
		
	}//main

}
