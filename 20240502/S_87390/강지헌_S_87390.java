public class Solution {
    public int[] solution(int n, long l, long r) {
        int[] ans = new int[(int)(r-l+1)];
        int t=0;
        for (long i=l;i<=r;i++,t++) ans[t]=Math.max((int)(i/n), (int)(i%n))+1;
        return ans;
    }
}
