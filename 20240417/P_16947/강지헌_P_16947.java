import java.io.*;
import java.util.*;

public class Main {
	static boolean[] chk, cy;
	static List<Integer> list[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		int[] di = new int[n + 1]; cy = new boolean[n + 1];
		for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b); list[b].add(a);
		}
		for (int i = 1; i <= n; i++) {
			chk = new boolean[n + 1];
			dfs(i, i, 1);
		}
		Queue<Integer> Q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (cy[i]) Q.add(i);
			else di[i] = -1;
		}
		while (!Q.isEmpty()) {
			int c = Q.poll();
			for (int t : list[c]) {
				if (di[t] == -1) {
					di[t] = di[c] + 1;
					Q.add(t);
				}
			}
		}
		for (int i = 1; i <= n; i++) System.out.print(di[i]+" ");
	}
	static void dfs(int a, int b, int c) {
		chk[b] = true;
		for (int t : list[b]) {
			if (t == a && c >= 3) { cy[t] = true; return; }
			if (!chk[t]) dfs(a, t, c + 1);
		}
	}
}
