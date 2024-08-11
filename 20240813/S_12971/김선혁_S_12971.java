import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        // dp문제
        // 1번째 or 2번째 스티커를 때면서 최대값 갱신
        int[][] dp = new int[2][sticker.length];
        int n = sticker.length;
        // 0번쨰는 1번을 포함할때
        // 1번째는 1x 2번포함할 때
        
        // 예외사항 n이 1부터 가능함 2일때는 두개중에서 하나 고름
        if(n==1){
            return sticker[0];
        }
        if(n==2){
            return Math.max(sticker[0] , sticker[1]);
        }
        dp[0][0] = sticker[0];
        dp[0][1] = sticker[0];
        
        dp[1][0] = 0;
        dp[1][1] = sticker[1];
       
        
        
        for(int i =2;i<sticker.length-1;i++){
            // 전에꺼와 2개전꺼에 지금+한거를 비교
            dp[0][i] = Math.max(dp[0][i-2] + sticker[i] , dp[0][i-1]);
            dp[1][i] = Math.max(dp[1][i-2] + sticker[i] , dp[1][i-1]);
        }
        // 마지막스티커계산
        dp[1][n-1] = Math.max(dp[1][n-3] + sticker[n-1] , dp[1][n-2]);
        dp[0][n-1] = dp[0][n-2];
        // 두개중 최대값 계산
        int answer = Math.max(dp[1][n-1] , dp[0][n-1]);
        return answer;
    }
}
