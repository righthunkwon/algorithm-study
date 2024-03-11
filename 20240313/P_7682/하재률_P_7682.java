package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7682_틱택토 {
	
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[3][3];
		
		
		while(true) {			
			String str = br.readLine();
			if(str.equals("end")) return;
			
			int xCnt = 0;
			int oCnt = 0;
			int idx = 0;
			
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j <3; j++) {
					map[i][j] = str.charAt(idx++);
					if(map[i][j] == 'X') xCnt++;
					if(map[i][j] == 'O') oCnt++;
				}
			}
			if(xCnt == oCnt) {
				if(!bingo('X') && bingo('O')) System.out.println("valid");
				else System.out.println("invalid");
			} else if(xCnt == oCnt + 1) {
				if(xCnt + oCnt == 9 && !bingo('O')) System.out.println("valid");
				else if(bingo('X') && !bingo('O')) System.out.println("valid");
				else System.out.println("invalid");
			} else System.out.println("invalid");
			
		}
	}
	
	static boolean bingo(char c) {
		// 가로
		for(int i = 0; i < 3; i++) {
			if(map[i][0] == c && map[i][1] == c && map[i][2] == c) return true;
		}
		
		// 세로
		for(int i = 0; i < 3; i++) {
			if(map[0][i] == c && map[1][i] == c && map[2][i] == c) return true;
		}
		
		// 대각선
		if(map[0][0] == c && map[1][1] == c && map[2][2] == c) return true;
		if(map[0][2] == c && map[1][1] == c && map[2][0] == c) return true;
		
		return false;
	}
}
