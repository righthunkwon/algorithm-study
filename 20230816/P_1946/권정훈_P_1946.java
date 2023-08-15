package level_25_greedy;

import java.util.Arrays;
import java.util.Scanner;

public class P_1946 {
	public static void main(String[] args) {
		// 서류 1등은 항상 합격
		// 서류 2등부터 면접 등수로 비교
		// 서류심사의 순위가 낮은 사원들은 앞 순위의 사원들보다 무조건 면접 순위가 더 높아야 함
		// 배열[서류순위] = 면접순위를 활용하면 정렬이 불필요하여 시간복잡도가 감소
		// 즉, 배열[서류등수] = 면접등수 일 때, 현재 사원보다 면접순위가 높은 사원이 존재하면 해당 사원은 미선발

		// ex. 1st test case
		// arr[0] = 4 (서류 1등, 항상 합격)
		// arr[1] = 3 (합)
		// arr[2] = 2 (합)
		// arr[3] = 1 (합)
		// arr[4] = 5 (불합)

		// ex. 2nd test case
		// arr[0] = 4 (서류 1등, 항상 합격)
		// arr[1] = 5 (불합)
		// arr[2] = 6 (불합)
		// arr[3] = 2 (합)
		// arr[4] = 7 (불합)
		// arr[5] = 1 (합)
		// arr[6] = 3 (불합)

		Scanner sc = new Scanner(System.in);

		// test case
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt(); // 지원자의 수
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				int doc = sc.nextInt(); // 서류순위
				int itv = sc.nextInt(); // 면접순위
				arr[doc-1] = itv; // 서류순위 = index + 1 (정렬 불필요)
			}
			
			// 서류 1등의 면접 순위를 기준으로 해당 순위보다 높으면 합격
			int cnt = 1; // 서류 1위(항상 합격)
			int rating = arr[0]; // 서류 1등의 면접 순위
			for (int i = 1; i < n; i++) {
				// 면접 순위 비교
				if (rating > arr[i]) {
					cnt++; // 합격자 수 증가
					rating = arr[i]; // 해당 면접 순위를 기준점으로 변경
				}
			}
			System.out.println(cnt);
		}
	}
}
