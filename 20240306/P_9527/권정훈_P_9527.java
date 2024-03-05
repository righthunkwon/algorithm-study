package level_99_bitmask;

import java.io.*;
import java.util.*;

// 1의 개수 세기
// https://tussle.tistory.com/1022
public class P_9527 {
	static long[] dp = new long[55];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		// 1의 개수의 누적합 계산
		dp(); 

		// A이상 B이하의 정수들에 대한 1의 개수의 합 계산
		// B의 누적합 - (A-1)의 누적합
		long ans = getCountOfNumberOne(B) - getCountOfNumberOne(A - 1);
		System.out.print(ans);
	}

	// 1~N 정수의 1의 개수 구하기
	static long getCountOfNumberOne(long N) {
		long cnt = N & 1; // 홀수 짝수 판단
		int size = (int) (Math.log(N) / Math.log(2)); // N보다 작은 2^n의 n의 최대값
		
		// 비트마스킹을 이용한 1의 개수 계산 진행
		// DP[i-1] : 000 ~ 111 개수
		// N - (1L << i) : 지정된 1이 반복 사용될 개수
		// + 1 : 1000...
		for (int i = size; i > 0; i--) {
			if ((N & (1L << i)) != 0L) {
				cnt += dp[i - 1] + (N - (1L << i) + 1);
				N -= (1L << i); // 비트 이동
			}
		}
		return cnt; // 1의 개수 반환
	}

	// DP[n] = DP[n-1] × 2 + 2^n
	// 1의 개수의 누적합을 저장하는 함수
	static void dp() {
		dp[0] = 1; // 초기값
		
		// dp[n-1] x 2 	== 	dp[i-1] << 1 
		// 2^n 			== 	1L << i
		for (int i = 1; i < 55; i++) {
			dp[i] = (dp[i - 1] << 1) + (1L << i);
		}
	}
}
