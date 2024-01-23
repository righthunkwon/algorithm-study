package _20240124;

import java.util.*;
import java.io.*;

public class _2239_스도쿠 {
	static int[][] arr;
	static boolean[][] rowCheck, colCheck, boxCheck;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[9][9];

		// 체크할 때, arr값을 그대로 넣기 위해서 열 크기는 10으로 한다
		rowCheck = new boolean[9][10]; // 행 체크, 행값에 해당 행을 넣고, 열값에 arr값을 넣는다
		colCheck = new boolean[9][10]; // 열 체크, 행값에 해당 열을 넣고, 열값에 arr값을 넣는다
		boxCheck = new boolean[9][10]; // 박스 체크, 행값에 해당 박스 위치를 넣고, 열값에 arr값을 넣는다

		for(int i=0;i<9;i++) {
			String temp = br.readLine();
			for(int j=0;j<9;j++) {
				arr[i][j] = temp.charAt(j)-'0';
				if(arr[i][j]!=0) {
					// 0이 아닐 땐 해당 값을 행체크/열체크/박스체크 에 각각 표시한다
					rowCheck[i][arr[i][j]]=true;
					colCheck[j][arr[i][j]]=true;
					boxCheck[3*(i/3)+(j/3)][arr[i][j]] = true;
				}
			}
		}
		sudoku(0, 0);


	}//main


	static void sudoku(int row, int col) {

		// 한 행의 열이 채워지면 그 다음 행으로 넘어간다
		if(col == 9) {
			sudoku(row+1,0);
			return;
		}
		// 모든 행이 다 채워지면 수를 출력한다

		// 문제에서 제시된 81자리 수 중에 가장 작은수는
		// 결국 위에서부터 수를 채워나가고, 1부터 대입해서 만족하는 수를 채우기 때문에
		// 제일 처음 완성되는 스도쿠를 의미한다
		if(row==9) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			System.exit(0);

		}
		// 수를 채워야 하는 자리라면
		if(arr[row][col]==0) {
			// 1부터 수를 넣어본다
			for(int i=1;i<=9;i++) {
				// 스도쿠 원리를 만족하는지 체크하고 만족하면 그 수를 넣고 모든 배열에 표시하고
				// 다음 위치로 넘어간다
				if (!rowCheck[row][i] && !colCheck[col][i] && !boxCheck[3*(row/3)+(col/3)][i]) {
					rowCheck[row][i] = true;
					colCheck[col][i] = true;
					boxCheck[3*(row/3)+(col/3)][i] = true;

					arr[row][col] = i;

					sudoku(row, col + 1);
					
					arr[row][col] = 0;
					rowCheck[row][i] = false;
					colCheck[col][i] = false;
					boxCheck[3*(row/3)+(col/3)][i] = false;
				}
			}
		} else {
			// 0이 아니면 이미 수가 있으므로 다음 열로 넘어간다
			sudoku(row,col+1);
		}
	}


}
