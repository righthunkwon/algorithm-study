package baek;

import java.io.*;
import java.util.*;

public class Pro_2638_치즈 {
	static boolean[][] contact;
	static int[][] map;
	static Queue<int[]> q;
	static int[] dr, dc;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		q = new LinkedList<int[]>();
		int result = 0;
		while (true) {
			contact = new boolean[N][M];// 외부공기인 곳은 true 아닌곳 false
			contact[0][0] = true;
			q.add(new int[] { 0, 0 });// 0,0은 무조건 외부공기니까
			bfs();// 외부공기와 연결되었는지안되었는지 바꿔놓기

			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < M - 1; j++) {
					if (check(i, j))
						map[i][j] = 0;
				}
			}
			result++;
			if (finish())
				break;
		}
		System.out.println(result);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int[] arr = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = arr[0] + dr[i];
				int nc = arr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 1 || contact[nr][nc])
					continue;
				contact[nr][nc] = true;// 외부와 접촉했으면 바꾸고 계속 진행
				q.add(new int[] { nr, nc });
			}
		}
	}

	private static boolean check(int r, int c) {// 외부공기와 2변이상 만나는지 확인하는 것
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;
			if (contact[nr][nc])
				cnt++;
			if (cnt >= 2)// 2변이상 만나면 녹았다고 리턴
				return true;
		}
		return false;
	}

	private static boolean finish() { // 치즈가 모두 녹았는지 확인하는 메소드
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {
				if (map[i][j] == 1)
					return false;
			}
		}
		return true;
	}

}
