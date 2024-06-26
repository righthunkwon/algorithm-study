import java.io.*;
import java.util.*;

class Solution {
    static class Node{
        private int n,dep;
        public Node(int n,int dep){
            this.n=n;
            this.dep=dep;
        }
    }
    public int solution(int n, int[][] edge) {
        //bfs 하면 될 듯?
        visited=new boolean[n+1];
        arr=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=new ArrayList();
        }
        for(int i=0;i<edge.length;i++){
            int o=edge[i][0];
            int t=edge[i][1];
            arr[o].add(t);
            arr[t].add(o);
        }
        q=new LinkedList();
        visited[1]=true;
        q.add(new Node(1,0));
        bfs();
        return cnt;
    }
    public static void bfs(){
        int max=0;
        cnt=0;
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(max<curr.dep){
                cnt=1;
                max=curr.dep;
            }else if(max==curr.dep){
                cnt++;
            }
            for(Integer n: arr[curr.n]){
                if(visited[n]) continue;
                q.add(new Node(n,curr.dep+1));
                visited[n]=true;
            }
        }

    }
    static boolean[] visited;
    static List<Integer>[] arr;
    static Queue<Node> q;
    static int cnt;
}
