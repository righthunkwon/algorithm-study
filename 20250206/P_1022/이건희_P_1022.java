import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        sc.close();

        int h = r2 - r1 + 1;
        int w = c2 - c1 + 1;
        int[][] result = new int[h][w];

        int maxLen = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int value = getNum(r1 + i, c1 + j);
                result[i][j] = value;
                maxLen = Math.max(maxLen, String.valueOf(value).length());
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
            	if(j == w-1) System.out.printf("%" + maxLen + "d", result[i][j]);
            	else System.out.printf("%" + maxLen + "d ", result[i][j]);
            }
            System.out.println();
        }
    }
    public static int getNum(int x, int y) {
        int k = Math.max(Math.abs(x), Math.abs(y));
        int max = (2 * k + 1) * (2 * k + 1);

        if (x == k) {
            return max - (k - y);
        } else if (y == -k) {
            return max - (2 * k) - (k - x);
        } else if (x == -k) { 
            return max - (4 * k) - (y + k);
        } else {
            return max - (6 * k) - (x + k);
        }
    }
}