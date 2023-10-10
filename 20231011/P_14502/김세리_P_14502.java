import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14502_연구소 {
	static int N, M;
    static int max = 0;
    static int[][] arr, virus;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        virus = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
                if (arr[i][j] == 1 || arr[i][j] == 2) visited[i][j] = true;
            }
        }

        dfs(0, 0, 0);
        System.out.println(max);
    }

    public static void dfs(int x, int y, int cnt) {
        if (cnt == 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (virus[i][j] == 0) virus[i][j] = arr[i][j];
                    if (virus[i][j] == 2) {
                        if (i - 1 >= 0 && virus[i - 1][j] == 0) virus[i - 1][j] = 2;
                        if (i + 1 < N && virus[i + 1][j] == 0) virus[i + 1][j] = 2;
                        if (j - 1 >= 0 && virus[i][j - 1] == 0) virus[i][j - 1] = 2;
                        if (j + 1 < M && virus[i][j + 1] == 0) virus[i][j + 1] = 2;
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (virus[i][j] == 0) sum++;
                }
            }
            max = Math.max(max, sum);
            return;
        }
        for (int i = x; i < N; i++) {
            for (int j = (i == x ? y : 0); j < M; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    virus[i][j] = 1;
                    dfs(i, j, cnt + 1);
                    visited[i][j] = false;
                    virus[i][j] = 0;
                }
            }
        }
    }
}
