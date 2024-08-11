import java.io.*;
import java.util.*;
//dfs??

//시작 지점, 끝 지점 저장 후 dfs로 16가지 경우의 수 
//이 때 도착한 것은 움직이지 않도록 주의 
class Solution {
    public int solution(int[][] maze) {
        this.maze=maze;
        dr=new int[]{-1,1,0,0};
        dc=new int[]{0,0,-1,1};
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                if(maze[i][j]==1){
                    st_r=new int[]{i,j};       
                }else if(maze[i][j]==2){
                    st_b=new int[]{i,j};
                }else if(maze[i][j]==3){
                    ed_r=new int[]{i,j};
                }else if(maze[i][j]==4){
                    ed_b=new int[]{i,j};
                }
            }
        }
        min=Integer.MAX_VALUE;
        int answer = 0;
        v_r=new boolean[maze.length][maze[0].length];
        v_b=new boolean[maze.length][maze[0].length];
        v_r[st_r[0]][st_r[1]]=true;
        v_b[st_b[0]][st_b[1]]=true;
        dfs(st_r,st_b,0);
        if(min!=Integer.MAX_VALUE)answer=min;
        return answer;
    }
    static void dfs(int[] r,int[] b, int depth){
        boolean r_fin,b_fin;
        if(r[0]==ed_r[0]&&r[1]==ed_r[1]){//빨강 도착?
            r_fin=true;
        }else r_fin=false;
        if(b[0]==ed_b[0]&&b[1]==ed_b[1]){//파랑 도착?
            b_fin=true;
        }else b_fin=false;
       if(r_fin&&b_fin){//둘 다 도착 ? 최소값 갱신
            min=Math.min(min,depth);
            return;
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                int r_nr,r_nc;
                if(r_fin){//이미 빨강이 도착했다면 i는 필요없다 
                    i+=1;
                    r_nr=r[0];
                    r_nc=r[1];
                }
                else{ //도착하지 않았다면 새로운 좌표 생성, 벽, 방문, 격자벗어났는지 예외처리
                     r_nr=r[0]+dr[i];
                     r_nc=r[1]+dc[i];
                
                     if(r_nr<0||r_nc<0||r_nr>=maze.length||r_nc>=maze[0].length||v_r[r_nr][r_nc]||maze[r_nr][r_nc]==5) continue;
                }
                int b_nr,b_nc;
                if(b_fin){
                    j+=3;
                    b_nr=b[0];
                    b_nc=b[1];
                }else{
                    b_nr=b[0]+dr[j];
                    b_nc=b[1]+dc[j];
                
                    if(b_nr<0||b_nc<0||b_nr>=maze.length||b_nc>=maze[0].length||v_b[b_nr][b_nc]||maze[b_nr][b_nc]==5) continue;
                }
                if(r_nr==b_nr&&r_nc==b_nc)continue; //움직인 이후 겹칠 경우
                if(r_nr==b[0]&&r_nc==b[1]&&b_nr==r[0]&&b_nc==r[1])continue;  // 빨파 위치를 교체할 경우 
                v_r[r_nr][r_nc]=true;
                v_b[b_nr][b_nc]=true;
                dfs(new int[]{r_nr,r_nc},new int[]{b_nr,b_nc},depth+1);
                if(!r_fin)v_r[r_nr][r_nc]=false;
                if(!b_fin)v_b[b_nr][b_nc]=false;
            }
        }
    }
    static int min;
    static int[] dr,dc,ed_r,ed_b,st_r,st_b;
    static int[][] maze;
    static boolean[][] v_r,v_b;
}
