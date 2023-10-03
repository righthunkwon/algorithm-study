import java.io.*;
import java.util.*;
public class q9205 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
l:		for(int tc=0;tc<T;tc++) {
			List<Node> L=new ArrayList<>();
			Node s=null,e=null;
			int N=Integer.parseInt(br.readLine());
			for(int i=0;i<N+2;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				if(i==0) s=new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
				else if(i==N+1) e=new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
				else L.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
			Queue<Node> Q=new LinkedList<>();
			boolean ch[]=new boolean[N];
			Q.add(s);
			while(!Q.isEmpty()) {
				Node t=Q.poll();
				if(Math.abs(t.x-e.x)+Math.abs(t.y-e.y)<=1000) {
					System.out.println("happy");
					continue l;
				}
				for(int i=0;i<N;i++) {
					if(!ch[i] && Math.abs(L.get(i).x-t.x)+Math.abs(L.get(i).y-t.y)<=1000) {
						ch[i]=true;
						Q.add(L.get(i));
					}
				}
			}
			System.out.println("sad");
		}	
	}
}
class Node {
	int x;
	int y;
	Node(int x,int y) {
		this.x=x;
		this.y=y;
	}
}
