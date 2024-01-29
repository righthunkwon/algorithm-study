package level_00_basic;

import java.io.*;
import java.util.*;

// 겹치는 건 싫어
public class P_20922 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 숫자 배열
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 투포인터
		// end를 늘려나가며 판단
		// 숫자가 K번 이상 사용되었다면 start를 늘림
		int ans = 0;
		int start = 0;
		int end = 0;
		int[] cnt = new int[100001];
		while (start <= end) {
//			System.out.println(Arrays.toString(cnt));
//			System.out.println(start);
//			System.out.println(end);
			if (end <= N - 1 && cnt[arr[end]] < K) {
				cnt[arr[end]]++;
				end++;
			} else if (cnt[arr[end]] == K) {
				cnt[arr[start]]--;
				start++;
			}
			ans = Math.max(ans, end - start);
			if (end == N) break;
		}
		System.out.println(ans);

	}
}
