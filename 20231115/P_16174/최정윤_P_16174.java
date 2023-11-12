package baek;

import java.io.*;
import java.util.StringTokenizer;

public class Pro_16174_점프왕쩰리 {
	static String result;
	static int N;
	static int[] dr, dc;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력끝

		dr = new int[] { 1, 0 };
		dc = new int[] { 0, 1 };
		result = "Hing";
		dfs(0, 0);
		System.out.println(result);
	}

	private static void dfs(int r, int c) {
		if (map[r][c] == -1) {
			result = "HaruHaru";
			return;
		}
		//우 하 로만 진행가능하기 때문에 원래 하던 방식의 visited체크는 해줄 필요가 없다.
		// 그 대신 어차피 같은 칸으로가면 같은 경로 재 실행이기 때문에 
		//그 칸을 통과해봤는지 체크하는 배열을 만든다. 끝나는부분에 false로 바꿔주는 거 처리 X 
		visited[r][c] = true;
		for (int i = 0; i < 2; i++) {
			int nr = r + dr[i] * map[r][c];
			int nc = c + dc[i] * map[r][c];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
				continue;
			dfs(nr, nc);
		}
	}

}
