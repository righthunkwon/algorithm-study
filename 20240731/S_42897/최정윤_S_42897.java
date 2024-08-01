import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] money) {
        //원 ,,, 
        //맨 앞 포함 dp랑 맨뒤 포함X , 맨 뒤 포함 dp 맨앞 포함X
        //맨 앞 포함, 맨 뒤 포함 X
        int[] dp=new int[money.length];
        for(int i=0;i<money.length-1;i++){
            if(i==0||i==1)dp[i]=money[i];
            else if(i==2) dp[i]=dp[0]+money[i];
            else {dp[i]=Math.max(dp[i-2],dp[i-3])+money[i];}
        }
        //맨 뒤 포함, 맨 앞 포함X
        int[] dp2=new int[money.length];
        for(int i=1;i<money.length;i++){
            if(i==1)dp2[i]=money[i];
            else if(i==2) dp2[i]=dp2[0]+money[i];
            else {dp2[i]=Math.max(dp2[i-2],dp2[i-3])+money[i];}
        }        
        //둘 중 최댓값
        int answer=Math.max( Math.max(dp[money.length-3],dp[money.length-2]),Math.max(dp2[money.length-1],dp2[money.length-2]));
        return answer;
    }
}
