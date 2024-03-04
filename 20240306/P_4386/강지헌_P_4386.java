import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        p=new int[N];
        for(int i=0;i<N;i++) p[i]=i;
        double[][] arr = new double[N][2];
        List<Node> no = new ArrayList<>();
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Double.parseDouble(st.nextToken());
            arr[i][1] = Double.parseDouble(st.nextToken());
            for(int j=0;j<i;j++) {
                double dist = Math.pow(arr[i][0]-arr[j][0],2)+Math.pow(arr[i][1]-arr[j][1],2);
                no.add(new Node(j,i,Math.sqrt(dist)));
            }
        }
        no.sort((o1, o2) -> {
            return o1.c-o2.c>0?1:-1;
        });
        double ans=0;
        for(Node t:no) {
            if(find(t.x)!=find(t.y)) {
                union(t.x,t.y);
                ans+=t.c;
            }
        }
        System.out.printf("%.2f",ans);
    }
    static int find(int x) {
        if(p[x]!=x) p[x]=find(p[x]);
        return p[x];
    }
    static void union(int x,int y) {
        int a=find(x),b=find(y);
        if(a<b) p[b]=a;
        else p[a]=b;
    }
}
class Node {
    int x,y;
    double c;
    Node(int x,int y,double c) {
        this.x=x;
        this.y=y;
        this.c=c;
    }
}
