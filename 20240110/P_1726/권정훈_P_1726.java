package level_31_dfs_bfs;

import java.io.*;
import java.util.*;

// 로봇
public class P_1726 {
	private static Robot start;
	public static class Robot {
		int x;
		int y;
		int dir; // 바라보는 방향
		int cnt; // 명령 횟수

		public Robot(int x, int y, int dir, int cnt) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
	}
	
	private static int M, N, X, Y, DIR;
	private static int[][] map;
	private static boolean[][][] visited;

	// 동서남북
	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 세로
		N = Integer.parseInt(st.nextToken()); // 가로

		map = new int[M][N];
		visited = new boolean[M][N][4]; // 3차원: 방향

		// 지도 배열 요소 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 초기 로봇 세팅 및 방문처리
		st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;
		int dir = Integer.parseInt(st.nextToken()) - 1;

		start = new Robot(x, y, dir, 0);
		visited[start.x][start.y][start.dir] = true;

		// 도착지점 입력
		st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(st.nextToken()) - 1;
		Y = Integer.parseInt(st.nextToken()) - 1;
		DIR = Integer.parseInt(st.nextToken()) - 1;

		// 정답 출력
		System.out.println(bfs(start));
	}

	private static int bfs(Robot robot) {
		Queue<Robot> q = new LinkedList<>();
		q.add(robot);
		while (!q.isEmpty()) {
			Robot curr = q.poll();

			// 종료조건(도착지)
			if (curr.x == X && curr.y == Y && curr.dir == DIR) {
				return curr.cnt;
			}

			// 그래프 탐색
			for (int i = 1; i <= 3; i++) {
				int nx = curr.x + dx[curr.dir] * i;
				int ny = curr.y + dy[curr.dir] * i;

				// 지도에서 벗어나면 멈춤
				if (!isInMap(nx, ny)) continue;

				// 벽을 만나면 어짜피 못 가므로 종료
				if (map[nx][ny] == 1) break;

				// 다음 큐 탐색
				if (!visited[nx][ny][curr.dir]) {
					visited[nx][ny][curr.dir] = true;
					q.add(new Robot(nx, ny, curr.dir, curr.cnt + 1));
				}
			}

			// 회전
			// 오른쪽	: 동0 남2 서1 북3
			// 왼쪽 	: 동0 북3 서1 남2
			int left = 0, right = 0;

			switch (curr.dir) {
			case 0:
				left = 3;
				right = 2;
				break;
			case 1:
				left = 2;
				right = 3;
				break;
			case 2:
				left = 0;
				right = 1;
				break;
			case 3:
				left = 1;
				right = 0;
				break;
			}

			// 다음 큐 탐색(왼쪽)
			if (!visited[curr.x][curr.y][left]) {
				visited[curr.x][curr.y][left] = true;
				q.add(new Robot(curr.x, curr.y, left, curr.cnt + 1));
			}

			// 다음 큐 탐색(오른쪽)
			if (!visited[curr.x][curr.y][right]) {
				visited[curr.x][curr.y][right] = true;
				q.add(new Robot(curr.x, curr.y, right, curr.cnt + 1));
			}

		}
		return -1;
	}

	private static boolean isInMap(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}
}
