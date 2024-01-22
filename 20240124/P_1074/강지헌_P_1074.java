
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, C, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        dfs((int) Math.pow(2, N), M, C);
    }

    private static void dfs(int s, int r, int c) {
        if (s == 1) {
            System.out.println(ans);
            System.exit(0);
        }
        int n = s / 2;
        if (r < n) {
            if (c < n) dfs(n, r, c);
            else {
                ans += n * n;
                dfs(n, r, c - n);
            }
        } else {
            if (c < n) {
                ans += n * n * 2;
                dfs(n, r - n, c);
            } else {
                ans += n * n * 3;
                dfs(n, r - n, c - n);
            }
        }
    }
}
