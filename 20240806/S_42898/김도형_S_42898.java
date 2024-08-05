class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int [][] dp = new int[n][m];
        
        //웅덩이 위치 입력
        for(int i=0;i<puddles.length;i++){
            dp[puddles[i][1]-1][puddles[i][0]-1]=-1;
        }
        
        // 시작 지점 초기화
        dp[0][0] = 1;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dp[i][j]==-1)continue; //웅덩이는 패스
                //dp[i-1][j] , dp[i][j-1] 중 양수인거만 더해줌 
                if(i>0&&dp[i-1][j]>0)dp[i][j]+=dp[i-1][j];
                if(j>0&&dp[i][j-1]>0)dp[i][j]+=dp[i][j-1];
                dp[i][j]%=1000000007;
            }
        }
        return dp[n-1][m-1];
    }
}
