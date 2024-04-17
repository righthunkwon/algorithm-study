package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Q4485_녹색_옷_입은_애가_젤다지 {

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int ans, N;
	static int[][] map;

	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int pNum = 0;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break; // 0이면 끝내기
			ans = Integer.MAX_VALUE; // 최소값 구해야하니까 정답 큰 값으로 초기화
			pNum++;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 끝
			bfs();

			System.out.println("Problem " + pNum + ": " + ans);
		} // while

	}// class

	public static void bfs() {

		Queue<Node> pq = new PriorityQueue<>(); // cost 작은 노드부터 꺼낼 우선순위 큐 생성
		int[][] minCost = new int[N][N]; // 각 위치까지 가는 최소비용 저장할 2차원 배열
		boolean[][] visit = new boolean[N][N]; //방문체크용

		visit[0][0] = true; //시작점 방문처리
		minCost[0][0] = map[0][0]; //시작점은 minCost가 현재 위치 cost
		pq.add(new Node(0, 0, map[0][0])); 
		l: while (!pq.isEmpty()) {
			Node now = pq.poll(); //큐에 들어있는 노드들 중 cost 제일 낮은거 꺼내기
			int x = now.x;
			int y = now.y;
			int cost = now.cost;

			for (int i = 0; i < 4; i++) {
				int nextx = x + dx[i];
				int nexty = y + dy[i];
				if (nextx < 0 || nexty < 0 || nextx >= N || nexty >= N)continue;
				if(visit[nextx][nexty])continue;
				int nextcost = cost + map[nextx][nexty];
				minCost[nextx][nexty] = nextcost;
				if (nextx == N - 1 && nexty == N - 1) { //맨 끝에 도착했으면 정답 갱신하고 break
					ans = minCost[nextx][nexty];
					break l;
				}
				visit[nextx][nexty] = true;
				pq.add(new Node(nextx, nexty, nextcost)); //큐에 다시 삽입
			}
		}

	}// bfs
}
