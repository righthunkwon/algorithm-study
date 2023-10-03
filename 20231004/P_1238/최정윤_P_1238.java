import java.io.*;
import java.util.*;

public class Pro_1238_파티 {

	static int N;
	static int[] dist;
	static PriorityQueue<Node> pq;
	static List<Node>[] arr;

	static class Node implements Comparable<Node> {
		int end;
		int T;

		public Node(int end, int T) {
			this.end = end;
			this.T = T;
		}

		@Override
		public int compareTo(Node o) {// T가 짧은 것부터 나와라
			// TODO Auto-generated method stub
			return this.T - o.T;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 학생수
		int M = Integer.parseInt(st.nextToken());// 도로 수
		int X = Integer.parseInt(st.nextToken());// 파티하는 곳
		arr = new ArrayList[N + 1];
		int[] result = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			arr[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			arr[start].add(new Node(end, T));
		} // 입력끝

		dist = new int[N + 1];
		pq = new PriorityQueue<Node>();

		// N명의 학생 집부터 X까지의 최단거리 구하는 것
		for (int j = 1; j <= N; j++) {
			pq.add(new Node(j, 0));
			dijk(j);// j부터 인덱스까지의 최단거리가 dist[] 배열에 담긴다.
			result[j] = dist[X]; // j부터 X까지의 최단거리를 result 배열에 저장
		}

		// X부터 N명의 학생의 집까지 최단거리 구하는 것
		pq.add(new Node(X, 0));
		dijk(X);
		for (int i = 1; i < N + 1; i++) {
			result[i] += dist[i];
		}

		Arrays.sort(result);
		System.out.println(result[N]);

	}

	static void dijk(int j) {
		boolean[] visited = new boolean[N + 1];
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (visited[curr.end])// 방문한 것은 그 지점까지의 최단거리 확정이기 때문에 pq에서 값이 나와도 변할 수 없다.
				continue;
			// visited안된 것 중에 나온 것은 우선순위큐를 통해 최단거리가 나온것이므로 ,
			visited[curr.end] = true; // 방문처리해주고
			dist[curr.end] = curr.T;// 최단거리를 dist에 넣어주고
			List<Node> list = arr[curr.end]; // 연결된 노드값 빼기
			for (Node node : list) {// 연결된 노드 돌면서 그 T가 최단거리던 아니던 몽땅 넣기, 어차피 빼낼때 우선순위 큐가 최단거리를 빼줄것이므로!
				pq.add(new Node(node.end, node.T + curr.T));
			}
		}
	}
}
