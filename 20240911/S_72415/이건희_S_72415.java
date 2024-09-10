import java.util.*;

class Solution {
    class Point {
        Point(int r, int c, int t) {
            row = r;
            col = c;
            cnt = t;
        }
        int row, col, cnt;
    }
    static final int INF = 987654321;
    static final int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] Board;

    int bfs(Point src, Point dst) {
        boolean[][] visited = new boolean[4][4];
        Queue<Point> q = new LinkedList<>();
        q.add(src);
        visited[src.row][src.col] = true;

        while (!q.isEmpty()) {
            Point curr = q.poll();
            if (curr.row == dst.row && curr.col == dst.col) return curr.cnt;

            for (int i = 0; i < 4; i++) {
                int nr = curr.row + d[i][0], nc = curr.col + d[i][1];
                if (nr < 0 || nr > 3 || nc < 0 || nc > 3) continue;

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, curr.cnt + 1));
                }

                for (int j = 0; j < 2; j++) {
                    if (Board[nr][nc] != 0) break;
                    if (nr + d[i][0] < 0 || nr + d[i][0] > 3 || nc + d[i][1] < 0 || nc + d[i][1] > 3) break;
                    nr += d[i][0];
                    nc += d[i][1];
                }

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, curr.cnt + 1));
                }
            }
        }
        // 경로가 없을 경우 INF 반환
        return INF;
    }

    int permutate(Point src) {
        int tmp = INF;
        for (int num = 1; num <= 6; num++) {
            List<Point> card = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (Board[i][j] == num) {
                        card.add(new Point(i, j, 0));
                    }
                }
            }
            if (card.isEmpty()) continue;

            int one = bfs(src, card.get(0)) + bfs(card.get(0), card.get(1)) + 2;
            int two = bfs(src, card.get(1)) + bfs(card.get(1), card.get(0)) + 2;

            Board[card.get(0).row][card.get(0).col] = 0;
            Board[card.get(1).row][card.get(1).col] = 0;

            tmp = Math.min(tmp, one + permutate(card.get(1)));
            tmp = Math.min(tmp, two + permutate(card.get(0)));

            // 복원
            Board[card.get(0).row][card.get(0).col] = num;
            Board[card.get(1).row][card.get(1).col] = num;
        }
        if (tmp == INF) return 0;
        return tmp;
    }

    public int solution(int[][] board, int r, int c) {
        Board = board;
        return permutate(new Point(r, c, 0));
    }
}