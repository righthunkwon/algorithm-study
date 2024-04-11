package _20240411;

import java.util.*;

public class _2602_돌다리건너기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String spell = sc.next();
        String angel = sc.next();
        String devil = sc.next();

        int[][][] dp = new int[2][spell.length() + 1][angel.length() + 1];

        // 초기값 설정
        for (int i=0;i<=angel.length(); i++) {
            dp[0][0][i] = 1;
            dp[1][0][i] = 1;
        }

        for (int i=1;i<=spell.length();i++) {
            for (int j=1;j<=angel.length();j++) {
                // 천사의 돌다리
                if (spell.charAt(i-1)==angel.charAt(j-1)) {
                    dp[0][i][j] = dp[1][i-1][j-1];
                }

                // 악마의 돌다리
                if (spell.charAt(i-1)==devil.charAt(j-1)) {
                    dp[1][i][j] = dp[0][i-1][j-1];
                }

                // 이전 상태를 누적
                dp[0][i][j] += dp[0][i][j-1];
                dp[1][i][j] += dp[1][i][j-1];
            }
        }

        // 최종 결과는 두 돌다리의 마지막 상태를 합한 값
        System.out.println(dp[0][spell.length()][angel.length()] + dp[1][spell.length()][angel.length()]);
    }
}
