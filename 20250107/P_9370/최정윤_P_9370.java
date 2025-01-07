import java.io.*;
import java.util.*;

public class Main {
   public static class Node implements Comparable<Node>{
      int ed,dist;
      public Node(int ed,int dist) {
         this.ed=ed;
         this.dist=dist;
      }
      public int compareTo(Node node){
          return this.dist - node.dist; // ㅇㅗㄹㅡㅁㅊㅏㅅㅜㄴ
      } 
   }
   static PriorityQueue<Node> pq; 
   static List<Node>[] arr; 

   public static void main(String[] args) throws IOException {
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      int T=Integer.parseInt(br.readLine());
      StringTokenizer st;
      
      for(int tc=1; tc<=T; tc++) {
         st=new StringTokenizer(br.readLine());
         int n=Integer.parseInt(st.nextToken());
         int m=Integer.parseInt(st.nextToken());
         int t=Integer.parseInt(st.nextToken());
         
         st=new StringTokenizer(br.readLine());
         int s=Integer.parseInt(st.nextToken());
         int g=Integer.parseInt(st.nextToken());
         int h=Integer.parseInt(st.nextToken());
         
         arr=new ArrayList[n+1];
         for(int i=1; i<=n; i++) {
            arr[i]=new ArrayList<>();
         }
         
         int gh=0;
         for(int i=0; i<m; i++) {
            st=new StringTokenizer(br.readLine());
            int one=Integer.parseInt(st.nextToken());
            int two=Integer.parseInt(st.nextToken());
            int dist=Integer.parseInt(st.nextToken());
            arr[one].add(new Node(two,dist));
            arr[two].add(new Node(one,dist));
            if((one==g && two==h) || (one==h && two==g)){
                gh=dist;
            }
         }
         
         PriorityQueue<Integer> list=new PriorityQueue<>(); 
         for(int i=1; i<=t; i++){
             list.add(Integer.parseInt(br.readLine()));
         }
  
         // 다익스트라 실행
          
          
         //s- g + g-h+ h-끝점
         //s-h +h-g +g-끝점
         //s-끝점 
         pq = new PriorityQueue<>();
         pq.add(new Node(s, 0));
         boolean[] visited_s_ed = new boolean[n+1];
         int[] dist_s = new int[n+1];
         Arrays.fill(dist_s, Integer.MAX_VALUE);
         dist_s[s] = 0; 
         dijk(visited_s_ed, dist_s);
         //g-끝
         pq.add(new Node(g, 0));
         boolean[] visited_g_ed = new boolean[n+1];
         int[] dist_g = new int[n+1];
         Arrays.fill(dist_g, Integer.MAX_VALUE); 
         dist_g[g] = 0;  
         dijk(visited_g_ed, dist_g);
          //h-끝
         pq.add(new Node(h, 0));
         boolean[] visited_h_ed = new boolean[n+1];
         int[] dist_h = new int[n+1];
         Arrays.fill(dist_h, Integer.MAX_VALUE); 
         dist_h[h] = 0; 
         dijk(visited_h_ed, dist_h);
          
         // 후보지 확인
          //s-g + gh+ g-끝== s-끝
         while(!list.isEmpty()) {
             int e = list.poll(); 
             if (e <= n && 
                (dist_s[e] == dist_s[g] + gh + dist_h[e] || 
                 dist_s[e] == dist_s[h] + gh + dist_g[e])) {
                 System.out.print(e + " ");
             }
         }
         System.out.println();
      }
   }

   public static void dijk(boolean[] visited, int[] dist) {
      while(!pq.isEmpty()) {
         Node curr = pq.poll();
         if(visited[curr.ed]) continue; 
         visited[curr.ed] = true; 
         for(Node node : arr[curr.ed]) {
             if(dist[node.ed] > dist[curr.ed] + node.dist) {
                 dist[node.ed] = dist[curr.ed] + node.dist;
                 pq.add(new Node(node.ed, dist[node.ed]));
             }
         }
      }
   }
}