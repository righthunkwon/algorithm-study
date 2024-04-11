package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1992_쿼드트리 {
	
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		sol(0, 0, N);
		System.out.println(sb);
		
	}
	
	static void sol(int x, int y, int size) {
		int tmp = map[x][y];
		boolean chk = true;
		
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(tmp != map[i][j]) {
					chk = false;
					break;
				}
			}
			if(!chk) break;
		}
		
		if(chk) {
			sb.append(tmp);
			return;
		}
		
		int half = size / 2;
		
		sb.append('(');
		sol(x, y, half); // 왼위
		sol(x, y + half, half); // 오위 
		sol(x + half, y, half); // 왼아래
		sol(x + half, y + half, half); // 오아래
		sb.append(')');
	}
}
