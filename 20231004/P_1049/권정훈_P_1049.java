package greedy;

import java.util.Scanner;

// 기타줄
public class P_1049 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 필요한 기타줄의 개수
		int m = sc.nextInt(); // 기타줄 브랜드
		int[] pack = new int[m]; // 6개 패키지 가격
		int[] each = new int[m]; // 1개 낱개 가격

		// 배열 요소 입력
		int packmin = Integer.MAX_VALUE;
		int eachmin = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			pack[i] = sc.nextInt();
			each[i] = sc.nextInt();
			packmin = Math.min(packmin, pack[i]); // 최소 패키지 가격
			eachmin = Math.min(eachmin, each[i]); // 최소 낱개 가격
		}

		// 풀이 로직
		int ans = 0; // 정답
		int packcnt = n / 6; // 패키지의 개수
		int restcnt = n % 6; // 나머지의 개수

		// 필요한 기타줄의 수가 한 패키지에 포함된 기타줄의 수보다 적을 때
		// 패키지보다 낱개로 사는 게 더 저렴한 경우
		if (packmin >= 6 * eachmin) {
			ans = n * eachmin;
		}

		// 일단은 패키지로 사는 게 더 저렴한 경우
		else {
			// 패키지로 최대한 사보고 남은 나머지는 낱개로 사는 게 더 저렴한 경우
			if (packmin >= restcnt * eachmin) {
				ans = (packcnt * packmin) + (restcnt * eachmin);
			}

			// 개수가 남더라도 패키지로만 사는 게 가장 저렴한 경우
			else {
				ans = (packcnt + 1) * packmin;
			}
		}
		System.out.println(ans);
	}
}
