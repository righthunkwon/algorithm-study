import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());// L명이상
		R = Integer.parseInt(st.nextToken());// R명 이하

		country = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				country[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력끝
		sum = 0;
		queue = new LinkedList<int[]>();
		queue2 = new LinkedList<int[]>();
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		move = true;
		int count = 0;
		while (move) {
			visited = new boolean[N][N];
			move = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						visited[i][j] = true;
						queue.add(new int[] { i, j });
						queue2.add(new int[] { i, j });
						bfs();
					}
				}
			}
			if(move) {++count;}
		}
		System.out.println(count);

	}

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

	public static void bfs() {
		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			sum += country[arr[0]][arr[1]];
			for (int i = 0; i < 4; i++) {
				int nr = arr[0] + dr[i];
				int nc = arr[1] + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (Math.abs(country[nr][nc] - country[arr[0]][arr[1]]) >= L
							&& Math.abs(country[nr][nc] - country[arr[0]][arr[1]]) <= R && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.add(new int[] { nr, nc });
						queue2.add(new int[] { nr, nc });
					}
				}
			}
		}
		if (queue2.size() > 1) {
			move = true;
			int avg = sum / (queue2.size());
			while (!queue2.isEmpty()) {
				int[] arr = queue2.poll();
				country[arr[0]][arr[1]] = avg;
			}
		} else {
			while (!queue2.isEmpty()) {
				queue2.poll();
			}
		}
		sum=0;
	}
}
