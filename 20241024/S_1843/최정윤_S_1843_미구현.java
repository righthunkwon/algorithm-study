import java.util.*;
class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        //뒤부터 ,, 해야하나?
        //-를 어디까지 적용하는지
        int[] dp=new int[arr.length];
        for(int i=arr.length-1;i>0;i-=2){
            if(arr[i-1]=="+"){
                if(i==arr.length-1) dp[i]=Integer.parseInt(arr[i]);
                else dp[i]=dp[i+2]+Integer.parseInt(arr[i]);
            }else{
                if(i==arr.length-1) dp[i]=-Integer.parseInt(arr[i]);
                else{
                if(dp[i+2]<0){
                    dp[i]=-dp[i+2]-Integer.parseInt(arr[i]);
                }else{
                    dp[i]=dp[i+2]-Integer.parseInt(arr[i]);
                }
                }
            }
        }
        dp[0]=dp[2]+Integer.parseInt(arr[0]);
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}
