import java.util.*;
class Solution {
    int[][] map;
    boolean[] vi;
    int[] c;
    public int solution(int n, int[][] wires) {
        int ans = n;
        map = new int[n][n];
        vi = new boolean[n];
        c = new int[n];
        Arrays.fill(c, 1);
        for(int[] t : wires) map[t[0]-1][t[1]-1] = map[t[1]-1][t[0]-1]=1;
        dfs(0);
        for(int i : c) ans = Math.min(ans, Math.abs(n - 2 * i));
        return ans;
    }
    private int dfs(int t) {
        vi[t] = true;
        for(int i = 0; i < map.length; i++) {
            if(vi[i] || map[t][i] == 0) continue;
            c[t] += dfs(i);
        }
        return c[t];
    }
}
