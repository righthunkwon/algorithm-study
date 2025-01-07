// https://www.acmicpc.net/problem/14578 비슷한 문제
// import java.util.*;

// public class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         long n = sc.nextLong();
//         System.out.println(der(n));
//     }

//     public static long der(long n) {
//         if (n == 0) return 1;
//         if (n == 1) return 0;

//         return ((n-1)*(der(n-1)+der(n-2)))%1000000000L;
//     }
// }
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(der(n));
    }

    public static long der(int n) {
        if (n == 0) return 1;
        if (n == 1) return 0;

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2])) % 1000000000L;
        }
        return dp[n];
    }
}