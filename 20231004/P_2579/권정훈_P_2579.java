package level_23_dynamic_programming1;

import java.util.Scanner;

// 계단 오르기
// 동적계획법은 적절한 점화식을 세우는 것이다.
// 그리고 점화식을 활용하기 위한 저장 공간(배열 등)을 만들어 값을 저장하며 효율성을 추구한다.

// n번째의 계단을 밟는 경우의 수는
// n-3, n-1를 밟고 n에 도착하는 경우와
// n-2를 밟고 n에 도착하는 경우 두 가지이다.

// 이를 활용하여 Bottom-up 방식으로
// 작은 부분문제의 최적해를 구한 뒤, 큰 문제의 해를 구하면 된다.
public class P_2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 계단의 개수
		int[] dp = new int[n + 1]; // 동적계획법
		int[] arr = new int[n + 1]; // 계단 배열

		// 계단 배열 요소 입력
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		// 계단의 개수가 1, 2, 3일 때까지는 예외처리
		// 계단의 개수가 한 개인 경우
		// 총 점수는 첫 번째 계단의 점수
		dp[1] = arr[1];

		for (int i = 2; i <= n; i++) {
			// 계단의 개수가 두 개인 경우
			// 총 점수는 첫 번째 계단과 두 번째 계단의 합
			if (i == 2) {
				dp[2] = arr[1] + arr[2];
			} 
			
			// 계단의 개수가 세 개인 경우
			// 총 점수는 첫 번째 계단과 두 번째 계단 중 큰 값과 세 번째 계단의 합
			else if (i == 3) {
				dp[3] = Math.max(arr[1], arr[2]) + arr[3];
			} 
			
			// 점화식(일반식)
			else {
				dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
			}
		}
		System.out.println(dp[n]);
	}
}
