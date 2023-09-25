import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _14466_소가길을건너간이유6 {
	static int N, K, R;
	static boolean[][] visited;
	static Point[] cows;
	static ArrayList<Point>[][] bridges;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 목초지
		K = Integer.parseInt(st.nextToken()); // 소의 총 수
		R = Integer.parseInt(st.nextToken()); // 길

		cows = new Point[K];
		bridges = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bridges[i][j] = new ArrayList<>();
			}
		}

		// R개 줄에 다리 정보 주어짐 -> 다리 정보 저장
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;

			bridges[a][b].add(new Point(c, d));
			bridges[c][d].add(new Point(a, b));
		}

		// K개 줄에 소 정보 주어짐 -> 소 위치 저장
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			cows[i] = new Point(a, b);
		}

		System.out.println(go());
	}

	private static int go() {

		int cnt = 0;

		// 소 한 마리씩 길을 건너지 않고 이동해보자.
		for (int c = 0; c < K; c++) {
			visited = new boolean[N][N];
			move(cows[c].x, cows[c].y);

			for (int nc = c; nc < K; nc++) {
				Point cow = cows[nc];
				// 이 소가 방문하지 않은 곳에 소가 있다면
				// 길을 건너지 않으면 만나지 못 하는 쌍이 된다.
				if(!visited[cow.x][cow.y]) cnt++;
			}

		}

		return cnt;
	}

	private static void move(int x, int y) {

		visited[x][y] = true;

		for (int d = 0; d < 4; d++) {
			int xx = x + dx[d];
			int yy = y + dy[d];
			// 범위
			if(xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
			// 이미 방문
			if(visited[xx][yy]) continue;
			// 길을 건너야 한다면
			if(bridges[x][y].contains(new Point(xx, yy))) continue;

			move(xx, yy);
		}

	}

}
