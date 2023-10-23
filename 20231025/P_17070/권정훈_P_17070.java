package level_31_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파이프 옮기기 1
// 조건을 풀면서 깨달아서 너무 오래 걸렸다. 문제를 꼼꼼히 읽자.
// 방향이 변하지 않으므로 중복 경로를 방문하지 않아 방문 배열이 필요하지 않다.

// 파이프를 옮기는 경우의 수
// 1) 파이프가 가로일 경우 - 오른쪽/오른쪽아래 두 방향으로
// 2) 파이프가 세로일 경우 - 아래/오른쪽아래 두 방향으로
// 3) 파이프가 대각선일 경우 - 오른쪽/아래/오른쪽아래 세 방향으로

// 파이프를 옮기는 방향에 따른 빈칸의 조건
// 1) 파이프를 오른쪽으로 옮길 경우 - 오른쪽칸 한 칸
// 2) 파이프를 아래로 옮길 경우 - 아래칸 한 칸
// 3) 파이프를 오른쪽아래로 옮길 경우 - 오른쪽칸/아래칸/오른쪽아래칸 세 칸

public class P_17070 {

	private static int n, ans;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ans = 0;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		// 배열 요소 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// x좌표, y좌표, 방향(0:오른쪽, 1:아래, 2:오른쪽아래)
		// 파이프의 끝 좌표(1,2)에서 시작, 배열 인덱스상으로 (0,1)부터 시작
		dfs(0,1,0);

		// 정답 출력
		System.out.println(ans);
	}

	private static void dfs(int x, int y, int dir) {
		// 기저부분(종료조건)
		if (x == n - 1 && y == n - 1) {
			ans++;
			return;
		}

		// 재귀부분(반복수행)
		// 1) 파이프가 가로일 경우 - 오른쪽/오른쪽아래 두 방향으로
		if (dir == 0) {
			// 오른쪽으로 이동
			// 범위에서 벗어나지 않고 오른쪽이 빈칸일 때
			if (isRange(x, y+1) && map[x][y+1] == 0) {
				dfs(x, y+1, 0);
			}

			// 오른쪽아래로 이동
			// 범위에서 벗어나지 않고 오른쪽/아래/오른쪽아래가 빈칸일 때
			if (isRange(x+1, y+1) && map[x+1][y+1] == 0 && map[x+1][y] == 0 && map[x][y+1] == 0) {
				dfs(x + 1, y + 1, 2);
			}
		} 
		
		// 2) 파이프가 세로일 경우 - 아래/오른쪽아래 두 방향으로
		else if (dir == 1) {
			// 아래로 이동
			// 범위에서 벗어나지 않고 아래가 빈칸일 때
			if (isRange(x+1, y) && map[x+1][y] == 0) {
				dfs(x+1, y, 1);
			}

			// 오른쪽아래로 이동
			// 범위에서 벗어나지 않고 오른쪽/아래/오른쪽아래가 빈칸일 때
			if (isRange(x+1, y+1) && map[x+1][y+1] == 0 && map[x][y+1] == 0 && map[x+1][y] == 0) {
				dfs(x+1, y+1, 2);
			}

		} 
		
		// 3) 파이프가 대각선일 경우 - 오른쪽/아래/오른쪽아래 세 방향으로
		else { 
			// 오른쪽으로 이동
			// 범위에서 벗어나지 않고 오른쪽이 빈칸일 때
			if (isRange(x, y+1) && map[x][y+1] == 0) {
				dfs(x, y+1, 0);
			}

			// 아래로 이동
			// 범위에서 벗어나지 않고 아래가 빈칸일 때
			if (isRange(x+1, y) && map[x+1][y] == 0) {
				dfs(x+1, y, 1);
			}

			// 오른쪽아래로 이동
			// 범위에서 벗어나지 않고 오른쪽/아래/오른쪽아래가 빈칸일 때
			if (isRange(x+1, y+1) && map[x+1][y+1] == 0 && map[x][y+1] == 0 && map[x+1][y] == 0) {
				dfs(x+1, y+1, 2);
			}
		}

	}

	public static boolean isRange(int x, int y) {
		return x >= 0 && x < n && y >= 1 && y < n;
	}
}
