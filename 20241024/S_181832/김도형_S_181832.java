class Solution{
    public int[][] solution(int n){
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        int [][] answer = new int[n][n];
        int x=0;
        int y=0;
        int dir=0; //이동 방향 설정용
        for(int i=1;i<=n*n;i++){
            answer[x][y]=i;
            //범위 벗어나거나 0이 아닌 숫자 이미 채워져있으면 방향전환
            if(x+dx[dir]>=n ||y+dy[dir]>=n ||x+dx[dir]<0 ||y+dy[dir]<0 ||answer[x+dx[dir]][y+dy[dir]]!=0)dir=(dir+1)%4;
            x+=dx[dir];
            y+=dy[dir];
        }
        return answer;
    }
    
}
