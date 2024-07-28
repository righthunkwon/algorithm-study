import java.util.*;
class Solution {
    class node implements Comparable<node> {
        int en;
        int cost;
        node(int en, int cost){
            this.en = en;
            this.cost = cost;
        }
        // 오름차순으로 정렬하게
        @Override
        public int compareTo(node o) {
            return this.cost - o.cost;
        }
    }
    static ArrayList<node>[] ar;
    
    public int solution(int n, int[][] costs) {
        int ans = 0;
        ar = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            ar[i] = new ArrayList<node>();
        }
        // 크루스칼..?
        // 현재 점을 하나 정하고서
        // 그 점을 기준으로 방문안한 점은 모두 우선순위 큐에 넣고
        // 꺼낼때마다 ans에 더하기
        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            ar[a].add(new node(b,c));
            ar[b].add(new node(a,c));
        }
        boolean[] visited = new boolean[n];
        PriorityQueue<node> pq = new PriorityQueue<>();
        // 우선 0부터시작
        pq.add(new node(0, 0));
        while(!pq.isEmpty()) {
            // 큐에서 하나 꺼내서
            // 현재점이 방문했는지
            // 체크하고 방문안했으면
            // 그점에서 이어지는점 탐색
            node now = pq.poll();
            
            if(visited[now.en]){
              continue;
            } 
            visited[now.en] = true;
            ans += now.cost;
            // 현재점에서 리스트에있는것들 탐색
            for(int i = 0; i < ar[now.en].size(); i++) {
                int en = ar[now.en].get(i).en;
                int cost = ar[now.en].get(i).cost;
                if(visited[en]) continue;
                pq.add(new node(en, cost));
            }
        }
        return ans;
    }
}
