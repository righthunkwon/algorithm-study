class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        // n x n 배열에 차레로 왼쪽 위에서 부터
        // 시계방향으로 숫자 하나씩 채우면됨
        int num = 1;
        // 1을 시작으로 동, 남, 서, 북 이방향으로 이동하고
        // 만약 숫자가 0이 아니거나 범위를 벗어나면 방향 전환
        int x = 0;
        int y = -1;
        int index = 0;
        while(true){
            int nx = x + dx[index];
            int ny = y + dy[index];
            if(nx >= n || ny >= n || nx < 0 || ny < 0 || answer[nx][ny] != 0){
                // 만약 벗어난 숫자면 x와y에서 index를 하나 증가시킨후에 다시 nx 와 ny를 구해야함
                index ++;
                index%= 4;
                nx = x + dx[index];
                ny = y + dy[index];
            }
            answer[nx][ny] = num++;
            // 해당 숫자를 넣은 후에는 x와 y를 갱신
            x = nx;
            y = ny;
            if(num > n*n){
                break;
            }
        }
        
        
        
        
        return answer;
    }
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
}
