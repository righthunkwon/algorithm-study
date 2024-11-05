// 재귀로 풀기 => 그리디로 다시 풀어보자
import java.util.*;
class Solution {
    public int solution(String name) {
        int n = name.length();
        boolean[] visited = new boolean[n];
        visited[0] = name.charAt(0) == 'A';
        return dfs(0, 0, visited, name);
    }

    public int dfs(int nowIdx, int cnt, boolean[] visited, String name) {
        boolean toggle = true;
        int n = name.length();
        int minCnt = 987654321;

        for (int i = 0; i < n; i++) {
            if (name.charAt(i) != 'A' && !visited[i]) {
                toggle = false;
                int moveCnt = move(nowIdx, i, n);
                int swapCnt = swap(name.charAt(i));
                visited[i] = true;
                int totalCnt = dfs(i, cnt + moveCnt + swapCnt, visited, name);
                minCnt = Math.min(minCnt, totalCnt);
                visited[i] = false;
            }
        }
        if (toggle) {
            return cnt;
        } else {
            return minCnt;
        }
    }
    
    public int swap(char target){
        return Math.min('Z'-target+1, target-'A');
    }
    
    public int move(int s, int e, int n){
        return Math.min((e - s + n) % n, (s - e + n) % n);
    }
}