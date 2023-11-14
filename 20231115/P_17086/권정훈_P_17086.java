package level_31_dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 아기 상어 2
class Shark {
	int x;
	int y;

	public Shark(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class P_17086 {
	private static int n, m, ans;
	private static int[][] map;
	private static int[][] dis;
	
	// 12시부터 시계방향으로 8방향 델타
	private static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	private static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 행
		m = sc.nextInt(); // 열
		map = new int[n][m]; // 공간
		dis = new int[n][m]; // 안전거리
		ans = -987654321; // 정답
		Queue<Shark> q = new LinkedList<Shark>(); // 상어 큐

		// 공간 배열 요소 및 상어 큐 입력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					q.add(new Shark(i, j)); // 상어 좌표 추가
				}
			}
		}

		// bfs
		while (!q.isEmpty()) {
			Shark curr = q.poll();
			int x = curr.x;
			int y = curr.y;
			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 범위에서 벗어나면 패스
				if (dis[nx][ny] != 0 || map[nx][ny] == 1) continue; // 방문했거나 상어가 있으면 패스
				dis[nx][ny] = dis[x][y] + 1; // 안전거리 갱신
				if (dis[nx][ny] > ans) ans = dis[nx][ny]; // 최대값 갱신
				q.add(new Shark(nx, ny)); // 다음 위치 큐에 추가
			}
		}
		System.out.println(ans);
	}

}
