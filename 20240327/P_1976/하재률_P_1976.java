package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자 {
	
	static int n, m;
	static boolean[] chk;
	static int[][] map;
	static int[] plan;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		chk = new boolean[n];
		
		map = new int[n][n];
		plan = new int[m];
		
		for(int i = 0; i <n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) plan[i] = Integer.parseInt(st.nextToken());
		
		dfs(plan[0] - 1);
		
		boolean ans = true;
		for(int i : plan) {
			if(i > 0 && !chk[i-1]) {
				ans = false;
				break;
			}
		}
		System.out.println(ans ? "YES" : "NO");
		
	}
	
	static void dfs(int x) {
		chk[x] = true;
		
		for(int i = 0; i < n; i++) {
			if(map[x][i] == 1 && !chk[i]) dfs(i);
		}
	}
}
