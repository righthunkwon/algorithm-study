import java.io.*;
import java.util.*;

//트리 : 사이클을 돌지 않는다 !!!!
//1번을 기준으로 가장 긴 것 찾고, 가장 긴 것의 종점을 기준으로 가장 긴 것 찾으면 항상 가장 긴 것을 찾을 수 있음!!!!
public class Pro_1167_트리의지름2 {
	static List<Node>[] arr_list;
	static boolean[] visited;
	static int max, max_v;

	static class Node {
		int ed, dist;

		public Node(int ed, int dist) {
			this.ed = ed;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int V = Integer.parseInt(br.readLine());
		arr_list = new ArrayList[V + 1]; // 인접리스트
		for (int i = 0; i <= V; i++) {
			arr_list[i] = new ArrayList<Node>();// 리스트 미리생성
		}
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			while (true) {
				int ed = Integer.parseInt(st.nextToken());
				if (ed == -1)
					break;
				int dist = Integer.parseInt(st.nextToken());
				arr_list[start].add(new Node(ed, dist));
			}
		} // 입력끝
		visited = new boolean[V + 1];
		max = 0;
		dfs(1, 0);
		visited = new boolean[V + 1];
		dfs(max_v, 0);
		System.out.println(max);

	}

	// 트리라서 어차피 사이클이 돌지않기 때문에 방문처리를 false안해도 괜찮음
	private static void dfs(int v, int length) {
		visited[v] = true;
		if (length > max) {
			max = length; //최대 길이 갱신
			max_v = v; //종점 찾기
		}
		for (Node curr : arr_list[v]) {
			if (visited[curr.ed])
				continue;
			dfs(curr.ed, length + curr.dist);
		}
	}

}
