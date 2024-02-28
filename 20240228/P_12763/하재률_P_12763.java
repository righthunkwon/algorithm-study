package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라 알고리즘
public class BOJ_12763_지각하면안돼 {
	
	// v : 다음 건물, t : 시간, m : 택시비
	static class Node {
		int v, t, m;

		public Node(int v, int t, int m) {
			this.v = v;
			this.t = t;
			this.m = m;
		}
	}
	
	static int N, T, M, L;
	static int[][] cost;
	static ArrayList<Node>[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 건물 개수
		map = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) map[i] = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken()); // 시간 제한
		M = Integer.parseInt(st.nextToken()); // 돈 제한
		
		L = Integer.parseInt(br.readLine());
		// 양방향 그래프
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken()); // 현재 노드
			int tmp2 = Integer.parseInt(st.nextToken()); // 다음 노드
			int tmp3 = Integer.parseInt(st.nextToken()); // 시간
			int tmp4 = Integer.parseInt(st.nextToken()); // 돈
			map[tmp1].add(new Node(tmp2, tmp3, tmp4));
			map[tmp2].add(new Node(tmp1, tmp3, tmp4));
		}
		
		cost = new int[N+1][T+1]; // 각 노드의 각 도착시간에 해당하는 비용
		for(int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE);
		cost[1][0] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>((a, b)-> a.m - b.m);
		pq.add(new Node(1, 0, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(cost[cur.v][cur.t] < cur.m) continue;
			
			for(Node next : map[cur.v]) {
				// 시간, 돈 초과시 continue
				if(T < next.t + cur.t || M < next.m + cur.m) continue;
				if(cost[next.v][next.t + cur.t] > next.m + cur.m) {
					cost[next.v][next.t + cur.t] = next.m + cur.m;
					pq.add(new Node(next.v, next.t + cur.t, next.m + cur.m));
				}
			}
		}
		
		// 마지막노드 도착한 비용 중 가장 최소를 res에 저장
		int res = Arrays.stream(cost[N]).min().getAsInt();
		
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
		
//		for(int i = 0; i <= N; i++) {
//			for(int j = 0; j <= T; j++) {
//				System.out.print(cost[i][j] == Integer.MAX_VALUE ? 0 + " " : cost[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
}
