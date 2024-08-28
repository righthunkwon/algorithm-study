import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, long l, long r) {
        //1->11011
        //0->00000
        //5 의 20제곱 1,5,5의 제곱, 5의 세제곱....
        //분할정복 아닌가 ...?
        answer = 0;
        dfs(n,l,r,1);
        return answer;
    }
    static int answer;
    public static void dfs(long n, long s, long e, long now){
        if(now>e||now+(long)Math.pow(5,n)-1<s) return; //범위안에 들지 않는 수 
        if(n==0) {
            answer++;
            return;
        }
        long len=(long)Math.pow(5,n-1);
        dfs(n-1,s,e,now);
        dfs(n-1,s,e,now+len*1);
        dfs(n-1,s,e,now+len*3);
        dfs(n-1,s,e,now+len*4);
        
    }
}
