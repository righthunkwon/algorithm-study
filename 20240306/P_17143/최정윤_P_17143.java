package study_240306;

import java.io.*;
import java.util.*;

public class Pro_17143_낚시왕 {
	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());// 행
		int C = Integer.parseInt(st.nextToken());// 열
		int M = Integer.parseInt(st.nextToken());// 상어의 수
		int[][] arr = new int[R][C];
		int[][] go_arr = new int[R][C];
		// 방향 0 위 1 아래 2 오른쪽 3 왼쪽
		int[] change_dir = new int[] { 1, 0, 3, 2 };
		int[] dr = new int[] { -1, 1, 0, 0 };
		int[] dc = new int[] { 0, 0, 1, -1 };
		Map<Integer, Shark> map = new HashMap<>();
		// 상어 r,c, 속력, 이동방향, 크기 입력됨
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			Shark shark = new Shark(r, c, s, d, z);
			arr[r][c] = i + 1;
			map.put(i + 1, shark);
		}
		int result = 0;
		// 낚시왕 이동
		for (int i = 0; i < C; i++) {
			// 상어 잡기
			for (int j = 0; j < R; j++) {
				if (arr[j][i] != 0) {
					result += map.get(arr[j][i]).z;
					map.put(arr[j][i], null);
					arr[j][i] = 0;
					break;
				}
			}
			go_arr = new int[R][C];
			// 상어 이동
			for (Integer key : map.keySet()) {
				Shark shark = map.get(key);
				if (shark == null)
					continue;
				int nr = shark.r;
				int nc = shark.c;
				if (arr[nr][nc] == 0)
					continue;
				int dir = shark.d;
				int s;
				if (dir == 0 || dir == 1) {// 여기가 시간초과 없애는 코드
					s = shark.s % (R * 2 - 2);
				} else {
					s = shark.s % (C * 2 - 2);
				}
				// 이동 ㄱㄱ
				for (int j = 0; j < s; j++) {
					nr = nr + dr[dir];
					nc = nc + dc[dir];
					if (nr < 0 || nc < 0 || nr >= R || nc >= C) { //벽이면 방향 바꿔서 다시 가라
						dir = change_dir[dir];
						nr = nr + dr[dir] * 2;
						nc = nc + dc[dir] * 2;
					}
				}
				if (go_arr[nr][nc] != 0 && map.get(go_arr[nr][nc]).z >= shark.z) {
					//갔는데 이미 온 애들중에 나보다 큰애 있으면 삭제
					map.put(key, null);
				} else {
					if (go_arr[nr][nc] != 0 && map.get(go_arr[nr][nc]).z < shark.z) {
						map.put(go_arr[nr][nc], null);
					}
					go_arr[nr][nc] = key;
					map.put(key, new Shark(nr, nc, shark.s, dir, shark.z));
				}
			}
			// arr을 go_arr로 바꾸기
			for (int j = 0; j < R; j++) {
				arr[j] = go_arr[j].clone();
			}

		}
		System.out.println(result);
	}
}
