package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1167_트리의지름 {
	
	static class Node {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
	}
	
	static ArrayList<Node>[] adj;
	static boolean[] chk;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int V = Integer.parseInt(br.readLine());
		adj = new ArrayList[V+1];
		for(int i = 0; i <= V; i++) adj[i] = new ArrayList<>();
		
		for(int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int tmpA = Integer.parseInt(st.nextToken());
				if(tmpA == -1) break;
				int tmpB = Integer.parseInt(st.nextToken());
				adj[a].add(new Node(tmpA, tmpB));
			}
		}
		
		chk = new boolean[V+1];
		dfs(1, 0);
		
		System.out.println(max);
	}
	
	static void dfs(int x, int d) {
		chk[x] = true;
		max = d > max ? d : max;
		
		for(int i = 0; i < adj[x].size(); i++) {
			Node n = adj[x].get(i);
			if(!chk[n.v]) dfs(n.v, d + n.w);
		}
	}
}
