
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[] di;
	static ArrayList<Node>[] no;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		no = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) no[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			no[a].add(new Node(b, c));
			no[b].add(new Node(a, c));
		}

		int s = 0, e = 1000000000;
		int ans = -1;
		while (s <= e) {
			int m = (s + e) / 2;
			if (di(m)) {
				ans = m;
				e = m - 1;
			}
			else s = m + 1;
		}
		System.out.println(ans);
	}

	private static boolean di(int x) {
		di = new int[N + 1];
		for (int i = 2; i <= N; i++) di[i] = Integer.MAX_VALUE;
		Queue<Node> q = new PriorityQueue<Node>(Comparator.comparingInt(o -> o.c));
		q.add(new Node(1, 0));
		while (!q.isEmpty()) {
			Node t = q.poll();
			for (Node i : no[t.y]) {
				int w = i.c <= x ? 0 : 1;
				if (di[i.y] > t.c + w) {
					di[i.y] = t.c + w;
					q.add(new Node(i.y, t.c + w));
				}
			}
		}
		return di[N] <= K;
	}
}
class Node{
	int y;
	int c;
	public Node(int y, int c) {
		this.y = y;
		this.c = c;
	}
}
