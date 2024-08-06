class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        long[][] dy = new long[n+1][m+1],map = new long[n+1][m+1];
        for(int[] i : puddles) map[i[1]][i[0]]=1;
        dy[1][1]=1;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(map[i][j]==1) continue;
                if(map[i-1][j]==0) dy[i][j]+=dy[i-1][j];
                if(map[i][j-1]==0) dy[i][j]+=dy[i][j-1];
                dy[i][j]%=1000000007;
            }
        }
        return (int)dy[n][m];
    }
}
