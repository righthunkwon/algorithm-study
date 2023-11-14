package _20231115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16174_점프왕쩰리_Large {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static String ans = "Hing";
	static int[] dr = {1,0}; // 아래, 오른쪽
	static int[] dc = {0,1}; // 아래, 오른쪽
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for(int i=0;i<N;i++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(s.nextToken());
			}
		}//입력끝
		visited[0][0]=true;
		jjelly(0,0);
		System.out.println(ans);

	}//main
  
	static void jjelly(int x, int y) {

		if(map[x][y] == -1) {
			ans = "HaruHaru";
			return;
		}

		for(int i=0;i<2;i++) {
			int nr = x + dr[i]*map[x][y];
			int nc = y + dc[i]*map[x][y];

			if (nr<0 || nc<0 || nr>=N || nc>=N) continue;

			if (visited[nr][nc]) continue;
			
			visited[nr][nc]=true;
			jjelly(nr,nc);
		}
		
	}//jjelly
}
