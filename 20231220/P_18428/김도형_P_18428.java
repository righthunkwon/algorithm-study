package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q18428_감시_피하기 {
	static int N;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static boolean flag; // 감시 피하는 경우가 되면 끝내기용 flag

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}

		dfs(0,0);
		if (flag) {
			System.out.println("YES");
		} else
			System.out.println("NO");

	}

	// 3개의 장애물 쌓는 경우의 수 하나씩 해보기
	public static void dfs(int cnt, int idx) {

		if (flag)return;

		if (idx == N * N) {
			return;
		}

		if (cnt == 3) {
			if (!check()) { // 학생 못찾았으면
				flag = true;
			}
			return;
		}
		int r = idx / N;
		int c = idx % N;
		if (map[r][c] == 'X') { // 빈칸이면
			map[r][c] = 'O'; // 장애물 설치
			dfs(cnt + 1, idx + 1);
			map[r][c] = 'X'; // 원상복구
		}
		dfs(cnt, idx + 1); //장애물 설치 안한 경우
	}

	// 선생님한테 걸리는지 여부 판단
	public static boolean check() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'T') { // 탐색하다가 선생님 있으면 4방향으로 학생 탐색
					for (int k = 0; k < 4; k++) {
						int nowr = i;
						int nowc = j;
						while (true) {
							int nextr = nowr + dr[k];
							int nextc = nowc + dc[k];
							if (nextr < 0 || nextc < 0 || nextr >= N || nextc >= N || map[nextr][nextc] == 'O')
								break;
							if (map[nextr][nextc] == 'S') {
								return true; // 학생 찾으면 true
							}
							nowr = nextr;
							nowc = nextc;
						}
					} // for k
				} // if S
			} // for j
		} // for i
		return false; // 학생 못찾았으면 false
	}

}
