package baek;

import java.io.*;
import java.util.*;
//두 집 사이에는 경로가 항상 존재 , 유지비 최소 
//=> 프림알고리즘 사용으로 모든 선 이어지는 최소 신장 트리 고르고(문제에서 임의의 두 집 사이에 경로 항상 존재),
//그 중 가장 max값인 선  한 개 삭제하면 마을 두 개로 분리된다.

//프림알고리즘 : 노드 기준으로 방문하고 그 뒤 방문 노드와 연결된 간선을 확인하여 최소 거리 간선을 선택하는 방식으로 진행 
public class Pro_1647_도시분할계획 {
	static class Node implements Comparable<Node> {
		int ed, w;

		public Node(int ed, int w) {
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;// 작은 수 부터 나오게
		}
	}

	static List<Node>[] arr;
	static final int INF = Integer.MAX_VALUE;
	static int[] dist;
	static boolean[] visited;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];// 배열안에 인접한 Node리스트 넣기,1번부터 하려고 N+1
		// 미리 모든 list 생성
		for (int i = 0; i < N + 1; i++) arr[i] = new ArrayList<Node>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			arr[A].add(new Node(B, C));
			arr[B].add(new Node(A, C));// 양쪽길 연결
		} // 입력 끝
		dist = new int[N + 1];
		visited = new boolean[N + 1];
		Arrays.fill(dist, INF);// 최댓값 세팅
		// 1번 정점부터 시작
		pq = new PriorityQueue<Node>();
		pq.add(new Node(1, 0));// 시작 1번 정점부터 찾는다.
		prim();
		int max = 0;
		int sum = 0;
		for (int i = 1; i < N + 1; i++) {
			max = Math.max(dist[i], max);//간선 중 가장 최대 간선 자르려고 저장
			sum += dist[i];
		}
		System.out.println(sum - max);
	}

	private static void prim() {
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (!visited[curr.ed]) {			//정점이 방문하지 않았다면
				visited[curr.ed] = true;		//방문처리 
				dist[curr.ed] = curr.w;		    // pq로 꺼내진 가장 노드는 선택된 것이므로 값 저장.
				List<Node> list = arr[curr.ed];// 끝점을 시작점으로 하는 간선리스트
				for (Node n : list) {
					if (!visited[n.ed])// 도착지점이 방문처리 되지 않앗다면(사이클을 막기 위해), pq에 넣기
						pq.add(n);
				}

			}
		}
	}
}
