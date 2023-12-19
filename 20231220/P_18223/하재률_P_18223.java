package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18223_민준이와마산그리고건우 {
	static class Node {
		int v, w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static int V, E, P;
	static List<Node>[] adjList;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[V+1];
		dist = new int[V+1];
		for(int i = 1; i <= V; i++) adjList[i] = new ArrayList<>();
		
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adjList[a].add(new Node(b, c));
			adjList[b].add(new Node(a, c));
		}
//		for(int i = 1; i <= V; i++) {
//			for(int j = 0; j < adjList[i].size(); j++) {
//				System.out.print(i+"노드는 "+ adjList[i].get(j).v + " " + adjList[i].get(j).w);
//				System.out.println();
//			}
//		}
		sol(1);
//		for(int i = 1; i <= V; i++) System.out.print(dist[i] + " ");
//		System.out.println();
		int tmpA = dist[V]; // 민준이가 마산 가는 최단 경로
		int tmpB = dist[P]; // 민준이가 건우한테 가는 최단 경로
		sol(P);
//		for(int i = 1; i <= V; i++) System.out.print(dist[i] + " ");
		int tmpC = dist[V]; // 건우가 마산 가는 최단 경로
		
		System.out.println(tmpB + tmpC <= tmpA ? "SAVE HIM" : "GOOD BYE");
	}
	
	static void sol(int st) {
		for(int i = 0; i <= V; i++) dist[i] = Integer.MAX_VALUE;
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
		
		pq.add(new Node(st, 0));
		dist[st] = 0;
		
		while(!pq.isEmpty()) {
			Node poll = pq.poll();
			
			if(dist[poll.v] < poll.w) continue;
			
			for(Node n : adjList[poll.v]) {
				int cost = dist[poll.v] + n.w;
				
				if(cost < dist[n.v]) {
					dist[n.v] = cost;
					pq.add(new Node(n.v, cost));
				}
			}
		}
		
	}
}

