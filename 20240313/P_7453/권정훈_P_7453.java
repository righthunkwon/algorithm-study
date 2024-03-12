package level_27_binary_search;

import java.io.*;
import java.util.*;

// 합이 0인 네 정수
// 4000 * 4000 * 4000 * 4000 = 256,000,000,000,000
public class P_7453 {
	static int n;
	static long ans;
	static int[][] arr;
	static int[] AB;
	static int[] CD;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[4][n];
		AB = new int[n * n];
		CD = new int[n * n];

		for (int j = 0; j < n; j++) {
			String[] str = br.readLine().split(" ");
			for (int i = 0; i < 4; i++) {
				arr[i][j] = Integer.parseInt(str[i]);
			}
		}

		// 배열 압축
		// A0+B0, A0+B1, A1+B0, A1+B1 ...
		
		// A와 B의 모든 순서쌍(4000 * 4000)
		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				AB[k++] = arr[0][i] + arr[1][j];
			}
		}

		// C와 D의 모든 순서쌍(4000 * 4000)
		k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				CD[k++] = arr[2][i] + arr[3][j];
			}
		}

		// 이분탐색을 위한 정렬
		Arrays.sort(AB);
		Arrays.sort(CD);

		twoPointer();

		System.out.println(ans);

	}

	private static void twoPointer() {
		int start = 0; // AB앞부터 시작
		int end = n * n - 1; // CD뒤부터 시작

		// 탐색 시작
		while (start < n * n && end >= 0) {
			long num1 = AB[start];
			long num2 = CD[end];
			long sum = num1 + num2;
			
			// 합이 0보다 작으면 AB의 값을 증가
			if (sum < 0) {
				start++;
			} 
			// 합이 0보다 크면 CD의 값을 감소
			else if (sum > 0) {
				end--;
			} 
			// AB와 CD의 합이 0이면
			// 두 숫자의 합이 같은 경우 해당하는 숫자의 개수를 세어 곱해서 정답에 더해준다
			else {
				long startCnt = 0; // AB[start]와 같은 수의 개수를 구한다
				long endCnt = 0; // CD[end]와 같은 수의 개수를 구한다
				while (start < n * n && num1 == AB[start]) {
					start++;
					startCnt++;
				}
				while (end >= 0 && num2 == CD[end]) {
					end--;
					endCnt++;
				}
				ans += startCnt * endCnt;
			}
		}
	}
}
