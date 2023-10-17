package baek;

import java.io.*;
import java.util.*;

public class Pro_1987_알파벳dfs {
	static int[] dr, dc;
	static int R, C, max;
	static char[][] board;
	static boolean[] alpa;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		max = 0;
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		alpa = new boolean[26];
		visited[0][0] = true;
		alpa[board[0][0] - 'A'] = true;
		dfs(0, 0);
		System.out.println(max);
	}

	private static void dfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc]) {
				continue;
			}
			if (alpa[board[nr][nc] - 'A']) {//이미 그 자리가 true라면 사용했다는 의미이다.
				max = Math.max(max, count());
				continue;
			}
			alpa[board[nr][nc] - 'A'] = true;//사용
			visited[nr][nc] = true;
			dfs(nr, nc);
			alpa[board[nr][nc] - 'A'] = false;//사용해지
			visited[nr][nc] = false;
		}
		max = Math.max(max, count());
	}

	private static int count() {//몇개의 알파벳을 사용하였는지 
		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			if (alpa[i]) {
				cnt++;
			}
		}
		return cnt;
	}
}
