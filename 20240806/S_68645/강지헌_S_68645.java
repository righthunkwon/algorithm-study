import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        int[] answer = new int[n*(n-1)/2+n];
        int dir=0, x=0, y=-1;
        for(int i=1; i<=n*(n-1)/2+n; i++) {
            if(dir==0) {
                y++;
                if((y+1>=n || map[y+1][x]!=0)) dir=(dir+1)%3;
            }
            else if(dir==1) {
                x++;
                if((x+1>=n || map[y][x+1]!=0)) dir=(dir+1)%3;
            }
            else {
                x--; y--;
                if((x-1<=0 || map[y-1][x-1]!=0)) dir=(dir+1)%3;
            }
            map[y][x] = i;
        }
        for(int i=0,t=0; i<map.length; i++) {
            for (int j=0; j<i+1; j++,t++) answer[t] = map[i][j];
        }
        return answer;
    }
}
