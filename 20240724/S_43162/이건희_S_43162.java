class Solution {
    static int N;
    static int map[][];
    static boolean visited[];
    public int solution(int n, int[][] computers) {
        N = n;
        int cnt = 0;
        map = computers;
        visited = new boolean [n];
        int answer = 0;
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                dfs(i);
                cnt++;
            }
        }
        return cnt;
    }
    
    public static void dfs(int start){
        visited[start] = true;
        for(int i = 0; i < N; i++){
            if(map[start][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}