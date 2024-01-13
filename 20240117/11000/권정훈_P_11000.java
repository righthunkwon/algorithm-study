package level_28_priority_queue;

import java.io.*;
import java.util.*;

// 강의실 배정
// 먼저 시작 시간을 기준으로 오름차순 정렬
// 이후 시작 시간이 같다면 종료 시간을 기준으로 오름차순 정렬
// 객체 간 비교 시 Comparable 혹은 Comparator 인터페이스 활용
// 단 클래스 내에서 객체의 순서를 정의하기 위해서는 Comparator가 아니라 Comparable를 사용해야 함 
public class P_11000 {

	// 클래스 내에서 객체의 순서를 정의하기 위함이므로
	// Comparator가 아니라 Comparable로 구현 클래스를 만들어야 한다.
	// Comparator로 구현 클래스를 만들 시 ClassCastException이 발생한다.
	private static class Lesson implements Comparable<Lesson> {
		int st, ed;

		public Lesson(int st, int ed) {
			this.st = st; // 수업 시작 시간
			this.ed = ed; // 수업 종료 시간
		}

		// 수업 시작 시간을 기준으로 오름차순 정렬
		// 만약 수업 시작 시간이 같다면 수업 종료 시간을 기준으로 오름차순 정렬
		@Override
		public int compareTo(Lesson o) {
			if (this.st == o.st) return this.ed - o.ed; // 오름차순
			else return this.st - o.st; // 오름차순
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 수업 수
		Lesson[] lessons = new Lesson[N]; // 수업 객체를 저장할 배열

		// 수업 객체 배열 요소 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			lessons[i] = new Lesson(start, end);
		}
		Arrays.sort(lessons); // 인터페이스를 구현만 했으므로 별도의 정렬 필수(시작 시간 기준 정렬)
		
		// 수업 종료 시간과 수업 시작 시간을 비교하여
		// 종료 시간이 다음 수업 시작 시간보다 늦는다면 새로운 강의실이 필요하지 않음
		// 강의실을 배정해야 할 경우 pq에 값을 추가하고 총 강의실의 수(pq의 size)를 출력
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 수업 종료 시간 pq
		pq.add(lessons[0].ed); // 첫 강의실 배정(첫 강의실은 시작시간이 가장 이른 수업에 배정)
		
		for (int i = 1; i < N; i++) {
			if (pq.peek() <= lessons[i].st) pq.poll(); // 기존 강의실에 추가하면 되므로 큐에서 제거 
			pq.add(lessons[i].ed); // 일단 강의실을 추가하며 그리디하게 다음 상황 파악
		}
		System.out.println(pq.size());
	}
}
