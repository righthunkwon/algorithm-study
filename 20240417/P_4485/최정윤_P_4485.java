package study_240417;

import java.io.*;
import java.util.*;
//기본 bfs로 구현
public class Pro_4485_녹색옷입은애가젤다지 {

	static class Node implements Comparable<Node> {
		int r, c, sum;

		public Node(int r, int c, int sum) {
			this.r = r;
			this.c = c;
			this.sum = sum;
		}

		public int compareTo(Node o) {
			return this.sum - o.sum;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		tc = 0;
		while (true) {
			tc++;
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			pq = new PriorityQueue();
			pq.add(new Node(0, 0, arr[0][0]));
			visited = new boolean[N][N];
			visited[0][0] = true;
			bfs();
		}
	}

	private static void bfs() {
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (curr.r == N - 1 && curr.c == N - 1) { 
				System.out.println("Problem " + tc + ": " + curr.sum);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
					continue;
				visited[nr][nc] = true;
				pq.add(new Node(nr, nc, curr.sum + arr[nr][nc]));
			}
		}
	}

	static int[] dr, dc;
	static int N, tc;
	static PriorityQueue<Node> pq;
	static boolean[][] visited;
	static int[][] arr;
}
