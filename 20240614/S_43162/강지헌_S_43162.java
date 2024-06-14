class Solution {
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] chk = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!chk[i]) {
                dfs(computers, i, chk);
                answer++;
            }
        }
        return answer;
    }
    static void dfs(int[][] arr, int t, boolean[] chk) {
        chk[t] = true;
        for (int i = 0; i < arr.length; i++)  if (t != i && arr[t][i] == 1 && chk[i] == false) dfs(arr, i, chk);
    }
}
