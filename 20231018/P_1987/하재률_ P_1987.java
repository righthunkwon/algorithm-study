package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static int R, C, res;
	static char[][] map;
	static boolean[] a2z;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 세로
		C = Integer.parseInt(st.nextToken()); // 가로
		map = new char[R][C]; 
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}// 입력 완
		a2z = new boolean[26]; // 알파벳 방문체크
		sol(0, 0, 1); // 말이 지나는 칸은 좌측 상단의 칸도 포함된다 << 때문에 1로 시작
		System.out.println(res);
	}
	
	static void sol(int x, int y, int depth) {
		a2z[map[x][y]-'A'] = true;
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx >= 0 && nx < R && ny >= 0 && ny < C && !a2z[map[nx][ny]-'A']) {
				sol(nx, ny, depth + 1);
				a2z[map[nx][ny]-'A'] = false;
			}
		}
		res = res < depth ? depth : res;
	}
}
