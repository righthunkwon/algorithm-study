import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		ArrayList<Node> li = new ArrayList<>();
		for(int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			li.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		li.sort(Comparator.comparingInt(o -> o.y));
		int l = 1;
		int r = Math.min(N, M);
		while(l <= r) {
			int m = (l + r) / 2;
			if(chk(m, li)) r = m - 1;
			else l = m + 1;
		}
		System.out.println(l);
	}

	public static boolean chk(int m, ArrayList<Node> list) {
		int cnt = 0, t = 0;
		for (Node i : list) {
			if (i.x > m) return false;
			if (t == 0 || t + m <= i.y) {
				t = i.y;
				cnt++;
				if (cnt > C) return false;
			}
		}
		return true;
	}
}
class Node {
	int x;
	int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
