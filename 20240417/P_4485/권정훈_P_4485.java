
import java.io.*;
import java.util.*;

// 녹색 옷 입은 애가 젤다지?
public class P_4485 {
	private static int n;
	private static int[][] map;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int idx = 1;
		String tc;
		while (!(tc = br.readLine()).equals("0")) {
			n = Integer.parseInt(tc);
			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cost = bfs();
			sb.append("Problem " + idx + ": " + cost + "\n");
			idx++;
		}
		System.out.println(sb.toString());
	}

	private static int bfs() {
		Queue<Node> q = new PriorityQueue<>();
		int[][] move = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(move[i], Integer.MAX_VALUE);
		}

		q.add(new Node(0, 0, map[0][0]));
		move[0][0] = map[0][0];

		while (!q.isEmpty()) {
			Node curr = q.poll();
			int cx = curr.x;
			int cy = curr.y;
			int cost = curr.cost;
			if (cx == n - 1 && cy == n - 1) {
				return cost;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1) {
					continue;
				}

				if (cost + map[ny][nx] < move[ny][nx]) {
					move[ny][nx] = cost + map[ny][nx];
					q.add(new Node(nx, ny, cost + map[ny][nx]));
				}

			}
		}
		return -1;
	}
	
	private static class Node implements Comparable<Node> {
		int x;
		int y;
		int cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;

		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
