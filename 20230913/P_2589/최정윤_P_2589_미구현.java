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
					max = Math.max(max, find(i, j, 0));
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
	// static int su;
	static int R;
	static int C;

	public static int find(int r, int c, int su) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[r][c]=true;
		for (int i = 0; i < 4; i++) {
			if (r + dr[i] >= 0 && r + dr[i] < R && c + dc[i] >= 0 && c + dc[i] < C && map[r + dr[i]][c + dc[i]] == 'L'
					&& visited[r + dr[i]][c + dc[i]] == false) {
				visited[r + dr[i]][c + dc[i]] = true;
				queue.add(i);
			}
		}
		if (queue.isEmpty())
			return su;
		su++;
		while (!queue.isEmpty()) 
		{//여기서 다시 dfs되어서 틀림 bfs로 구현해야함
			int i = queue.poll();
			max = Math.max(max, find(r + dr[i], c + dc[i], su));
		}
		return max;
	}

}
