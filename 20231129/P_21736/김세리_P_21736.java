package _20231129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21736_헌내기는친구가필요해 {
	static char[][] map;
	static int N,M,idx=0,jdx=0,cnt=0;
	static int ans = 0;
	static boolean[][] visited;
	// 상, 하, 좌, 우
	static int[]dr = {-1,1,0,0};
	static int[]dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]= s.charAt(j);
				if(map[i][j]=='I') {
					idx = i; jdx = j;
				}
			}
		}
//		System.out.println(idx+" "+jdx);
		moving(idx,jdx);
		if(ans>0) System.out.println(ans);
		if(ans==0) System.out.println("TT");
		
		
	}//main
	static void moving(int x, int y) {
		
		ans = Math.max(ans, cnt);
		
		visited[x][y]=true;
		for(int i=0;i<4;i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
//			System.out.println(nr+" "+nc);
			if(nr<0 || nc<0 || nr>=N || nc>=M || map[nr][nc]=='X' || visited[nr][nc]==true) continue;
			if(map[nr][nc]=='P') {
				cnt++;
			}
			moving(nr,nc);
			
		}
		
		
	}//moving

}
