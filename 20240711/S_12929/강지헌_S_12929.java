class Solution {
    public int solution(int n) {
        int[] dy=new int[n+1];
        dy[0]=1; dy[1]=1;
        for (int i=2;i<=n;i++) {
            for(int j=0;j<i;j++) dy[i]+=dy[i-j-1]*dy[j];
        }
        return dy[n];
    }
}
