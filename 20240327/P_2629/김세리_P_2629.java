package _20240411;

import java.util.*;

public class _2629_양팔저울 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 추의 개수
        int[] weights = new int[n];
        for (int i=0;i<n;i++) {
            weights[i] = sc.nextInt();
        }
        
        // 추의 최대 무게가 500g이므로, 총 무게는 40000g을 넘지 않는다
        boolean[][] dp = new boolean[n+1][40001];
        dp[0][0] = true; // 초기값 설정

        for (int i=0;i<n;i++) {
            for (int j=0;j<=40000;j++) {
                if (dp[i][j]) {
                    dp[i+1][j] = true; // 이전 상태 그대로
                    
                    dp[i+1][Math.abs(j-weights[i])] = true; // 추를 한쪽에 놓는 경우
                    
                    if (j+weights[i]<=40000) {
                        dp[i+1][j+weights[i]] = true; // 추를 반대쪽에 놓는 경우
                    }
                }
            }
        }

        int m = sc.nextInt(); // 구슬의 개수
        StringBuilder sb = new StringBuilder();
        
        for (int i=0;i<m;i++) {
            int marble = sc.nextInt();
            if (marble>40000) {
                sb.append("N ");
            } else {
                sb.append(dp[n][marble] ? "Y " : "N ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
