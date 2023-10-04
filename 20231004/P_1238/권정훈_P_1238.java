package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 그림: https://steady-coding.tistory.com/106

// 다익스트라 알고리즘
// 그래프의 최단 경로를 구하는 알고리즘
// 하나의 정점에서 출발하는 최단 거리를 구함
// 음수 가중치가 없어야 함(가중치가 음수인 간선이 없어야 함)
// 우선순위큐를 활용하여 구현 및 시간복잡도 개선 가능(m log n)

// 다익스트라 알고리즘의 과정
// 1) 출발 노드 입력
// 2) 최단거리 테이블 초기화(MAX_VALUE) 및 출발 노드 설정(값 변경, 0)
// 3) 방문하지 않은 노드 중 최단거리(최소 가중치를 가진 간선)를 갖는 노드 선택
// 4) 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 비용이 더 적으면 최단거리 테이블을  갱신
// 5) 3, 4번의 과정을 반복

// dist				: 출발지에서 최소 거리를 기록하는 테이블
// visited			: 정점의 방문 여부 확인
// priority queue	: 출발지에서 정점까지 가는 최소 거리를 저장하는 우선순위 큐

// 파티
// 조건) 모든 학생들은 집에서 X에 갈수 있고, X에서 집으로 돌아올 수 있는 데이터만 입력으로 주어진다.
// 문제에서 X에서 집으로 돌아오는 경우는 기존 입력된 간선을 기준으로 다익스트라를 해주면 되고,
// 학생들이 각자의 집에서 X로 가는 경우에는 입력한 간선을 거꾸로 바꾸어 다익스트라를 해주어 각 dist

// 각 마을에서 X번 마을까지의 왕복이므로
// 1) 다른 마을 -> X번 마을의 최단거리와
// 2) X번 마을 -> 다른 마을의 최단거리의 두 거리를 구한다.

// 이때 다른 마을로부터 X번 마을의 최단거리는 그냥 구하면 되지만,
// X번 마을부터 각 마을까지의 최단거리는 n-1번의 연산을 필요로 한다.

// 이때 연산을 효율적으로 하기 위해서는 간선의 방향을 바꾸면 된다.
// X번 마을로부터 다른 마을까지의 최단거리를 간선의 방향을 바꿔서 구하면 한 번의 연산만 해주면 된다.


class Town implements Comparable<Town> {
	int end; // 도착정점의 번호
	int weight; // 가중치

	Town(int townNum, int weight) {
		this.end = townNum;
		this.weight = weight;
	}

	@Override
	public int compareTo(Town t) {
		// 오름차순 정렬
		// 다익스트라 알고리즘은 방문하지 않은 노드 중 최단거리(최소 가중치를 가진 간선)를 갖는 노드를 선택하는
		// 알고리즘 이므로, 이후 우선순위 큐를 활용하여 비교할 때 최단거리를 갖는 노드부터 넣어주고자 Town 클래스를 미리 정렬
		return weight - t.weight; 
	}
}

public class P_1238 {

	private static int N, M, X, ans;
	private static int[] dist; 
	private static boolean[] visited; 
	private static ArrayList<ArrayList<Town>> adjList;
	private static ArrayList<ArrayList<Town>> reversedAdjList;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점(마을)의 수
		M = Integer.parseInt(st.nextToken()); // 간선(도로)의 수
		X = Integer.parseInt(st.nextToken()); // 시작 정점

		adjList = new ArrayList<>(); // 문제의 입력을 그대로 받은 배열
		reversedAdjList = new ArrayList<>(); // 문제의 입력을 반대로 받은 배열

		// 초기화
		for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
			reversedAdjList.add(new ArrayList<>());
		}

		// adjList와 reversedAdjList를 각각 단방향 인접리스트로 구현
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList.get(start).add(new Town(end, weight));
			reversedAdjList.get(end).add(new Town(start, weight));
		}

		int[] dist1 = dijkstra(adjList); // X에서 시작점들 사이의 최단거리를 저장한 배열, X에서 집으로 돌아올 때의 거리
		int[] dist2 = dijkstra(reversedAdjList); // 시작점들에서 X 사이의 최단거리를 저장한 배열, 집에서 X로 갈 때의 거리

		// 최대값 갱신
		ans = 0;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, dist1[i] + dist2[i]);
		}

		// 정답 출력
		System.out.println(ans);
	}

	// 다익스트라 알고리즘
	public static int[] dijkstra(ArrayList<ArrayList<Town>> list) {
		PriorityQueue<Town> pq = new PriorityQueue<>(); // 가중치 기준으로 정렬(위의 class에서 Comparable로 정의)
		pq.add(new Town(X, 0)); // 도착 정점의 번호와 가중치(문제 기준으로는 도착점이고, 다익스트라 기준으로는 시작점)

		dist = new int[N + 1]; // 최단거리 배열 생성
		Arrays.fill(dist, Integer.MAX_VALUE); // 초기화
		dist[X] = 0; // 시작 정점 초기화
		visited = new boolean[N + 1]; // 방문처리 배열 생성
		
		while (!pq.isEmpty()) {
			Town curTown = pq.poll();
			int cur = curTown.end;

			if (!visited[cur]) {
				visited[cur] = true; // 방문처리

				// 현재 방문하고 있는 정점과 연결된 모든 정점을 대상으로
				for (Town t : list.get(cur)) {
					
					// 해당 정점을 방문하지 않았고, 기존 최소값보다 해당 정점을 지나는 가중치가 더 작으면 최소값 갱신
					if (!visited[t.end] && dist[t.end] > dist[cur] + t.weight) {
						dist[t.end] = dist[cur] + t.weight; // 갱신
						pq.add(new Town(t.end, dist[t.end])); // 갱신한 걸 큐에 담아서 반복
					}
				}
			}
		}
		return dist;
	}
}
