
import java.io.*;
import java.util.*;

public class Pro_2146_다리만들기 {
	
	static int[] dr, dc;
	static Queue<int[]> q;
	static Queue<Ground> q2;
	static int number, N;
	static boolean[][] visited;
	static boolean[][][] visited2;
	static int[][] map;
	
	static class Ground {
		int r, c, depth, num;
		public Ground(int r, int c, int depth, int num) {
			this.r = r;
			this.c = c;
			this.depth = depth;
			this.num = num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력끝
		visited = new boolean[N][N];
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };

		number = 2;
		q = new LinkedList<int[]>();
		q2= new LinkedList<Ground>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					q.add(new int[] { i, j });
					q2.add(new Ground(i, j, 0, number));
					visited[i][j] = true;
					map[i][j] = number;
					bfs();
					number++;
				}
			}
		} // 육지 번호 주기
		visited2 = new boolean[N][N][number];
		// 0이 아닌 내가 아닌 다른 번호를 만나면 -1만큼
		find();
	}

	private static void find() {
		while (!q2.isEmpty()) {
			Ground g = q2.poll();
			for (int i = 0; i < 4; i++) {
				int nr = g.r + dr[i];
				int nc = g.c + dc[i];
				if (nr >= N || nr < 0 || nc < 0 || nc >= N||map[nr][nc]==g.num||visited2[nr][nc][g.num])
					continue;
				if (map[nr][nc] != 0 && g.num != map[nr][nc]) {
					System.out.println(g.depth);
					System.exit(0);
				}
				visited2[nr][nc][g.num]=true;
				q2.add(new Ground(nr, nc, g.depth + 1, g.num));
			}
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr >= N || nr < 0 || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == 0)
					continue;
				q.add(new int[] { nr, nc });
				visited[nr][nc] = true;
				q2.add(new Ground(nr, nc, 0, number));
				map[nr][nc] = number;
			}
		}
	}
}
