package level_31_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 헌내기는 친구가 필요해
public class P_21736 {
	private static int n, m, dox, doy, ans;
	private static int[][] map; // 빈 공간: 0, 벽: 1, 도연이: 2, 사람: 3
	private static boolean[][] visited;
	
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	
	private static class point {
		int x;
		int y;
		
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 행
		m = Integer.parseInt(st.nextToken()); // 열
		map = new int[n][m]; // 캠퍼스
		visited = new boolean[n][m]; // 방문처리
		ans = 0; // 만날 수 있는 사람의 수

		// 캠퍼스 요소 입력
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				char ch = str.charAt(j);
				switch (ch) {
				case 'O':
					map[i][j] = 0;
					break;
				case 'X':
					map[i][j] = 1;
					break;
				case 'I':
					map[i][j] = 2;
					dox = i; // 도연x좌표(시작점)
					doy = j; // 도연y좌표(시작점)
					break;
				case 'P':
					map[i][j] = 3;
					break;
				}
			}
		}

		// 탐색 및 정답 출력
		bfs(dox, doy);
		if (ans == 0) System.out.println("TT");
		else System.out.println(ans);
	}

	private static void bfs(int x, int y) {
		visited[x][y] = true; // 시작점 방문처리
		
		Queue<point> q = new LinkedList<>();
		q.add(new point(x, y));
		
		while (!q.isEmpty()) {
			point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				// 범위에서 벗어나지 않고, 방문하지 않았고, 벽이 아니라면 사람인지 확인하고 재탐색
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == false && map[nx][ny] != 1) {
					if (map[nx][ny] == 3) ans++; // 사람인지 확인
					visited[nx][ny] = true; // 방문처리
					q.add(new point(nx, ny)); // 재탐색
				}
			}
		}
		
	}
}

