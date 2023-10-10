import java.util.*;
import java.io.*;
public class Main {
    static int N,M,max=Integer.MIN_VALUE;
    static int[][] map;
    static int[] xx= {0,0,1,-1}, yy= {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) map[i][j]=Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(max);
    }
    static void dfs(int cnt) {
        if(cnt==3) {
            bfs();
            return;
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j]==1 || map[i][j]==2) continue;
                map[i][j]=1;
                dfs(cnt+1);
                map[i][j]=0;
            }
        }
    }
    static void bfs() {
        Queue<Node> Q=new LinkedList<>();
        for(int i=0;i<N;i++)
            for(int j=0;j<M;j++)
                if(map[i][j]==2)
                    Q.add(new Node(i,j));
        int[][] arr=new int[N][M];
        for(int i=0;i<N;i++) arr[i]=map[i].clone();
        while(!Q.isEmpty()) {
            Node t=Q.poll();
            for(int i=0;i<4;i++) {
                int dx=t.x+xx[i];
                int dy=t.y+yy[i];
                if(dx<0 || dy<0 || dx>=N || dy>=M) continue;
                if(arr[dx][dy]==0) {
                    Q.add(new Node(dx,dy));
                    arr[dx][dy]=2;
                }
            }
        }
        int cnt=0;
        for(int i=0;i<N;i++)
        	for(int j=0;j<M;j++)
        		if(arr[i][j]==0)
        			cnt++;
        max=Math.max(max,cnt);
    }
}

class Node {
    int x,y;
    Node(int x,int y) {
        this.x=x;
        this.y=y;
    }
}
