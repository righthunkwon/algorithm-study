class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m][n][2];
        
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // 통행 금지
                if(cityMap[i][j] == 1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                    continue;
                }
                // 위 -> 아래
                if(i > 0) {
                    if(cityMap[i-1][j] == 2) dp[i][j][0] = dp[i-1][j][0]; // 직진
                    else dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1]) % MOD;
                }
                // 왼 -> 오
                if(j > 0) {
                    if(cityMap[i][j-1] == 2) dp[i][j][1] = dp[i][j-1][1]; // 직진
                    else dp[i][j][1] = (dp[i][j-1][0] + dp[i][j-1][1]) % MOD;
                }
            }
        }
        
        return (dp[m-1][n-1][0] + dp[m-1][n-1][1]) % MOD;
    }
}
