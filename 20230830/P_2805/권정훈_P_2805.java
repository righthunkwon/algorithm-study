package level_27_binary_search;

import java.util.Arrays;
import java.util.Scanner;

// 나무자르기
// 이분탐색 & 매개변수 탐색 
// mid의 값 그대로 비교하는 것이 아니라, mid의 값을 대입하여 나무의 길이를 구한 뒤,
// mid를 올릴지 내릴지 결정하는 것이므로 엄밀히 말하면 매개변수 탐색이 맞지만, 이분탐색의 응용 정도로도 풀이할 수 있다.
// upper bound를 먼저 적용한 뒤 적용되지 않을 경우 lower bound를 적용하는 것이 에러 발생 확률이 낮다(일단 이해는 안 되지만 암기).
public class P_2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 나무의 수
		int m = sc.nextInt(); // 나무의 길이
		int[] arr = new int[n]; // 나무 배열

		// 나무 배열 요소 입력
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		// 나무 배열 정렬
		Arrays.sort(arr);

		// 이진 탐색(upper bound)
		System.out.println(upperBound(arr, m));
	}

	private static int upperBound(int[] arr, int key) {
		// start 값을 0으로, end 값을 나무 중 가장 큰 나무의 길이로 지정한다.
		// mid를 구한 뒤 이분 탐색을 통해 얻을수 있는 나무의 길이를 구한다.

		// 요구되는 나무의 길이보다 얻을 수 있는 나무의 길이가 길거나 같다면 절단기의 높이를 높인다(start = mid + 1)
		// 요구되는 나무의 길이보다 얻을 수 있는 나무의 길이가 짧다면 절단기의 높이를 낮춘다(end = mid - 1)
		// 반복문이 종료되면 최대 높이를 출력한다.

		int st = 0; // 시작점
		int ed = arr[arr.length - 1]; // 종료점
		int ans = 0; // 정답(절단기의 최대 높이)

		while (st <= ed) {
			int mid = (st + ed) / 2; // 중간점
			long sum = 0; // 나무들의 높이 합(나무의 길이가 최대 10억이므로 long으로 선언)

			// 나무의 길이만큼 반복
			for (int i = 0; i < arr.length; i++) {

				// 중간점을 기준으로 자른 나무들의 높이의 합(0보다 클 때만 합)
				if (arr[i] - mid > 0) {
					sum += arr[i] - mid;
				}
			}
			
			// 자른 나무들의 높이의 합이 필요한 나무의 길이보다 길 경우
			// 더 높은 곳에서 나무를 잘라야 하므로 하한점을 높여야 한다.
			if (sum >= key) {
				st = mid + 1;
				
				// 높은 게 더 낫다(upper bound).
				if (mid >= ans) {
					ans = mid;
				}
			}

			// 자른 나무들의 높이의 합이 필요한 나무의 길이보다 짧을 경우
			// 더 낮은 곳에서 나무를 잘라야 하므로 상한점을 낮춰야 한다.
			else {
				ed = mid - 1;
			}
		}
		return ans;
	}

}
