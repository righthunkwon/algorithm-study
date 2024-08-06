class Solution {
    public int[] solution(int n) {
        
        int [][] map = new int[n][n];
        int num = 1;
        map[0][0]=num;
        num++;
        int x=0;
        int y=0;
        
        //n이 1인 경우엔 1만 배열로 리턴해주고 끝내기
        if(n==1)return new int[] {1};
        
        l:while(true){
            //아래로 채우기
            while(x+1<n&&map[x+1][y]==0){
                map[x+1][y]=num++;
                if(num>(n*(n+1))/2)break l;
                x++;
            }
            //오른쪽으로 채우기
            while(y+1<n&&map[x][y+1]==0){
                map[x][y+1]=num++;
                if(num>(n*(n+1))/2)break l;
                y++;
            }
            //대각선 채우기(좌상향)
            while(map[x-1][y-1]==0){
                map[x-1][y-1]=num++;
                if(num>(n*(n+1))/2)break l;
                x--;
                y--;
            }
        }
        
        //정답배열
        int[] answer = new int[(n*(n+1))/2];
        
        int idx = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                answer[idx++]=map[i][j];
            }
        }
        
        
        return answer;
    }
}
