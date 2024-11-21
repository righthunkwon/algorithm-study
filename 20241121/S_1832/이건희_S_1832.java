class Solution {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m][n][2];

        for (int j = 0; j < n; j++) {
            if (cityMap[0][j] == 1) {
                break;
            }
            dp[0][j][0] = 1;
            dp[0][j][1] = 0;
        }

        for (int i = 0; i < m; i++) {
            if (cityMap[i][0] == 1) {
                break;
            }
            dp[i][0][1] = 1;
            dp[i][0][0] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cityMap[i][j] == 1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                } else {
                    dp[i][j][0] = dp[i][j - 1][0];
                    if (cityMap[i][j - 1] == 0) {
                        dp[i][j][0] = (dp[i][j][0] + dp[i][j - 1][1]) % MOD;
                    }

                    dp[i][j][1] = dp[i - 1][j][1];
                    if (cityMap[i - 1][j] == 0) {
                        dp[i][j][1] = (dp[i][j][1] + dp[i - 1][j][0]) % MOD;
                    }
                }
            }
        }

        int answer = (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD;
        return answer;
    }
}

// class Solution {
//     int MOD = 20170805;
//     public int solution(int m, int n, int[][] cityMap) {
//         int[][] dp = new int[m][n];
//         dp[0][0] = 1;

//          for (int j = 1; j < n; j++) {
//             if (cityMap[0][j] == 1) dp[0][j] = 0;
//             else dp[0][j] = dp[0][j - 1];
//         }

//         for (int i = 1; i < m; i++) {
//             if (cityMap[i][0] == 1) dp[i][0] = 0;
//             else dp[i][0] = dp[i - 1][0];
//         }
        
//         for (int i = 1; i < m; i++) {
//             for (int j = 1; j < n; j++) {
//                 if (cityMap[i][j] == 1) {
//                     dp[i][j] = 0;
//                 } else if (cityMap[i][j] == 2) {
//                     if (cityMap[i - 1][j] == 2) dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
//                     if (cityMap[i][j - 1] == 2) dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
//                 } else {
//                     dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
//                 }
//             }
//         }

//         return dp[m - 1][n - 1];
//     }
// }
// 거리 누적합으로 해결