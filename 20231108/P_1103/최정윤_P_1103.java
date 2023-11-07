package baek;
import java.io.*;
import java.util.StringTokenizer;

public class Pro_1103_게임 {
	static int N, M, max;
	static boolean[][] visited;
	static char[][] board;
	static int[] dr, dc;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		max = 0;
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		visited = new boolean[N][M];
		dp = new int[N][M];
		game(0, 0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max + 1);
	}

	private static int game(int r, int c) {
		if (visited[r][c]) {//사이클 돌면 -1출려
			System.out.println(-1);
			System.exit(0);
		}
		if (dp[r][c] != 0)//이미 그 지점 주위를 돌아서 최댓값 찾았다면
			return dp[r][c];

		visited[r][c] = true;
		int X = board[r][c] - '0';
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i] * X;
			int nc = c + dc[i] * X;
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || board[nr][nc] == 'H')
				continue;
			dp[r][c]=Math.max(game(nr,nc)+1,dp[r][c]);
		}
		visited[r][c] = false;
		return dp[r][c];
	}

}
