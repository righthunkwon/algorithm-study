package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pro_15591_MooTube {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		// 인접행렬
		arr = new int[N + 1][N + 1];
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			arr[p][q] = r;
			arr[q][p] = r;
		}
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			dist = new int[N + 1];
			visited = new boolean[N + 1][N + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			usado(v);
			int cnt = 0;
			for (int j = 1; j < N + 1; j++) {
				if (dist[j] >= K&&dist[j]!=Integer.MAX_VALUE)
					cnt++;
			}
			
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}

	private static void usado(int v) {
		for (int j = 1; j < N + 1; j++) {
			if (arr[v][j] != 0 && !visited[v][j]) {
				dist[j] = Math.min(dist[v], Math.min(arr[v][j], dist[j]));
				visited[v][j] = true;
				visited[j][v] = true;
				usado(j);
			}
		}
	}

	static int N;
	static int[] dist;
	static int[][] arr;
	static boolean[][] visited;
} 
