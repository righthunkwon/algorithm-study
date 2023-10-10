//시간초과이슈..해결예정..

package baek;

import java.io.*;
import java.util.*;

public class Pro_15686_치킨배달2 {
  	static int sum;
	static int min;
	static boolean visited[][];
	static List<int[]> list;
	static Queue<int[]> q;
	static int chick;
	static int N;
	static int M;
	static int[][] map;
	static int[] dr;
	static int[] dc;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		min = Integer.MAX_VALUE;
		chick = 0;
		list = new ArrayList<>();
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					chick++;
				else if (map[i][j] == 1)
					list.add(new int[] { i, j, 0 });
			}
		} // 입력끝
		select(0);
		System.out.println(min);
	}

	private static void select(int idx) {
		if (idx == chick - M) {
			sum = 0;
			for (int i = 0; i < list.size(); i++) {
				visited = new boolean[N][N];
				q = new LinkedList<int[]>();
				q.add(list.get(i));
				bfs();
			}
			min = Math.min(sum, min);
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) {
					map[i][j] = 0;
					select(idx + 1);
					map[i][j] = 2;
				}
			}
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int r = arr[0];
			int c = arr[1];
			int depth = arr[2];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= N || nc >= N || nr < 0 || nc < 0 || visited[nr][nc])
					continue;
				if (map[nr][nc] == 2) {
					sum += depth + 1;
					return;
				} else {
					q.add(new int[] { nr, nc, depth + 1 });
					visited[nr][nc] = true;
				}
			}


		}
	}


}
