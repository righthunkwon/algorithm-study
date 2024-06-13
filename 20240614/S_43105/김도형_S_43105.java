class Solution {
    public int solution(int[][] triangle) {
        
        int [][]dp = new int[501][501];
        
        int len = triangle.length; //삼각형 크기
        
        dp[0][0]=triangle[0][0];
        
        for(int i=1;i<len;i++){
            for(int j=0;j<=i;j++){ 
                if(j==0){//줄의 첫 숫자는 예외처리
                    dp[i][j]=dp[i-1][0]+triangle[i][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1])+triangle[i][j];
                }     
            }  
        }
        
        //dp맨 아랫줄에서 최대값 구하기
        int answer = 0;
        for(int i=0;i<len;i++){
            answer=Math.max(answer,dp[len-1][i]);
        }
        return answer;
    }
}
