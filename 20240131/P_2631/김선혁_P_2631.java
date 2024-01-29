import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			int[] arr = new int[N];
			int[] dp = new int[N];
			// 배열 선언 
			// 일단 노가다로 dfs로 풀면
			// 시간초과가 난다.
			for(int i = 0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			// 일단 아이들을 쭉 세워논다고 생각하고
			// 처음부터 오른차순이 되는 숫자가 제일 큰 숫자를 구하면
			// 일단 그 애들은 고정시켜놓고
			// 나머지 애들을 옮겨서 넣으면됨 
			
			// ex)3 7 5 2 6 1 4 에서 3 5 6 이순서로 일단 고정시킨다 생각
			// 그러고 나머지 숫자 7 2 1 4를 빈자리에 하나씩 넣으면 됨
			// 오름차순 제일 긴 수열을 찾아서 N 에서빼면 정답
			
			// -- > dp 문제로 만약 그항이 오름차순일 경우에만 그전항값 +1해줌
			dp[0] = 1;
			int ans = 0;
			for(int i = 1;i<N;i++) {
				dp[i] = 1 ; 
				// 일단 길이가 1이라 가정하고 
				// 만약 j번째 숫자(i이하)보다 작다면
				// j항의 dp에서 1을 더한것과 기존의 값중 최대값을 저장
				for(int j = 0;j<i;j++) {
					if(arr[i] > arr[j]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);     
					}
				}
				// 한번할때마다 ans 최대값으로 갱신
				ans = Math.max(ans, dp[i]);
			}
			
			System.out.println(N-ans);
	}
}
