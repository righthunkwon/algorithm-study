import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, T, M;
    static List<Node>[] arr;
    static int[] d;

    static boolean dfs(int y, int t, int m) {
        boolean f = false;
        if (y == N) return true;
        for (Node n : arr[y]) {
            if (t + n.t > T || m + n.m > M) continue;
            f = dfs(n.y, t + n.t, m + n.m) || f;
            if(f) d[n.y] = Math.min(d[n.y],m+n.m);
        }
        return f;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        d = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
            d[i] = Integer.MAX_VALUE;
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b, c, d));
            arr[b].add(new Node(a, c, d));
        }
        d[1] = 0;
        dfs(1, 0, 0);
        System.out.println(d[N] == Integer.MAX_VALUE ? -1 : d[N]);
    }
}

class Node {
    int y, t, m;
    Node(int y, int t, int m) {
        this.y = y;
        this.t = t;
        this.m = m;
    }
}
