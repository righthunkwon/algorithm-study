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
        List<Node> Q = new ArrayList<>();

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            Q.add(new Node(a - 1, b - 1, c, d, e));
        }
        Q.sort((o1, o2) -> {
            return o2.z - o1.z;
        });
        int ans = 0;
        for (int i = 0; i < M; i++) {
            int min = Integer.MAX_VALUE, mx = -1;
            for (int j = 0; j < C; j++) {
                if (Q.get(j).y == i && min > Q.get(j).x) {
                    min = Q.get(j).x;
                    mx = j;
                }
            }
            if (mx != -1) {
                ans += Q.get(mx).z;
                Q.remove(mx);
            }
            boolean[] chk = new boolean[C];
            for (int j = 0; j < Q.size(); j++) {
                Node t = Q.get(j);

            }

        }
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
