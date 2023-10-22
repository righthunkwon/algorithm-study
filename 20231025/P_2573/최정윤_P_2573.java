package baek;

import java.io.*;
import java.util.*;

public class Pro_2573_빙산 {
	static int[] dr, dc;
	static int[][] map;
	static int N, M;
	static Queue<int[]> q;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		q = new LinkedList<int[]>();
		map = new int[N][M];
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝
		
		int result = 0;
		while (!finish()) {//여기서 문제점 모두가 동시에 0으로 변하여 쪼개지지 않고 끝나도 false가 return됨. iszero로 그냥 모두 0으로 변했는지 확인해야한다.
			if (iszero()) {//빙산이 한번에 녹아서 모두 0이 되어버렸다면 0 출력후 끝냄
				result = 0;
				break;
			}
			//빙산 녹이는 과정 시작
			int[][] minus = new int[N][M];// 녹은 뒤 저장배열
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0) {
						int cnt = map[i][j] - check(i, j);
						cnt = cnt <= 0 ? 0 : cnt;//음수가 된다면 0으로 세팅
						minus[i][j] = cnt;//저장해놓기 , 바로 map으로 바꿔버리면 같은 시간에 녹는 것 check할 때 혼동이 온다.
					}
				}
			}
			for (int i = 0; i < N; i++) {//저장해놓은 것으로 바꾸기
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0) {
						map[i][j] = minus[i][j];
					}
				}
			}
			result++;
		}
		System.out.println(result);
	}

	private static boolean iszero() {
		int zero = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					zero++;
			}
		}
		if (zero == N * M) {
			return true;
		}
		return false;
	}

	private static int check(int i, int j) {
		int cnt = 0;
		for (int k = 0; k < 4; k++) {//4방중 0인것 수 세서 반환
			int nr = i + dr[k];
			int nc = j + dc[k];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] != 0)
				continue;
			cnt++;
		}

		return cnt;
	}

	private static boolean finish() {//빙산이 2개 이상으로 쪼개졌는가 
		visited = new boolean[N][M];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && cnt == 0) {//첫번째 0이 아닌 수 나오면 bfs 돌려서 연결된 것 visited true로 한다.
					q.add(new int[] { i, j });
					bfs();
					cnt++;
				} else if (map[i][j] != 0 && !visited[i][j]) {//이후에 지도에 0이 아닌 수가 visited 안되있다면 2개이상으로 쪼개진 것
					return true;
				}
			}
		}
		return false; 
	}

	private static void bfs() {//연결된 것 찾기
		while (!q.isEmpty()) {
			int[] arr = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = arr[0] + dr[i];
				int nc = arr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 0 || visited[nr][nc])
					continue;
				q.add(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}
	}
}
