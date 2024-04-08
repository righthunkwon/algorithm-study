package level_26_divide_and_conquer;

import java.io.*;
import java.util.*;

// 쿼드트리
// 동일한 로직으로 판단하며, 불가할 경우 공간을 지속적으로 분할하여 재판단 
public class P_1992 {
	public static int[][] map;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - 48;
			}
		}

		recursion(0, 0, N);
		System.out.println(sb);
	}

	// 재귀
	public static void recursion(int x, int y, int size) {

		// 압축이 가능할 경우 숫자를 추가
		if (isPossible(x, y, size)) {
			sb.append(map[x][y]);
			return;
		}

		// 압축이 불가능할 경우 영역 분할 및 괄호 추가
		int newSize = size / 2;
		sb.append('('); 

		// 시작점 기준 재귀 시작
		recursion(x, y, newSize); // 왼쪽 위
		recursion(x, y + newSize, newSize); // 오른쪽 위
		recursion(x + newSize, y, newSize); // 왼쪽 아래
		recursion(x + newSize, y + newSize, newSize); // 오른쪽 아래

		// 괄호 닫기
		sb.append(')');
	}

	// 압축 가능 여부 판단
	public static boolean isPossible(int x, int y, int size) {
		int start = map[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (start != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
