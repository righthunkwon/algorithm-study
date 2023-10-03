package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238_파티 {
	static class Node implements Comparable<Node>{
		int v, t;
		
		public Node(int v, int t) {
			this.v = v;
			this.t = t;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.t, o.t);
		}
		
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int N, M, C;
	static List<Node>[] list1, list2;
	static int[] dist1, dist2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		list1 = new ArrayList[N+1];
		list2 = new ArrayList[N+1];
		
		for(int i = 0; i <= N; i++) {
			list1[i] = new ArrayList<>();
			list2[i] = new ArrayList<>();
		}
		
		dist1 = new int[N+1];
		dist2 = new int[N+1];
		Arrays.fill(dist1, INF);
		Arrays.fill(dist2, INF);
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			list1[A].add(new Node(B, T));
			list2[B].add(new Node(A, T));
		}
		
		dijkstra(list1, dist1, 1);
		dijkstra(list2, dist2, 1);
		
//		System.out.println(Arrays.toString(dist1));
//		System.out.println(Arrays.toString(dist2));
		
		int res = 0;
		for(int i = 1; i <= N; i++) {
			int tmp = dist1[i] + dist2[i];
			res = tmp > res ? tmp : res;
		}
		System.out.println(res);
		
	}
	static void dijkstra(List<Node>[] list, int[] dist, int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] chk = new boolean[N+1];
		
		pq.add(new Node(st, 0));
		dist[st] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(chk[curr.v]) continue;
			chk[curr.v] = true;
			
			for(Node n : list[curr.v]) {
				if(!chk[n.v] && dist[n.v] > dist[curr.v] + n.t) {
					dist[n.v] = dist[curr.v] + n.t;
					pq.add(new Node(n.v, dist[n.v]));
				}
			}
		}
	}
}
