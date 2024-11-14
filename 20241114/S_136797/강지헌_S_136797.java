public class Solution {
    private final int[][][] dp=new int[100000][10][10];
    private final int[][] edge={
        {1,7,6,7,5,4,5,3,2,3},
        {7,1,2,4,2,3,5,4,5,6},
        {6,2,1,2,3,2,3,5,4,5},
        {7,4,2,1,5,3,2,6,5,4},
        {5,2,3,5,1,2,4,2,3,5},
        {4,3,2,3,2,1,2,3,2,3},
        {5,5,3,2,4,2,1,5,3,2},
        {3,4,5,6,2,3,5,1,2,4},
        {2,5,4,5,3,2,3,2,1,2},
        {3,6,5,4,5,3,2,4,2,1}
    };

    public int solution(String numbers) {
        for (int i=0;i<100000;i++) {
            for (int j=0;j<10;j++) {
                for (int k=0;k<10;k++) dp[i][j][k]=100000000;
            }
        }
        return dfs(numbers,0,4,6);
    }

    private int dfs(String numbers,int t,int l,int r) {
        if (t>=numbers.length()) return 0;
        if (dp[t][l][r]!=100000000) return dp[t][l][r];
        
        int next=numbers.charAt(t)-'0';
        if (next!=r) dp[t][l][r]=Math.min(dp[t][l][r],dfs(numbers,t+1,next,r)+edge[l][next]);
        if (next!=l) dp[t][l][r]=Math.min(dp[t][l][r],dfs(numbers,t+1,l,next)+edge[r][next]);
        
        return dp[t][l][r];
    }
}
