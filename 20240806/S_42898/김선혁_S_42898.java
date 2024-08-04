class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[n+1][m+1];
        // 웅덩이가 있는 부분 밑 또는 오른쪾은 어차피 못가기 때문에
        // 이 과정을 먼저해줌
        for(int i = 0;i<puddles.length;i++){
            int a = puddles[i][1];
            int b = puddles[i][0];
            dp[a][b] = -100;
        }
        for(int i = 1;i<=n;i++){
            if(dp[i][1] <0){
                break;
            }
            dp[i][1] = 1;
        }
         for(int i = 1;i<=m;i++){
             if(dp[1][i] <0){
                 break;
             }
            dp[1][i] = 1;
        }       
        // 테두리 부분은 모두 1로 채운상태로 시작하고
        // 물에잠긴지역은 -100으로 설정해놓는다.
      
        for(int i = 2;i<=n;i++){
            for(int j =2;j<=m;j++){
                // 음수가 아니라면 각 하나의 전항+1의 값을 넣음
                if(dp[i][j] >=0){
                    int ans = 0;
                    if(dp[i-1][j]>=0){
                        ans += dp[i-1][j];
                    }
                    if(dp[i][j-1]>=0){
                        ans += dp[i][j-1];
                    }
                    dp[i][j] = ans%1000000007;
                }
            }
        }
        
        return dp[n][m];
    }
}
