package level_00_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 통계학
public class P_2108 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 수의 개수
		int[] arr = new int[n]; // 수 저장 배열
		double sum = 0; // 산술평균에 활용할 합

		// 배열 요소 입력 및 합 계산
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}

		// 중앙값과 범위를 구하기 위한 정렬
		Arrays.sort(arr);

		int max = -987654321;
		int cnt = 0;
		int mode = arr[0];
		boolean flag = false; // 두 번째로 작은 값을 찾기 위한 flag

		// 최빈값 구하는 반복문
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				cnt++;
			} else {
				cnt = 0;
			}

			// 최빈값을 나타내는 최댓값 갱신
			if (max < cnt) {
				max = cnt;
				mode = arr[i];
				flag = true;
			} else if (max == cnt && flag == true) {
				mode = arr[i];
				flag = false;
			}
		}
		System.out.println(Math.round(sum / n)); // 산술평균
		System.out.println(arr[(n - 1) / 2]); // 중앙값
		System.out.println(mode); // 최빈값
		System.out.println(arr[n - 1] - arr[0]); // 범위
	}
}
