package level_16_stack_queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 센티와 마법의 뿅망치
// 우선순위큐를 키를 기준으로 내림차순으로 초기화
public class P_19638 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 거인 수
		int h = Integer.parseInt(st.nextToken()); // 센티 키
		int t = Integer.parseInt(st.nextToken()); // 뿅망치 횟수제한

		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐 내림차순 생성
		
		// 우선순위큐에 거인 수만큼 거인의 키 요소 삽입
		for (int i = 0; i < n; i++) {
			q.add(Integer.parseInt(br.readLine()));
		}

		// 뿅망치 횟수만큼 키를 절반으로 줄임
		boolean flag = false; // 전체 
		for (int i = 0; i < t; i++) {
			// 가장 큰 거인의 키가 센티의 키보다 작을 경우 
			if (q.peek() < h) {
				System.out.println("YES");
				System.out.println(i);
				flag = true;
				break;
			}
			
			// 가장 큰 거인의 키가 1일 경우
			if (q.peek() == 1) break;
			
			// 조건에 맞지 않을 경우 
			// 해당 요소를 꺼내고 키를 절반으로 한 뒤 큐에 다시 넣음
			int tmp = q.poll();
			q.add(tmp / 2);
		}

		// 마지막 고려
		if (!flag) {
			if (q.peek() < h) {
				System.out.println("YES");
				System.out.println(t);
			} else {
				System.out.println("NO");			
				System.out.println(q.peek());
			}
		}
	}
}
