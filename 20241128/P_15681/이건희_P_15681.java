import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int r = Integer.parseInt(firstLine[1]);
        int q = Integer.parseInt(firstLine[2]);

        ArrayList<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] edge = reader.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            tree[u].add(v);
            tree[v].add(u);
        }

        int[] subtree = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        cal(r, tree, subtree, visited);

        for (int i = 0; i < q; i++) {
            int query = Integer.parseInt(reader.readLine());
            writer.write(subtree[query] + "\n");
        }

        writer.flush();
        writer.close();
    }

    static int cal(int currentNode, ArrayList<Integer>[] tree, int[] subtree, boolean[] visited) {
        visited[currentNode] = true;
        int size = 1;
        for (int neighbor : tree[currentNode]) {
            if (!visited[neighbor]) {
                size += cal(neighbor, tree, subtree, visited);
            }
        }
        subtree[currentNode] = size;
        return size;
    }
}