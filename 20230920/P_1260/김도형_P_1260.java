import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static boolean[] dfsArr;
	static boolean[] bfsArr;
	static List<Integer>[] list;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 정점의 개수 N
		int M = sc.nextInt(); // 간선의 개수 M
		int V = sc.nextInt(); // 탐색 시작할 정점의 번호 V

		dfsArr = new boolean[N + 1]; // dfs용 visit 배열 (초기값 false)
		bfsArr = new boolean[N + 1]; // bfs용 visit 배열 (초기값 false)

//		System.out.println(Arrays.toString(dfsArr));

		list = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>(); // 배열 초기화 해주기
		}

		for (int i = 0; i < M; i++) { // 간선 입력

			int a = sc.nextInt(); // 시작정점
			int b = sc.nextInt(); // 끝정점

			list[a].add(b);
			list[b].add(a);

		} // 간선 입력 끝

		for (int i = 0; i < N+1; i++) {

			Collections.sort(list[i]); // 오름차순 정렬

		}

		dfs(V);
		System.out.println();
		bfs(V);

	}// main

	/*
	 * st : 탐색할 노드
	 */
	public static void dfs(int v) {

		dfsArr[v] = true; // 현재 노드 방문 처리

		System.out.print(v + " "); // 방문 노드 출력

		for (int i = 0; i < list[v].size(); i++) {
			// 방문하지 않은 인접 노드 중 가장 작은 노드 선택해서 재귀

			if (dfsArr[list[v].get(i)] == false) {

				dfs(list[v].get(i));

			}

		}

	}

	public static void bfs(int v) {

		Queue<Integer> queue = new LinkedList<>();
		queue.add(v); // 스타트 지점 큐에 add

		bfsArr[v] = true; // 현재 노드 방문 처리

		// 큐가 빌 때까지 반복
		while (!queue.isEmpty()) {
			// 큐에서 하나의 원소를 뽑아 출력
			int x = queue.poll();
			System.out.print(x + " ");

			// 인접한 노드 중 아직 방문 안한 원소들 큐에 삽입
			for (int i = 0; i < list[x].size(); i++) {
				if (bfsArr[list[x].get(i)] == false) {
					queue.add(list[x].get(i));
					bfsArr[list[x].get(i)] = true;
				}

			}

		} // while

	}

}// class
