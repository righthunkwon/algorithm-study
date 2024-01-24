
import java.io.*;
import java.util.*;

public class Pro_20058_마법사상어와파이어스톰 {
	static int[][] ice, newIce;
	static int[] dr, dc;
	static Queue<int[]> q;
	static int max, size;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, N);
		ice = new int[size][size];
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int L = Integer.parseInt(st.nextToken());
			newIce = new int[size][size];
			if (L == 0) {
				for (int j = 0; j < size; j++) {
					newIce[j] = ice[j].clone();
				}
			} else {
				for (int j = 0; j < size; j += Math.pow(2, L)) {
					for (int k = 0; k < size; k += Math.pow(2, L)) {
						turn(j, k, (int) Math.pow(2, L));
					}
				}
			}
			// 얼음 3방향 이상에 있나 확인
			boolean[][] melt = new boolean[size][size];

			for (int j = 0; j < size; j++) {
				h: for (int k = 0; k < size; k++) {
					if (newIce[j][k] != 0) {
						int cnt = 0;
						for (int l = 0; l < 4; l++) {
							int nr = j + dr[l];
							int nc = k + dc[l];
							if (nr < 0 || nc < 0 || nr >= size || nc >= size || newIce[nr][nc] == 0) {
								cnt++;
							}
							if (cnt >= 2) { // 얼음이 없거나 범위 벗어난게 2개 이상이면 녹는다. 
								melt[j][k] = true;
								continue h;
							}
						}
					}
				}
			}
			//녹이기 
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					if (melt[j][k])
						newIce[j][k]--;
				}
			}
			// 녹이기 끝
			// 복사
			for (int j = 0; j < size; j++) {
				ice[j] = newIce[j].clone();
			}

		}
		//최종 얼음 총합 구하기
		int sum = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sum += ice[i][j];
			}
		}
		//덩어리 중 가장 큰 덩어리 구하기
		max = 0;
		visited = new boolean[size][size];
		q = new LinkedList<>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!visited[i][j] && ice[i][j] != 0) {
					q.add(new int[] { i, j });
					visited[i][j] = true;
					bfs();
				}
			}
		}
		System.out.println(sum);
		System.out.println(max);
	}

	private static void bfs() {
		int cnt = 0;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			cnt++; //이어진 개수 구하기
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= size || nc >= size || visited[nr][nc] || ice[nr][nc] == 0)
					continue;
				q.add(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}
		max = Math.max(max, cnt); //최댓값 갱신
	}

	private static void turn(int r, int c, int l) { //돌리기
		int nr = r;
		int nc = c;
		for (int i = l - 1; i >= 1; i -= 2) {
			for (int j = 0; j < i; j++) {
				newIce[nr + j][nc + i] = ice[nr][nc + j];
				newIce[nr][nc + i - 1 - j] = ice[nr + j + 1][nc];
				newIce[nr + i][nc + i - j] = ice[nr + j][nc + i];
				newIce[nr + j + 1][nc] = ice[nr + i][nc + j + 1];
			}
			nr += 1;
			nc += 1;

		}
	}

}
