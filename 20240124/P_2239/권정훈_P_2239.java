package level_22_backtracking;

import java.io.*;
import java.util.*;

// 스도쿠
public class P_2239 {

	private static int[][] map;
	private static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 입력
		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			char[] carr = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				map[i][j] = carr[j] - '0';
			}
		}
		
		// 탐색
		dfs(0);
		
		// 정답출력
		for (int i = 0; i < 9; i++) {
		    for (int j = 0; j < 9; j++) {
		        sb.append(map[i][j]);
		    }
		    sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int idx) {
		// 종료 조건
		if (idx == 81) {
			flag = true;
			return;
		}

		int x = idx / 9;
		int y = idx % 9;

		if (map[x][y] != 0) {
			dfs(idx + 1);
		} else {
			for (int i = 1; i <= 9; i++) {
				// 유효성 검사 결과 가능하지 않으면 패스
				if (!isValid(x, y, i)) continue;

				map[x][y] = i;
				dfs(idx + 1);

				// 종료조건에 만족하지 못하면 이전 재귀로 돌아감
				if (flag) return;
				map[x][y] = 0;
			}
		}

	}

	private static boolean isValid(int x, int y, int n) {
		// 행열 중복검사
		for (int i = 0; i < 9; i++) {
			if (map[i][y] == n || map[x][i] == n)
				return false;
		}

		// 3*3 중복검사
		int sx = x / 3 * 3;
		int sy = y - y % 3;
		for (int i = sx; i < sx + 3; i++) {
			for (int j = sy; j < sy + 3; j++) {
				if (map[i][j] == n)
					return false;
			}
		}

		// 유효함
		return true;
	}

}
