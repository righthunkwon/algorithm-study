class Solution{
    public int solution(int [][]board){
        //완전탐색 -> 시간초과..
        //dp로 접근
        int max = 0;
        int r = board.length;
        int c = board[0].length;
        int s = Math.min(r,c);
        if(s==1)return 1;
        
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(board[i][j] == 1){
                    //해당 칸이 1이면 그 칸의 왼쪽위, 위, 왼쪽 칸 중 가장 작은 값 + 1 을 재할당
                    //그 값이 해당 칸을 우측하단 꼭지점으로하는 정사각형의 변의 길이중 가장 큰 값이 됨
                    board[i][j] = Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1])+1;
                    max = Math.max(max, board[i][j]);
                }
            }
        }
        return max*max; //정사각형 넓이니까
    }
}
