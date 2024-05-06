import java.io.*;
import java.util.*;
class Solution {
    public int solution(int n) {
        memo= new int[n+1];
        int answer = dfs(n)%1234567;
        return answer;
    }
    
    static int[] memo;
    public static int dfs(int n){
        if(n==0||n==1) return n;
        if(memo[n]!=0) return memo[n];
        memo[n]= (dfs(n-1)+dfs(n-2))%1234567;
        return memo[n];
    }
}
