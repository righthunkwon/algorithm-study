
import java.io.*;
import java.util.*;

// 줄세우기
// 가장 긴 오름차순의 길이
// 최장 증가 수열 (LIS)
public class P_2631 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int[] dp = new int[N];
		dp[0] = 1;

		int ans = 0;
		for (int i = 1; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(N - ans);
	}
}
