class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        // 행렬 초기화
        int[][] arr = new int[rows][columns];
        int idx = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = idx++;
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(arr, queries[i]);
        }

        return answer;
    }
    
    public int rotate(int[][] arr, int[] query) {
        int x1 = query[0] - 1, y1 = query[1] - 1, x2 = query[2] - 1, y2 = query[3] - 1;
        int tmp = arr[x1][y1];
        int min = tmp;

        for (int i = x1; i < x2; i++) {
            arr[i][y1] = arr[i + 1][y1];
            min = Math.min(min, arr[i][y1]);
        }

        for (int i = y1; i < y2; i++) {
            arr[x2][i] = arr[x2][i + 1];
            min = Math.min(min, arr[x2][i]);
        }

        for (int i = x2; i > x1; i--) {
            arr[i][y2] = arr[i - 1][y2];
            min = Math.min(min, arr[i][y2]);
        }

        for (int i = y2; i > y1 + 1; i--) {
            arr[x1][i] = arr[x1][i - 1];
            min = Math.min(min, arr[x1][i]);
        }
        arr[x1][y1 + 1] = tmp;
        return min;
    }
}