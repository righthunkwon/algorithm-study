package level_23_dynamic_programming1;

import java.util.Scanner;

// 레벨 햄버거
// 누적합을 저장하는 재귀함수 호출 활용
// 별찍기와 유사하게 점화식의 규칙을 찾아내자!

// 다음 총 레이어의 수는 [번 + 이전버거 + 패티 + 이전버거 + 번] 이므로, 
// 이전 버거의 레이어의 수에 두 배를 곱한 것에 3을 더한 값이고,

// 다음 패티의 수는 [이전버거패티 + 패티 + 이전버거패티] 이므로,
// 이전 버거 패티의 수에 두 배를 곱한 것에 1을 더한 값이다.
public class P_16974 {
	public static int n; // 레벨
	public static long x; // 먹은 레이어의 수(아래부터)
	public static long[] total; // 전체 레이어 수
	public static long[] patty; // 먹은 패티 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		x = sc.nextLong();

		// 1이상 n이하이므로 배열의 크기는 +1
		total = new long[n+1];
		patty = new long[n+1];

		// 초기값(n=0)
		patty[0] = 1;
		total[0] = 1;

		// 1~n 레벨의 레이어의 수와 패티의 수를 배열에 저장
		for (int i = 1; i <= n; i++) {
			total[i] = 2*total[i-1] + 3;
			patty[i] = 2*patty[i-1] + 1;
		}

		// 정답 출력
		long ans = getpattiescnt(n, x); // (레벨, 먹은 레이어의 수)
		System.out.println(ans);
	}

	public static long getpattiescnt(int n, long x) {

		// 경우의 수 분류
		// 레벨 햄버거의 구조 : [번 + 이전버거 + 패티 + 이전버거 + 번]

		// (0) 특수한 경우 처리(초기값 & 한 레이어만 먹었을 경우)
		// (1) 중간 패티 이전
		// (2) 중간 패티
		// (3) 중간 패티 이후
		// (4) 전체

		// 초기값(n=0, 패티 한 장)일 경우
		if (n == 0) {

			// 아무것도 안 먹었을 때
			// 먹은 패티의 수는 0이다.
			if (x == 0) {
				return 0;
			}

			// 레이어 하나 먹었을 때
			// 레벨0 햄버거는 패티 한 장이므로
			// 먹은 패티의 수는 1이다.
			else if (x == 1) {
				return 1;
			}
		}

		// 초기값(n=0)이 아닐 경우에 한 장만을 먹었다는 건
		// 항상 맨 아래 위치한 번만 먹었다는 것이므로
		// 먹은 패티의 수는 0이다.
		if (x == 1) {
			return 0;
		}


		// (1) 중간 패티 이전(절반 이전)
		// 맨 앞 빵을 빼준 뒤(x-1),
		// 이전 레벨의 햄버거로 돌아가는 재귀함수를 호출(n-1)
		if (x < total[n-1] + 2) {
			return getpattiescnt(n-1, x-1);
		}
			
		// (2) 중간 패티(절반)
		// 이전 레벨의 햄버거의 패티 수 + 현재 레벨의 중앙 패티(1장)을 반환
		else if (x == total[n-1] + 2) {
			return patty[n-1] + 1;
		}

		// (3) 중간 패티 이후(절반 이상)
		// 중간을 포함하는 중간 이전의 패티의 수를 더한 뒤(patty[n-1] + 1)
		// 중간 이후의 패티 수를 구하기 위해 재귀함수를 호출(n-1), 
		// 이때 총 먹은 레이어의 수에서 이전 레벨에서 먹은 절반만큼을 제거(- total[n-1] - 2)  
		else if (x < 2*total[n-1] + 2) {
			return patty[n-1] + 1 + getpattiescnt(n - 1, x - total[n-1] - 2);
		} 

		// (4) 전체
		// 먹은 전체 패티의 수 반환
		else {
			return 2*patty[n-1] + 1;
		}
	}
}
