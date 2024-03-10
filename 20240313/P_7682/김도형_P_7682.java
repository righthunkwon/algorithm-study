package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_Q7682_틱택토 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L:while (true) {
			String str = br.readLine();
			if (str.contains("end"))
				break;
			char[][] arr = new char[3][3];
			boolean Xbingo = false;
			boolean Obingo = false;
			int Xcnt = 0;
			int Ocnt = 0;
			// 3개씩
			for (int i = 0; i < 9; i++) {
				int r = i / 3;
				int c = i % 3;
				arr[r][c] = str.charAt(i);
				if(arr[r][c]=='X')Xcnt++;
				if(arr[r][c]=='O')Ocnt++;
			}
	
			//X가 1개 많을 수는 있지만 차이가 2이상 나면 안됨!
			if(Math.abs(Ocnt-Xcnt)>1 || Ocnt>Xcnt) {
				System.out.println("invalid");
				continue L;
			} 
			
			int [][] bingo = {
					{0,0,0,1,0,2},
					{1,0,1,1,1,2},
					{2,0,2,1,2,2},
					{0,0,1,0,2,0},
					{0,1,1,1,2,1},
					{0,2,1,2,2,2},
					{0,0,1,1,2,2},
					{0,2,1,1,2,0}
					};
			
			for(int i=0;i<8;i++) {
				StringBuilder sb = new StringBuilder();
				sb.append(arr[bingo[i][0]][bingo[i][1]])
				.append(arr[bingo[i][2]][bingo[i][3]])
				.append(arr[bingo[i][4]][bingo[i][5]]);
				String s = sb.toString();
				if(s.contains("XXX")) {
					Xbingo=true;
				}else if(s.contains("OOO")) {
					Obingo=true;
				}
			}
			
			//X,O 모두 빙고가 되면 안됨
			if(Xbingo&&Obingo) {
				System.out.println("invalid");
				continue L;
			}
			
			//X가 빙고를 만들어 이겼으면 X의 수가 O보다 1많아야만 함!
			if(Xbingo&&Xcnt != Ocnt+1) {
				System.out.println("invalid");
				continue L;
			}
			
			//O빙고면 O의 개수와 X의 개수 같아야함!
			if(Obingo && Xcnt!=Ocnt) {
				System.out.println("invalid");
				continue L;
			}
			
			//게임판이 가득 차서 게임 종료
			if(Xcnt+Ocnt==9 && !Xbingo && !Obingo) {
				System.out.println("valid");
				continue L;
			}
			
			//게임판 덜차고 빙고가 없으면 아직 게임 종료X
			if(Xcnt+Ocnt!=9 && !Xbingo && !Obingo) {
				System.out.println("invalid");
				continue L;
			}
			
			//이 외에는 모두 가능
			System.out.println("valid");
		} // while
	}// main
}// class
