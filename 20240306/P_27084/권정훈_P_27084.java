package level_19_combinatorics;

import java.io.*;
import java.util.*;

// 카드 뽑기
public class P_27084 {
	static int n;
	static long ans;
	static int[] arr;
	static HashMap<Integer, Integer> selected;
	static final int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 입력
		ans = 1;
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 효율화
		selected = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (selected.containsKey(arr[i])) {
				selected.put(arr[i], selected.get(arr[i]) + 1);
			} else {
				selected.put(arr[i], 1);
			}
		}

		// 승리하기 위해서는 각 숫자는 한 장씩만 뽑아야 함
		// 전체 카드의 개수(value)중 하나만 뽑는 경우와 아예 안 뽑는 경우
		for (int v : selected.values()) {
			ans *= v + 1;
			ans %= MOD;
		}
		System.out.println(ans -1);
	}
}
