package level_28_priority_queue;

import java.io.*;
import java.util.*;

// 절댓값 힙
public class P_11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// 반환값이 음수면 첫 번째 인자가 두 번째 인자보다 작음 → 자리를 유지
				// 반환값이 양수면 첫 번재 인자가 두 번째 인자보다 큼 → 자리를 바꿔줌
				// 반환값이 0이면 두 인자가 같음 → 자리를 그대로

				// 절대값 기준으로 앞 값이 더 크다면 자리를 바꿔준다.
				if (Math.abs(o1) > Math.abs(o2)) {
					return Math.abs(o1) - Math.abs(o2);
				} 
				
				// 절대값이 같다면 입력값을 기준으로 오름차순 정렬
				// o1 - o2가 양수면 o1이 더 큰 것이므로 자리를 바꿔주고
				// o1 - o2가 음수면 o2가 더 큰 것이므로 자리를 유지한다.
				else if (Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}

				// 절갯값 기준으로 뒤 값이 더 크다면 자리률 유지한다.
				else {
					return -1;
				}
			}
		});

		for (int i = 0; i < N; i++) {
			int operation = Integer.parseInt(br.readLine());
			if (operation == 0) {
				if (!pq.isEmpty())
					System.out.println(pq.poll());
				else
					System.out.println(0);
			} else {
				pq.add(operation);
			}
		}
	}
}
