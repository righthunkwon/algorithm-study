package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11123_양한마리양두마리 {
	static int H, W;
	static char[][] map;
	static boolean[][] chk;
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			chk = new boolean[H][W];
			map = new char[H][W];
			for(int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray(); 
			}// 입력 완료
			
			int cnt = 0;
			
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(map[i][j] == '#' && !chk[i][j]) { // 양이 존재하고 방문하지 않았으면
						dfs(i, j); // dfs진행
						cnt++; // dfs 한 사이클 진행했으면 한 무리 발견했으니 cnt++
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	// dfs로 양의 무리 찾기
	static void dfs(int x, int y) {
		chk[x][y] = true; // 방문쳌 해주고
		
		for(int d = 0; d < 4; d++) {
			int a = x + dx[d];
			int b = y + dy[d];
			if(a >= 0 && a < H && b >= 0 && b < W ) { // 범위 벗어나지 않고
				if(!chk[a][b] && map[a][b] == '#') { // 방문하지 않고, 양이면
					dfs(a, b); // dfs진행
				}
			}
		}
	}
}
