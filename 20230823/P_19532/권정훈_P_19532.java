package level_12_bruteforce;

import java.util.Scanner;

public class P_19532 {
	public static void main(String[] args) {
		// 브루트 포스의 정의
		// 모든 경우의 수를 탐색하는 완전 탐색
		// 시간복잡도는 높지만 안정적으로 정답 출력 가능
		// 단, 보통 1초당 반복문 수행횟수가 10^8 즉,1억 회 정도를 넘어가면 시간 초과 발생

		// 문제에서는 x와 y가 각각 -999부터 999까지 1999개의 개수
		// 시간복잡도는 O(1999^2)으로 3,996,001의 연산이 필요(1초 이내에 충분하므로 브루트 포스 가능!!!)

		// ax + by = c
		// dx + ey = f
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();

		// 연립방정식의 두 식에 가능한 모든 x y 값을 넣어 두 식 모두가 만족하는 해를 구한다.
		for (int i = -999; i < 1000; i++) {
			for (int j = -999; j < 1000; j++) {
				if ((a * i + b * j == c) && (d * i + e * j == f)) {
					System.out.printf("%d %d", i, j);
				}
			}
		}

	}
}
