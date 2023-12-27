package level_31_dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// MooTube (Silver)
// 최소신장트리, 최소 간선의 수를 갖는 연결 그래프
// BFS를 돌며 영상 사이의 거리가 K보다 작으면 탐색 패스
// 간선의 개수가 적으므로 이차원배열로 메모리와 시간을 낭비하면 안 된다.
public class P_15591 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();

		// 2차원배열쓰면 시간초과 발생
		ArrayList<int[]>[] usado = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			usado[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i < N - 1; i++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int r = sc.nextInt();
			
			// 무방향 연결
			usado[p].add(new int[] { q, r });
			usado[q].add(new int[] { p, r });
		}

		for (int i = 1; i <= Q; i++) {
			int k = sc.nextInt();
			int v = sc.nextInt();
			int ans = 0;

			Queue<Integer> queue = new LinkedList<>();
			int[] visited = new int[N + 1];
			visited[v] = 1;
			queue.add(v);

			while (!queue.isEmpty()) {
				int now = queue.poll();
				for (int[] arr : usado[now]) {
					int next = arr[0];
					int usa = arr[1];
					if (visited[next] == 1 || usa < k)
						continue;
					ans++;
					visited[next] = 1;
					queue.add(next);
				}
			}
			System.out.println(ans);
		}
	}
}
