package level_00_basic;

import java.util.Scanner;

// 응애(EASY)
public class P_28088 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int ans = 0; // k번 인사한 뒤 다음에 인사할 사람의 수
		boolean[] hello = new boolean[n]; // 인사 판단
		boolean[] flag = new boolean[n]; // 임시 판단

		for (int i = 0; i < m; i++) {
			int idx = sc.nextInt();
			hello[idx] = true; // 처음에 인사
			flag[idx] = true; // 처음에 인사
		}

		while (k > 0) {
			for (int i = 0; i < n; i++) {
				// 처음 사람일 때
				if (i == 0) {
					// 다음 사람과 마지막 사람이
					// 둘 다 인사했거나 인사하지 않았을 때
					if (hello[1] == true && hello[n - 1] == true) {
						flag[0] = false; // 인사하지 않는다.
					} else if (hello[1] == false && hello[n - 1] == false) {
						flag[0] = false; // 인사하지 않는다.
					}
					// 이외의 경우에는
					else {
						flag[0] = true; // 인사한다.
					}
				}

				// 끝 사람일 때
				else if (i == n - 1) {
					// 이전 사람과 첫 사람이
					// 둘 다 인사했거나 인사하지 않았을 때
					if (hello[n - 2] == true && hello[0] == true) {
						flag[n - 1] = false; // 인사하지 않는다.
					} else if (hello[n - 2] == false && hello[0] == false) {
						flag[n - 1] = false; // 인사하지 않는다.
					}
					// 이외의 경우에는
					else {
						flag[n - 1] = true; // 인사한다.
					}
				}

				// 이외일 때
				else {
					// 이전 사람과 첫 사람이
					// 둘 다 인사했거나 인사하지 않았을 때
					if (hello[i - 1] == true && hello[i + 1] == true) {
						flag[i] = false; // 인사하지 않는다.
					} else if (hello[i - 1] == false && hello[i + 1] == false) {
						flag[i] = false; // 인사하지 않는다.
					}
					// 이외의 경우에는
					else {
						flag[i] = true; // 인사한다.
					}
				}

			}
			// 과정이 종료되면 
			// flag를 hello에 복사시키고 턴 한 번을 줄인다.
			hello = flag.clone();
			k--;
		}
		for (int i = 0; i < n; i++) {
			if (hello[i] == true) ans++;
		}
		System.out.println(ans);
	}
}
