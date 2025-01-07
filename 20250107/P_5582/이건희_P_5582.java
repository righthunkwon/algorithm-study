// LCS 문제
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();

        System.out.println(lcs(a, b));
    }

    public static int lcs(String a, String b) {
        int n = a.length();
        int m = b.length();

        int[][] lcs = new int[n + 1][m + 1];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                    max = Math.max(max, lcs[i][j]);
                } else {
                    lcs[i][j] = 0;
                }
            }
        }
        return max;
    }
}