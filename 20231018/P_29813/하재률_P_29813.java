package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_29813_최애의팀원 {
	// String과 int를 함께 저장하기 위해 class를 만들어요
	static class Node {
		String s;
		int x;
		public Node(String s, int x) {
			this.s = s;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Queue<Node> q = new LinkedList<>();

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			q.add(new Node(st.nextToken(), Integer.parseInt(st.nextToken())));
		}// 입력 완

		while(q.size() > 1) { // q에 하나의 요소가 남을때까지 반복
			int tmp = q.poll().x; // 젤 앞에 선 사람의 X를 저장해서
			for(int i = 1; i < tmp; i++) { // X-1번만큼 패스
				Node poll = q.poll();
				q.add(new Node(poll.s, poll.x));
			}
			q.poll(); // 젤 앞에 선 사람과 손 잡고 나가
		}
		System.out.println(q.peek().s);

	}
}