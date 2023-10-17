package _20231018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _1987_알파벳 {
	static int R, C;
	static char[][] board;
	static boolean[][] visited;
	static int max=-1;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static ArrayList<Character> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String st = br.readLine();
		R = Integer.parseInt(st.split(" ")[0]);
		C = Integer.parseInt(st.split(" ")[1]);
		
		board = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0;i<R;i++) {
			st = br.readLine();
			for(int j=0;j<C;j++) {
				board[i][j]=st.charAt(j);
			}
		}//입력끝
		
		move(0,0);
		System.out.println(max);
		
		
	}//main
	
	static void move(int x, int y) {
		visited[x][y]= true;
		list.add(board[x][y]);
		for(int i=0; i<4;i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			if(nr<0||nc<0||nr>=R||nc>=C) continue;
			if(!visited[nr][nc]) {
				if(!list.contains(board[nr][nc])){
				 move(nr,nc);
				}
			}
		}
		int cnt = list.size();
		max = Math.max(max, cnt);
		// max값 까지 구한 후에는 list에 추가된걸 지워주고
		// visited값도 다시 false로 바꿔준다
		list.remove(list.size()-1);
		visited[x][y] = false;
		return;
	}//dfs

}
