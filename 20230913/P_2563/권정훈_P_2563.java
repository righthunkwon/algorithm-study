package level_07_array_2;

import java.util.Scanner;

// 색종이
// 2차원 배열을 통한 넓이 구하기(색종이 영역: 1, 빈 영역: 0)
public class P_2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 10*10 색종이의 수

		// 왼쪽 아래 꼭지점의 위치
		int[] left = new int[n];
		int[] bottom = new int[n];
		
		// 도화지
		int[][] map = new int[100][100];

		// 색종이의 수만큼 반복
		for (int i = 0; i < n; i++) {
			left[i] = sc.nextInt();
			bottom[i] = sc.nextInt();

			// 2차원 배열 map에 left와 bottom을 기준으로 해당 영역의 요소값을 1로 바꾼다.
			for (int j = left[i]; j < left[i] + 10; j++) {
				for (int k = bottom[i]; k < bottom[i] + 10; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		// 전체 합을 구하고 출력
		int ans = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				ans += map[i][j];
			}
		}

		System.out.println(ans);
	}
}
