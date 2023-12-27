package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427_불 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[h][w];
			Queue<int[]> sang = new LinkedList<>();
			Queue<int[]> fire = new LinkedList<>();
			for(int i = 0; i < h; i++) {
				String input = br.readLine();
				for(int j = 0; j < w; j++) {
					map[i][j] = input.charAt(j);
					if(map[i][j] == '@') sang.add(new int[] {i, j, 0});
					else if(map[i][j] == '*') fire.add(new int[] {i, j});
				}
			}
			boolean flag = false;
			int res = 0;
			l:
			while(!sang.isEmpty()) {
				// 개별 불들 사방으로 번지기
				for(int i = 0; i < fire.size(); i++) {
					int[] poll = fire.poll();
					
					for(int d = 0; d < 4; d++) {
						int nx = poll[0] + dx[d];
						int ny = poll[1] + dy[d];
						if(nx >= 0 && nx < h && ny >= 0 && ny < w) {
							if(map[nx][ny] == '.' || map[nx][ny] == '@') {
								map[nx][ny] = '*';
								fire.add(new int[] {nx, ny});
							}
						}
					}
				}
				// 상근이 이동하기
				for(int i = 0; i < sang.size(); i++) {
					int[] poll = sang.poll();
					
					for(int d = 0; d < 4; d++) {
						int nx = poll[0] + dx[d];
						int ny = poll[1] + dy[d];
						if(nx >= 0 && nx < h && ny >= 0 && ny < w) {
							if(map[nx][ny] == '.') {
								map[nx][ny] = '@';
								sang.add(new int[] {nx, ny, poll[2]+1});
								if(nx == 0 || nx == h-1 || ny == 0 || ny == w-1) {
									flag = true;
									res = poll[2]+1;
									break l;
								}
							}
						}
					}
				}
			}
			System.out.println(flag ? res+1 : "IMPOSSIBLE");
			
		}
	}
}
