package level_33_two_pointer;

import java.util.Scanner;

// 부분합
// 투포인터를 사용하는 문제
// 반복문 열심히 쓰면 시간초과
// 나중에 다시 한 번 직접 구현해보자
// 구간합 문제에 투포인터를 적용할 수 있다
public class P_1806 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 수열의 길이
		int s = sc.nextInt(); // 목표 부분합
		int min = Integer.MAX_VALUE; // 최소길이

		// 배열 요소 입력
		int[] arr = new int[n + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		// 투포인터
		int st = 0;
		int ed = 0;
		int sum = 0;

		// 범위 내에 있는 동안 반복
		while (st <= n && ed <= n) {

			// 합이 s를 넘고 길이가 더 짧다면 최소값 갱신
			if (sum >= s && min > ed - st) {
				min = ed - st;
			}

			// 합이 s를 넘지 않는다면 더해주고
			// s는 넘거나 같으면 빼준다
			if (sum < s) {
				sum += arr[ed++];
			} else {
				sum -= arr[st++];
			}

		}

		// 정답 출력
		if (min == Integer.MAX_VALUE) {
			System.out.println("0");
		} else {
			System.out.println(min);
		}
	}
}
