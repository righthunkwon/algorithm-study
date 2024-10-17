class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        int answer = 0;
        
        while (true) {
            boolean[][] marked = new boolean[m][n];
            boolean toggle = false;

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char block = map[i][j];
                    if (block != ' ' && block == map[i][j + 1] && block == map[i + 1][j] && block == map[i + 1][j + 1]) {
                        marked[i][j] = true;
                        marked[i][j + 1] = true;
                        marked[i + 1][j] = true;
                        marked[i + 1][j + 1] = true;
                        toggle = true;
                    }
                }
            }
            if (!toggle) break;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (marked[i][j]) {
                        map[i][j] = ' ';
                        answer++;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] == ' ') {
                        for (int k = i - 1; k >= 0; k--) {
                            if (map[k][j] != ' ') {
                                map[i][j] = map[k][j];
                                map[k][j] = ' ';
                                break;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}