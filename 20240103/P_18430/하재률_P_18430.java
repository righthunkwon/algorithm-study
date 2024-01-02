package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18430_무기공학 {
	
	static int N, M, res;
	static int[][] map;
	static boolean[][] chk;
	static int[][] dx = {{1, 0}, {-1, 0}, {-1, 0}, {1, 0}}; // ㄱ, .ㅣ, ㄴ, ㅣ' 
	static int[][] dy = {{0, -1}, {0, -1}, {0, 1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		chk = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력 완
		
		res = 0;
		dfs(0, 0, 0);
		
		System.out.println(res);
	}
	static void dfs(int i, int j, int sum) {
		// i가 N이 되면 종료(모든 map을 탐색)
		if(i == N) {
			res = res > sum ? res : sum;
			return;
		}
		// j가 M에 닿으면 i를 늘리기에요
		if(j == M) {
			dfs(i + 1, 0, sum);
			return;
		}
		
		if(!chk[i][j]) {
			// 가능한 부메랑을 모두 구해보기
			for(int d = 0; d < 4; d++) {
				int nx1 = i + dx[d][0];
				int ny1 = j + dy[d][0];
				int nx2 = i + dx[d][1];
				int ny2 = j + dy[d][1];
				
				if(isPo(nx1, ny1, nx2, ny2)) {
					chk[i][j] = true;
					chk[nx1][ny1] = true;
					chk[nx2][ny2] = true;
					dfs(i, j+1, sum + (map[i][j] * 2) + map[nx1][ny1] + map[nx2][ny2]);
					chk[i][j] = false;
					chk[nx1][ny1] = false;
					chk[nx2][ny2] = false;
				}
			}
		}
		dfs(i, j + 1, sum);
		
	}
	// 범위내에있고, 모두 방문하지 않았어야 true
	static boolean isPo(int nx1, int ny1, int nx2, int ny2) {
		if(nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= M) return false;
		if(nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= M) return false;
		if(chk[nx1][ny1]) return false;
		if(chk[nx2][ny2]) return false;
		return true;
	}
}
