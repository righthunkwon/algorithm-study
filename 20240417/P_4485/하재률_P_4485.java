package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지 {
	
	static int N, res;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] chk;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) System.exit(0);
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			res = Integer.MAX_VALUE;
			chk = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					chk[i][j] = Integer.MAX_VALUE;
				}
			}
			bfs(0, 0);
			System.out.println("Problem "+tc++ +": " + res);
		}
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x, y, map[0][0]});
		chk[x][y] = map[0][0];
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = poll[0] + dx[d];
				int ny = poll[1] + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				int newCost = poll[2] + map[nx][ny];
				if(newCost < chk[nx][ny]) {
					chk[nx][ny] = newCost;
					q.add(new int[] {nx, ny, newCost});
				}
			}
			
		}
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(chk[i][j] + " ");
//			}
//			System.out.println();
//		}
		res = chk[N-1][N-1];
	}
}
