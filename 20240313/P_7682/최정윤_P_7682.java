package study_240313;

import java.io.*;

public class Pro_7682_틱택토2 {
	// 빙고 8가지밖에 없어서 배열로 풀고 싶은디 ..

//	경우
//	1. 9개가 다 찬 경우 - x 개수는 5, o 개수가 4이여야만함 - o가 빙고가 되면 안됨
//	2. 9개는 다 안 참 - x+o의 수가 짝수면 x=o이고 x는 빙고 아니고 o가 빙고여야함
//	               - x+o의 수가 홀수면 x=o+1이여야하고 o는 빙고 아니고 x가 빙고여야함
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bingo = new int[][][] { { { 0, 0 }, { 0, 1 }, { 0, 2 } }, { { 1, 0 }, { 1, 1 }, { 1, 2 } },
				{ { 2, 0 }, { 2, 1 }, { 2, 2 } }, { { 0, 0 }, { 1, 0 }, { 2, 0 } }, { { 0, 1 }, { 1, 1 }, { 2, 1 } },
				{ { 0, 2 }, { 1, 2 }, { 2, 2 } }, { { 0, 0 }, { 1, 1 }, { 2, 2 } }, { { 2, 0 }, { 1, 1 }, { 0, 2 } } };

		a: while (true) {
			String input = br.readLine();
			game = new char[3][3];
			int o = 0, x = 0; //O와 X의 수 세기
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					game[i][j] = input.charAt(3 * i + j);
					if (game[0][0] == 'e')
						System.exit(0);
					if (game[i][j] == 'O')
						o++;
					else if (game[i][j] == 'X')
						x++;
				}
			} // 입력 끝

			if (o + x == 9) {  //	1. 9개가 다 찬 경우 - x 개수는 5, o 개수가 4이여야만함 - o가 빙고가 되면 안됨
				if (x == 5 && o == 4) {
					if (!isObingo()) {
						System.out.println("valid");
						continue a;
					}
				}
			} else {//	2. 9개는 다 안 참 
				if ((x + o) % 2 == 0 && x == o) { // x+o의 수가 짝수면 x=o이고 x는 빙고 아니고 o가 빙고여야함
					if (isObingo() && !isXbingo()) {
						System.out.println("valid");
						continue a;
					}
				} else if ((x + o) % 2 == 1 && x == o + 1) { //x+o의 수가 홀수면 x=o+1이여야하고 o는 빙고 아니고 x가 빙고여야함
					if (!isObingo() && isXbingo()) {
						System.out.println("valid");
						continue a;
					}
				}
			}
			System.out.println("invalid");
		}
	}

	static char[][] game;
	static int[][][] bingo;

	private static boolean isObingo() {
		for (int i = 0; i < 8; i++) {
			if (game[bingo[i][0][0]][bingo[i][0][1]] == 'O'
					&& game[bingo[i][0][0]][bingo[i][0][1]] == game[bingo[i][1][0]][bingo[i][1][1]]
					&& game[bingo[i][2][0]][bingo[i][2][1]] == game[bingo[i][0][0]][bingo[i][0][1]]) {
				return true;
			}
		}
		return false;
	}

	private static boolean isXbingo() {
		for (int i = 0; i < 8; i++) {
			if (game[bingo[i][0][0]][bingo[i][0][1]] == 'X'
					&& game[bingo[i][0][0]][bingo[i][0][1]] == game[bingo[i][1][0]][bingo[i][1][1]]
					&& game[bingo[i][2][0]][bingo[i][2][1]] == game[bingo[i][0][0]][bingo[i][0][1]]) {
				return true;
			}
		}
		return false;
	}
}
