// BFS 시간초과
import java.util.*;
class Solution {
    // BFS에서 이동할 방향: 오른쪽, 아래, 대각선 아래
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};

    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int max = 0; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    int length = bfs(board, i, j);
                    max = Math.max(max, length);
                }
            }
        }
        return max * max;
    }
    
    private int bfs(int[][] board, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        int size = 1; 

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int px = point[0];
            int py = point[1];

            boolean toggle = true;
            for (int i = 0; i < 3; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                if (nx >= board.length || ny >= board[0].length || board[nx][ny] != 1) {
                    toggle = false;
                    break;
                }
            }
            if (toggle) {
                size++;
                queue.offer(new int[]{px + 1, py + 1});
            } else {
                break;
            }
        }
        return size;
    }
}
//DP 문제였구나......
public class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int r = board.length;
        int c = board[0].length;
        
        int[][] map = new int[r + 1][c + 1];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i + 1][j + 1] = board[i][j];
            }
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (map[i][j] != 0) {
                    map[i][j] = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]) + 1;
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }

        return answer * answer;
    }
}