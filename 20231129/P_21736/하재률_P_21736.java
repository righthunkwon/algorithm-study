package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21736_헌내기는친구가필요해 {
	// bfs로 풀자 ㅎ
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = 0;
		char[][] map = new char[N][M];
		boolean[][] chk = new boolean[N][M];
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		Queue<int[]> q = new LinkedList<>();
		
		for(int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'I') {
					q.add(new int[] {i, j});
					chk[i][j] = true;
					while(!q.isEmpty()) {
						int[] poll = q.poll();
						for(int d = 0; d < 4; d++) {
							int nx = poll[0] + dx[d];
							int ny = poll[1] + dy[d];
							if(nx >= 0 && nx < N && ny >= 0 && ny < M && !chk[nx][ny] && map[nx][ny] != 'X') {
								if(map[nx][ny] == 'P') ans++;
								q.add(new int[] {nx, ny});
								chk[nx][ny] = true;
							}
						}
					}
				}
			}
		}
		if(ans == 0) System.out.println("TT");
		else System.out.println(ans);
		
	}
}
