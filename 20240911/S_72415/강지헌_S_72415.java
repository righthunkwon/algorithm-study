import java.util.*;
public class Solution {
    public static boolean[] use;
    public static Node[] permu;
    public static int min_ans = Integer.MAX_VALUE;
    public static Node[][] No;
    public static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public static int[][] bd;
    int solution(int[][] board, int r, int c) {
        int answer = 0;
        use = new boolean[7];
        No = new Node[7][2];
        bd = board;
        int num = 0;
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                if(board[i][j] != 0) {
                    num++;
                    if(No[board[i][j]][0] == null) No[board[i][j]][0] = new Node(i, j, board[i][j]);
                    else No[board[i][j]][1] = new Node(i, j, board[i][j]);
                }
            }
        }
        permu = new Node[num];
        dfs(0, num/2, r, c);
        answer = min_ans;
        return answer;
    }

    public static void dfs(int depth, int end, int r, int c){
        if(depth == end){
            int dis = bfs(r, c);
            min_ans = Math.min(min_ans, dis);
            return;
        }
        for(int i=1;i<=end;i++){
            if(use[i]) continue;
            permu[2*depth] = new Node(No[i][0].x, No[i][0].y, No[i][0].num);
            permu[2*depth+1] = new Node(No[i][1].x, No[i][1].y, No[i][1].num);
            use[i] = true;
            dfs(depth+1, end, r, c);
            permu[2*depth+1] = new Node(No[i][0].x, No[i][0].y, No[i][0].num);
            permu[2*depth] = new Node(No[i][1].x, No[i][1].y, No[i][1].num);
            dfs(depth+1, end, r, c);
            use[i] = false;
        }
    }
    public static int bfs(int r, int c){
        int dis = 0;
        int[][] copy = new int[4][4];
        for(int i=0;i<4;i++) copy[i] = bd[i].clone();
        int s_x = r;
        int s_y = c;
        for(Node node_p:permu){
            boolean[][] visited = new boolean[4][4];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{s_x, s_y, 0});
            visited[s_x][s_y] = true;
            while (!q.isEmpty()){
                int[] node = q.poll();
                if(node[0] == node_p.x && node[1] == node_p.y){
                    dis += (node[2]+1);
                    copy[node[0]][node[1]] = 0;
                    break;
                }
                for(int d=0;d<4;d++){
                    int nx = node[0] + dx[d];
                    int ny = node[1] + dy[d];
                    if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;

                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, node[2]+1});
                    }
                }
                for(int d=0;d<4;d++) {
                    int nx = node[0];
                    int ny = node[1];
                    while (true) {
                        nx += dx[d];
                        ny += dy[d];
                        if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
                            nx -= dx[d];
                            ny -= dy[d];
                            if(!visited[nx][ny]) {
                                visited[nx][ny] = true;
                                q.add(new int[]{nx, ny, node[2] + 1});
                            }
                            break;
                        }
                        if(copy[nx][ny] > 0){
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny, node[2]+1});
                            break;
                        }
                    }
                }
            }
            s_x = node_p.x;
            s_y = node_p.y;
        }
        return dis;
    }

}
class Node {
    int x, y, num;
    Node(int x, int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }
}
