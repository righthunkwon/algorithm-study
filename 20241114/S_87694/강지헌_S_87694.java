import java.util.*;
class Solution {
    public int solution(int[][] rectangle,int characterX,int characterY,int itemX,int itemY){
        int[] xx={-1,1,0,0},yy={0,0,-1,1};
        int[][] map=new int[102][102]; 
        for (int[] v : rectangle) {
            int x1=v[0]*2,y1=v[1]*2,x2=v[2]*2,y2=v[3]*2;
            for(int i=x1; i<=x2; i++) {
                for(int j=y1; j<=y2; j++) {
                     if(i==x1 || i==x2 || j==y1 || j==y2 ) {
                         if(map[i][j]==0) map[i][j]=1;
                     }
                     else map[i][j]=-1;
                }
            }
        }
        Queue<int []> q=new LinkedList<>(); 
        q.offer(new int [] {characterX*2,characterY*2,0});
        map[characterX*2][characterY*2]=-1;
        while(!q.isEmpty()) {
            int[] t=q.poll();
            int nx=t[0],ny=t[1],dist=t[2];
            if(nx==itemX*2 && ny==itemY*2) return dist/2;
            for(int i=0; i<4; i++) {
                int dx=nx+xx[i],dy=ny+yy[i];
                if(dx<0 || dy<0 || dx>=map.length|| dy>=map.length) continue;
                if(map[dx][dy]==1) {
                    map[dx][dy]=-1;
                    q.add(new int[] {dx,dy,dist+1});
                }
            }
        }
        return -1;
    }
}
