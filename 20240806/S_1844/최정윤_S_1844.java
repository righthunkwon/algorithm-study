import java.io.*;
import java.util.*;

class Solution {
    public static class Node{
        int r,c,d;
        public Node(int r,int c, int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    public int solution(int[][] maps) {
        map=maps;
        dr=new int[]{-1,1,0,0};
        dc=new int[]{0,0,1,-1};
        q=new LinkedList();
        visited=new boolean[maps.length][maps[0].length];
        visited[0][0]=true;
        q.add(new Node(0,0,1));
        answer = -1;
        bfs();
        return answer;
    }
//기본bfs
    public static void bfs(){
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr.r==map.length-1&&curr.c==map[0].length-1) {
                answer=curr.d;
                break;
            }
            for(int i=0;i<4;i++){
                int nr=curr.r+dr[i];
                int nc=curr.c+dc[i];
                if(nr<0||nc<0||nr>=map.length||nc>=map[0].length||visited[nr][nc]||map[nr][nc]==0) continue;
                q.add(new Node(nr,nc,curr.d+1));
                visited[nr][nc]=true;
            }
        }
    }
    static int [] dr,dc;
    static Queue<Node> q;
    static boolean[][] visited;
    static int[][] map;
    static int answer;
}
