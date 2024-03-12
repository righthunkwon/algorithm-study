
import java.io.*;
import java.util.*;


// 프림 알고리즘
// 하나의 시작 정점을 기준으로 가장 비용이 작은 간선과 연결된 정점을 선택하며 노드를 연결

// 나만 안 되는 연애
public class P_14621 {

	private static class Node implements Comparable<Node> {
		int next, cost;

		public Node(int to, int w) {
			this.next = to;
			this.cost = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 학교 수
		int M = Integer.parseInt(st.nextToken()); // 도로 수
		ArrayList<Node>[] list = new ArrayList[N + 1]; // 정점배열
		boolean[] isMan = new boolean[N + 1]; // 남초대학교 여부

		// 리스트 초기화
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>(); 
		}
		
		// 남초 여부 저장
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			isMan[i] = st.nextToken().equals("M");
		}

		// 정점리스트배열 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int prev = Integer.parseInt(st.nextToken()); // 이전
			int next = Integer.parseInt(st.nextToken()); // 이후
			int cost = Integer.parseInt(st.nextToken()); // 비용
			
			// 다른 타입의 대학교인 경우에만 이동
			if (isMan[prev] != isMan[next]) {
				list[prev].add(new Node(next, cost));
				list[next].add(new Node(prev, cost));
			}
		}

		int ans = 0; // 최소 비용 합
		int cnt = 0; // 정점의 수
		PriorityQueue<Node> pq = new PriorityQueue<>(); // 비용 순 정렬
		boolean[] visited = new boolean[N + 1]; // 정점 방문확인
		pq.offer(new Node(1, 0)); // 시작 정점
		
		// 탐색
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (visited[curr.next]) continue;
			visited[curr.next] = true;
			ans += curr.cost;
			cnt++;
			for (Node node : list[curr.next]) {
				if (!visited[node.next]) {
					pq.offer(node);
				}
			}
		}

		if (cnt == N) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}
	}
}
