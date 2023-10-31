package baek;

import java.io.*;
import java.util.*;

public class Pro_12100_2048 {
	static int[] select;
	static int N, max;
	static int[][] map, inputMap;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		inputMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				inputMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		select = new int[5];
//		left(); :0
//		right(); :1
//		up(); :2
//		down();: 3
		// 어디로 움직일지 5번 방향 정하기
		dfs(0);
		System.out.println(max);
	}

	private static void dfs(int cnt) {
		if (cnt == 5) {//5뱡향 다 정해졌으면 
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = inputMap[i].clone();
			}
			game();
			return;
		}
		for (int i = 0; i <= 3; i++) {
			select[cnt] = i;
			dfs(cnt + 1);
		}

	}

	private static void game() {
		for (int i = 0; i < 5; i++) {
			switch (select[i]) {
			case 0:
				left();
				break;
			case 1:
				right();
				break;
			case 2:
				up();
				break;
			default:
				down();
				break;
			}
		}
		maxBlock();//5번 이동했으면 가장 큰 값 구하자
	}

	private static void maxBlock() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(map[i][j], max);
			}
		}
	}

	private static void left() {
		// 왼쪽 구현
		for (int i = 0; i < N; i++) {
			int num = 0;
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					continue;
				int cnt = 1;
				while (j + cnt < N && map[i][j + cnt] == 0) {
					cnt++;
				}
				if (j + cnt < N && map[i][j] == map[i][j + cnt]) {
					map[i][num] = map[i][j] * 2;
					j += cnt;
				} else {
					map[i][num] = map[i][j];
				}
				num++;
			}
			for (int k = num; k < N; k++) {
				map[i][k] = 0;
			}
		}
	}

	private static void right() {
		// 오른쪽 구현
		for (int i = 0; i < N; i++) {
			int num = N - 1;
			for (int j = N - 1; j >= 0; j--) {
				if (map[i][j] == 0)
					continue;
				int cnt = 1;
				while (j - cnt >= 0 && map[i][j - cnt] == 0) {
					cnt++;
				}
				if (j - cnt >= 0 && map[i][j] == map[i][j - cnt]) {
					map[i][num] = map[i][j] * 2;
					j -= cnt;
				} else {
					map[i][num] = map[i][j];
				}
				num--;
			}
			for (int k = num; k >= 0; k--) {
				map[i][k] = 0;
			}
		}
	}

	private static void up() {
		// 위구현
		for (int j = 0; j < N; j++) {
			int num = 0;
			for (int i = 0; i < N; i++) {
				if (map[i][j] == 0)
					continue;
				int cnt = 1;
				while (i + cnt < N && map[i + cnt][j] == 0) {
					cnt++;
				}
				if (i + cnt < N && map[i][j] == map[i + cnt][j]) {
					map[num][j] = map[i][j] * 2;
					i += cnt;
				} else {
					map[num][j] = map[i][j];
				}
				num++;
			}
			for (int k = num; k < N; k++) {
				map[k][j] = 0;
			}
		}
	}

	private static void down() {
		// 아래 구현
		for (int j = 0; j < N; j++) {
			int num = N - 1;
			for (int i = N - 1; i >= 0; i--) {
				if (map[i][j] == 0)
					continue;
				int cnt = 1;
				while (i - cnt >= 0 && map[i - cnt][j] == 0) {
					cnt++;
				}
				if (i - cnt >= 0 && map[i][j] == map[i - cnt][j]) {
					map[num][j] = map[i][j] * 2;
					i -= cnt;
				} else {
					map[num][j] = map[i][j];
				}
				num--;
			}
			for (int k = num; k >= 0; k--) {
				map[k][j] = 0;
			}
		}
	}

}
