class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        int[][] dy = new int[n][2];
        dy[0][0]=tops[0]+2; dy[0][1]=1;
        for(int i=1;i<n;i++) {
            dy[i][0]=(dy[i-1][0]*(tops[i]+2)+dy[i-1][1]*(tops[i]+1))%10007;
            dy[i][1]=(dy[i-1][0]+dy[i-1][1])%10007;
        }
        return (dy[n-1][0]+dy[n-1][1])%10007;
    }
}
