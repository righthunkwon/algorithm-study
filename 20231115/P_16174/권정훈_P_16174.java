package level_31_dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 점프왕 쩰리(Large)
public class P_16174 {

	private static int n;
	private static boolean flag;
	private static int map[][];
	private static boolean visited[][];

	// 오른쪽 혹은 아래
	private static int dx[] = { 0, 1 };
	private static int dy[] = { 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine()); // 크기
		map = new int[n][n]; // 지도 배열
		visited = new boolean[n][n]; // 방문 배열

		// 지도 배열 요소 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		flag = false; // 도착지 도착 여부
		dfs(0, 0); // dfs
		
		if (flag) System.out.println("HaruHaru");
		else System.out.println("Hing");
	}

	private static void dfs(int x, int y) {
		// 현재 위치
		int pos = map[x][y];
		
		// 현재 위치가 도착지인 경우
		if (pos == -1) flag = true;

		for (int i = 0; i < 2; i++) {
			int nx = x + dx[i] * pos;
			int ny = y + dy[i] * pos;

			if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue; // 범위 벗어나면 패스
			if (visited[nx][ny]) continue; // 방문했으면 패스
				
			visited[nx][ny] = true; // 방문 처리하고 (경로가 단방향이므로 같은 곳에 다시 가는 지만 체크해주면 된다) 
			dfs(nx, ny); // 다음 위치로 점프
		}

	}
}
