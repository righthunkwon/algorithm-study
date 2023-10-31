package baek;

import java.util.*;

public class Pro_12851_숨바꼭질2 {
	static boolean visited[];
	static Queue<int[]> q;
	static int N, K, time, cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		if (N == K) {
			System.out.println(0);
			System.out.println(1);
		} else {
			time = 0;
			cnt = 0;
			visited = new boolean[200001];
			q = new LinkedList<int[]>();
			q.add(new int[] { N, 0, 0 });
			visited[0] = true;
			bfs();
			System.out.println(time);
			System.out.println(cnt);
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int[] now = q.poll();
			visited[now[0]] = true;
//			System.out.println(now[0] + "ddd" + now[1]);
			if (time != 0 && now[1] > time)
				return;
			if (now[0] == K) {
				if (time == 0) {
					time = now[1];
					cnt++;
				} else if (now[1] == time)
					cnt++;

			} else {
				if (now[0] - 1 >= 0 && now[2] != 1 && !visited[now[0] - 1]) {
					q.add(new int[] { now[0] - 1, now[1] + 1, -1 });
				}
				if (now[0] + 1 <= K && now[2] != -1 && !visited[now[0] + 1]) {
					q.add(new int[] { now[0] + 1, now[1] + 1, 1 });
				}
				if (2 * now[0] < 200001 && !visited[now[0] * 2]) {
					q.add(new int[] { 2 * now[0], now[1] + 1, 0 });
				}
			}
		}
	}
}
