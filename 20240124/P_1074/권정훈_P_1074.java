package level_26_divide_and_conquer;

import java.io.*;
import java.util.*;

// Z
// 탑다운 재귀
public class P_1074 {
	private static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		ans = 0; // 카운트
		System.out.println(recursion(n, x, y));
	}

	// 0, 1, 2, 3 사분면으로 나눈다.
	// 각 사분면의 (0,0) 값은 4^(n-1) * (0~3)이다.
	// 재귀를 돌며 n을 감소시키면서 사분면을 계속 탐색하고 n이 0이면 좋료한다.
	private static int recursion(int n, int x, int y) {

		// 종료조건
		if (n == 0) return ans;

		// 사분면 계산
		int quadrant; // 사분면
		int mid = (int) Math.pow(2, n - 1); // 구역 구분선
		if (x >= mid && y >= mid) {
			quadrant = 3;
			x -= mid;
			y -= mid;
		} else if (x < mid && y >= mid) {
			quadrant = 2;
			y -= mid;
		} else if (x >= mid && y < mid) {
			quadrant = 1;
			x -= mid;
		} else {
			quadrant = 0;
		}

		// 사분면에 따른 시작점
		int start = (int) Math.pow(4, n - 1);
		ans += (start * quadrant);

		// 재귀 호출 (n을 1씩 감소시키면서)
		return recursion(--n, x, y);
	}
}
