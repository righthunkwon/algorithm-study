

ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ


package AlgoStudy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_Q14502_연구소 {

	// x,y 좌표값 넣을 자료형 Pos
	public static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int N, M; // 세로 가로 길이
	static int[][] map; // 연구소 지도
	static boolean[][] visit; // 방문여부 확인용
	static int[] dx = { 0, 0, -1, 1 }; // 상하좌우 탐색용 델타
	static int[] dy = { -1, 1, 0, 0 };
	static int maxSafe; // 최대 안전구역 넓이

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 세로
		M = sc.nextInt(); // 가로
		map = new int[N][M]; // 맵 초기화
		

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt(); // 지도 입력
			}
		}
		maxSafe = 0;

		dfs(0,0,0);

		System.out.println(maxSafe);

	}// main

	public static void bfs() {
		Queue<Pos> queue = new LinkedList<Pos>();// bfs용 큐 만들기

		int[][] tmpMap = new int[N][M]; // bfs용 임시 맵
		visit = new boolean[N][M]; //방문배열 초기화

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmpMap[i][j] = map[i][j];

				if (tmpMap[i][j] == 2) { // 바이러스 발생지면
					queue.add(new Pos(j, i)); // 일단 큐에 넣는다
					visit[i][j]=true;//방문처리
				}
			}
		}

		while (!queue.isEmpty()) {
			Pos now = queue.poll(); // 큐에서 꺼낸 곳부터 탐색 시작

			for (int i = 0; i < 4; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || tmpMap[nextY][nextX] == 1
						|| visit[nextY][nextX])
					continue;
				// 범위 벗어나거나, 벽이거나, 이미 방문완료면 쳐내

				tmpMap[nextY][nextX] = 2; // 감염시키고
				visit[nextY][nextX] = true; // 방문처리한 다음
				queue.add(new Pos(nextY, nextX)); // 거기서 다시 탐색하기 위해 큐에 넣음
			}
		} // 바이러스 전염 끝

		// 카운트해보고 더 크면 최대 안전지대 넓이 갱신
		maxSafe = Math.max(maxSafe, safeArea());

	}

	public static void dfs(int wallcnt, int x, int y) {

	    if (wallcnt == 3) { // 3개 벽 세웠으면 bfs로 바이러스 퍼지게 하고 안전지대 카운트
	        // 벽을 세우기 전에 현재 위치의 값을 저장
	        int[][] originalMap = new int[N][M];
	        for (int i = 0; i < N; i++) {
	            originalMap[i] = Arrays.copyOf(map[i], M);
	        }
	        
	        bfs();
	        
	        // 벽을 세우고 나서 원래 상태로 되돌리기
	        for (int i = 0; i < N; i++) {
	            map[i] = Arrays.copyOf(originalMap[i], M);
	        }
	        return;
	    }

		// 재귀파트
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(wallcnt + 1, j, i);
					map[i][j] = 0;
				}
			}
		}

	}

	// 안전지대 카운트할 메서드
	public static int safeArea() {

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

}// class
