import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[] g = new char[N+1];
		List<Node>[] di = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) di[i] = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) g[i] = st.nextToken().charAt(0);
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			di[a].add(new Node(b,c));
			di[b].add(new Node(a,c));
		}

		boolean[] chk = new boolean[N+1];
		Queue<Node> Q = new PriorityQueue<>(Comparator.comparingInt(o -> o.c));
		int sum=0, cnt=0;
		Q.add(new Node(1,0));
		while(!Q.isEmpty()) {
			Node t = Q.poll();
			if(chk[t.y]) continue;
			chk[t.y] = true;
			sum+=t.c;
			cnt++;
			for(Node i : di[t.y]) if(!chk[i.y] && g[i.y]!=g[t.y]) Q.add(i);
		}
		System.out.println(cnt!=N?-1:sum);
	}
}
class Node {
	int y;
	int c;
	public Node(int y, int c) {
		this.y=y;
		this.c=c;
	}
}
