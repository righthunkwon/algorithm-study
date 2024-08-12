import java.io.*;
import java.util.*;

class Solution {
    int [] cnt;
    int n,m;
    boolean [][]visit;//bfs용 방문체크배열
    boolean [][]check;//count용 방문체크배열
    int []dx = {-1,0,1,0};
    int []dy = {0,1,0,-1};
    public int solution(int[][] land) {
        n = land.length; //세로
        m = land[0].length; //가로
        
        visit = new boolean[n][m];
        check = new boolean[n][m];
        
        cnt = new int[m]; //각 열을 선택했을 때 뽑을 수 있는 총 석유량 저장용
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j]==1&&!visit[i][j]){
                    bfs(land,i,j,cnt);
                }
            }
        }
        
        int answer = 0;
        for(int i=0;i<m;i++){
            answer = Math.max(answer,cnt[i]);
        }        
        return answer;
    }
    
    //각 석유들의 덩어리 크기 측정용 bfs
    public void bfs(int[][]land,int x,int y,int[]cnt){
        int oil = 1; //출발지점은 석유니까
        visit[x][y]=true;
        boolean []visitedCol = new boolean[m];
        Queue<Integer>qx = new LinkedList<>();
        Queue<Integer>qy = new LinkedList<>();
        visitedCol[y]=true;
        qx.add(x);
        qy.add(y);
        while(!qx.isEmpty()&&!qy.isEmpty()){
            int nowx = qx.poll();
            int nowy = qy.poll();
            for(int i=0;i<4;i++){
                int nx = nowx+dx[i];
                int ny = nowy+dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m)continue;//범위밖은 pass
                if(visit[nx][ny]||land[nx][ny]==0)continue;//방문했거나 석유아니면
                oil++;
                visit[nx][ny]=true;
                if(!visitedCol[ny])visitedCol[ny]=true;
                qx.add(nx);
                qy.add(ny);
            }
        }
        for(int i=0;i<m;i++){
            if(visitedCol[i])cnt[i]+=oil;
        }
        
    }
    
    
}
