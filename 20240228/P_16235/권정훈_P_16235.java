
import java.io.*;
import java.util.*;

// 나무 재테크
public class P_16235 {
	private static int n, m, k, ans;
	private static int[][] map, feed;
	private static PriorityQueue<Integer>[][] tree;

	private static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	
	private static class Point {
		int x, y, age;

		public Point(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(map[i], 5);
		}
		
		feed = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				feed[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		tree = new PriorityQueue[n + 1][n + 1]; // 양분이 적은 순서
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				tree[i][j] = new PriorityQueue<>();
			}
		}
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()); // x좌표
			int y = Integer.parseInt(st.nextToken()); // y좌표
			int z = Integer.parseInt(st.nextToken()); // 나이
			tree[x][y].add(z);
		}

		while (k > 0) {
			List<Point> dead = new ArrayList<>(); // 죽은 나무들의 정보
			List<Point> propagated = new ArrayList<>(); // 번식할 나무들의 정보

			// 나이만큼 양분 먹고 나이 1 증가
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					PriorityQueue<Integer> tmp = new PriorityQueue<>();
					while (!tree[i][j].isEmpty()) {
						int age = tree[i][j].poll();
						if (age <= map[i][j]) {
							map[i][j] -= age;
							tmp.add(++age);
							// 나이가 5의 배수면 번식
							if (age % 5 == 0) {
								propagated.add(new Point(i, j, age));
							}
						} else {
							// 나무 죽음
							dead.add(new Point(i, j, age));
						}
					}
					tree[i][j] = tmp;
				}
			}

			// 양분 추가
			for (Point p : dead) {
				map[p.x][p.y] += p.age / 2;
			}

			// 나무 번식
			for (Point p : propagated) {
				int x = p.x;
				int y = p.y;
				for (int i = 0; i < 8; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (1 <= nx && nx <= n && 1 <= ny && ny <= n) {
						tree[nx][ny].add(1);
					}
				}
			}

			// 양분 추가
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					map[i][j] += feed[i][j];
				}
			}
			k--; // 연도 감소
		}
		
		// 살아있는 나무 개수 카운트 및 정답 출력
		ans = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				ans += tree[i][j].size();
			}
		}
		System.out.println(ans);
	}
}
