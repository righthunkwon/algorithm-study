package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
	static int N, M, sum, max;
	static int[][] map;
	static boolean[][] chk;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 종이 세로 크기
		M = Integer.parseInt(st.nextToken()); // 종이 가로 크기
		map = new int[N][M]; // 종이안에 수들을 담을 배열
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력 완료
		
		max = 0;
		chk = new boolean[N][M]; // 방문쳌용 boolean배열
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) { // 한 칸씩 돌면서 모든 도형의 경우의 수를 찾아볼거야
				sum = 0;
				chk[i][j] = true; // 방문쳌
				dfs(i, j, map[i][j], 3); // depth를 3으로 설정해 4칸으로 연결된 모든 도형을 탐색할거야
				chk[i][j] = false; // 초기화
				
			}
		}
		System.out.println(max);
	}
	
	// 4칸으로 연결된 모든 도형의 경우의 수를 찾으면 된다. dfs로
	static void dfs(int x, int y, int sum, int depth) {
		if(depth==0) { // 4칸이끝나면 return
			if(sum > max) max = sum;
			return;
		}
		
		int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
		int[] dy = {0, 0, -1, 0};
		
		for(int d = 0; d < 4; d++) {
			int a = x + dx[d];
			int b = y + dy[d];
			if(a >= 0 && a < N && b >= 0 && b < M && !chk[a][b]) { // 조건이 맞으면
				chk[a][b] = true; // 방문쳌
				if(depth==2) dfs(x, y, sum+map[a][b], depth-1); // 이게 핵심이다.. 2칸을 가고 난 뒤에는 가던 방향으로 안가고 ㅏ ㅓ ㅗ ㅜ 를 탐색하는 조건문
				dfs(a, b, sum+map[a][b], depth-1);
				chk[a][b] = false; // 초기화
			}
		}
	}
}
