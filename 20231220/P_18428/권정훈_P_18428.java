package level_22_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 감시 피하기
// dfs로 장애물을 설치하고
// bfs로 선생님들이 상하좌우로 학생 탐색
// bfs의 반환값을 boolean으로 하여 조건 가지치기
public class P_18428 {

	private static int n;
	private static char[][] map;
	private static char[][] copy;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { 1, -1, 0, 0 };
	
	private static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}

		// 탐색
		dfs(0);
		System.out.println("NO");
	}

	public static void dfs(int depth) {
		// 종료조건
		// 장애물이 3개이면서 모든 학생들이 선생님의 감시를 피할 수 있을 경우
		if (depth == 3) {
			if (bfs()) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}

		// 재귀부분
		// 장애물 설치
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'X') {
					map[i][j] = 'O';
					dfs(depth + 1);
					map[i][j] = 'X';
				}
			}
		}
	}

	public static boolean bfs() {
		Queue<Node> q = new LinkedList<>();
		copy = new char[n][n]; // 원본 배열을 유지시키기 위해 복사 배열을 매번 선언하여 복사 배열을 통해 판단
		
		// 배열 복사
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = map[i][j];
				
				// 선생님이 있는 좌표는 큐에 저장하여 확인
				if (copy[i][j] == 'T') {
					q.offer(new Node(i, j));
				}
			}
		}

		// 탐색
		while (!q.isEmpty()) {
			Node curr = q.poll();

			for (int i = 0; i < 4; i++) {
				// 뽑은 선생님의 위치 기준으로 상하좌우 좌표를 구하고
				int nx = curr.x;
				int ny = curr.y;
				
				while (true) {
					// 해당 위치를 기준으로 상하좌우로 계속 뻗어나간다
					nx += dx[i];
					ny += dy[i];
					
					if (nx < 0 || ny < 0 || ny >= n || nx >= n)	break; // 좌표가 배열 범위를 벗어나면 종료
					if (copy[nx][ny] == 'O') break; // 장애물을 만나면 탐색을 멈추므로 종료
					if (copy[nx][ny] == 'S') return false; // 학생을 만나면 불가하므로 false를 반환 후 종료
				}
			}
		}
		
		// 탐색한 결과가 false가 아니라면
		// 학생을 만날 수 없다는 것이므로 true 반환
		return true;
	}
}
