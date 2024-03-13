package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1800_인터넷설치 {
	
	static int N, K, P, res;
	static List<Node>[] adj;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
		
		for(int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b, c));
			adj[b].add(new Node(a, c));
		}
		res = -1;
		int l = 0;
		int r = 1000000;
		while(l <= r) {
			int mid = (l + r) / 2;
			if(sol(mid)) {
				res = mid;
				r = mid - 1;
			}else {
				l = mid + 1;
			}
		}
		
		System.out.println(res);
	}
	
	static boolean sol(int mid) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		
		while(!pq.isEmpty()) {
			Node poll = pq.poll();
			if(poll.w > dist[poll.v]) continue;
			
			for(Node n : adj[poll.v]) {
				int cost = (n.w > mid) ? 1 : 0;
				
				if(dist[n.v] > poll.w + cost) {
					dist[n.v] = poll.w + cost;
					pq.add(new Node(n.v, dist[n.v]));
				}
			}
		}
		
		return dist[N] <= K;
	}
	static class Node implements Comparable<Node> {
		int v, w;

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}

	}
}
