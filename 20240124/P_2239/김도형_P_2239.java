import java.io.*;

public class Main {
	static int[][]map = new int[9][9]; //스도쿠 보드 저장용 배열
	static boolean[][][]visit=new boolean[3][9][10];
	//가로,세로, 3*3칸에 해당 숫자 사용했는지 여부 저장용 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j)-'0';
				if(map[i][j]!=0) {
					visit[0][i][map[i][j]]=true; //세로
					visit[1][j][map[i][j]]=true; //가로
					visit[2][(i/3)*3+j/3][map[i][j]]=true; //3*3칸
				}
			}
		} //입력 끝
		sudoku(0,0);
	}//main
	public static void sudoku(int x,int y) {
		//기저파트
		if(x==9) {
			printSudoku(map); 
			System.exit(0); //최초 완성 맵 출력하고 끝내기
		}
		
		//재귀파트
		if(map[x][y]!=0) { //이미 숫자 있는 칸 pass
			if(y+1==9) {
				sudoku(x+1,0);
			}else
				sudoku(x,y+1);
		}else { //빈칸이면 가로,세로,3*3칸 중복 체크 해서 들어갈 수 있는 숫자 넣고 넘어가기
			for(int i=1;i<=9;i++) {
				if(!visit[0][x][i] && !visit[1][y][i] && !visit[2][(x/3)*3+y/3][i]) {
					visit[0][x][i]=true;
					visit[1][y][i]=true;
					visit[2][(x/3)*3+y/3][i]=true;
					map[x][y]=i;
					
					//다음칸으로 넘어가
					if(y+1==9) {
						sudoku(x+1,0);
					}else
						sudoku(x,y+1);
					
					//해당 숫자 안넣는 경우
					map[x][y]=0;
					visit[0][x][i]=false;
					visit[1][y][i]=false;
					visit[2][(x/3)*3+y/3][i]=false;
				}
			}
		}
	}
	// 스도쿠 보드 출력하는 함수
	private static void printSudoku(int[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}//clas
