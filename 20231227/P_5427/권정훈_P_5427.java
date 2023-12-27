package level_31_dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 불
public class P_5427 {
	private static int w, h, ans;
	private static boolean flag;
	private static char[][] map;
	private static Queue<int[]> q;

	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); // 너비
			h = Integer.parseInt(st.nextToken()); // 높이
			ans = 0; // 탈출 시간
			flag = false; // 탈출가능여부

			map = new char[h][w]; // 지도
			q = new LinkedList<>(); // 불과 상근이를 담을 큐

			// 상근이 위치
			int sx = 0;
			int sy = 0;

			// 배열 요소 입력
			for (int i = 0; i < h; i++) {
				String s = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = s.charAt(j);

					// 불 먼저 추가
					if (map[i][j] == '*') {
						q.add(new int[] { i, j });
					} else if (map[i][j] == '@') {
						sx = i;
						sy = j;
					}
				}
			}
			// 상근이는 마지막에 추가
			q.add(new int[] { sx, sy });

			// 탐색 시작
			bfs();

			// 정답 출력
			if (flag)
				System.out.println(ans);
			else
				System.out.println("IMPOSSIBLE");
		}
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			ans++; // 시간 증가
			int size = q.size(); // 큐 크기를 변수에 미리 저장하지 않으면 중간에 변동이 생겨 반복문에 에러 발생
			for (int i = 0; i < size; i++) {
				int[] curr = q.poll();

				// 탐색
				for (int j = 0; j < 4; j++) {
					int nx = curr[0] + dx[j];
					int ny = curr[1] + dy[j];
					if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
						if (map[curr[0]][curr[1]] == '@') {
							flag = true;
							return;
						}
						continue;
					}

					// 성능 개선
					if (map[nx][ny] != '.') {
						continue;
					}

					// 좌표 갱신 후 재탐색
					map[nx][ny] = map[curr[0]][curr[1]];
					q.add(new int[] { nx, ny });
				}
			}
		}
		return;
	}
}
