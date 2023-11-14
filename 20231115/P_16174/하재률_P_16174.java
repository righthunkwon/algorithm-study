package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16174_점프왕쩰리Large {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력 완
		int[] dx = {0, 1}; int[] dy = {1, 0}; // 오른쪽, 아래쪽 
		boolean[][] chk = new boolean[N][N]; // 방문쳌
		Queue<int[]> q = new LinkedList<>();
		// 0, 0부터 시작
		q.add(new int[] {0, 0});
		chk[0][0] = true;
		boolean res = false;
		l:
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int jump = map[poll[0]][poll[1]];
			
			for(int d = 0; d < 2; d++) {
				int nx = poll[0] + dx[d] * jump;
				int ny = poll[1] + dy[d] * jump;
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && !chk[nx][ny]) {
					q.add(new int[] {nx, ny});
					chk[nx][ny] = true;
					
					if(nx == N-1 && ny == N-1) {
						res = true;
						break l;
					}
				}
			}
		}
		
		System.out.println(res ? "HaruHaru" : "Hing");
	}
}
