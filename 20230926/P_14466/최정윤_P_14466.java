package baek;

import java.io.*;
import java.util.*;
//주석 내일,,
public class Pro_14466 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		road = new int[R][4];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				road[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cow = new boolean[N + 1][N + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			cow[r][c] = true;
		} // 입력끝
		
		
		ex = 0;
		visited = new boolean[N + 1][N + 1];
		queue = new LinkedList<int[]>();
		list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (!visited[i][j]) {
					count = 0;
					queue.add(new int[] { i, j });
					visited[i][j] = true;
					bfs();
				}
			}
		}
		int result = 0;

		if (list.size() > 1) {
			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) {
					result += list.get(i) * list.get(j);
				}
			}
		} else if (list.size() == 1)
			result = list.get(0);

		System.out.println(result);
	}

	static boolean[][] visited;
	static Queue<int[]> queue;
	static int[] dr;
	static int[] dc;
	static int N;
	static int R;
	static int[][] road;
	static boolean[][] cow;
	static List<Integer> list;
	static int count;
	static int ex;

	public static void bfs() {
		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			check: for (int i = 0; i < 4; i++) {
				int nr = arr[0] + dr[i];
				int nc = arr[1] + dc[i];
				if (nr < 1 || nc < 1 || nr >= N + 1 || nc >= N + 1 || visited[nr][nc])
					continue;
				for (int j = 0; j < R; j++) {
					if (road[j][0] == arr[0] && road[j][1] == arr[1] && nr == road[j][2] && nc == road[j][3]) {
						continue check;
					} else if (road[j][2] == arr[0] && road[j][3] == arr[1] && nr == road[j][0] && nc == road[j][1]) {
						continue check;
					}
				}
				visited[nr][nc] = true;
				queue.add(new int[] { nr, nc });
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (visited[i][j])
					if (visited[i][j] && cow[i][j]) {
						count += 1;
					}
			}
		}

		list.add(count - ex);
		ex = count;
	}
}
