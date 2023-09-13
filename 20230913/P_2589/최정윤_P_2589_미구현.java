package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Pro_2589_보물섬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		max = 0;
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		} // 입력 끝

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {

				if (map[i][j] == 'L') {
					visited = new boolean[R][C];
					 find(i, j);
				}
			}
		}

		System.out.println(max);

	}

	public static char[][] map;
	public static boolean[][] visited;
	public static int time;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int max;
	static int su;
	static int R;
	static int C;

	public static void find(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			if (r + dr[i] >= 0 && r + dr[i] < R && c + dc[i] >= 0 && c + dc[i] < C && map[r + dr[i]][c + dc[i]] == 'L'
					&& visited[r + dr[i]][c + dc[i]] == false) {
				visited[r + dr[i]][c + dc[i]] = true;

				queue.add(new int[] { r + dr[i], c + dc[i], 1 });
			}
		}
		while (!queue.isEmpty()) {
			int[] j = queue.poll();
			int nr = j[0];
			int nc = j[1];
			int su = j[2];
			max = Math.max(max, su);
			for (int i = 0; i < 4; i++) {
				if (nr + dr[i] >= 0 && nr + dr[i] < R && nc + dc[i] >= 0 && nc + dc[i] < C
						&& map[nr + dr[i]][nc + dc[i]] == 'L' && visited[nr + dr[i]][nc + dc[i]] == false) {
					visited[nr + dr[i]][nc + dc[i]] = true;
					queue.add(new int[] { nr + dr[i], nc + dc[i],su+1});//??????????????????????????????
				}
			}

		}
	}

}
