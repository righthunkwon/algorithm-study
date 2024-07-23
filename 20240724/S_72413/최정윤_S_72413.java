import java.io.*;
import java.util.*;

class Solution {
    static int n;
    static List<Edge>[] arr;
    static boolean[] visited;
    static PriorityQueue<Edge> pq;
    
    public static class Edge implements Comparable<Edge>{
        int e, p;
        public Edge(int e,int p){
            this.e=e;
            this.p=p;
        }
        public int compareTo(Edge e){
            return this.p-e.p;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        //출발지에서 각 지점까지의 최소비용 계산, 
        //각 지점에서부터 A와 B의 최소비용 계산
        //이 중 최솟값이 정답
        arr=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=new ArrayList();
        }
        for(int i=0;i<fares.length;i++){
            int st=fares[i][0];
            int ed=fares[i][1];
            int pay=fares[i][2];
            arr[st].add(new Edge(ed,pay));
            arr[ed].add(new Edge(st,pay));
        }
        //출발지에서 각 지점까지의 최소비용 계산
        this.n=n;
        int[] dist1=dijk(s);

        int min=Integer.MAX_VALUE;
        //각 지점에서 a,b까지의 최소거리 구하기
        for(int i=1;i<n+1;i++){
            if(dist1[i]==Integer.MAX_VALUE) continue;
            int[] dist2=dijk(i);
            min=Math.min(dist1[i]+dist2[a]+dist2[b],min);
        }
        int answer = min;
        return answer;
    }
  
    public static int[] dijk(int s){
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq=new PriorityQueue();
        visited=new boolean[n+1];
        dist[s]=0;
        pq.add(new Edge(s,0));
        
        while(!pq.isEmpty()){
            Edge curr=pq.poll();
            int now=curr.e;
            if(visited[now]) continue;
            visited[now]=true;
            for(Edge edge:arr[now]){
                if(!visited[edge.e]&&dist[now]+edge.p<dist[edge.e]){
                    dist[edge.e]=dist[now]+edge.p;
                    pq.add(new Edge(edge.e,dist[edge.e]));
                }
            }
        }
        
        return dist;
    }
}
