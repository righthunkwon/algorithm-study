package study_240227;

import java.io.*;
import java.util.*;

public class Pro_12763_지각하면안돼 {
	static class Note {
		int ed, t, m;

		public Note(int ed, int t, int m) {
			this.ed = ed;
			this.t = t;
			this.m = m;
		}
	}

	static int[][] dist;
	static boolean[] visited;
	static List<Note>[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 건물 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());// 남은 시간
		int M = Integer.parseInt(st.nextToken());// 돈

		int L = Integer.parseInt(br.readLine());// 길 개수

		arr = new ArrayList[N + 1];// 인접 리스트

		dist = new int[N + 1][N + 1]; // 정점 별 t분 이하 시간,최소 돈
		for (int i = 1; i <= N; i++) {// 리스트 미리 생성
			arr[i] = new ArrayList<>();
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			arr[a].add(new Note(b, t, m));
			arr[b].add(new Note(a, t, m));
		} // 입력끝
		visited = new boolean[N + 1];
		// 1번에서 T분 이내로 N번으로 가는 데 M이하의 돈 중 최소지출
		// 일반 최소지출을 기준으로 최단거리 후 가장 최소지출부터 T분 이내로 갈 수 있는 지 판단

		// 다잌스트라는 최단거리만 기억하기 때문에 최소지출만 기억하게된다 ..
		// 그럼 T분 이내로 갈 수 있는 것만
		dfs(1);
	}

	private static void dfs(int i) {
		for (Note n : arr[i]) {

		}
	}
}
