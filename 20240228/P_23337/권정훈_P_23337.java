
import java.io.*;
import java.util.*;

// Drunk passenger
public class P_23337 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] dp = new double[N + 1];
        dp[N] = (double) 1 / (N - 1);
        for (int i = N - 1; i > 1; i--) {
            // dp[i] : 확률 누적 결과
            // dp[i + 1] : 이전 사람이 내 자리에 앉을 확률
            // dp[i + 1] * ( 1 / i ) : 해당 사람이 내 자리에 앉을 확률
            dp[i] = dp[i + 1] + dp[i + 1] * (double) 1 / i;
        }
        System.out.print(dp[2]);
    }
}
