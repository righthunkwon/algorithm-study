package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획 {
	// 프림을 이용한 풀이
	static int N, M; // 집 N, 길 M
	static List<Node>[] list;
	static boolean[] chk;
	
	static class Node implements Comparable<Node>{
		int st, ed, w;

		public Node(int st, int ed, int w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		// 우선순위큐를 유지비 순서로 정렬하기 위해
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 인접리스트를 하나 맨들어줌
		list = new ArrayList[N];
		for(int i = 0; i < N; i++) list[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken())-1;
			int B = Integer.parseInt(st.nextToken())-1;
			int W = Integer.parseInt(st.nextToken());
			
			list[A].add(new Node(A, B, W));
			list[B].add(new Node(B, A, W));
		}// 양방향 연결 입력 완
		
		chk = new boolean[N];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		// 1번(0번) 노드 넣어두고
		chk[0] = true;
		pq.addAll(list[0]);
		
		int pick = 1; // 1번노드 골랐으니 pick
		int ans = 0; // 답 저장할 변수
		// 전체를 최소비용으로 탐색할건데, 그 중 가장 유지비가 많이 드는 간선을 끊으면 도시가 나눠짐
		int max = 0; 
		
		// 전체 다 뽑으면 while 종료
		while(pick != N) {
			// 우선순위 큐에 넣어놔서 최소 유지비가 드는 길만 뽑음
			Node poll = pq.poll();
			
			if(chk[poll.ed]) continue;
			
			ans += poll.w;
			max = max < poll.w ? poll.w : max;
			pq.addAll(list[poll.ed]);
			chk[poll.ed] = true;
			pick++;
		}
		System.out.println(ans-max);
 	}
}
