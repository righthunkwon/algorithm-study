package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4386_별자리만들기 {
	
	static class Star {
		int idx;
		double x, y;
		public Star(int idx, double x, double y) {
			this.idx = idx;
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge {
		int s, e;
		double v;

		public Edge(int s, int e, double v) {
			this.s = s;
			this.e = e;
			this.v = v;
		}
	}
	
	static int[] parent;
	static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		Star[] stars = new Star[n+1];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			stars[i] = new Star(i, Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		}
		
		pq = new PriorityQueue<>((a,b)-> (int)(a.v - b.v));
		parent = new int[n+1];
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = i + 1; j <= n; j++) {
				double di = dist(stars[i], stars[j]);
				pq.add(new Edge(stars[i].idx, stars[j].idx, di));
			}
		}
		
//		while(!pq.isEmpty()) {
//			Edge e = pq.poll();
//			System.out.println("s : " + e.s);
//			System.out.println("e : " + e.e);
//			System.out.println("v : " + e.v);
//		}
		double res = 0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(find(e.s) != find(e.e)) {
				res += e.v;
				cnt++;
				union(e.s, e.e);
			}
			if(cnt == n-1) {
				System.out.printf("%.2f", res);
				return;
			}
		}

//		for(int i = 0; i <= n; i++) System.out.print(parent[i] + " ");
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) parent[y] = x;
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		return find(parent[x]);
	}
	
	static double dist(Star s1, Star s2) {
		return Math.sqrt(Math.pow(s2.x - s1.x, 2) + Math.pow(s2.y - s1.y, 2));
	}
}
