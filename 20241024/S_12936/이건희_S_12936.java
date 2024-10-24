class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        boolean[] visited = new boolean[n + 1];
        long[] record = new long[n + 1];

        record[0] = 1;
        for (int i = 1; i <= n; i++) {
            record[i] = record[i - 1] * i;
        }
        k--;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if (visited[j]) continue;
                if (k >= record[n - 1 - i]) {
                    k -= record[n - 1 - i];
                } else {
                    answer[i] = j;
                    visited[j] = true;
                    break;
                }
            }
        }
        return answer;
    }
}