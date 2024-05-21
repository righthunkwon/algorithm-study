import java.util.*;
class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n+1][4];
        for(int i=1;i<=n;i++) {
            for(int j=0;j<4;j++) dp[i][j]=land[i-1][j];         
        }
        for(int i = 1; i < n+1; i++){
            for(int j=0;j<4;j++) dp[i][j]+=Math.max(Math.max(dp[i-1][(j+1)%4],dp[i-1][(j+2)%4]),dp[i-1][(j+3)%4]);
        }
        Arrays.sort(dp[n]);
        return dp[n][3];
    }
}
