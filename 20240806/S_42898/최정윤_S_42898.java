class Solution {
    public int solution(int m, int n, int[][] puddles) {
        //맨 윗줄, 맨 왼쪽 채우고 상,좌 더한 값
        int[][] dp=new int[n+1][m+1];
        //puddles먼저 -1로 채우기
        for(int i=0;i<puddles.length;i++){
            dp[puddles[i][1]][puddles[i][0]]=-1;
        }
       
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==1&&j==1){
                    dp[i][j]=1;
                    continue;
                }
                if(dp[i][j]==-1)dp[i][j]=0;
                else dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000007;
            }
        }
        int answer = dp[n][m];
        return answer;
    }
}
