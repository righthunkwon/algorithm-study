package level_00_etc;

import java.io.*;
import java.util.*;

// 틱택토
public class P_7682 {

	static int idx, cntX, cntO;
	static int rowTTTCntX, colTTTCntX, crossTTTCntX;
	static int rowTTTCntO, colTTTCntO, crossTTTCntO;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();

			// 종료 조건
			if (str.equals("end")) break; 

			// 초기화
			idx = 0;
			cntX = 0;
			cntO = 0;
			map = new char[3][3];
			rowTTTCntX = 0;
			colTTTCntX = 0;
			rowTTTCntO = 0;
			colTTTCntO = 0;
			crossTTTCntO = 0;
			crossTTTCntX = 0;
			
			// 판 배열 요소 입력
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					map[i][j] = str.charAt(idx++);

					// 개수 카운트
					if (map[i][j] == 'X') cntX++;
					else if (map[i][j] == 'O') cntO++;
				}
			}

			// 종료 조건
			// O의 개수가 X의 개수보다 많거나
			// X가 O의 개수보다 2개 이상 많은 경우
			if (cntO > cntX || cntX - cntO > 1) {
				System.out.println("invalid");
				continue;
			}

			// 가로 검사
			for (int i = 0; i < 3; i++) {
				int rowX = 0;
				int rowO = 0;

				for (int j = 0; j < 3; j++) {

					if (map[i][j] == 'X') rowX++;
					else if (map[i][j] == 'O') rowO++;

					if (rowO == 3) rowTTTCntO++;
					else if (rowX == 3) rowTTTCntX++;
				}
			}

			// 세로 검사
			for (int i = 0; i < 3; i++) {
				int colX = 0;
				int colO = 0;

				for (int j = 0; j < 3; j++) {

					if (map[j][i] == 'X') colX++;
					else if (map[j][i] == 'O') colO++;

					if (colX == 3) colTTTCntX++;
					else if (colO == 3) colTTTCntO++;
				}
			}

			// 대각선 검사 ( \ )
			int cross1X = 0;
			int cross1O = 0;
			for (int i = 0; i < 3; i++) {
				if (map[i][i] == 'X') cross1X++;
				else if (map[i][i] == 'O') cross1O++;

				if (cross1O == 3) crossTTTCntO++;
				if (cross1X == 3) crossTTTCntX++;
			}

			// 대각선 검사 ( / )
			int cross2X = 0;
			int cross2O = 0;
			int j = 0;
			for (int i = 2; i >= 0; i--) {
				
				if (map[i][j] == 'X') cross2X++;
				else if (map[i][j] == 'O') cross2O++;
				
				if (cross2O == 3) crossTTTCntO++;
				if (cross2X == 3) crossTTTCntX++;
				j++;
			}

			// 종료 조건
			// 같은 라인의 틱택토가 여러개인 경우
			if (rowTTTCntX > 1 || rowTTTCntO > 1 || colTTTCntX > 1 || colTTTCntO > 1) {
				System.out.println("invalid");
				continue;
			}

			// 종료 조건
			// X와 O가 같으면 O가 이겨야함
			if (cntX == cntO) {
				if ((rowTTTCntX > 0 || colTTTCntX > 0 || crossTTTCntX > 0)) {
					System.out.println("invalid");
					continue;
				}
			}

			// 종료 조건
			// X가 더 크면 X가 이겨야 한다
			else if (cntX > cntO) {
				if (rowTTTCntO > 0 || colTTTCntO > 0 || crossTTTCntO > 0) {
					System.out.println("invalid");
					continue;
				}
			}

			// 종료 조건
			// 게임판이 가득 찬 경우
			if (cntX + cntO == 9) {
				System.out.println("valid");
				continue;
			}
			
			// 종료 조건
			// 빙고가 하나도 없는 경우
			if (rowTTTCntX + colTTTCntX + rowTTTCntO + colTTTCntO + crossTTTCntO + crossTTTCntX == 0) {
				System.out.println("invalid");
				continue;
			}

			// 조건에 걸리지 않은 경우
			System.out.println("valid");
		}

	}
}
