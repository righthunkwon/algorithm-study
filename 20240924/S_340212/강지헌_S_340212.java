class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long l=1,r=limit;
        while(l<r) {
            long m=(l+r)/2, t=(long)times[0];
            for(int i=1;i<diffs.length;i++) {
                if(diffs[i]>m) t+=(diffs[i]-m)*(times[i-1]+times[i]);
                t+=times[i];
            }
            if(limit<t) l=m+1;
            else r=m;
        }
        return (int)l;
    }
}
