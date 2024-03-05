
import java.io.*;
import java.util.*;

// 낚시왕
public class P_17143 {
	static int R, C, M, ans;
	static Shark[][] map;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;

		Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); // 행의 수
		C = Integer.parseInt(st.nextToken()); // 열의 수
		M = Integer.parseInt(st.nextToken()); // 상어의 수
		ans = 0; // 정답

		// 지도 배열 요소 입력
		map = new Shark[R][C];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()); // 행
			int c = Integer.parseInt(st.nextToken()); // 열
			int s = Integer.parseInt(st.nextToken()); // 속력
			int d = Integer.parseInt(st.nextToken()); // 방향
			int z = Integer.parseInt(st.nextToken()); // 크기

			if (d == 1)
				d = 0;
			else if (d == 4)
				d = 1;

			map[r - 1][c - 1] = new Shark(r - 1, c - 1, s, d, z);
		}

		// 열마다 이동
		for (int col = 0; col < C; col++) {
			for (int row = 0; row < R; row++) {
				if (map[row][col] != null) {
					ans += map[row][col].z; // 최단거리에 존재하는 상어 크기 저장
					map[row][col] = null; // 상어 제거
					break;
				}
			}

			// 상어 큐에 추가
			Queue<Shark> queue = new LinkedList<>();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					// 현재 지도에 있는 상어 추가
					if (map[i][j] != null) {
						queue.add(new Shark(i, j, map[i][j].s, map[i][j].d, map[i][j].z));
					}
				}
			}
			map = new Shark[R][C]; // 지도 초기화

			// 상어 이동
			///////////////////////////////////////// 여기부터 /////////////////////////////////////////
			while (!queue.isEmpty()) {
				Shark shark = queue.poll();
			}

			// 정답 출력
			System.out.println(ans);
		}
	}
}
