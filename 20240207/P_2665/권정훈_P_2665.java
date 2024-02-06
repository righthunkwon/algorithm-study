
import java.io.*;
import java.util.*;

// 미로만들기
public class P_2665 {

	private static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int N;
	private static int map[][];
	private static int dist[][];

	private static int dx[] = { -1, 1, 0, 0 };
	private static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 크기
		map = new int[N][N]; // 미로
		dist = new int[N][N]; // 최소 검은 방 수

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		bfs();
		System.out.println(dist[N - 1][N - 1]);
	}

	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0)); // 시작점
		dist[0][0] = 0; // 흰방 → 검은방 이동수

		while (!q.isEmpty()) {
			Node curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				// 범위 판단
				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					// 최적 경로일 경우만 고려
					if (dist[nx][ny] > dist[curr.x][curr.y]) {
						// 다음이 흰 방일 경우 바꿀 필요가 없음(dist 유지)
						if (map[nx][ny] == 1) {
							dist[nx][ny] = dist[curr.x][curr.y];
						} 
						// 다음이 검은 방일 경우 바꿔야함(dist 1 증가)
						else {
							dist[nx][ny] = dist[curr.x][curr.y] + 1;
						}
						
						// 다음 위치 탐색
						q.add(new Node(nx, ny));
					}
				}
			}
		}
	}
}
