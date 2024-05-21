import java.util.*;

class Solution {
    int solution(int[][] land) {
        // dfs해서 최대값 갱신
        // -> 실패 dp인듯
        int answer = 0;
        int x= land.length;
        int y= land[0].length;
        int[][] dp = new int[x][y];
        
          for (int j = 0; j < y; j++) {
            dp[0][j] = land[0][j];
        }
        // 일단 첫 좌표는 다 넣어놓음
        // 다음부터는 현재 위의 좌표 3개중에서 
        // 가장 큰 점수에서만 + 해서 저장

        for (int i = 1; i < x; i++) {
            dp[i][0] = land[i][0] + Math.max(Math.max(dp[i - 1][1], dp[i - 1][2]), dp[i - 1][3]);
            dp[i][1] = land[i][1] + Math.max(Math.max(dp[i - 1][0], dp[i - 1][2]), dp[i - 1][3]);
            dp[i][2] = land[i][2] + Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][3]);
            dp[i][3] = land[i][3] + Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
        }
        // 다 입력 넣으면 끝지점 최대값 갱신
        for (int j = 0; j < y; j++) {
            answer = Math.max(answer, dp[x - 1][j]);
        }
        
        
        
        return answer;
    }

}
