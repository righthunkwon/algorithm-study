package level_12_bruteforce;

import java.util.Scanner;

public class P_1018 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 열
		int m = sc.nextInt(); // 행

		// 체스판 입력
		String board[] = new String[n];
		for (int i = 0; i < n; i++) {
			board[i] = sc.next();
		}

		int min = 1000000000;
		int cnt1; // WBW
		int cnt2; // BWB

		// 체스판은 8*8 사이즈이므로 배열 범위를 끝까지 순회할 필요가 없음
		for (int i = 0; i < n - 7; i++)
			for (int j = 0; j < m - 7; j++) {
				cnt1 = 0;
				cnt2 = 0;

				// 해당 영역을 체스판으로 만들기 위한 수정 횟수 탐색
				for (int p = i; p < i + 8; p++)
					for (int q = j; q < j + 8; q++) {
						if (p % 2 == 0) {
							if (q % 2 == 0) {
								if (board[p].charAt(q) == 'W')
									cnt1++;
								else
									cnt2++;
							} else {
								if (board[p].charAt(q) == 'B')
									cnt1++;
								else
									cnt2++;
							}
						} else {
							if (q % 2 == 0) {
								if (board[p].charAt(q) == 'B')
									cnt1++;
								else
									cnt2++;
							} else {
								if (board[p].charAt(q) == 'W')
									cnt1++;
								else
									cnt2++;
							}
						}
					}
				min = Math.min(min, Math.min(cnt1, cnt2)); // 최소 수정 횟수 저장
			}
		// 모든 경우의 최소 수정 횟수 출력
		System.out.println(min); 
	}
}
