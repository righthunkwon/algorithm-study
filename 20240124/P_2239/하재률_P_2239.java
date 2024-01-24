package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 가로줄, 세로줄, 사각형 1~9
public class BOJ_2239_스도쿠 {
	
	static int[][] map;
	static boolean[][] chk1, chk2, chk3;
	static boolean flag = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		chk1 = new boolean[9][9]; // 가로
		chk2 = new boolean[9][9]; // 세로
		chk3 = new boolean[9][9]; // 사각형
		
		for(int i = 0; i < 9; i++) {
			String input = br.readLine();
			for(int j = 0; j < 9; j++) {
				map[i][j] = input.charAt(j) - '0';
				if(map[i][j] != 0) {
					chk1[i][map[i][j]-1] = chk2[map[i][j]-1][j] = chk3[nemo(i, j)][map[i][j]-1] = true;
				}
			}
		}
		
		sol(0, 0);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	static void sol(int x, int y) {
		if(x == 9) {
			flag = true;
			return;
		}
		
		if(y == 9) {
			sol(x+1, 0);
			return;
		}
		
		if(map[x][y] != 0) {
			sol(x, y+1);
		} else {
			for(int i = 1; i <= 9; i++) {
				if(!chk1[x][i-1] && !chk2[i-1][y] && !chk3[nemo(x, y)][i-1]) {
					chk1[x][i-1] = chk2[i-1][y] = chk3[nemo(x, y)][i-1] = true;
					map[x][y] = i;
					
					sol(x, y+1);
					if(flag) break;
					
					chk1[x][i-1] = chk2[i-1][y] = chk3[nemo(x, y)][i-1] = false;
					map[x][y] = 0;
				}
			}
		}
	}
	
	static int nemo(int i, int j) {
		return (i/3)*3+j/3;
	}
}
