import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        
        int[]dp =new int [1000001];
        dp[2]=1;
        dp[3]=2;
        
        for(int i=4;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1234567;
        }
        
        int answer = dp[n];
        return answer;
    }
}
