 //   | 2 1 1 1 | 3
 //   | 1 0 1 1 | 4
 // 2 | 1 1 1 2 |
 //       3 4
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int Big = 1000000007;
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
 
        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1; 
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 물웅덩이
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = (dp[i][j] + (i > 0 ? dp[i - 1][j] : 0) + (j > 0 ? dp[i][j - 1] : 0)) % Big;
            }
        }

        return dp[n - 1][m - 1];
    }
}