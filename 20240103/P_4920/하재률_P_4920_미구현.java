package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 25%에서 틀린다. 왜why?
public class BOJ_4920_테트리스게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// int[13][2][4]
		int[][][] tetris = {
				// 그 긴거 가로
				{{0, 0, 0, 0}, {0, 1, 2, 3}},
				// 그 긴거 세로
				{{0, 1, 2, 3}, {0, 0, 0, 0}},
				// ㄱㄴ 정방향
				{{0, 0, 1, 1}, {0, 1, 1, 2}},
				// ㄱㄴ 시계방향 회전
				{{0, 1, 1, 2}, {0, 0, -1, -1}},
				// ㄱ 정방향
				{{0, 0, 0 ,1}, {0, 1, 2, 2}},
				// ㄱ 시계방향 90
				{{0, 1, 2, 2}, {0, 0, 0, -1}},
				// ㄱ 시계방향 180
				{{0, 1, 1, 1}, {0, 0, 1, 2}},
				// ㄱ 시계방향 270
				{{0, 0, 1, 2}, {0, 1, 0, 0}},
				// ㅜ 정방향
				{{0, 0, 0, 1}, {0, 1, 2, 1}},
				// ㅜ 시계방향 90
				{{0, 1, 1, 2}, {0, -1, 0, 0}},
				// ㅜ 시계방향 180
				{{0, 1, 1, 1}, {0, -1, 0, 1}},
				// ㅜ 시계방향 270
				{{0, 1, 1, 2}, {0, 0, 1, 0}},
				// ㅁ
				{{0, 0, 1, 1}, {0, 1, 1, 0}},
		};
		
		int tc = 1;
		while(true) {
			int N = Integer.parseInt(br.readLine().trim());
			if(N == 0) return;
			int[][] map = new int[N][N];
			int res = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken().trim());
				}
			}// 입력 완
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					for(int k = 0; k < tetris.length; k++) {
						int sum = 0;
						boolean flag = false;
						// 테트리스 조각 모음
						for(int d = 0; d < 4; d++) {
							int nx = i + tetris[k][0][d];
							int ny = j + tetris[k][1][d];
							if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
								flag = true;
								break;
							}
							sum += map[nx][ny];
						}
						if(!flag) res = res > sum ? res : sum;
					}
				}
			}
			System.out.println(tc + ". " + res);
			tc++;
		}
	}
}
