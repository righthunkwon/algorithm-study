package study_240313;

import java.io.*;
import java.util.*;

public class Pro_14621_나만안되는연애 {
	static List<Edge>[] list;
	static String[] wm;
	static boolean[] visited;
	static PriorityQueue<Edge> pq;
	static int result;
	
	static class Edge implements Comparable<Edge> {
		int s, e, d;
		public Edge(int s, int e, int d) {
			this.s = s;
			this.e = e;
			this.d = d;
		}
		@Override
		public int compareTo(Edge o) {
			return this.d - o.d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		result = 0;
		wm = new String[N + 1];
		list = new ArrayList[N + 1];// 인접리스트
		for (int i = 1; i <= N; i++) {
			wm[i] = st.nextToken();
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if (wm[s].equals(wm[e]))
				continue;// 성별같으면 간선을 아예 넣지도 말자
			list[s].add(new Edge(s, e, d));
			list[e].add(new Edge(e, s, d));// 양방향
		} // 입력끝
		visited = new boolean[N + 1];
		pq = new PriorityQueue<>();
		// 무조건 1번 노드부터 확인
		// 1번 노드 인접리스트 다 꺼내 pq에 담기 제일 먼저 꺼내진거 wm확인
		for (Edge edge : list[1]) {
			pq.add(edge);
		}
		visited[1] = true;
		prim();
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i]) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		System.out.println(result);
	}

	private static void prim() {
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (visited[curr.e]) continue;
			visited[curr.e] = true;
			result += curr.d;
			for (Edge edge : list[curr.e]) {
				pq.add(edge);
			}
		}
	}
}
