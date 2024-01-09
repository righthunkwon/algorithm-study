package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1726_로봇 {
	
	static class robo {
		int x, y, di, cnt;

		public robo(int x, int y, int di, int cnt) {
			this.x = x;
			this.y = y;
			this.di = di;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int [][]map = new int[M][N];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		robo ro1 = new robo(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, 0);
		st = new StringTokenizer(br.readLine());
		robo ro2 = new robo(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, 0);
		
		boolean[][][] chk = new boolean[M][N][4];
		int[] dx = {0, 0, 1, -1}; // 동서남북
		int[] dy = {1, -1, 0, 0};
		
		Queue<robo> q = new LinkedList<>();
		q.add(ro1);
		chk[ro1.x][ro1.y][ro1.di] = true;
		
		while(!q.isEmpty()) {
			robo poll = q.poll();
			
			if(poll.x == ro2.x && poll.y == ro2.y && poll.di == ro2.di) {
				System.out.println(poll.cnt);
				return;
			}
			
			// 직진
			for(int i = 1; i <= 3; i ++) {
				int nx = poll.x + dx[poll.di] * i;
				int ny = poll.y + dy[poll.di] * i;
				
				if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
				if(map[nx][ny] == 1) break;
				
				if(!chk[nx][ny][poll.di]) {
					chk[nx][ny][poll.di] = true;
					q.add(new robo(nx, ny, poll.di, poll.cnt + 1));
//					System.out.println("x : " + nx + " y : " + ny + " 방향은 : " + poll.di + " cnt는 : " + (poll.cnt+1));
				}
			}
			
			/*
			 * 동0 서1 남2 북3
			 * 
			 * 동일때 /서+1/ 남+2 북+3
			 * 서일때 남+1 북+2 /동+3/
			 * 남일때 /북+1/ 동+2 서+2
			 * 북일때 동+1 서+2 /남+3/ 
			 */
			
			// 회전 -> +d % 4
			for(int d = 1; d < 4; d++) {
				
				int tmp = 0;
				int ndi = (poll.di + d) % 4;
				if(chk[poll.x][poll.y][ndi]) continue;
				if(poll.di % 2 == 0 && d == 1) tmp = 2;
				else if(poll.di % 2 == 1 && d == 3) tmp = 2;
				else tmp = 1;
				
				q.add(new robo(poll.x, poll.y, ndi, poll.cnt + tmp));
				chk[poll.x][poll.y][ndi] = true;
//				System.out.println("돌리기 x : " + poll.x + " y : " + poll.y + " 방향은 : " + poll.di + " cnt는 : " + (poll.cnt+tmp));
			}
		}
		
	}
	
}
