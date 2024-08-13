// DFS 테스트 케이스 13, 14 계속 실패......, 교차 체크까지 했는데....
import java.util.*;

class Solution {
    private int[] dx = {1, -1, 0, 0}; // x축 방향 이동
    private int[] dy = {0, 0, 1, -1}; // y축 방향 이동
    private int minDepth = Integer.MAX_VALUE; // 최소 이동 횟수를 저장하는 변수

    public int solution(int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;

        int[] blueStart = new int[2];
        int[] redStart = new int[2];

        // 수레의 시작 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 2) {
                    blueStart[0] = i;
                    blueStart[1] = j;
                } else if (maze[i][j] == 1) {
                    redStart[0] = i;
                    redStart[1] = j;
                }
            }
        }

        boolean[][][][] visited = new boolean[n][m][n][m]; // 두 수레의 위치를 조합하여 방문 상태 관리
        visited[blueStart[0]][blueStart[1]][redStart[0]][redStart[1]] = true;

        // DFS 시작
        dfs(blueStart, redStart, 0, visited, maze, n, m);

        return minDepth == Integer.MAX_VALUE ? 0 : minDepth;
    }

    private void dfs(int[] bluePos, int[] redPos, int depth, boolean[][][][] visited, int[][] maze, int n, int m) {
        int blueX = bluePos[0], blueY = bluePos[1];
        int redX = redPos[0], redY = redPos[1];

        // 백트래킹 조건, 현재 깊이가 이미 최솟값보다 크거나 같다면 더 이상 탐색하지 않음
        if (depth >= minDepth) {
            return;
        }

        // 두 수레가 모두 도착지에 도달한 경우, 최소 이동 횟수 갱신
        if (maze[blueX][blueY] == 4 && maze[redX][redY] == 3) {
            minDepth = Math.min(minDepth, depth);
            return;
        }

        // 네 방향에 대해 각각의 수레 이동 시도
        for (int i = 0; i < 4; i++) {
            int nextBlueX = blueX + dx[i];
            int nextBlueY = blueY + dy[i];

            // 파란색 수레가 도착지에 있는 경우
            if (maze[blueX][blueY] == 4) {
                nextBlueX = blueX;
                nextBlueY = blueY;
            }

            if (isValidMove(nextBlueX, nextBlueY, maze, n, m)) {
                for (int j = 0; j < 4; j++) {
                    int nextRedX = redX + dx[j];
                    int nextRedY = redY + dy[j];

                    // 빨간색 수레가 도착지에 있는 경우
                    if (maze[redX][redY] == 3) {
                        nextRedX = redX;
                        nextRedY = redY;
                    }
                    if (isValidMove(nextRedX, nextRedY, maze, n, m)) {
                        // 수레들이 같은 위치로 이동하는 경우를 방지
                        if (nextBlueX == nextRedX && nextBlueY == nextRedY) {
                            continue;
                        }
                        // 수레들이 서로 교차하거나 같은 위치에 도달하는 경우를 방지
                        if (!(nextBlueX == redX && nextBlueY == redY && blueX == nextRedX && blueY == nextRedY)) {
                            if (!visited[nextBlueX][nextBlueY][nextRedX][nextRedY]) {
                                visited[nextBlueX][nextBlueY][nextRedX][nextRedY] = true;
                                dfs(new int[]{nextBlueX, nextBlueY}, new int[]{nextRedX, nextRedY}, depth + 1, visited, maze, n, m);
                                visited[nextBlueX][nextBlueY][nextRedX][nextRedY] = false;
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean isValidMove(int x, int y, int[][] maze, int n, int m) {
        // 주어진 위치가 유효하고, 벽이 아닌지 확인
        return x >= 0 && x < n && y >= 0 && y < m && maze[x][y] != 5;
    }
}

// BFS 테스트 케이스 4, 7, 9, 10, 11, 13, 14 실패
import java.util.*;

class Solution {
    private int[] dx = {1, -1, 0, 0}; // x축 방향 이동
    private int[] dy = {0, 0, 1, -1}; // y축 방향 이동

    public int solution(int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;

        // 예외 처리, 1xN 또는 Nx1 퍼즐판 수레 교차X
        if (n == 1 || m == 1) {
            return 0; // 수레가 교차할 수 없으므로 바로 0 반환
        }

        int[] blueStart = new int[2];
        int[] redStart = new int[2];

        // 수레의 시작 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 2) {
                    blueStart[0] = i;
                    blueStart[1] = j;
                } else if (maze[i][j] == 1) {
                    redStart[0] = i;
                    redStart[1] = j;
                }
            }
        }

        // BFS 초기 설정
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[n][m][n][m];
        queue.offer(new int[] {blueStart[0], blueStart[1], redStart[0], redStart[1], 0});// 좌표랑 이동거리 추가
        visited[blueStart[0]][blueStart[1]][redStart[0]][redStart[1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int blueX = curr[0], blueY = curr[1];
            int redX = curr[2], redY = curr[3];
            int depth = curr[4];// 이동 횟수 체크

            // 두 수레가 모두 도착했는지 확인
            if (maze[blueX][blueY] == 4 && maze[redX][redY] == 3) {
                return depth;
            }

            for (int i = 0; i < 4; i++) {
                int nextBlueX = blueX + dx[i];
                int nextBlueY = blueY + dy[i];

                // 파란색 수레가 도착한 경우
                if (maze[blueX][blueY] == 4) {
                    nextBlueX = blueX;
                    nextBlueY = blueY;
                }

                if (move(nextBlueX, nextBlueY, maze, n, m) && !visited[nextBlueX][nextBlueY][redX][redY]) {
                    for (int j = 0; j < 4; j++) {
                        int nextRedX = redX + dx[j];
                        int nextRedY = redY + dy[j];

                        // 빨간색 수레가 도착한 경우
                        if (maze[redX][redY] == 3) {
                            nextRedX = redX;
                            nextRedY = redY;
                        }

                        if (move(nextRedX, nextRedY, maze, n, m) && (nextBlueX != nextRedX || nextBlueY != nextRedY)) {
                            if (!(nextBlueX == redX && nextBlueY == redY && blueX == nextRedX && blueY == nextRedY)) {
                                visited[nextBlueX][nextBlueY][nextRedX][nextRedY] = true;
                                queue.offer(new int[] {nextBlueX, nextBlueY, nextRedX, nextRedY, depth + 1});
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    private boolean move(int x, int y, int[][] maze, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m && maze[x][y] != 5;
    }
}
