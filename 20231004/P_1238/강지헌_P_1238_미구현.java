import java.io.*;
import java.util.*;
public class q1238 {
	static int N,M,C;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());		
		M=Integer.parseInt(st.nextToken());		
		C=Integer.parseInt(st.nextToken());
		ArrayList<Node>[] L1=new ArrayList[N+1],L2=new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {
			L1[i]=new ArrayList<>();
			L2[i]=new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());	
			int y=Integer.parseInt(st.nextToken());	
			int t=Integer.parseInt(st.nextToken());	
			L1[x].add(new Node(y,t));
			L2[y].add(new Node(x,t));
		}
		int[] d1=D(L1);
		int[] d2=D(L2);
		int ans=0;
		for(int n=1;n<=N;n++) ans=Math.max(ans,d1[n]+d2[n]);
		System.out.println(ans);
	}
	public static int[] D(ArrayList<Node>[] L) {
		boolean[] ch=new boolean[N+1];
		int[] d = new int[N+1];
		Arrays.fill(d,Integer.MAX_VALUE);
		d[C]=0;
		PriorityQueue<Node> pq=new PriorityQueue<>((o1,o2) -> {
			return o1.d-o2.d;
		});
		pq.offer(new Node(C,0));
		while(!pq.isEmpty()) {
			int t=pq.poll().y;
			if(ch[t]) continue;
			ch[t]=true;
			for(Node i : L[t]) {
				if(d[i.y]>d[t]+i.d) {
					d[i.y]=d[t]+i.d;
					pq.offer(new Node(i.y,d[i.y]));
				}
			}
		}
		return d;
	}

}
class Node {
	int y;
	int d;
	Node(int y,int d) {
		this.y=y;
		this.d=d;
	}
}
