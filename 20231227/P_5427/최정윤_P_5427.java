import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());

			R = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
			}
			f = new LinkedList<int[]>();
			J = new LinkedList<int[]>();
			dr = new int[] { -1, 1, 0, 0 };
			dc = new int[] { 0, 0, -1, 1 };
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == '*')
						f.add(new int[] { i, j });

					else if (map[i][j] == '@')
						J.add(new int[] { i, j });
				}
			}
			go = true;
			boolean impo = false;
			int cnt = 0;
			while (go) {
				if (J.size() == 0) {
					impo = true;
					break;
				}
				bfs(f.size(), J.size());
				cnt++;
			}
			if (!impo) {
				System.out.println(cnt);
			} else {
				System.out.println("IMPOSSIBLE");
			}
		}
	}

	static Queue<int[]> f, J;
	static int R, C;
	static char[][] map;
	static int[] dr, dc;
	static boolean go;

	private static void bfs(int fcnt, int jcnt) {
		for (int i = 0; i < fcnt; i++) {
			int[] arr = f.poll();
			for (int j = 0; j < 4; j++) {
				int nr = arr[0] + dr[j];
				int nc = arr[1] + dc[j];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == '#' || map[nr][nc] == '*')
					continue;
				map[nr][nc] = '*';
				f.add(new int[] { nr, nc });
			}
		}
		for (int i = 0; i < jcnt; i++) {
			int[] arr = J.poll();
			for (int j = 0; j < 4; j++) {
				int nr = arr[0] + dr[j];
				int nc = arr[1] + dc[j];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
					go = false;
					return;
				}
				if (map[nr][nc] == '.') {
					map[nr][nc] = 'J';
					J.add(new int[] { nr, nc });
				}
			}
		}
	}

}
