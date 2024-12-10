package algo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int[] cnt = new int[M];
        int sum = 0;

        for (int i = 0; i < M; i++) {
            cnt[i] = sc.nextInt();
            sum += cnt[i];
        }

        int K = sc.nextInt();

        double num = 0.0;
        double denom = comb(sum, K);

        for (int i = 0; i < M; i++) {
            if (cnt[i] >= K) {
                num += comb(cnt[i], K);
            }
        }

        double result = num/denom;
        System.out.println(result);
    }

    public static double comb(int n, int k) {
        if (k > n) return 0.0;
        if (k > n - k) k = n - k;
        double res = 1.0;
        for (int i = 1; i <= k; i++) {
            res *= (n - k + i);
            res /= i;
        }
        return res;
    }
}