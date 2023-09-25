package silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon_Q1697_숨바꼭질 {

	static int N, K;
	static int cnt;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static int[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 수빈 위치
		K = sc.nextInt(); // 동생 위치

		visited = new int[100001]; // 방문 확인용 배열

		if (N == K) {
			System.out.println(0); // 처음부터 같은 위치면 0을 출력하고 끝
			return; //@@@@@리턴 안해서 틀렸었음...@@@
		} else {
			bfs(N); //bfs 진행
		}
		
		System.out.println(cnt);

	}// main

	// 위치를 인자로 받는 bfs
	static void bfs(int num) {

		queue.add(num); // 현 위치 큐에 삽입
		visited[num] = 0; 

		while (!queue.isEmpty()) {
			int t = queue.poll(); // 하나 꺼냄

			if (t == K) {
				cnt = visited[t];
				return;
			}
			
			//범위 안에 있고 아직 방문안했으면
			if (t + 1 <= 100000 && visited[t + 1] == 0) {
				visited[t + 1] = visited[t] + 1;
				queue.add(t + 1);
			}
			if (t - 1 >= 0 && visited[t - 1] == 0) {
				visited[t - 1] = visited[t] + 1;
				queue.add(t - 1);
			}
			if (t * 2 <= 100000 && visited[t * 2] == 0) {
				visited[t * 2] = visited[t] + 1;
				queue.add(t * 2);
			}

		}

	}

}// class
