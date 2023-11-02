package AlgoStudy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_Q13913_숨바꼭질4 {

	static int N, K;
	static int cnt;
	static Queue<Integer> queue = new LinkedList<Integer>(); // bfs용 큐
	static int[] visited; // 수빈이가 해당 위치까지 가는 데 걸린 시간을 저장해두는 배열(0이면 방문한적 없는 것)
	static int[] root;
	static int[] ans;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 수빈 위치
		K = sc.nextInt(); // 동생 위치

		visited = new int[100001]; // 방문 확인용 배열(0이면 방문 안한것, 방문하면 그 위치까지 가는 데 걸린 시간이 배열에 저장됨)

		if (N == K) {
			System.out.println(0);
			System.out.println(N);
			return; //
		} // 처음 수빈이 위치와 동생 위치가 같으면 0, N 출력하고 끝

		bfs();
		System.out.println(cnt); // 수빈이가 동생을 찾는 가장 빠른 시간 출력

		visited[N] = 0; // 출발지 다시 0으로 넣어줘야됨 (0은 미방문과 같아서, bfs과정에서 다른 숫자가 들어가버린다..)

		root = new int[cnt + 1]; //dfs 돌면서 경로 저장하는 배열
		ans = new int[cnt + 1]; //정답을 저장할 배열
		
		dfs(0,N);
		
		for(int i=0; i<cnt+1;i++) {
			System.out.print(ans[i]+" "); //경로 출력
		}

	}// main

	
	/*
	 * 경로를 다시 dfs로 탐색하면서 이동할마다 root라는 배열에 이동 경로를 저장한다
	 * 그러다가 위에서 구한 최소시간만에 동생의 위치에 도달한 경우에만 그때의 경로를 정답 배열에 복사해준다.
	 * */
	
	// idx는 좌표, depth는 몇번째 이동중인지
	static void dfs(int depth, int idx) {

		if (depth == cnt) { 
			if (idx == K) {
				for (int i = 0; i < cnt + 1; i++) {
					ans[i] = root[i]; // 제대로 도착했으면 복사
					ans[cnt]=K;
				}
			}
			return;
		}
		
		root[depth]=idx;
		
		if(idx+1<=100000 && visited[idx+1]==visited[idx]+1) {
			dfs(depth+1,idx+1);
		}
		if(idx-1>=0 && visited[idx-1]==visited[idx]+1) {
			dfs(depth+1,idx-1);
		}
		if(idx*2<=100000 && visited[idx*2]==visited[idx]+1) {
			dfs(depth+1,idx*2);
		}

	}

	// 위치를 인자로 받는 bfs
	// N => K 로 가는 최소시간 구하기
	static void bfs() {

		queue.add(N); // 수빈 현 위치 큐에 삽입
		visited[N] = 0;

		while (!queue.isEmpty()) {
			int t = queue.poll(); // 하나 꺼냄

			if (t == K) {
				cnt = visited[t];
				return;
			}

			// X-1 / X+1 / X*2 가 각각 범위 안에 있고 아직 방문안했으면
			// t까지 걸린시간 +1을 그 위치까지 가는데 걸린 시간으로 넣어주고, 큐에 삽입
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

	}// bfs


}// class
