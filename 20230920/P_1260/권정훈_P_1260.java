package dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// DFS와 BFS

// DFS
// 깊이 우선 탐색 (DFS, Depth-First Search)
// 깊게 탐색하는 방법, 시작 정점 방문 후 다음 분기로 넘어가기 전 해당 분기를 완벽하게 탐색
// 모든 경로를 탐색하거나 경로의 특징을 저장해야 할 때 자주 사용
// 보통 재귀함수(LIFO)를 통해 구현(인접행렬 혹은 인접리스트 활용, 스택도 사용 가능) 

// BFS
// 너비 우선 탐색 (BFS, Breadth-First Search)
// 넓게 탐색하는 방법, 시작 정점 방문 후 해당 정점과 가까운 정점을 우선 방문
// 두 노드 사이의 최단 거리 혹은 최단 경로를 구할 때 자주 사용
// BFS는 현재 노드에서 가까운 곳부터 찾기 때문에 경로 탐색 시 첫번째로 찾아지는 답이 곧 최단거리
// 보통 큐(FIFO)를 통해 구현(인접행렬 혹은 인접리스트 활용)

// 연결리스트로 구현
public class P_1260 {
	private static int n, m, st;
	private static boolean dvisited[], bvisited[];
	private static List<Integer>[] list;
	private static StringBuilder dsb;
	private static StringBuilder bsb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 컴퓨터의 수
		m = sc.nextInt(); // 연결된 컴퓨터 쌍의 수
		st = sc.nextInt(); // 탐색을 시작할 번호의 수
		list = new ArrayList[n + 1]; // 인접리스트
		dvisited = new boolean[n + 1]; // dfs 방문배열
		bvisited = new boolean[n + 1]; // bfs 방문배열
		dsb = new StringBuilder(); // dfs sb
		bsb = new StringBuilder(); // bfs sb

		// Null Pointer Exception을 방지하기 위한 배열 초기화
		for (int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		// 간선의 정보 입력
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt(); // 시작 정점
			int y = sc.nextInt(); // 끝 정점

			// 무방향그래프
			list[x].add(y);
			list[y].add(x);
		}

		// 정점번호가 작은 것을 먼저 방문할 수 있도록 인접리스트 정렬
		for (int i = 0; i < n + 1; i++) {
			Collections.sort(list[i]);
		}

		// 시작 정점 값 담기
		dsb.append(st + " ");
		bsb.append(st + " ");

		// dfs & bfs
		dfs(st);
		bfs(st);

		// 정답 출력
		System.out.println(dsb);
		System.out.println(bsb);
		sc.close();
	}

	// dfs는 보통 재귀로 구현(LIFO)
	private static void dfs(int st) {
		dvisited[st] = true; // 방문처리
		
		for (int i : list[st]) {
			// 방문하지 않았을 경우
			if (dvisited[i] == false) {
				dsb.append(i + " ");
				dfs(i);
			}
		}
	}

	// bfs는 보통 큐로 구현(FIFO)
	private static void bfs(int st) {
		bvisited[st] = true; // 방문처리

		Queue<Integer> q = new LinkedList<>();
		q.add(st);

		while (!q.isEmpty()) {
			// 현재 탐색중인 정점
			int tmp = q.poll();
			
			for (int i : list[tmp]) {
				// 방문하지 않았을 경우
				if (bvisited[i] == false) {
					q.add(i);
					bsb.append(i + " ");
					bvisited[i] = true;
				}

			}
		}
	}
}
