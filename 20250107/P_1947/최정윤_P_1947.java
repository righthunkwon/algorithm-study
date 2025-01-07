import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
		//계속 나눠주는데 long으로 해야하는 이유 ,,,?
        long[] dp= new long[N+1];
        //1->0 2->1 3->2 4->9 5-> 44
        for(int i=1;i<=N;i++){
            if(i==1||i==2)dp[i]=i-1;
            else{
				//새로 투입된 친구가 다른 한명과 둘이 선물바꾸기+ 그 다른 한명이 다시 다른 사람들과 선물바꾸기
                dp[i]=(dp[i-2]+dp[i-1])*(i-1)%1000000000;
            }
        }
        System.out.println(dp[N]);
    }
}