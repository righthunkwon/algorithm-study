package level_31_dfs_bfs;

// 미네랄
// 모두들 고생했다!
public class P_2933 {
	private static int R, C, N;
	private static char[][] map;
	private static int[][] clusters;

	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	private static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		map = new char[R][C];

		// 지도 배열 요소 입력
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		N = Integer.parseInt(br.readLine()); // 막대를 던진 횟수

		// 막대
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			// 방향전환
			int dir = 1;
			if (i % 2 == 1) dir = 2;
			breakMineral(tmp, dir);
		}

		for (int i = 0; i < R; i++) {
			System.out.println(map[i]);
		}

	}
}
