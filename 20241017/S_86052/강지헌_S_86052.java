import java.util.*;
class Solution {
    static int[] xx={0,1,0,-1}, yy={1,0,-1,0};
    public int[] solution(String[] grid) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n=grid.length, m=grid[0].length();
        char[][] map = new char[n][m];
        boolean[][][] chk = new boolean[n][m][4];
        for(int i=0;i<n;i++) map[i]=grid[i].toCharArray();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                for(int k=0;k<4;k++) {
                    int dx=(i+xx[k]+n)%n,dy=(j+yy[k]+m)%m;
                    if(!chk[dx][dy][k]) {
                        int cnt=0;
                        while(!chk[dx][dy][k]) {
                            chk[dx][dy][k]=true;
                            if(map[dx][dy]=='L') k=(k+3)%4;
                            else if(map[dx][dy]=='R') k=(k+1)%4;
                            dx=(dx+xx[k]+n)%n; dy=(dy+yy[k]+m)%m;
                            cnt++;
                        }
                        arr.add(cnt);
                    }
                }
            }
        }
        int[] answer = new int[arr.size()];
        for(int i=0;i<arr.size();i++) answer[i]=arr.get(i);
        Arrays.sort(answer);
        return answer;
    }
}
