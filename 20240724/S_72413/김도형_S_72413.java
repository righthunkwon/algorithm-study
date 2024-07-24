import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dp = new int[n + 1][n + 1]; // n+1 크기의 2차원 배열 생성 (도시 번호는 1부터 n까지 사용)

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 20000001); // 초기 비용을 최대값으로 설정
            dp[i][i] = 0; // 자기 자신으로 가는 비용은 0
        }

        // 주어진 택시 요금을 dp에 적용
        for (int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];

            dp[start][end] = cost; 
            dp[end][start] = cost; 
        }

        // 플로이드-워셜 알고리즘 적용: 모든 쌍의 최단 거리를 구함
        for (int k = 1; k < n + 1; k++) { // 경유지
            for (int i = 1; i < n + 1; i++) { // 출발지
                for (int j = 1; j < n + 1; j++) { // 도착지
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]); // i에서 j로 가는 최단 거리를 갱신
                }
            }
        }

        // 일단 각자 따로 가는 경우를 답으로 해놓고
        int answer = dp[s][a] + dp[s][b];

        // 경유지를 통해 가는 경우가 더 싸면 갱신
        // s -> i -> a, s -> i -> b의 비용을 계산하여 최소값으로 갱신
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, dp[s][i] + dp[i][a] + dp[i][b]);
        }

        return answer;
    }
}
