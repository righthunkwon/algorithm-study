package _20230913;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2589_보물섬 {
	//상, 우, 하, 좌
	static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] board;
    static int n, m;
    static boolean[][] visited;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        n = scan.nextInt();
        m = scan.nextInt();
        scan.nextLine();
        
        board = new char[n][m];
        for(int i = 0; i < n; i++) {
            String str = scan.nextLine();
            for(int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'L') {
                    visited = new boolean[n][m];
                    int len = bfs(i, j);
                    max = Math.max(max, len);
                }
            }
        }
        System.out.println(max);
    }//main
    
    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0));
        visited[x][y] = true;
        
        int len = 0;
        while(!q.isEmpty()) {
            Node current = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(visited[nx][ny] == false && board[nx][ny] == 'L') {
                        q.offer(new Node(nx, ny, current.cost + 1));
                        len = Math.max(len, current.cost + 1);
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return len;
    }//bfs
    
    public static class Node {
        int x;
        int y;
        int cost;
        
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }//node
}
