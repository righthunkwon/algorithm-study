import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0,max=0;
        int[] d = new int[n+1];
        int[][] map = new int[n+1][n+1];
        for(int[] i : edge) map[i[0]][i[1]] = map[i[1]][i[0]] = 1;
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.add(1);
        while(!Q.isEmpty()) {
            int t = Q.poll();
            
            for(int i=2;i<=n;i++) {
                if(map[t][i]==1 && d[i]==0) { 
                    d[i]=d[t]+1;
                    Q.add(i);
                    max = Math.max(max,d[i]);
                }
            }
        }
        for(int i:d) {
            if(i==max) answer++;
        }
        return answer;
    }
}
