package level_22_backtracking;

import java.io.*;
import java.util.*;

// 숫자 재배치
// C는 A의 순열 중 하나가 되어야 하므로 모든 숫자를 다 사용하기에 자리수가 같아야 한다.
public class P_16943 {
	private static String A, B, C;
	private static int a, b, ans;
	private static int[] arr;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = st.nextToken();
		B = st.nextToken();
		C = "";

		a = Integer.parseInt(A);
		b = Integer.parseInt(B);
		ans = -1; // c

		arr = new int[A.length()];
		visited = new boolean[A.length()];
		for (int i = 0; i < A.length(); i++) {
			arr[i] = A.charAt(i) - 48;
		}

		dfs();
		System.out.println(ans);
	}

	private static void dfs() {
		// 종료조건
		if (C.length() == A.length()) {
			if (Integer.parseInt(C) < b) {
				ans = Math.max(ans, Integer.parseInt(C));
			}
			return;
		}

		// 기저부분
		for (int i = 0; i < A.length(); i++) {
			if ((C.length() == 0 && A.charAt(i) == '0' || visited[i])) {
				continue;
			}
			visited[i] = true;
			C += A.charAt(i);
			dfs();
			visited[i] = false;
			C = C.substring(0, C.length() - 1);
		}
	}

}
