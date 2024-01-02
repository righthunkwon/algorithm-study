import java.io.*;
import java.util.*;

public class Pro_18430_무기공학 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		arr = new int[][] { { 0, 2 }, { 0, 3 }, { 1, 3 }, { 1, 2 } };
		hp = new int[N][M];
		use = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				hp[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력끝
		result = 0;
		if (N < 2 || M < 2)
			System.out.println(0);
		else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					visited[i][j] = true;
					dfs(i, j, 0, 0);
				}
			}
			System.out.println(result);
		}
	}

	static int[][] arr, hp, use;
	static int N, M, result;
	static boolean[][] visited;
	static int[] dr, dc;

//f t t f t t t t f
	private static void dfs(int r, int c, int sum, int cnt) {
//		result = Math.max(result, sum);
		if (cnt > N * M / 3)
			return;
		for (int[] a : arr) {
			int nr1 = r + dr[a[0]];
			int nc1 = c + dc[a[0]];
			int nr2 = r + dr[a[1]];
			int nc2 = c + dc[a[1]];
			if (nr1 < 0 || nc1 < 0 || nr2 < 0 || nc2 < 0 || nr1 >= N || nr2 >= N || nc1 >= M || nc2 >= M
					|| use[nr1][nc1] != 0 || use[nr2][nc2] != 0)
				continue;
			use[r][c] = 2;
			use[nr1][nc1] = 1;
			use[nr2][nc2] = 1;
			result = Math.max(result,  sum + hp[r][c] * 2 + hp[nr1][nc1] + hp[nr2][nc2]);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j] && use[i][j] == 0) {
						visited[i][j] = true;
						dfs(i, j, sum + hp[r][c] * 2 + hp[nr1][nc1] + hp[nr2][nc2],cnt+1);
						visited[i][j] = false;
					}
				}
			}
			use[r][c] = 0;
			use[nr1][nc1] = 0;
			use[nr2][nc2] = 0;
		}
	}
}
