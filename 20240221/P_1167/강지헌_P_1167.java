import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] edges;
    static boolean[] vi;
    static int V, can, max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V=Integer.parseInt(br.readLine());
        edges = new ArrayList[V+1];
        vi = new boolean[V+1];
        for(int i=0; i<=V; i++) edges[i]= new ArrayList<Node>();
        for(int i=0; i<V; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while(true) {
                int b = Integer.parseInt(st.nextToken());
                if(b==-1) break;
                int c = Integer.parseInt(st.nextToken());
                edges[a].add(new Node(b,c));
            }
        }
        dfs(1,0);
        vi=new boolean[V+1];
        dfs(can, 0);
        System.out.println(max);
    }

    static public void dfs(int v, int len) {
        if(len>max) {
            max=len;
            can=v;
        }
        vi[v]=true;
        for(int i=0; i<edges[v].size(); i++) {
            Node t = edges[v].get(i);
            if(!vi[t.y]) dfs(t.y,len+t.t);
        }
    }
}
class Node{
    int y;
    int t;
    public Node(int y, int t) {
        this.y=y;
        this.t=t;
    }
}
