package level_21_recursion;

import java.io.*;
import java.util.*;

// 시철이가 사랑한 GCD
// 유클리드 호제법(오름차순 정렬을 전제, 정렬이 안 되어 있을 경우 두 수의 값을 바꿔줘야 함)
public class P_21870 {
	private static int N;
	private static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(dfs(arr));
	}

	public static int dfs(int[] arr) {
		if (arr.length == 1) {
			return arr[0];
		} else {
			int mid = arr.length / 2; // 절반나누는 인덱스

			// 왼쪽배열
			int[] larr = new int[mid];
			for (int i = 0; i < mid; i++) {
				larr[i] = arr[i];
			}

			// 오른쪽배열
			int[] rarr = new int[arr.length - mid];
			for (int i = mid; i < arr.length; i++) {
				rarr[i - mid] = arr[i];
			}

			// 왼쪽 들어갔다가 오른쪽 돌아보거나
			// 오른쪽 들어갔다가 왼쪽 돌아보기
			return Math.max(solve(larr) + dfs(rarr), solve(rarr) + dfs(larr));
		}
	}

	// 배열의 모든 요소에 대한 최대공약수 계산
	private static int solve(int[] arr) {
		int gcd = arr[0];
		for (int i = 1; i < arr.length; i++) {
			gcd = GCD(gcd, arr[i]);
		}
		return gcd;
	}

	// GCD(9, 15)
	// 15,9 -> 9,6 -> 6,3 -> 3,0
	public static int GCD(int a, int b) {
		while (b != 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		return a;
	}

}
