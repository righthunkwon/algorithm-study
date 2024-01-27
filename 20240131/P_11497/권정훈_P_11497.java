package level_25_greedy;

import java.io.*;
import java.util.*;

// 통나무 건너뛰기
public class P_11497 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			// 기운데를 가장 높은 통나무로 배치
			int left = 0;
			int right = N - 1;
			int[] logs = new int[N];
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					logs[left++] = arr[i];
				} else {
					logs[right--] = arr[i];
				}
			}
			
			// 난이도 찾기
			int ans = 0;
			ans = Math.max(ans, Math.abs(logs[0] - logs[N - 1])); // 처음과 끝
			for (int i = 1; i < N; i++) { // 나머지
				ans = Math.max(ans, Math.abs(logs[i] - logs[i-1]));
			}
			
			// 정답 출력
			System.out.println(ans);
		}
	}
}
