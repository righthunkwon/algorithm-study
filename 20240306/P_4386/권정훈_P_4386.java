package level_99_prim_kruskal;

import java.io.*;
import java.util.*;

// 별자리 만들기
// 크루스칼 알고리즘
// 최소 스패닝 트리에서 활용
// 최소 스패닝 트리는 특정 정점을 최소 비용으로 연결하는 자료구조
// 즉, 크루스칼 알고리즘은 모든 노드를 최소한으로 연결하는 간선의 가중치의 값을 최소로 구하는 알고리즘

// 노드의 개수를 n개라고 할 경우 간선의 개수는 n-1개이므로, 
// 모든 간선 정보를 오름차순으로 정렬한 뒤 비용이 적은 간선부터 순차적으로 그래프에 포함
// 또한, 사이클을 형성시키는 간선은 그래프에 포함하지 않아야 최소 스패닝 트리를 구할 수 있음
public class P_4386 {
	static int n;
	static double ans;
	static int[] parent;
	static ArrayList<Edge> edgeList;

	static class Node {
		int num;
		double x;
		double y;

		Node(int num, double x, double y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		double weight;

		Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			if (weight < o.weight) {
				return -1;
			}
			return 1;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		ans = 0;
		
		Node[] nodes = new Node[n];

		// 노드 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			nodes[i] = new Node(i, x, y);
		}

		// 간선정보 입력
		edgeList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				double weight = dist(nodes[i], nodes[j]);
				edgeList.add(new Edge(nodes[i].num, nodes[j].num, weight));
			}
		}
		Collections.sort(edgeList); // 간선비용을 오름차순으로 정렬

		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		// 크루스칼
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);

			if (find(edge.start) != find(edge.end)) {
				ans += edge.weight;
				union(edge.start, edge.end);
			}
		}

		// 정답 출력
		System.out.println(ans);
	}

	private static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[y] = x;
		}
	}
	
	private static double dist(Node p1, Node p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}

}
