package study_240417;

import java.io.*;
import java.util.*;

public class Pro_17140_이차원배열과연산 {
	static class Result implements Comparable<Result> {
		int key, value;

		public Result(int key, int value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(Result o) {
			if (this.value == o.value)
				return this.key - o.key;
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int k = Integer.parseInt(st.nextToken());

		A = new int[100][100];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력끝
		r_length = 3;
		c_length = 3;
		if (A[r][c] == k)
			System.out.println(0);
		else {
			int cnt = 0;
			while (true) {
				cnt++;
				if (r_length >= c_length) {
					// R연산
					max = R();
					c_length = max;
				} else {// C연산
					C();
				}
				if (A[r][c] == k) {
					System.out.println(cnt);
					break;
				}
				if (cnt == 100) {
					System.out.println(-1);
					break;
				}

			}
		}
	}

	static int[][] A;
	static int max, r_length, c_length;

	private static void C() {
		HashMap<Integer, Integer> map;
		PriorityQueue<Result> pq;
		int max2 = 0;
		for (int i = 0; i < max; i++) {
			map = new HashMap<Integer, Integer>();
			for (int j = 0; j < A.length; j++) {
				if (A[j][i] == 0)
					continue;
				map.put(A[j][i], map.getOrDefault(A[j][i], 0) + 1);
				A[j][i] = 0;
			}
			pq = new PriorityQueue<>();
			for (Integer key : map.keySet()) {
				pq.add(new Result(key, map.get(key)));
			}
			max2 = Math.max(max2, pq.size() * 2);
			int idx = 0;
			while (!pq.isEmpty()) {
				Result r = pq.poll();
				if (idx == 100)
					break;
				A[idx][i] = r.key;
				if (idx + 1 == 100)
					break;
				A[idx + 1][i] = r.value;
				idx += 2;

			}
			r_length = max2;
		}
	}

	private static int R() {
		// 등장 수 작->큰
		// 등장 수 동일 : 수 작->큰
    // map에 수만큼 세서 담고, 다 빼면서 다시 값 넣기
		HashMap<Integer, Integer> map;
		PriorityQueue<Result> pq;
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			map = new HashMap<Integer, Integer>();
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] == 0)
					continue;
				map.put(A[i][j], map.getOrDefault(A[i][j], 0) + 1);
				A[i][j] = 0;
			}
			pq = new PriorityQueue<>();
			for (Integer key : map.keySet()) {
				pq.add(new Result(key, map.get(key)));
			}
			max = Math.max(max, pq.size() * 2);
			int idx = 0;
			while (!pq.isEmpty()) {
				Result r = pq.poll();
				if (idx == 100)
					break;
				A[i][idx] = r.key;
				if (idx + 1 == 100)
					break;
				A[i][idx + 1] = r.value;
				idx += 2;
			}
		}
		return max;
	}
}
