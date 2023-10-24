package baek;

import java.io.*;
import java.util.*;

public class Pro_11054_가장긴바이토닉부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 각 i방을 기준으로 앞에는 작은 것이있는지, 뒤에도 작은 것이 있는지 확인 후 개수 세고 더하기
		int[] dp_min = new int[N];
		// 1.앞에 작은 것이 몇 개 있는지
		dp_min[0] = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j])
					dp_min[i] = Math.max(dp_min[j] + 1, dp_min[i]);
			}
		}
//		System.out.println(Arrays.toString(dp_min));
		//2.뒤에 작은 것이 몇 개 있는지
		int[] dp_max = new int[N];
		dp_max[N - 1] = 0;
		for (int i = N - 1; i >= 0; i--) {
			for (int j = N - 1; j > i; j--) {
				if (arr[i] > arr[j])
					dp_max[i] = Math.max(dp_max[j] + 1, dp_max[i]);
			}
		}
//		System.out.println(Arrays.toString(dp_max));
		int[] dp = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = dp_min[i] + dp_max[i] + 1;
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
