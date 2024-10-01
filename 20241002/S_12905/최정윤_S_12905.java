class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        //dp 같은디 ...
        //사각형 위, 왼쪽, 대각선 중 최솟값+1 값이 내가 만들 수 있는 최대 정사각형
        int[][] dp=new int[board.length][board[0].length];
        
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0||j==0) {
                    dp[i][j]=board[i][j];
                    answer=Math.max(dp[i][j],answer);
                    continue;
                }
                if(board[i][j]==1){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    answer=Math.max(dp[i][j],answer);
                }
            }
        }

        return answer*answer;
    }
}
