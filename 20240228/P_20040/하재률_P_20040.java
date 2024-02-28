package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20040_사이클게임 {
	
	static int n, m, res;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 부모노드 초기화
		parent = new int[n];
		for(int i = 0; i < n; i ++) parent[i] = i;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(!union(x, y)) {
				res = i+1;
				break;
			}
		}
		System.out.println(res);
		
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return false;
		
		if(x <= y) parent[y] = x;
		else parent[x] = y;
		return true;
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		return find(parent[x]);
	}
}
