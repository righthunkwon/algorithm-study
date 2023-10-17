package level_22_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 알파벳
public class P_1987 {

	private static int r, c, ans;
	private static int[][] map;
	private static boolean[] visited;
	
	// 상하좌우
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken()); // 행
		c = Integer.parseInt(st.nextToken()); // 열
		ans = 0; // 정답 값 할당
		map = new int[r][c]; // 배열
		visited = new boolean[26]; // 알파벳 방문처리 배열
		
		// 배열 요소 입력
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j) - 'A'; // A=0, B=1, ... Z=25
			}
		}
		
		// (x좌표, y좌표, 이동횟수)
		dfs(0, 0, 0); // (0,0)부터 시작

		// 정답 출력
		System.out.println(ans);
	}
	
	public static void dfs(int x, int y, int cnt) {
		// 기저부분(종료조건)
		// 새로 이동한 곳이 이미 방문했다면 정답을 갱신
		if (visited[map[x][y]]) {
			ans = Math.max(ans, cnt);
			return;
		}
		
		// 재귀부분(반복수행)
		visited[map[x][y]] = true; // 방문처리
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 범위 내에 있지 않다면 패스
			if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;

			// 범위 내에 있다면 dfs
			dfs(nx, ny, cnt + 1);
		}
		visited[map[x][y]] = false; // 방문처리 해제
	}
}
