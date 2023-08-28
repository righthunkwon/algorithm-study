package level_12_bruteforce;

import java.util.Scanner;

public class P_10157 {
	// 상우하좌
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int c = sc.nextInt(); // 열
		int r = sc.nextInt(); // 행
		int k = sc.nextInt(); // 정답 대기번호

		// !!! 중단 조건 !!!
		// 이렇게 하지 않으면 두 번째 테스트 케이스 통과 불가 
		if (k > c * r) {
			System.out.println(0);
			return; // main method fin
		}
		
		int[][] stage = new int[c][r];

		int cnt = 1; // 입력 대기번호
		int x = r - 1; // 시작행
		int y = 0; // 시작열
		int dir = 0; // 방향
		
		// 입력 대기번호가 정답 대기번호보다 작을 때까지만 반복
		while (cnt != k) {
			stage[x][y] = cnt;
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			// 범위에서 벗어나거나 이미 입력된 값이 있으면 방향을 전환하고 새로운 좌표 입력
			if (nx < 0 || nx >= r || ny < 0 || ny >= c || stage[nx][ny] != 0) {
				// 방향전환
				dir = (dir + 1) % 4;

				// 방향을 바꾼 새로운 좌표 입력
				nx = x + dx[dir];
				ny = y + dy[dir];
			}

			// 새로운 좌표 반영
			x = nx;
			y = ny;

			// 입력할 대기번호 증가
			cnt++;
		}

		// 결과 출력
		System.out.println((y + 1) + " " + (r - x));
	}
}
