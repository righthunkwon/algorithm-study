package level_31_dfs_bfs;

import java.util.Scanner;

// 양 한마리... 양 두마리...
public class P_11123 {
	private static int h, w, ans;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static char[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// test case
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			ans = 0; // 정답 초기화
			h = sc.nextInt(); // 행
			w = sc.nextInt(); // 열
			map = new char[h][w]; // 양 배열
			visited = new boolean[h][w]; // 방문처리 배열

			// 양 배열 요소 입력
			for (int i = 0; i < h; i++) {
				String tmp = sc.next();
				for (int j = 0; j < w; j++) {
					map[i][j] = tmp.charAt(j);
				}
			}

			// 풀이 로직
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					// 방문하지 않았고 양이 있다면
					if (visited[i][j] == false && map[i][j] == '#') {
						ans++; // 양 무리의 개수를 하나 증가시키고
						dfs(i, j); // 깊이 우선 탐색
					}
				}
			}
			System.out.println(ans);
		}
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true; // 방문처리

		// 상하좌우 순으로 계속해서 깊이우선 탐색하여
		// 연결된 양무리를 방문하고 방문처리함으로써 다시 중복 제거
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < h && ny >= 0 && ny < w && visited[nx][ny] == false && map[nx][ny] == '#') {
				dfs(nx, ny);
			}
		}
		return; // 종료
	}
}
