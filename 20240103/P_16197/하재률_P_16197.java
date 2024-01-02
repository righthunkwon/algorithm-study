package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16197_두동전 {
	static class Coin {
		int x;
		int y;
		public Coin(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		List<Coin> coins = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == 'o') coins.add(new Coin(i, j));
			}
		}
		
		Queue<Coin[]> q = new LinkedList<>();
		boolean[][][][] chk = new boolean[N][M][N][M];
		
		q.add(new Coin[] {coins.get(0), coins.get(1)});
		chk[coins.get(0).x][coins.get(0).y][coins.get(1).x][coins.get(1).y] = true;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int cnt = 1;
		int res = 0;
		
		while(!q.isEmpty()) {
			if(cnt > 10) {
				System.out.println(-1);
				return;
			}
			int size = q.size();
			for(int i = 0; i < size; i++) {
				Coin[] poll = q.poll();
				
				for(int d = 0; d < 4; d++) {
					int nx1 = poll[0].x + dx[d];
					int ny1 = poll[0].y + dy[d];
					int nx2 = poll[1].x + dx[d];
					int ny2 = poll[1].y + dy[d];
					
					// 한 개만 떨어졌을 때
					if ((isOutOfMap(nx1, ny1) && !isOutOfMap(nx2, ny2)) || (!isOutOfMap(nx1, ny1) && isOutOfMap(nx2, ny2))) {
					    System.out.println(cnt);
					    return;
					}
					// 둘 다 떨어졌을 때
					if(isOutOfMap(nx1, ny1) && isOutOfMap(nx2, ny2)) continue;
					// 겹쳤을 때
					if(nx1 == nx2 && ny1 == ny2) continue;
					// 벽을 만났을때
					if(!isOutOfMap(nx1, ny1) && map[nx1][ny1] == '#') {
						nx1 = poll[0].x;
						ny1 = poll[0].y;
					}
					if(!isOutOfMap(nx2, ny2) && map[nx2][ny2] == '#') {
						nx2 = poll[1].x;
						ny2 = poll[1].y;
					}
					// 이미 방문
					if(chk[nx1][ny1][nx2][ny2]) continue;
					// 정상 이동
					q.add(new Coin[] {new Coin(nx1, ny1), new Coin(nx2, ny2)});
					chk[nx1][ny1][nx2][ny2] = true;
				}
			}
			cnt++;
			
		}
		System.out.println(-1);
	}
	
	static boolean isOutOfMap(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return true;
		return false;
	}
}
