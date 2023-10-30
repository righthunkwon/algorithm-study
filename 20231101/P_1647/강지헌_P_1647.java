import java.io.*;
import java.util.*;

public class Main {
	static int[] p;
	static int N,M;
	public static void main(String [] args) throws IOException {
		PriorityQueue<Node> Q=new PriorityQueue<>((o1,o2) -> {
			return o1.c-o2.c;
		});
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			Q.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		int ans=0,max=0;
		p=new int[N+1];
		for(int i=1;i<=N;i++) p[i]=i;
		while(!Q.isEmpty()) {
			Node t=Q.poll();
			if(find(t.x)!=find(t.y)) {
				ans+=t.c;
				int x=find(t.x),y=find(t.y);
				if(x!=y) p[y]=x;
				max=t.c;
			}
		}
		System.out.println(ans-max);
	}
	static int find(int t) {
		if(t==p[t]) return t;
		return p[t]=find(p[t]);
	}
}
class Node {
	int x,y,c;
	Node(int x,int y,int c) {
		this.x=x;
		this.y=y;
		this.c=c;
	}
}
