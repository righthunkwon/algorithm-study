import java.io.*;
import java.util.*;
public class Main {
	private static final BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static final int INF=1000000000;
    public static int T,n,m,t,s,g,h;
    public static ArrayList<ArrayList<Node>> map;
    public static int[] d;
    public static void main(String[] args) throws IOException {
    	StringTokenizer st;
        T=Integer.parseInt(br.readLine());
        for(int j=0;j<T;j++) {
        	st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            t=Integer.parseInt(st.nextToken());
            map=new ArrayList<>();
            st=new StringTokenizer(br.readLine());
            s=Integer.parseInt(st.nextToken());
            g=Integer.parseInt(st.nextToken());
            h=Integer.parseInt(st.nextToken());
            for(int i=0;i <= n;i++) map.add(new ArrayList<>());
            for(int i=0;i<m;i++) {
            	st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                int d=Integer.parseInt(st.nextToken());
                map.get(a).add(new Node(b,d));
                map.get(b).add(new Node(a,d));
            }
            int[] des=new int[t];
            for(int i=0;i<t;i++) des[i]=Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            for(int d : des) {
                long d1=di(s,g)+di(g,h)+di(h,d);
                long d2=di(s,h)+di(h,g)+di(g,d);
                long d3=di(s,d);
                if(Math.min(d1,d2)==d3) pq.add(d);
            }
            while(!pq.isEmpty()) System.out.print(pq.poll()+" ");
            System.out.println();
        }
    }
    public static int di(int st,int en) {
        d=new int[n+1];
        Arrays.fill(d,INF);
        PriorityQueue<Node> pq=new PriorityQueue<>((o1,o2) -> o1.d-o2.d);
        pq.add(new Node(st,0));
        d[st]=0;
        while(!pq.isEmpty()) {
            Node node=pq.poll();
            int xx=node.x;
            int di=node.d;
            if(d[xx]<di) continue;
            for(int i=0;i<map.get(xx).size();i++) {
                int c=d[xx]+map.get(xx).get(i).d;
                if(c<d[map.get(xx).get(i).x]) {
                    d[map.get(xx).get(i).x]=c;
                    pq.offer(new Node(map.get(xx).get(i).x,c));
                }
            }
        }
        return d[en];
    }
}
class Node {
	int x,d;
	Node(int x,int d) {
		this.x=x;
		this.d=d;
	}
}
