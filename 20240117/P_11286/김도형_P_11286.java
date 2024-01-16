package AlgoStudy;

import java.io.*;
import java.util.*;

public class BOJ_Q11286_절댓값_힙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 연산의 개수
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) > Math.abs(o2)) {
					return 1;
				} else if (Math.abs(o1) < Math.abs(o2)) {
					return -1;
				} else { // 절댓값 동일한 경우 작은수 출력
					if (o1 > o2) {
						return 1;
					} else if (o1 < o2) {
						return -1;
					} else {
						return 0;
					}
				}
			}
		});
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a != 0)
				pq.add(a);
			else if (a == 0 && !pq.isEmpty()) {//
				System.out.println(pq.poll());
			} else if (a == 0 && pq.isEmpty()) { // 배열 비어있는데 출력 요청하면
				System.out.println(0);
			}
		}
	}
}
