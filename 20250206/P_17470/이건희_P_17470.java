import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] tmp = {{0, 1}, {2, 3}};
    static boolean fX, fY;
    static int turn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        char[] cmd = br.readLine().replace(" ", "").toCharArray();
        cal(cmd);
        print(arr);
    }

    private static void cal(char[] calc) {
        for (char r : calc) {
            switch (r) {
                case '1': tmp = fY(tmp); fY = turn % 2 == 0 ? !fY : fY;
                    fX = turn % 2 == 1 ? !fX : fX; break;
                case '2': tmp = fX(tmp); fX = turn % 2 == 0 ? !fX : fX;
                    fY = turn % 2 == 1 ? !fY : fY; break;
                case '3': tmp = tR(tmp); turn = (turn + 1) % 4; 
                    break;
                case '4': tmp = tL(tmp); turn = (turn + 3) % 4; 
                    break;
                case '5': tmp = rotR(tmp); 
                    break;
                case '6': tmp = rotL(tmp); 
                    break;
            }
        }
    }

    private static void print(int[][] arr) {
        int[][][] div = new int[4][N / 2][M / 2];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                if (i < N / 2 && j < M / 2) div[0][i][j] = arr[i][j];
                else if (i < N / 2) div[1][i][j - M / 2] = arr[i][j];
                else if (j < M / 2) div[2][i - N / 2][j] = arr[i][j];
                else div[3][i - N / 2][j - M / 2] = arr[i][j];
            }

        for (int i = 0; i < 4; i++) {
            if (fX) div[i] = fX(div[i]);
            if (fY) div[i] = fY(div[i]);
            for (int j = 0; j < turn; j++) div[i] = tR(div[i]);
        }

        if (turn % 2 == 1) {
            int tmp = N;
            N = M;
            M = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i < N / 2 && j < M / 2) sb.append(div[tmp[0][0]][i][j]);
                else if (i < N / 2) sb.append(div[tmp[0][1]][i][j - M / 2]);
                else if (j < M / 2) sb.append(div[tmp[1][0]][i - N / 2][j]);
                else sb.append(div[tmp[1][1]][i - N / 2][j - M / 2]);
                if (j != M - 1) sb.append(" ");
            }
            if (i != N - 1) sb.append("\n");
        }
        System.out.print(sb);
    }

    static int[][] fY(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) res[n - i - 1] = arr[i].clone();
        return res;
    }

    static int[][] fX(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) res[i][m - j - 1] = arr[i][j];
        return res;
    }

    static int[][] tR(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) res[j][n - i - 1] = arr[i][j];
        return res;
    }

    static int[][] tL(int[][] arr) {
        return new int[][]{{arr[0][1], arr[1][1]}, {arr[0][0], arr[1][0]}};
    }

    static int[][] rotR(int[][] arr) {
        return new int[][]{{arr[1][0], arr[0][0]}, {arr[1][1], arr[0][1]}};
    }

    static int[][] rotL(int[][] arr) {
        return new int[][]{{arr[0][1], arr[1][1]}, {arr[0][0], arr[1][0]}};
    }
}