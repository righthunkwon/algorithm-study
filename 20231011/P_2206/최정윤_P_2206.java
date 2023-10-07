package baek;

import java.io.*;
import java.util.*;

public class Pro_2206_벽부수고이동하기 {
	static int result;
	static Queue<Node> queue;
	static int[] dr;
	static int[] dc;
	static boolean chance;
	static boolean[][] visited;
	static boolean[][] breakvisited;
	static char[][] map;
	static int N;
	static int M;

	static class Node {
		int r;
		int c;
		int depth;
		boolean chance;

		public Node(int r, int c, int depth, boolean chance) {
			this.r = r;
			this.c = c;
			this.depth = depth;
			this.chance = chance;//깰 기회가 있는지
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M];
		breakvisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		result = -1;
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		queue = new LinkedList<>();
		queue.add(new Node(0, 0, 1, true));
		visited[0][0] = true;
		bfs();
		System.out.println(result);

	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			if (curr.r == N - 1 && curr.c == M - 1) {
				result = curr.depth;
				return;
			}
			//1을 깨고와 안깨고 방문배열을 따로 처리해줘야함 
			//1을 깨고 가서 방문이 되어버려서 안깨고 갔을 때 방문처리가 되어있어서 가지 못하는 경우가 발생
			if (curr.chance) {
				addqueue(visited, curr);
			} else {
				addqueue(breakvisited, curr);
			}
		}
	}

	public static void addqueue(boolean[][] arr, Node curr) {

		for (int i = 0; i < 4; i++) {
			int nr = curr.r + dr[i];
			int nc = curr.c + dc[i];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M || arr[nr][nc])
				continue;
			if (map[nr][nc] == '0') {
				queue.add(new Node(nr, nc, curr.depth + 1, curr.chance));
				arr[nr][nc] = true;
			} else if (map[nr][nc] == '1' && curr.chance) {//아직 깰 기회가 있다면 
				queue.add(new Node(nr, nc, curr.depth + 1, false));//1깨고 큐에 넣어라 chance는 false로 바꿔야함
				arr[nr][nc] = true;
			}

		}
	}
}
