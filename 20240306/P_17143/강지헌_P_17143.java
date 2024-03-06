import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[] xx={-1,1,0,0},yy={0,0,1,-1};
        List<Node> Q = new ArrayList<>();

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            Q.add(new Node(a - 1, b - 1, c, d-1, e));
        }
        Q.sort((o1, o2) -> {
            return o2.z - o1.z;
        });
        int ans = 0;
        for (int i = 0; i < M; i++) {
            int min = Integer.MAX_VALUE, mx = -1;
            for (int j = 0; j < Q.size(); j++) {
                if (Q.get(j).y == i && min > Q.get(j).x) {
                    min = Q.get(j).x;
                    mx = j;
                }
            }
            if (mx != -1) {
                ans += Q.get(mx).z;
                Q.remove(mx);
            }
            boolean[] chk = new boolean[Q.size()];
            boolean[][] map = new boolean[N][M];
            for (int j = 0; j < Q.size(); j++) {
                Node t = Q.get(j);
                int dx=t.x+xx[t.d]*(t.s%((N-1)*2)),dy=t.y+yy[t.d]*(t.s%((M-1)*2));
                while(dx<0 || dx>=N) {
                    if(dx<0) { t.d=1-t.d; dx=Math.abs(dx); }
                    if(dx>=N) { t.d=1-t.d; dx = (N*2-2)-dx; }
                }
                while(dy<0 || dy>=M) {
                    if(dy<0) { t.d=5-t.d; dy=Math.abs(dy); }
                    if(dy>=M) { t.d=5-t.d; dy = (M*2-2)-dy; }
                }
                if(map[dx][dy]) chk[j]=true;
                map[dx][dy]=true;
                t.x=dx; t.y=dy;
                Q.set(j,t);
            }
            for(int j=Q.size()-1;j>=0;j--) {
                if(chk[j]) Q.remove(j);
            }
        }
        System.out.println(ans);
    }
}

class Node {
    int x, y, s, d, z;

    Node(int x, int y, int s, int d, int z) {
        this.x = x;
        this.y = y;
        this.s = s;
        this.d = d;
        this.z = z;
    }
}
