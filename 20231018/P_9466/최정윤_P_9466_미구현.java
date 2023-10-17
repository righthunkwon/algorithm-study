//시간초과 허허..
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			pick = new int[n + 1];
			st = new StringTokenizer(br.readLine());
			team = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				pick[i] = Integer.parseInt(st.nextToken());
				if (i == pick[i])
					team[i] = true;
			} // 입력끝\

			for (int i = 1; i <= n; i++) {
				if (!team[i] && !team[pick[i]]) {
					check = new boolean[n + 1];
					dfs(i, i, 0);
				}
			}

			System.out.println(count());

		}
	}

	static boolean[] team, check;
	static int[] pick;
	static int n;

	private static void dfs(int start, int now, int cnt) {
		check[now] = true;
		if (pick[now] == start) {
			for (int i = 1; i <= n; i++) {
				if (check[i])
					team[i] = true;
			}
			return;
		}
		if (cnt == count() || team[pick[now]] || check[pick[now]])
			return;

		dfs(start, pick[now], cnt + 1);
	}

	static int count() {
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (!team[i])
				cnt++;
		}
		return cnt;
	}
}
