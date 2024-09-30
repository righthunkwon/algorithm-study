class Solution{
    public int solution(int [][]board){
        int answer = 0;
        // 해당 점을 기준으로 밑과 오른쪽으로 넓혀가는 방식으로
        int[][] dp = new int[board.length][board[0].length];
        // 우선 맨끝쪽은 board값을 그대로 가져옴
        for(int i = 0;i<board.length;i++){
            dp[i][0] = board[i][0];
        }
        for(int j = 0;j<board[0].length;j++){
            dp[0][j] = board[0][j];
        }
        
        for(int i = 1;i<board.length;i++){
            for(int j = 1;j<board[0].length;j++){
                if(board[i][j]== 0) continue;
                // 해당 점에서 시작
                // 이문제는 dp로 해당 점에서 왼쪽 오른쪽 대각선왼쪽위 3개중에 최소값 +1 한 값이 해당 블럭까지의 연속값임
                dp[i][j] = Math.min(dp[i][j-1] , Math.min(dp[i-1][j] , dp[i-1][j-1])) +1;
                // 현재 board에 있는 값은 가로 세로 모두 반영된 연속값
            }
        }
        
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                answer = Math.max(answer, dp[i][j]);
            }
        }
        

        return answer* answer;
    }
}
