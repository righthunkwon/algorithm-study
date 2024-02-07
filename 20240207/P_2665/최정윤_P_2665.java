import java.io.*;
import java.util.*;

public class Main {
	static PriorityQueue<Node> pq;
	static boolean[][] visited;
	static int[] dr, dc;
	static int n;
	static char[][] miro;
	
	static class Node implements Comparable<Node> {
		int r, c, black;

		public Node(int r, int c, int black) {
			this.r = r;
			this.c = c;
			this.black = black;
		}

		@Override
		public int compareTo(Node o) {
			return this.black - o.black;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<Node>();
		miro = new char[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			miro[i] = br.readLine().toCharArray();
		}
		// (0,0)에서 (n-1,n-1)로 가는 것
		// 백트래킹 하려면 dfs ????????
		// bfs로 하면 결국 다 돌아야함
		// 우선순위 큐 써야한다..........
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		pq.add(new Node(0, 0, 0));
		visited[0][0] = true;
		bfs();
	}

	// 0 이 검은방 1이 흰방
	// 흰방만 지나가기 가능
	private static void bfs() {
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (curr.r == n - 1 && curr.c == n - 1) {
				System.out.println(curr.black);
				System.exit(0);
			}
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				if (nr >= n || nc >= n || nr < 0 || nc < 0 || visited[nr][nc]) {
					continue;
				}
				int black = miro[nr][nc] == '0' ? curr.black + 1 : curr.black;
				pq.add(new Node(nr, nc, black));
				visited[nr][nc] = true;
			}
		}
	}


}
