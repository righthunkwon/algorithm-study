import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
	int vertex;
	int weight;

	public Node(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.weight, o.weight);
	}
}//Node
public class _1238_파티 {


	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();  // 마을의 수
		int M = scanner.nextInt();  // 도로의 수
		int X = scanner.nextInt();  // 파티가 열리는 마을

		List<Node>[] graph = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			int weight = scanner.nextInt();
			graph[start].add(new Node(end, weight));
		}

		int[] distToX = dijkstra(graph, X);

		int maxTime = 0;
		for (int i = 1; i <= N; i++) {
			if (i != X) {
				int[] distFromX = dijkstra(graph, i);
				maxTime = Math.max(maxTime, distFromX[X] + distToX[i]);
			}
		}

		System.out.println(maxTime);
	}//main



	static int[] dijkstra(List<Node>[] graph, int start) {
		int[] dist = new int[graph.length];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node current = pq.poll();

			if (current.weight > dist[current.vertex]) continue;

			for (Node neighbor : graph[current.vertex]) {
				int newDist = current.weight + neighbor.weight;
				if (newDist < dist[neighbor.vertex]) {
					dist[neighbor.vertex] = newDist;
					pq.offer(new Node(neighbor.vertex, newDist));
				}
			}
		}

		return dist;
	}//dijkstra
}



