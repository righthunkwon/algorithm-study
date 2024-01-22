import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] dy = new int[n][m + 1];
        Arrays.fill(dy[0], 1);
        for (int i = 1; i < n; i++) {
            dy[i][0] = 1;
            for (int j = 1; j <= m; j++) dy[i][j] = (dy[i - 1][j] + dy[i][j - 1]) % 1000000000;
        }
        System.out.println(dy[n - 1][m]);
    }
}
