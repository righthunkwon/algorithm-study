import java.util.*;
class Solution {
    static int ans = Integer.MAX_VALUE;
    public int solution(int N, int number) {
        dfs(0,N,number,0);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public void dfs(int d, int N, int n, int a) {
        if (d>8) return;
        if (n==a) {
            ans=Math.min(d,ans);
            return;
        }
        int t=0;
        for(int i=0;i<8;i++) {
            if(d+i<8) {
                t=t*10+N;
                dfs(d+i+1,N,n,a+t);
                dfs(d+i+1,N,n,a-t);
                dfs(d+i+1,N,n,a/t);
                dfs(d+i+1,N,n,a*t);     
            }      
        }
    }
}
