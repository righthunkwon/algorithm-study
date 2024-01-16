package level_33_two_pointer;

import java.io.*;
import java.util.*;

// 댄스 파티
// 단순 배열로 풀면 삭제하는 부분에서 시간초과 발생(O(N))
// 우선순위큐를 활용하여 삭제를 효율화하여 풀면 패스(O(logN)) - 힙(완전이진트리)
public class P_2831 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		// 자동 정렬
		PriorityQueue<Integer> m1 = new PriorityQueue<>(); // 키 큰 여자와 춤추기를 원하는 남자(키: 양수)
		PriorityQueue<Integer> m2 = new PriorityQueue<>(); // 키 작은 여자와 춤추기를 원하는 남자(키: 음수)
		PriorityQueue<Integer> w1 = new PriorityQueue<>(); // 키 큰 남자와 춤추기를 원하는 여자(키: 양수)
		PriorityQueue<Integer> w2 = new PriorityQueue<>(); // 키 작은 남자와 춤추기를 원하는 여자(키: 음수)

		// 남자 입력
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp > 0) m1.add(tmp);
			else m2.add(-tmp);
		}
		// 여자 입력
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp > 0) w1.add(tmp);
			else w2.add(-tmp);
		}
		
		// m1 w2 매칭
		int ans = 0;
		while (!m1.isEmpty() && !w2.isEmpty()) {
			if (m1.peek() < w2.peek()) {
				m1.poll();
				w2.poll();
				ans++;
			} else {
				w2.poll();
			}
		}

		// m2 w1 매칭
		while (!m2.isEmpty() && !w1.isEmpty()) {
			if (m2.peek() > w1.peek()) {
				m2.poll();
				w1.poll();
				ans++;
			} else {
				m2.poll();
			}
		}
		System.out.println(ans);
	}

}
