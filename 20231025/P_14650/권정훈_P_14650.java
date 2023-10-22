package level_22_backtracking;

import java.util.Scanner;

// 걷다보니 신천역 삼(Small)
// 브루트포스 방식으로 매 탐색을 3의 배수인지 판단
public class P_14650 {
	
	private static int n, ans;
	private static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // n자리 수
		arr = new int[] {0,1,2}; // 3개의 숫자
		ans = 0; // 정답 값 할당
		dfs(0, 0);
		System.out.println(ans);
	}
	
	private static void dfs(int sum, int depth) {
		// 기저부분(종료조건)
		if (depth == n) {
			// n자리 수가 3의 배수일 경우 3의 배수 개수 증가
			if (sum % 3 == 0) ans++; 
			return;
		}
		
		// 재귀부분(반복수행)
		for (int i = 0; i < 3; i++) {
			// 백트래킹
			// 첫 시작부터 숫자가 0일 경우 경우의 수에서 제외
			if (depth == 0 && arr[i] == 0) continue;
			
			// 탐색 반복
			dfs(sum + arr[i], depth + 1);
		}
	}
}
