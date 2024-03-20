package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146_다리만들기 {
	
	static int N, tmp, res;
	static int[][] map;
	static Queue<int[]> q;
	static boolean[][] chk;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 섬 번호 붙이기
		q = new LinkedList<>();
		chk = new boolean[N][N];
		numberLand();
		// 다리 만들기
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		res = Integer.MAX_VALUE;
		for(int i = 0 ; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) continue;
				if(map[i][j] != 0) {
					tmp = map[i][j];
					chk = new boolean[N][N];
					int cnt = sol(i, j, 0);
					if(cnt == -1) continue;
					res = res > cnt ? cnt : res;
				}
			}
		}
		System.out.println(res);
	}
	
	static int sol(int x, int y, int a) {
		q = new LinkedList<int[]>();
		
		q.add(new int[] {x, y, a});
		chk[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int na = poll[2];
			for(int d = 0; d < 4; d++) {
				int nx = poll[0] + dx[d];
				int ny = poll[1] + dy[d];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(chk[nx][ny] || map[nx][ny] == tmp) continue;
				if(map[nx][ny] != 0 && map[nx][ny] != tmp) return na;
				chk[nx][ny] = true;
				q.add(new int[] {nx, ny, na + 1});
			}
		}
		return -1;
	}
	
	static void numberLand() {
		int num = 2;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0) continue;
				if(map[i][j] == 1) {					
					q.add(new int[] {i, j});
					map[i][j] = num;
					chk[i][j] = true;
					
					while(!q.isEmpty()) {
						int[] poll = q.poll();
						for(int d = 0; d < 4; d++) {
							int nx = poll[0] + dx[d];
							int ny = poll[1] + dy[d];
							if(nx < 0 || nx >= N || ny < 0 || ny >= N || chk[nx][ny]) continue;
							if(map[nx][ny] == 1) {
								map[nx][ny] = num;
								chk[nx][ny] = true;
								q.add(new int[] {nx, ny});
							}
						}
					}
					num++;
					
				}
			}
		}
	}
	
	
}
