package study_240417;

import java.io.*;
import java.util.*;

public class Pro_7579_앱 {
	static class App implements Comparable<App> {
		int m, c;

		public App(int m, int c) {
			this.m = m;
			this.c = c;
		}

		@Override
		public int compareTo(App o) {
			return this.m - o.m;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] memory = new int[N];
		int[] cost = new int[N];
		List<App> list = new ArrayList();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			list.add(new App(memory[i], cost[i]));
		}

		Collections.sort(list);
		int[] dp = new int[10000001];

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).m; j++) {
				if (dp[j] != 0) {
					dp[j + list.get(i).m] = Math.min(j + list.get(i).c, dp[j + list.get(i).m]);
				}
			}
			dp[list.get(i).m] = list.get(i).c;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 100000 - 1; i >= 0; i--) {
			if (dp[i] != 0) {
				min = Math.min(min, dp[i]);
			}
			dp[i] = min;
		}
		System.out.println(dp[M]);
	}
}
