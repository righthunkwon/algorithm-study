import java.util.*;
import java.io.*;

class Solution {
    //프림알고리즘 이용
    //정점고르고 가장 비용이 적게드는 간선을 고른다
    public static class Node implements Comparable<Node> {
        int e, c;
        
        public Node(int e, int c) {
            this.e = e;
            this.c = c;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }
    
    
    
    public int solution(int n, int[][] costs) {
        answer = 0;
        arr=new ArrayList[n];
        for(int i = 0; i < n; i++) {
            arr[i]=new ArrayList();
        }
        for (int i=0;i <costs.length;i++) {
            int st = costs[i][0];
            int ed = costs[i][1];
            int c = costs[i][2];
            arr[st].add(new Node(ed, c));
            arr[ed].add(new Node(st, c));
        }
        visited = new boolean[n];
        pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        prim();
        
        return answer;
    }
    public static void prim(){
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            
            if(visited[curr.e]) continue;
            visited[curr.e] = true;
            answer += curr.c;
            
            for(Node node : arr[curr.e]) {
                if(visited[node.e]) continue;
                pq.add(new Node(node.e, node.c));
            }
        }
    }
    static List<Node>[] arr;
    static PriorityQueue<Node> pq;
    static boolean[] visited;
    static int answer;
}
