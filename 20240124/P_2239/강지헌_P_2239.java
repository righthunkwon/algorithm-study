import java.io.*;

public class Main {
    static int[][] arr = new int[9][9];
    static boolean[][] ga = new boolean[9][10], se = new boolean[9][10], sq = new boolean[9][10];
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String t = br.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = t.charAt(j) - '0';
                ga[i][arr[i][j]] = se[j][arr[i][j]] = sq[(i / 3) * 3 + j / 3][arr[i][j]] = true;
            }
        }
        dfs(0);
    }

    public static void dfs(int cnt) {
        if (cnt > 80) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) System.out.print(arr[i][j]);
                System.out.println();
            }
            System.exit(0);
        }
        int x = cnt / 9, y = cnt % 9;
        if (arr[x][y] != 0) dfs(cnt + 1);
        else {
            for (int i = 1; i <= 9; i++) {
                if (!ga[x][i] && !se[y][i] && !sq[(x / 3) * 3 + y / 3][i]) {
                    ga[x][i] = se[y][i] = sq[(x / 3) * 3 + y / 3][i] = true;
                    arr[x][y] = i;
                    dfs(cnt + 1);
                    ga[x][i] = se[y][i] = sq[(x / 3) * 3 + y / 3][i] = false;
                    arr[x][y] = 0;
                }
            }
        }
        return;
    }
}
