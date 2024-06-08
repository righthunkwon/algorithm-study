import java.io.*;
import java.util.*;
//뭔가 거꾸로 해도 좋았을듯?!
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int r=triangle.length;
        int c=triangle[triangle.length-1].length;
        int[][] dp=new int[r][c];
        dp[0][0]=triangle[0][0];
        for(int i=1;i<r;i++){
            for(int j=0; j<triangle[triangle[i].length-1].length; j++){
                if(j==0) dp[i][j]=dp[i-1][j]+triangle[i][j];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1])+triangle[i][j];
            }
        }
        
        for(int i=0;i<triangle[r-1].length;i++){
            answer=Math.max(answer,dp[r-1][i]);
        }
        return answer;
    }
}
