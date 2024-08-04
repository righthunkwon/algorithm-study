import java.util.*;

class Solution {
    static class node {
        int x;
        int y;
        int cnt;
        node(int x, int y, int cnt){
            this.x = x;
            this.y =y;
            this.cnt = cnt;
        }
    }
    static Queue<node> q = new LinkedList<>();
    static int ans;
    static boolean[][] flag;
    public int solution(int[][] maps) {
        // bfs로 최단거리 찾으면 될듯
        // node에는 좌표와 현재까지의 거리 저장
        // 큐이용해서 구하기
        ans = -1;
        flag = new boolean[maps.length][maps[0].length];
        bfs(maps, maps.length, maps[0].length);
        return ans;
    }
    public static void bfs(int[][] maps, int N, int M){
        q.add(new node(0,0,1));
        // 0,0부터 시작 bfs
        while(true){
            if(q.size() ==0){
                break;
            }
            node n = q.poll();
            // System.out.println(n.x+" "+n.y+" "+n.cnt);
            // 만약 도착지점이거나 현재지점 방문했을 수도있음
            if(flag[n.x][n.y]){
                continue;
            }
            // 현재 위치 방문안했으면 방문처리 후
            // 현재지점이 도착지점인지 확인
            // bfs이기 때문에 나중에 나오면 어차피 지금보다 더늦음
            flag[n.x][n.y] = true;
            if(n.x == N-1 && n.y == M-1){
                ans = n.cnt;
                break;
            }
        
            for(int i = 0 ;i<dx.length;i++){
                int x  = n.x + dx[i];
                int y  = n.y + dy[i];
                if(x< 0 || y <0 || x>=N || y>=M || flag[x][y] || maps[x][y] == 0){
                    continue;
                }
                q.add(new node(x,y,n.cnt+1));
            }
        } // while
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
}
