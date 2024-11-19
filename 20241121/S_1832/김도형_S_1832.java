class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        //(y,x)좌표에 갈 수 있는 경우의 수
        //단, 이전에 왼쪽에서 온 경우와 위에서 온 경우 2가지로 나눠서 저장
        int [][][] dp = new int [m][n][2]; 
        dp[0][0][0]=1; //0은 위->아래로 온 경우
        dp[0][0][1]=1; //1은 왼쪽->오른쪽으로 온 경우
        for(int i=1;i<m;i++){
            if(cityMap[i][0]==1)break;//통행 금지 구역 나올때까지 1로 채우기(시작점->아래 이동)
            dp[i][0][0]=1;
        }
        for(int i=1;i<n;i++){
            if(cityMap[0][i]==1)break;//통행 금지 구역 나올때까지 1로 채우기(시작점->우측 이동)
            dp[0][i][1]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(cityMap[i][j]==1)continue; //통행금지구역인 경우

                if(cityMap[i-1][j]==2){ //위가 회전금지구역인 경우
                    dp[i][j][0]=dp[i-1][j][0];
                }else{
                    dp[i][j][0]=(dp[i-1][j][1]+dp[i-1][j][0])%MOD;
                }
                
                if(cityMap[i][j-1]==2){ //왼쪽이 회전금지구역인 경우
                    dp[i][j][1]=dp[i][j-1][1];
                }else{
                    dp[i][j][1]=(dp[i][j-1][1]+dp[i][j-1][0])%MOD;
                }
            }
        }
        answer = (dp[m-1][n-1][0]+dp[m-1][n-1][1])%MOD;        
        return answer;
    }
}
