import java.io.*;
import java.util.*;

class Solution {
    public static class Node implements Comparable<Node>{
        int r,c,d;
        String str;
        public Node(int r,int c,int d,String str){
            this.r=r;
            this.c=c;
            this.d=d;
            this.str=str;
        }
        public int compareTo(Node o){
            return this.d-o.d;
        }
        
    }
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        n1=n;
        m1=m;
        r1=r;
        c1=c;
        k1=k;
        dr=new int[]{0,0,-1,1};
        dc=new int[]{-1,1,0,0};
        dstr=new String[]{"l","r","u","d"};
        pq=new PriorityQueue();
        pq.add(new Node(x,y,0,""));
        bfs();
        String answer = "impossible";
        if(list.size()>0){
            Collections.sort(list);
            answer=list.get(0);
        }
        return answer;
    }
    public static void bfs(){
        list=new ArrayList();
        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(n.d==k1&&n.r==r1&&n.c==c1){
                list.add(n.str);
            }
            if(n.d>k1) return;
            for(int i=0;i<4;i++){
                int nr=n.r+dr[i];
                int nc=n.c+dc[i];
                if(nr<1||nc<1||nr>n1||nc>m1)continue;
                pq.add(new Node(nr,nc,n.d+1,n.str+dstr[i]));
            }
        }
    }
    static int[] dr,dc;
    static String[] dstr;
    static PriorityQueue<Node> pq;
    static int n1,m1,k1,r1,c1;
    static List<String> list;
}
