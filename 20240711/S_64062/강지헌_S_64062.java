class Solution {
    public int solution(int[] stones, int k) {
        int answer=0, l=0, r=0;
        for (int s : stones) r=Math.max(r, s);
        while (l<=r) {
            int m=(l+r)/2;
            int t=0, max=0;
            for (int i=0;i<stones.length;i++) {
                if (stones[i]-m<=0) max = Math.max(max, ++t);
                else t=0;
            }
            if (max+1>k) r=m-1;
            else l=m+1;
        }
        return l;
    }
}
