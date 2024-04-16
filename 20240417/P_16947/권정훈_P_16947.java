
import java.io.*;
import java.util.*;

// 서울 지하철 2호선
// https://moonsbeen.tistory.com/276 참조

// 처음 방문했던 노드를 다시 방문하면 싸이클
// 싸이클이 발생했다면 해당 노드가 싸이클에 포함된 노드라는 표시를 남겨줌(isCycled)

// 싸이클이 발생한 노드인지 판별하기 위해서는
// 먼저 현대 노드의 싸이클을 true로 설장하고,
// 현재 노드와 연결된 노드를 탐색한 뒤, 아직 확인하지 않은 노드를 탐색하고
// 만약 연결된 노드가 직전에 방문한 노드가 아니고, 시작 노드라면 처음 방문했던 노드를 재방문한 것이므로 싸이클이 발생한 것
public class P_16947 {
	private static int n;
	private static boolean[] isCycled;
	private static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			list[n1].add(n2);
			list[n2].add(n1);
		}

		// 싸이클 확인
		isCycled = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (checkCycled(i, i, i))
				break;
			isCycled = new boolean[n + 1];
		}

		int[] result = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			if (!isCycled[i]) {
				result[i] = bfs(i);
			}
		}

		for (int i = 1; i <= n; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public static int bfs(int node) {
		Queue<Node> q = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];
		q.add(new Node(node, 0));
		visited[node] = true;

		while (!q.isEmpty()) {
			Node curr = q.poll();
			if (isCycled[curr.val]) {
				return curr.cnt;
			}

			for (int i = 0; i < list[curr.val].size(); i++) {
				int next = list[curr.val].get(i);
				if (!visited[next]) {
					visited[next] = true;
					q.add(new Node(next, curr.cnt + 1));
				}
			}
		}
		return 0;
	}

	public static boolean checkCycled(int prev, int node, int start) {
		isCycled[node] = true;

		for (int i = 0; i < list[node].size(); i++) {
			int next = list[node].get(i);

			if (!isCycled[next]) {
				if (checkCycled(node, next, start)) {
					return true;
				}
			} else if (next != prev && next == start) {
				return true;
			}

		}
		isCycled[node] = false;

		return false;
	}

	public static class Node {
		int val;
		int cnt;

		public Node(int val, int cnt) {
			this.val = val;
			this.cnt = cnt;
		}
	}
}
