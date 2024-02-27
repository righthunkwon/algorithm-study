import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int xx[] = {1,1,1,0,-1,-1,-1,0}, yy[] = {1,0,-1,-1,-1,0,1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> Q = new PriorityQueue<>(Comparator.comparingInt(o -> o.c));
        int[][] arr = new int[N][N], brr = new int[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j]=5;
                brr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            Q.add(new Node(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())));
        }

        for(int i=0;i<K;i++) {
            Queue<Node> tn = new LinkedList<>();
            int[][] na = new int[N][N];
            while(!Q.isEmpty()) {
                Node t = Q.poll();
                if(arr[t.x][t.y]>=t.c) {
                    arr[t.x][t.y]-=t.c;
                    t.c++;
                    tn.add(t);
                }
                else na[t.x][t.y]+=t.c/2;
            }
            for(int j=0;j<N;j++) {
                for(int k=0;k<N;k++) {
                    arr[j][k]+=na[j][k];
                }
            }
            while(!tn.isEmpty()) {
                Node t = tn.poll();
                if(t.c%5==0) {
                    for(int j=0;j<8;j++) {
                        int dx=t.x+xx[j],dy=t.y+yy[j];
                        if(dx<0 || dx>=N || dy<0 || dy>=N) continue;
                        Q.add(new Node(dx,dy,1));
                    }
                }
                Q.add(t);
            }
            for(int j=0;j<N;j++) {
                for(int k=0;k<N;k++) {
                    arr[j][k]+=brr[j][k];
                }
            }
        }
        System.out.println(Q.size());
    }
}
class Node {
    int x, y, c;
    Node(int x, int y, int c) {
        this.x=x;
        this.y=y;
        this.c=c;
    }
}
