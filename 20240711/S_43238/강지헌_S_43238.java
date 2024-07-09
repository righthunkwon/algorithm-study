class Solution {
    public long solution(int n, int[] times) {
        long l=1,r=100000000000000L;
        while(l<=r) {
            long m = (l+r)/2,t=0;
            for(int i:times) {
                t+=m/i;
            }
            if(t>=n) r=m-1;
            else l=m+1;
        }
        return l;
    }
}
