import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] hive = new int[M][M];
        for (int i = 0; i < M; i++) {
            Arrays.fill(hive[i], 1);
        }

        int[] side = new int[2 * M - 1];

        for (int n = 0; n < N; n++) {
            int i0 = sc.nextInt();
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();
            for (int i = i0; i < i0 + i1; i++) {
                side[i] += 1;
            }
            for (int i = i0 + i1; i < 2 * M - 1; i++) {
                side[i] += 2;
            }
        }
        for (int i = 0; i < M; i++) {
            hive[M - 1 - i][0] += side[i];
            if (i > 0) {
                hive[0][i] += side[M - 1 + i];
            }
        }

        for (int j = 1; j < M; j++) {
            for (int i = 1; i < M; i++) {
                hive[i][j] = hive[i - 1][j]; 
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(hive[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}