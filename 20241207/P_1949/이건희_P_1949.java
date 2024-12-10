import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] adj = new int[N + 1][N + 1];
        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u][v] = 1;
            adj[v][u] = 1;
        }

        boolean[] visited = new boolean[N + 1];
        int[][] town = new int[N + 1][2];
        dfs(1, arr, adj, visited, town);

        int result = Math.max(town[1][0], town[1][1]);
        System.out.println(result);
    }

    public static void dfs(int node, int[] arr, int[][] adj, boolean[] visited, int[][] town) {
        visited[node] = true;
        town[node][0] = 0;
        town[node][1] = arr[node];

        for (int i = 1; i < adj.length; i++) {
            if (adj[node][i] == 1 && !visited[i]) {
                dfs(i, arr, adj, visited, town);
                town[node][0] += Math.max(town[i][0], town[i][1]);
                town[node][1] += town[i][0];
            }
        }
    }
}