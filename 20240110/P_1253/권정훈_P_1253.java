package level_33_two_pointer;

import java.io.*;
import java.util.*;

// 좋다
public class P_1253 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); // 투포인터는 정렬하지 않으면 틀린다(문제 조건 꼭 확인할 것)

		int ans = 0;
		for (int i = 0; i < N; i++) {
			int start = 0;
			int end = N - 1;
			int good = arr[i]; // 찾는 수

			while (start < end) {
				int sum = arr[start] + arr[end];
				if (sum == good) {
					if (start != i && end != i) { // 자기 자신 제외
						ans++;
						break;
					} else if (start == i) {
						start++;
					} else {
						end--;
					}
				} else if (sum < good) {
					start++;
				} else {
					end--;
				}
			}
		}
		System.out.println(ans);
	}
}
