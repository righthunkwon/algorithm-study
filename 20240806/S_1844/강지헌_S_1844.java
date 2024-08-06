import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n=maps.length,m=maps[0].length;
        int[] xx={-1,0,1,0},yy={0,1,0,-1};
        boolean[][] chk = new boolean[n][m];
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(0,0,1));
        chk[0][0]=true;
        while(!Q.isEmpty()) {
            Node t = Q.poll();
            for(int i=0;i<4;i++) {
                int dx=t.x+xx[i],dy=t.y+yy[i];
                if(dx<0 || dx>=n || dy<0 || dy>=m || maps[dx][dy]==0 || chk[dx][dy]) continue;
                if(dx==n-1 && dy==m-1) {
                    return t.c+1;
                }
                chk[dx][dy]=true;
                Q.add(new Node(dx,dy,t.c+1));
            }
        }
        return -1;
    }
}
class Node {
    int x,y,c;
    Node(int x,int y,int c) {
        this.x=x;
        this.y=y;
        this.c=c;
    }
}
