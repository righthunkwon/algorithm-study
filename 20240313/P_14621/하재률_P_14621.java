package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14621_나만안되는연애 {
	
	static class Edge implements Comparable<Edge>{
		int v, w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	static List<Edge>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			String str = st.nextToken();
			// 해당 노드가 남초 대학교라면 0, 여초 대학교라면 1
			if(str.equals("W")) arr[i] = 1;
		}
		
		graph = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(arr[a] != arr[b]) { // 남 - 녀 만 간선 이어주기
				graph[a].add(new Edge(b, c));
				graph[b].add(new Edge(a, c));
			}
		}
		
		// 프림
		boolean[] chk = new boolean[n+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1, 0)); // 시작 노드
		
		int res = 0;
		while(!pq.isEmpty()) {
			Edge poll = pq.poll();
			
			if(chk[poll.v]) continue;
			
			chk[poll.v] = true;
			res += poll.w; // res에 최소 비용만 +
			
			for(Edge e : graph[poll.v]) {
				if(!chk[e.v]) {
					pq.add(e);
				}
			}
		}
		// 모든 학교를 연결하는 경로가 없으면 -1 출력
		for(int i = 1; i <= n; i++) {
			if(!chk[i]) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		// 연결됐으면 res 출력
		System.out.println(res);
	}
}
