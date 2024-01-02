import java.io.*;
import java.util.*;

public class Pro_16197_두동전 {
	static List<int[]> coin;
	static int[] dr, dc;
	static int N, M, min;
	static char[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		coin = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = input.charAt(j);
				if (board[i][j] == 'o') {
					coin.add(new int[] { i, j });
				}
			}
		} // 입력끝

		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		min = Integer.MAX_VALUE;
		dfs(1);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else System.out.println(min);
		
	}

	private static void dfs(int depth) {
		if (depth == 11 || depth >= min) return;//10회 이상
		if (coin.get(0)[0] == coin.get(1)[0] && coin.get(0)[1] == coin.get(1)[1]) return;//두 동전의 위치가 같다면
		
		int[] coin1 = coin.get(0);//코인의 좌표를 저장해두자,dfs로 들어가면 coin이 바뀔 수 있다.
		int[] coin2 = coin.get(1);
		for (int i = 0; i < 4; i++) {
			int out = 0;
			
			// 첫번째 동전 옮기기
			int nr = coin1[0] + dr[i];
			int nc = coin1[1] + dc[i];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M) {//동전 떨어지면 
				out++;
			} else if (board[nr][nc] != '#') {//움직일 수 있다면 그 좌표로 간다.
				coin.set(0, new int[] { nr, nc });
			} else {//벽이라면 그대로 다시 세팅
				coin.set(0, new int[] { coin1[0], coin1[1] });
			}
			
			// 두번째 동전 옮기기
			nr = coin2[0] + dr[i];
			nc = coin2[1] + dc[i];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
				out++;
			} else if (board[nr][nc] != '#') {
				coin.set(1, new int[] { nr, nc });
			} else {
				coin.set(1, new int[] { coin2[0], coin2[1] });
			}
			
			if (out == 1) {//한개의 동전만 떨어지면 최솟값 갱신, 다른 방향으로 가보기 
				min = Math.min(depth, min);
				continue;
			} else if (out == 2) continue; //둘다 떨어지면 한개만 떨어지기 불가능 , 다른 방향 탐색
			
			dfs(depth + 1);//다시 반복
		}

	}
}
