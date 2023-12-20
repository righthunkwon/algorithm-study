import java.io.*;
import java.util.*;

public class Pro_18223_민준이와마산그리고건우 {
	static int V;
	static PriorityQueue<Node> pq;
	static boolean[] visited;
	static int[] dist;
	static List<Node>[] arr;

	static class Node implements Comparable<Node> {
		int ed, w;
		public Node(int ed, int w) {
			this.ed = ed;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		arr = new ArrayList[V + 1];
		dist = new int[V + 1];
		for (int i = 1; i < V + 1; i++) {
			arr[i] = new ArrayList<Node>();// 인접리스트 생성
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a].add(new Node(b, c));
			arr[b].add(new Node(a, c));
		}
		// 다잌스트라로 최단거리 찾을 수 있음 1출발 V도착
		// 근데 그때 P를 들리는지 알아야함

		pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		dijk(1);//1부터 각 정점까지의 최소거리 구함
		int min_v = dist[V];// 1-v까지의 최소거리
		int min_p = dist[P]; // 1-p까지의 최소거리

		pq.add(new Node(P, 0));
		dijk(P);//P부터 각 정점까지의 최소거리 구함
		int ptov = dist[V];// p-v까지의 최소거리

		//결과출력
		//1-v 와 1-p+p-v 거리 같다면 최소거리에 p가 있다는 뜻
		if (min_v == min_p + ptov)
			System.out.println("SAVE HIM");
		else {
			System.out.println("GOOD BYE");
		}

	}

	private static void dijk(int start) {
		Arrays.fill(dist, Integer.MAX_VALUE); //거리배열 무한대로 
		dist[start] = 0;				 	//시작점 거리 0
		visited = new boolean[V + 1];

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			visited[curr.ed] = true;		//선택된 정점 방문처리	
			for (Node n : arr[curr.ed]) { //현재 정점과 연결된 정점 돌기
				if (!visited[n.ed] && dist[n.ed] > dist[curr.ed] + n.w) {
					//방문하지않았고 (방문했다면 최소거리 확정이기 때문)
					//(연결 정점의 최소거리> 현재정점의 최소거리+간선)면 최소거리 새로 갱신 
					dist[n.ed] = dist[curr.ed] + n.w;
					pq.add(new Node(n.ed, dist[n.ed]));
				}
			}
		}
	}
}
