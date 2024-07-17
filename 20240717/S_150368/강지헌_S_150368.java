import java.util.*;
class Solution {
    static int[] num, sales = {10, 20, 30, 40};
    static PriorityQueue<int[]> Q;
    public int[] solution(int[][] users, int[] emoticons) {
        num = new int[emoticons.length];
        Q = new PriorityQueue<>((o1,o2) -> { return o2[0]==o1[0]?o2[1]-o1[1]:o2[0]-o1[0]; });
        dfs(0, users, emoticons);
        return Q.poll();
    }
    public void dfs(int r, int[][] u, int[] e) {
        if(r == num.length) {
            int s = 0, m = 0;
            for(int i = 0; i < u.length; i ++) {
                int t = 0;
                for(int j = 0; j < e.length; j ++) {
                    if(num[j] >= u[i][0]) {
                        t += e[j] * (100 - num[j]) / 100;
                    }
                }
                if(t >= u[i][1]) s++;
                else m += t;
            }
            Q.add(new int[] {s, m});
            return;
        }
        for(int i = 0; i < sales.length; i ++) {
            num[r] = sales[i];
            dfs(r + 1, u, e);
        }
    }
}
