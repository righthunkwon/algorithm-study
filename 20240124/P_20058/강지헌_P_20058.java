import java.io.*;
import java.util.*;

public class Main {
    static int[][] dxy = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}, map;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int n = (int) Math.pow(2, N);
        map = new int[n][n];
        int[] arr = new int[M];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) arr[i] = Integer.parseInt(st.nextToken());


        for (int i = 0; i < M; i++) {
            rot(arr[i]);
            cut();
        }
        int ans = 0;
        boolean[][] chk = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!chk[i][j] && map[i][j] > 0) {
                    int cnt = 0;
                    Queue<int[]> Q = new LinkedList<int[]>();
                    Q.add(new int[]{i, j});
                    chk[i][j] = true;
                    while (!Q.isEmpty()) {
                        int[] t = Q.poll();
                        cnt++;
                        for (int k = 0; k < 4; k++) {
                            int dx = t[0] + dxy[k][0];
                            int dy = t[1] + dxy[k][1];
                            if (dx >= 0 && dx < map.length && dy >= 0 && dy < map.length && map[dx][dy] > 0 && !chk[dx][dy]) {
                                Q.add(new int[]{dx, dy});
                                chk[dx][dy] = true;
                            }
                        }
                    }
                    ans = Math.max(ans, cnt);
                }
            }
        }
        System.out.println(sum + "\n" + ans);

    }


    static void rot(int l) {
        int n = map.length;
        int[][] t = new int[n][n];
        for (int i = 0; i < n; i++) t[i] = Arrays.copyOf(map[i], n);

        int sq = (int) Math.pow(2, l);
        for (int i = 0, j = 0; j < n; ) {
            for (int p = 0; p < sq; p++) {
                for (int q = 0; q < sq; q++) {
                    map[i + q][j + sq - p - 1] = t[i + p][j + q];
                }
            }
            i += sq;
            if (i > n - 1) {
                i = 0;
                j += sq;
            }
        }
    }

    static void cut() {
        int n = map.length;
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(map[i], n);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int dx = i + dxy[k][0];
                        int dy = j + dxy[k][1];
                        if (dx >= 0 && dx < n && dy >= 0 && dy < n && copy[dx][dy] > 0) {
                            cnt++;
                        }
                    }
                    if (cnt < 3) {
                        map[i][j]--;
                        sum--;
                    }
                }
            }
        }
    }
}
