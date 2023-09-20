package baek;

import java.io.*;
import java.util.*;

public class Pro_16234_인구이동 {
	static boolean[][] visited;
	static Queue<int[]> queue;
	static Queue<int[]> queue2;
	static int[] dr;
	static int[] dc;
	static int[][] country;
	static int R;
	static int N;
	static int L;
	static int sum;
	static boolean move;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken()); // L명이상
		R = Integer.parseInt(st.nextToken()); // R명 이하

		country = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				country[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력끝
		sum = 0;
		queue = new LinkedList<int[]>();// bfs를 사용하여 계속 돌리는 queue, poll하기 때문에 어떠한 나라들이 연결되는지 저장X
		queue2 = new LinkedList<int[]>();// 저장해놓는 queue 1개 더 만듬
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		move = true;// 하루에 인구 이동이 있었는지
		int count = 0;
		while (move) {
			visited = new boolean[N][N];
			move = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {//=> 보통 bfs처럼 queue에 한번에 더하고 bfs하지 않은 이유
						                 //   연결된 나라끼리 avg 값을 구해야하기 때문에 연결된 것 따로 따로 해줘야한다.                    
						visited[i][j] = true;
						queue.add(new int[] { i, j });
						queue2.add(new int[] { i, j });
						bfs();
					}
				}
			}
			if (move) {
				++count;
			}
		}
		System.out.println(count);

	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			sum += country[arr[0]][arr[1]];
			for (int i = 0; i < 4; i++) {//4방향 탐색
				int nr = arr[0] + dr[i];
				int nc = arr[1] + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {	//범위 안이면
					int diff = Math.abs(country[nr][nc] - country[arr[0]][arr[1]]); //현재위치 나라와 옆나라의 인구수 차이의 절댓값
					if (diff >= L && diff <= R && !visited[nr][nc]) {//범위 안에 들어오면 
						visited[nr][nc] = true;
						queue.add(new int[] { nr, nc });
						queue2.add(new int[] { nr, nc });
					}
				}
			}
		}
		//queue가 empty여서 사이클이 끝나면 연결된 나라들이 queue2에 저장되어 있음 
		//이제 queue2로 avg 구한다.
		
		
		if (queue2.size() > 1) {// 나라가 2개 이상이여야 인구 이동 있는 것
			move = true; // 이동했다 알려주고
			int avg = sum / (queue2.size()); // 평균값 구하기
			while (!queue2.isEmpty()) { // 인구이동하는 나라들
				int[] arr = queue2.poll();
				country[arr[0]][arr[1]] = avg; // 평균값 다시 넣어주기
			}
		} else {
			while (!queue2.isEmpty()) {// queue 리셋해주기
				queue2.poll();
			}
		}
		sum = 0;// sum 초기화
	}
}
