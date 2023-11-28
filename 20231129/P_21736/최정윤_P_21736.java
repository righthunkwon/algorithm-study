
import java.io.*;
import java.util.StringTokenizer;

public class Pro_21736_헌내기는친구가필요해 {
	static int[] dr, dc;
	static int N, M, max;
	static char[][] campus;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		campus = new char[N][M];
		for (int i = 0; i < N; i++) {
			campus[i] = br.readLine().toCharArray();
		} // 입력끝

		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		max = 0;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (campus[i][j] == 'I')
					dfs(i, j);
			}
		}
		if (max == 0)
			System.out.println("TT");
		else {
			System.out.println(max);
		}
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || campus[nr][nc] == 'X' || visited[nr][nc])
				continue;
			if (campus[nr][nc] == 'P') {
				//어차피 모든 곳을 다 돌것이라 바로 플러스 
				max++;
			} 
			dfs(nr, nc);
		}
	}
}
