package baek;

import java.io.*;
import java.util.*;
//최단거리 =bfs
//최대값 =dfs
//bfs로 하게 되면 메모리초과

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
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		max = 0;
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		alpa = new boolean[26];			//알파벳 사용되면 그 자리 true로 바꿔줄 것이다.
		alpa[board[0][0] - 'A'] = true; //시작자리 true 세팅 
		dfs(0, 0);
		System.out.println(max);
	}

	private static void dfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= R || nc >= C || alpa[board[nr][nc] - 'A']) {
				continue;//범위값 초과하고 이미 있는 알파벳이면 넘어가기
			}
			alpa[board[nr][nc] - 'A'] = true;//사용
			dfs(nr, nc);
			alpa[board[nr][nc] - 'A'] = false;//사용해지
		}//4방향 끝난 후 max값  항상 갱신
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
