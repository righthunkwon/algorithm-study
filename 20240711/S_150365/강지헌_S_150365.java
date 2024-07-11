import java.util.*;
class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int[] xx = {1, 0, 0, -1}, yy = {0, -1, 1, 0};
        boolean[][][] chk = new boolean[n][m][k+1];
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(x-1,y-1,new StringBuilder()));
        chk[x-1][y-1][0]=true;
        while(!Q.isEmpty()) {
            Node no = Q.poll();
            if(no.x==r-1 && no.y==c-1 && no.sb.toString().length()==k) return no.sb.toString();
            if(no.sb.toString().length()==k) continue;
            for(int i=0;i<4;i++) {
                int dx=no.x+xx[i],dy=no.y+yy[i];
                if(dx<0 || dy<0 || dx>=n || dy>=m || chk[dx][dy][no.sb.toString().length()+1]) continue;
                chk[dx][dy][no.sb.toString().length()+1]=true;
                Q.add(new Node(dx,dy,new StringBuilder(no.sb).append(dir(i))));
            }
        }
        return "impossible";
    }
    public char dir(int d) {
        if(d==0) return 'd';
        else if(d==1) return 'l';
        else if(d==2) return 'r';
        else return 'u';
    }
}

class Node {
    int x, y;
    StringBuilder sb;
    Node(int x, int y, StringBuilder sb) {
        this.x = x;
        this.y = y;
        this.sb = sb;
    }
}
