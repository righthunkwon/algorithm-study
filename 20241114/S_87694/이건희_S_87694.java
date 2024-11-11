import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[102][102];
        for (int[] rect : rectangle) {
            for (int y = rect[0]*2; y <= rect[2]*2; y++) {
                for (int x = rect[1]*2; x <= rect[3]*2; x++) {
                    map[y][x] = 1;
                }
            }
        }
        
        for (int[] rect : rectangle) {
            for (int y = rect[0]*2+1; y < rect[2]*2; y++) {
                for (int x = rect[1]*2+1; x < rect[3]*2; x++) {
                    map[y][x] = 0;
                }
            }
        }
      
        boolean[][] visited = new boolean[102][102];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{characterX*2, characterY*2, 0});
        visited[characterX*2][characterY*2] = true;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == itemX*2 && curr[1] == itemY*2) {
                return curr[2] / 2;
            }
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                if (nx >= 0 && nx < 102 && ny >= 0 && ny < 102) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, curr[2] + 1});
                    }
                }
            }
        }
        return 0;
    }
}






class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[51][51];
        int[] dx1 = {1,1,1,0,0,-1,-1,-1};
        int[] dy1 = {1,0,-1,1,-1,1,0,-1};
        for (int[] el : rectangle) {
            for (int x = el[0]; x <= el[2]; x++) {
                for (int y = el[1]; y <= el[3]; y++) {
                    map[y][x] = 1;
                }
            }
        }
        // 테두리 표시
        for (int x = 0; x <= 50; x++) {
            for (int y = 0; y <= 50; y++) {
                if (map[y][x] == 1) {
                    for (int i = 0; i < 8; i++) {
                        int xd = x + dx1[i];
                        int yd = y + dy1[i];
                        if (xd >= 0 && xd <= 50 && yd >= 0 && yd <= 50) {
                            if (map[yd][xd] == 0) {
                                map[y][x] = 2; // 테두리로 표시
                                break;
                            }
                        } else {
                            // 맵의 경계를 벗어나면 테두리로 간주
                            map[y][x] = 2;
                            break;
                        }
                    }
                }
            }
        }

        // 테두리 시각화 출력
        for (int y = 50; y >= 0; y--) { // y 좌표는 위에서 아래로 출력
            for (int x = 0; x <= 50; x++) {
                if (map[y][x] == 0) {
                    System.out.print(' '); // 빈 공간
                } else if (map[y][x] == 1) {
                    System.out.print('#'); // 내부 영역
                } else if (map[y][x] == 2) {
                    System.out.print('*'); // 테두리
                }
            }
            System.out.println();
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[51][51];

        // 시작 위치가 테두리인지 확인
        if (map[characterY][characterX] != 2) {
            return 0;
        }

        queue.offer(new int[]{characterX, characterY, 0}); // {x, y, 거리}
        visited[characterY][characterX] = true;
        int answer = Integer.MAX_VALUE;

        // BFS 4방향 탐색
        int[] dx2 = {-1, 1, 0, 0};
        int[] dy2 = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int distance = curr[2];

            // 아이템 위치에 도달하면 거리 반환
            if (x == itemX && y == itemY) {
                answer = distance;
                break; // 최단 경로이므로 즉시 종료
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx2[i];
                int ny = y + dy2[i];

                // 인덱스 범위 체크 및 테두리(2)인 곳만 탐색
                if (nx >= 0 && nx <= 50 && ny >= 0 && ny <= 50 && map[ny][nx] == 2 && !visited[ny][nx]) {
                    queue.offer(new int[]{nx, ny, distance + 1});
                    visited[ny][nx] = true;
                }
            }
        }

        return answer;
    }
}