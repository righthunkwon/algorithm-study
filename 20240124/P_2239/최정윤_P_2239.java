
import java.util.*;
import java.io.*;

public class Pro_2239_스도쿠 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cnt = 0;
		visited = new boolean[10][10][3]; // 가로, 세로 , 네모
		puzzle = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < 9; j++) {
				puzzle[i][j] = Integer.parseInt(input[j]);
				if (puzzle[i][j] == 0)
					cnt++;
				visited[i][puzzle[i][j]][0] = true;
				visited[j][puzzle[i][j]][1] = true;
				visited[(i / 3) * 3 + j / 3][puzzle[i][j]][2] = true;
			}
		} // 입력끝

		dfs(0, 0);
	}

	static boolean[][][] visited;
	static int[][] puzzle;
	static int cnt;

	private static void dfs(int r, int c) {
		if (r == 9) { //모든거 다 돌면 다 채워졌다는 뜻 , 사전순작은 게 먼저 온다.
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(puzzle[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		if (puzzle[r][c] == 0) { //값을 넣어야한다면 
			for (int i = 1; i <= 9; i++) { //1~9 중에 조건 맞는 값 넣자
				if (!visited[r][i][0] && !visited[c][i][1] && !visited[(r / 3) * 3 + c / 3][i][2]) { //가로, 세로, 네모에 없는 값만 
					visited[r][i][0] = true;
					visited[c][i][1] = true;
					visited[(r / 3) * 3 + c / 3][i][2] = true;
					puzzle[r][c]=i;
					if (c == 8)
						dfs(r + 1, 0);
					else
						dfs(r, c + 1);
					visited[r][i][0] = false;
					visited[c][i][1] = false;
					visited[(r / 3) * 3 + c / 3][i][2] = false;
					puzzle[r][c]=0;
				}
			}
			return;
		} else {
			if (c == 8)
				dfs(r + 1, 0);
			else
				dfs(r, c + 1);
		}
	}
}
