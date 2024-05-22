import java.io.*;
import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int l=land.length;
        int[][] dp=new int[l][4];
        dp[0]=land[0];
        for(int i=1;i<l;i++){
            for(int j=0;j<4;j++){
                dp[i][j]=Math.max(Math.max(dp[i-1][(j+1)%4],dp[i-1][(j+2)%4]),dp[i-1][(j+3)%4])+land[i][j];
            }
        }
        
        answer=Math.max(Math.max(Math.max(dp[l-1][0],dp[l-1][1]),dp[l-1][2]),dp[l-1][3]);
        return answer;
    }
}
