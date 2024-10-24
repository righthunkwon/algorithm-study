class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        int idx = 0, x = 0, y = 0;
        answer[x][y] = 1;

        for (int i = 2; i <= n * n; i++) {
            int xd = x + dx[idx], yd = y + dy[idx];
            if (xd >= 0 && xd < n && yd >= 0 && yd < n && answer[xd][yd] == 0) {
                x = xd; y = yd;
                answer[x][y] = i;
            } else {
                idx = (idx + 1) % 4; i--;
            }
        }
        return answer;
    }
}