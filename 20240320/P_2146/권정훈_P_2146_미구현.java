
import java.io.*;
import java.util.*;

public class P_2146 {
	static int n, ans;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		ans = Integer.MAX_VALUE;
		map = new int[n][n];
		visited = new boolean[n][n];
		q = new LinkedList<>();

		// 지도 배열 요소 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬 개수 구하기
		getIslandCnt();

		///////////////////
		// 최소 다리 길이 구하기
		getMinBridgeLength();
		
		System.out.println(ans);
	}
	
	private static void getMinBridgeLength() {
		
	}

	private static void getIslandCnt() {
		int idx = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					map[i][j] = idx;
					visited[i][j] = true;
					q.add(new int[] { j, i });

					while (!q.isEmpty()) {
						int[] curr = q.poll();
						int x = curr[0];
						int y = curr[1];

						for (int d = 0; d < 4; d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];

							if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1) continue;
							if (visited[ny][nx]) continue;

							if (map[ny][nx] == 1) {
								visited[ny][nx] = true;
								map[ny][nx] = idx;
								q.add(new int[] { nx, ny });
							}
						}
					}
					idx++;
				}
			}

		}

	}
}
