import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        int ans=0;
        for(int i=0;i<A.length;i++) {
            ans+=A[i]*B[A.length-1-i];
        }
        return ans;
    }
}
