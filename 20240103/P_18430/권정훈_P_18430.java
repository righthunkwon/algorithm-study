import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 무기 공학
// 좌표 지정하는 법 익혀두자
// 구현 문제를 더 많이 풀어봐야겠다
public class P_18430 {
	private static int n, m, ans;
	private static int[][] map;
	private static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		backtracking(0, 0);
		System.out.println(ans);
	}

	public static void backtracking(int cnt, int sum) {
		// 모든 지점을 돌았을 때
		if (cnt == n * m) {
			ans = Math.max(sum, ans);
			return;
		}

		int x = cnt / m;
		int y = cnt % m;

		if (!visited[x][y]) {
			// 1 2
			//   1
			if (x + 1 < n && y - 1 >= 0 && !visited[x + 1][y] && !visited[x][y - 1]) {
				visited[x][y] = true;
				visited[x + 1][y] = true;
				visited[x][y - 1] = true;

				int tmp = sum + 2 * (map[x][y]) + map[x + 1][y] + map[x][y - 1];
				backtracking(cnt + 1, tmp);

				visited[x][y] = false;
				visited[x + 1][y] = false;
				visited[x][y - 1] = false;
			}
			//   1
			// 1 2
			if (x - 1 >= 0 && y - 1 >= 0 && !visited[x - 1][y] && !visited[x][y - 1]) {
				visited[x][y] = true;
				visited[x - 1][y] = true;
				visited[x][y - 1] = true;

				int tmp = sum + 2 * (map[x][y]) + map[x - 1][y] + map[x][y - 1];
				backtracking(cnt + 1, tmp);

				visited[x][y] = false;
				visited[x - 1][y] = false;
				visited[x][y - 1] = false;
			}
			// 1
			// 2 1
			if (x - 1 >= 0 && y + 1 < m && !visited[x - 1][y] && !visited[x][y + 1]) {
				visited[x][y] = true;
				visited[x - 1][y] = true;
				visited[x][y + 1] = true;

				int tmp = sum + 2 * (map[x][y]) + map[x - 1][y] + map[x][y + 1];
				backtracking(cnt + 1, tmp);

				visited[x][y] = false;
				visited[x - 1][y] = false;
				visited[x][y + 1] = false;
			}
			// 2 1
			// 1
			if (x + 1 < n && y + 1 < m && !visited[x + 1][y] && !visited[x][y + 1]) {
				visited[x][y] = true;
				visited[x + 1][y] = true;
				visited[x][y + 1] = true;

				int tmp = sum + 2 * (map[x][y]) + map[x + 1][y] + map[x][y + 1];
				backtracking(cnt + 1, tmp);

				visited[x][y] = false;
				visited[x + 1][y] = false;
				visited[x][y + 1] = false;
			}
		}
		backtracking(cnt + 1, sum);
	}
}
