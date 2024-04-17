package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Q16947_서울_지하철_2호선 {
	static int n;
	static int[] dist;
	static boolean[] visited, isCycle;
	static List<Integer> list[];
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1]; //연결 리스트
		dist = new int[n + 1]; //순환선과의 거리 저장할 배열
		isCycle = new boolean[n + 1]; //순환선에 속하는지 정보 저장용 배열

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>(); //리스트 초기화
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a); //양방향 인접 정보 입력
		}

		for (int i = 1; i <= n; i++) { // 모든 노드 사이클 여부 확인
			visited = new boolean[n + 1]; //매번 방문 배열 초기화
			findCycle(i, i, 1);
		}

		for (int i = 1; i <= n; i++) {
			if (isCycle[i])
				q.add(i); // 사이클에 속한 노드들만 큐에 넣음
			else
				dist[i] = -1; // 나머지 노드들의 거리는 -1로 초기화
		}

		bfs();

		//정답 출력
		for (int i = 1; i <= n; i++) {
			System.out.print(dist[i]+" ");
		}
		

	}// main

	static void findCycle(int start, int now, int cnt) { // 노드 수가 n개고 간선의 수도 n개 이므로 사이클은 무조건 하나다.
		visited[now] = true;
		for (int next : list[now]) {
			if (next == start && cnt >= 3) { // 시작점과 같은 노드이고 cnt가 3이상이라면 사이클
				isCycle[next] = true;
				return;
			} else if (!visited[next])
				findCycle(start, next, cnt + 1);
		}
	}

	static void bfs() { //순환선과의 거리 구하는 bfs
		// 사이클에 속한 노드들로부터 인접한 노드들을 탐색해 나가며 거리를 1씩 증가시킨다.
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next : list[now]) {
				if (dist[next] == -1) { //사이클에 포함 안된 노드 첫 방문 시
					dist[next] = dist[now] + 1;
					q.add(next);
				}
			}
		}
	}

}
