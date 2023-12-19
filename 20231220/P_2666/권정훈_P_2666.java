package level_23_dynamic_programming;

import java.util.Scanner;

// 벽장문의 이동
// 그리디하게 풀리지 않는다.
// 반환 시에 재귀호출을 해서 최소값을 찾는 방식으로 전체를 dp하게 재귀처리해야 풀린다.
public class P_2666 {
	private static int n, m, open1, open2, ans;
	private static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 총 벽장 수
		open1 = sc.nextInt(); // 열린 벽장 1
		open2 = sc.nextInt(); // 열린 벽장 2
		m = sc.nextInt(); // 사용할 벽장 수
		ans = 0; // 문이 이동한 횟수의 총합

		// 사용할 벽장 배열 요소 입력
		arr = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = sc.nextInt();
		}

		// 사용할 벽장을 찾는 최소값 찾기
		ans = recursion(open1, open2, 0);
		System.out.println(ans);
	}

	private static int recursion(int o1, int o2, int idx) {
		// 종료조건
		if (idx == m) return 0;

		// 재귀부분
		int tmp1 = Math.abs(o1 - arr[idx]);
		int tmp2 = Math.abs(o2 - arr[idx]);
		return Math.min(tmp1 + recursion(o2, arr[idx], idx + 1), tmp2 + recursion(o1, arr[idx], idx + 1));
	}
}
