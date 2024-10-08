class Solution {
    int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer={};
        answer=new int[queries.length];
        map=new int[110][110];
        int t=1;
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=columns;j++) map[i][j]=t++;
        }
        
        for(int l=0;l<queries.length;l++){
            int sx=queries[l][0],sy=queries[l][1],ex=queries[l][2],ey=queries[l][3],m=map[sx][sy];
            t=map[sx][sy];
            for(int i=sx;i<ex;i++){
                m=Math.min(m, map[i][sy]);
                map[i][sy]=map[i+1][sy];    
            }
            for(int i=sy;i<ey;i++){
                m=Math.min(m, map[ex][i]);
                map[ex][i]=map[ex][i+1];
            }
            for(int i=ex;i>sx;i--){
                m=Math.min(m, map[i][ey]);
                map[i][ey]=map[i-1][ey];
            }
            for(int i=ey;i>sy;i--){
                m=Math.min(m, map[sx][i]);
                map[sx][i]=map[sx][i-1];
            }
            map[sx][sy+1]=t;
            answer[l]=m;
        }
        return answer;
    }
}
