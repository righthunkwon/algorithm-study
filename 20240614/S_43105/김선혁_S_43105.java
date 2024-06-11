import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        // dfs로 최대값 갱신 -> 시간초과
        // -> dp로 풀어야함
        int ans = 0;
        // 현재 위치의 삼각형합은 전의 값 
        int dp[][] = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        // 맨첫지점은 0,0지점 값으로 넣어놓고 시작
        for(int i = 1 ;i<triangle.length;i++){
            // 맨 왼쪽 값은 그대로 1자값 넣으면 됨
            // 맨오른쪽도 마찬가지
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
            
            // 가운데는 점화식 왼쪽위와 오른쪽위의 최대값
            // 뒤에서는 못오기때문에 i전까지만
            for(int j=1;j<=i;j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }
        // 이거 다한 후에 최대값 찾아야함 맨밑에서
        for(int i =0;i<triangle.length;i++){
         ans = Math.max(ans, dp[triangle.length-1][i]);   
        }
        return ans;
    }

    
}
