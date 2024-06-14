class Solution {
    
    static boolean [] visited;
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n]; //방문확인용 배열 초기화
        for(int i=0;i<n;i++){
            if(!visited[i]){ //방문 안한 컴퓨터 dfs하고 네트워크 개수 +1
                dfs(n,computers,i);
                answer++;
            }
        }
        return answer;
    }
    
    public static void dfs(int n,int[][]computers,int com){
        visited[com] = true;
        for(int i=0;i<n;i++){
            if(computers[com][i]==1&&!visited[i]){
                dfs(n,computers,i);
            }
        }
    }
}
