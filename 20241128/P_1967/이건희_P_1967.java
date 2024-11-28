import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max = 0;
    static int node;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[parent].add(new Node(child, cost));
            list[child].add(new Node(parent, cost));
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        dfs(node, 0);

        System.out.println(max);
    }

    static void dfs(int x, int len) {
        visited[x] = true;

        if (len > max) {
            max = len;
            node = x;
        }

        for (Node n : list[x]) {
            if (!visited[n.d]) {
                dfs(n.d, len + n.cost);
            }
        }
    }

    static class Node {
        int d;
        int cost;

        public Node(int d, int cost) {
            this.d = d;
            this.cost = cost;
        }
    }
}