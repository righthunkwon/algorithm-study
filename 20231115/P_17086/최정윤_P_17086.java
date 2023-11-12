package baek;

import java.io.*;
import java.util.*;

public class Pro_17086_아기상어2 {
	static Queue<Node> q;
	static int[] dr, dc;
	static int N, M, max;
	static boolean[][] visited;
	static int[][] shark;
	
	static class Node {
		int r, c, depth;

		public Node(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		shark = new int[N][M];

		// 8방 가능 윗줄부터 왼->오 순
		dr = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		dc = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				shark[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (shark[i][j] == 0) {//상어가 아닌 곳만 안전거리 확인 후 안전거리 중 가장 최댓값 구하기
					visited = new boolean[N][M];
					visited[i][j] = true;
					q = new LinkedList<>();
					q.add(new Node(i, j, 1));
					bfs();
				}
			}
		}
		System.out.println(max);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			Node curr = q.poll();
			for (int i = 0; i < 8; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc])
					continue;
				if (shark[nr][nc] == 1) {//상어가 있다면 그 depth가 최소 거리이다=안전거리
					max = Math.max(max, curr.depth);//최댓값 갱신 후 return
					return;
				}
				q.add(new Node(nr, nc, curr.depth + 1));
				visited[nr][nc] = true;
			}
		}
	}
}
