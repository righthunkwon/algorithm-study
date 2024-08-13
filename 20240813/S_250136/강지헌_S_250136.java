import java.util.*;
class Solution {
    public int solution(int[][] land) {
        int n = land.length, m = land[0].length;
        int[] oil = new int[m], xx = {-1, 1, 0, 0}, yy = {0, 0, -1, 1};
        boolean[][] chk = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 0 || chk[i][j]) continue;
                Queue<int[]> q = new LinkedList<>();
                int cnt = 1;
                q.add(new int[]{i, j});
                chk[i][j] = true;
                Set<Integer> set = new HashSet<>();
                while (!q.isEmpty()) {
                    int[] t = q.poll();
                    set.add(t[1]);
                    for (int k = 0; k < 4; k++) {
                        int dx = t[0] + xx[k], dy = t[1] + yy[k];
                        if (dx < 0 || dx >= n || dy < 0 || dy >= m) continue;
                        if (land[dx][dy] == 1 && chk[dx][dy] == false) {
                            q.add(new int[]{dx, dy});
                            chk[dx][dy] = true;
                            cnt++;
                        }
                    }
                }
                for (int k : set) oil[k] += cnt;
            }
        }
        int answer = 0;
        for (int i = 0; i < m; i++) answer = Math.max(answer,oil[i]);
        return answer;
    }
}
