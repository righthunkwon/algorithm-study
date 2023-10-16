package level_16_stack_queue_deque;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

// 최애의 팀원
// 가장 앞에 선 학생부터 자신의 최애의 팀원을 찾아간다 - 큐 자료구조 활용
public class P_29813 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 학생의 수
		Queue<String> q = new LinkedList<>(); // 대기열
		Map<String, Integer> passCnt = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			int num = sc.nextInt();
			q.add(str);
			passCnt.put(str, num);
		}
		out: while (q.size() > 1) {
			String student = q.poll(); // 짝 찾는 학생
			for (int i = 1; i < passCnt.get(student); i++) {
				if (q.isEmpty()) break out; // 한 명 남으면 종료
				String tmp = q.poll(); // 뽑고
				q.add(tmp); // 넣고
			}
			q.poll(); // 짝 제거
		}
		System.out.println(q.poll());
	}
}
