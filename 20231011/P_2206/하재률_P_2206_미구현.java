package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {
	static int N, M, res;
	static int[][] map;
	static boolean[][] chk;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Node {
		int x, y, depth;

		public Node(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		res = 987654321;
		sol(0);
		System.out.println(res != 987654321 ? res : -1);
	}

	static void sol(int idx) {
		if(idx == 1) {
			bfs();
			return;
		}

		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					map[i][j] = 0;
					sol(idx + 1);
					map[i][j] = 1;
				}
			}
		}
	}

	static void bfs() {
		
		chk = new boolean[N][M];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0,1));
		chk[0][0] = true;

		l:
		while(!q.isEmpty()) {
			Node poll = q.poll();
			for(int d = 0; d < 4; d++) {
				int nx = poll.x + dx[d];
				int ny = poll.y + dy[d];
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(map[nx][ny] == 0 && !chk[nx][ny]) {
						q.add(new Node(nx, ny, poll.depth + 1));
						chk[nx][ny] = true;
					}
					if(nx == N-1 && ny == M-1) {
						res = Math.min(res, poll.depth + 1);
						break l;
					}
				}
			}
		}
	}
}
