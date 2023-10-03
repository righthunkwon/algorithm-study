package level_31_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 맥주 마시면서 걸어가기
// 문제 내에서 맥주 개수는 큰 관련이 없어서 
// 정점 간 이동할 때마다 풀맥주(20잔) 때리고 출발하면 된다.

// 각 정점들의 좌표를 입력받은 뒤, 정점 간의 거리를 계산하여
// 정점 간 거리차이가 1000 이하면 이동할 수 있으므로 이를 연결한다(무방향간선).

// 모든 정점의 연결이 끝났다면 bfs를 통해 락페스티벌 정점에 도달할 경우
// happy를 출력하고, 도달하지 못했다면 sad를 출력한다.
class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class P_9205 {
	private static int n; // 편의점 개수
	private static List<Node> list; // 정점
	private static List<List<Integer>> map; // 간선
	private static boolean[] visited; // 방문처리
	private static StringBuilder sb; // 정답을 담을 스트링빌더

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// test case
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb = new StringBuilder(); // 정답을 담을 스트링빌더
			n = Integer.parseInt(br.readLine()); // 편의점의 개수
			list = new ArrayList<Node>(); // 집, 편의점, 락페스티벌의 좌표를 담을 리스트
			visited = new boolean[n + 2]; // 방문처리배열
			map = new ArrayList<List<Integer>>(); // 간선 배열

			// 정점 배열 요소 값 입력
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new Node(x, y));
			}

			// 간선 배열 초기화
			for (int i = 0; i < n + 2; ++i) {
				map.add(new ArrayList<>());
			}

			// 간선 배열 요소 값 입력(거리가 1000이하일 경우, 무방향그래프)
			for (int i = 0; i < n + 1; ++i) {
				for (int j = i + 1; j < n + 2; ++j) {
					int diff = Math.abs(list.get(i).x - list.get(j).x) + Math.abs(list.get(i).y - list.get(j).y);
					if (diff <= 1000) {
						map.get(i).add(j);
						map.get(j).add(i);
					}
				}
			}
			bfs(0);
			System.out.println(sb);
		}
	}

	private static void bfs(int st) {
		visited[st] = true; // 방문처리

		Queue<Integer> q = new LinkedList<>();
		q.add(st);

		while (!q.isEmpty()) {
			int tmp = q.poll();
			
			// 집에서 출발해서 락페스티벌에 도착하면
			if (tmp == n + 1) {
				sb.append("happy");
				return;
			}

			for (int i : map.get(tmp)) {
				if (!visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		sb.append("sad");
	}
}
