class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][] cityMap2 = new int[m+1][n+1];
        for(int i = 0 ; i<m;i++){
            for(int j = 0;j<n;j++){
                cityMap2[i][j] = cityMap[i][j];
            }
        }
        // dp 방식으로 해당 좌표가 0일경우에는 두개의 값을 더하고
        // 1인경우에는 아예 불가능
        // 2인 경우에는 해당 좌표와 그방향으로 다음 좌표가 가능하다면 두개다 기록, 불가능하면 x
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;

        // 0일때만 수직으로 이동이 가능해서 각 끝좌표에
        // 1을 다 넣어놓는다
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                dp[i][j] %= 20170805;
                System.out.println(i+" "+j+" "+dp[i][j]+" "+cityMap2[i][j]);
                if(cityMap2[i+1][j] == 2){
                    dp[i+1][j] = 0;
                }
                else if (cityMap2[i+1][j] ==1){
                       dp[i+2][j] += dp[i][j];
                }
                else{
                    dp[i+1][j] += dp[i][j];
                }
                
                if(cityMap2[i][j+1] == 2){
                    dp[i][j+1] = 0;
                }
                else if(cityMap2[i][j+1] ==1){
                    dp[i][j+2]+= dp[i][j];
                }
                else{
                    dp[i][j+1] += dp[i][j];
                }
            }
        }
        answer = dp[m-1][n-1]%20170805;
        
        
        
        return answer;
    }
}
