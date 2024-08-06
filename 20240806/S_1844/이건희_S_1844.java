import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 동, 남, 서, 북
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        // 시작점 초기화
        queue.add(new int[]{0, 0, 1});  // {x, y, distance}
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            
            // 목표 지점에 도달하면 거리 반환
            if (x == n - 1 && y == m - 1) {
                return distance;
            }
            
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                // 유효한 좌표인지, 방문한 적이 없는지, 벽이 아닌지 확인
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, distance + 1});
                }
            }
        }
        
        // 목표 지점에 도달할 수 없는 경우
        return -1;
    }
}