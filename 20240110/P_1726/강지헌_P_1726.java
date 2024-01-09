import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        boolean[][][] chk = new boolean[N][M][5];
        Queue<Node> Q = new LinkedList<>();
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int sx=Integer.parseInt(st.nextToken())-1,sy=Integer.parseInt(st.nextToken())-1,sd=Integer.parseInt(st.nextToken());
        Q.add(new Node(sx,sy,sd,0));
        chk[sx][sy][sd]=true;
        st = new StringTokenizer(br.readLine());
        int ex=Integer.parseInt(st.nextToken())-1,ey=Integer.parseInt(st.nextToken())-1,ed=Integer.parseInt(st.nextToken());

        int[] xx={0,0,0,1,-1},yy={0,1,-1,0,0};
        while(!Q.isEmpty()) {
            Node t = Q.poll();
            if(t.x==ex && t.y==ey && t.d==ed) {
                System.out.println(t.c);
                return;
            }
            int ld,rd;
            if(t.d<=2) {ld=3; rd=4;}
            else {ld=1; rd=2;}
            if(!chk[t.x][t.y][ld]) { Q.add(new Node(t.x,t.y,ld,t.c+1)); chk[t.x][t.y][ld]=true; }
            if(!chk[t.x][t.y][rd]) { Q.add(new Node(t.x,t.y,rd,t.c+1)); chk[t.x][t.y][rd]=true; }
            for(int i=1;i<=3;i++) {
                int dx=t.x+xx[t.d]*i,dy=t.y+yy[t.d]*i;
                if(dx<0 || dx>=N || dy<0 || dy>=M) continue;
                if(arr[dx][dy]==1) break;
                if(!chk[dx][dy][t.d]) { Q.add(new Node(dx,dy,t.d,t.c+1)); chk[dx][dy][t.d]=true; }
            }
        }
    }
}
class Node {
    int x,y,d,c;
    Node(int x,int y,int d,int c) {
        this.x=x;
        this.y=y;
        this.d=d;
        this.c=c;
    }
}
