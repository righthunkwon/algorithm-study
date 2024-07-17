class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        // 이상태에서 skill발동때마다 board 변화하면 시간초과
        // 기록해놓고 한번에 바꾸는 방식..
        // 범위형태로 주어지니깐..
        // 해당 범위 시작점에 +힘 만큼 해놓고 , 그범위 +1지점 두개에 -해놓고 교차부분 +해놓으면 될듯
        int[][] sum = new int[board.length+1][board[0].length+1];
        // 끝점까지일경우 인덱스오류 때매 +1까지 선언
        for(int i = 0 ;i<skill.length;i++){
            int a = skill[i][1];
            int b = skill[i][2];
            int c = skill[i][3];
            int d = skill[i][4];
            int power = skill[i][5];
            // 0번쨰가 1이면 -로바꿈
            if(skill[i][0] == 1){
                power *= -1;
            }
            // 이제 범위 기록
            sum[a][b] += power;
            sum[c+1][d+1] += power;
            sum[a][d+1] -= power;
            sum[c+1][b] -= power;
        }
        // 기록한거 토대로 사이에 있는 블록들에도 값 넣어줌
        
        // 전에 블록꺼에서 값을 가져와야해서 1부터(0은 어차피 그대로)
        // 위아래
        for(int i = 1;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                sum[i][j] += sum[i-1][j];
            }
        }
        // 좌우
        for(int j = 1;j<board[0].length;j++){
            for(int i =0;i<board.length;i++){
                sum[i][j] += sum[i][j-1];
            }
        }
        // 이제 board에 반영      
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                board[i][j] += sum[i][j];
                if(board[i][j] >0){
                    answer ++;
                }
            }
        }
        
        return answer;
    }
}
