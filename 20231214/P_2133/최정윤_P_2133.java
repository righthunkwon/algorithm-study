package baek;

import java.util.*;
import java.io.*;

public class Pro_2133_타일채우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N%2==1||N%2==3)System.out.println(0);//홀수는 불가능
		else {
			long[] dp=new long[N/2+1];
			for(int i=1;i<N/2+1;i++) {
				if(i==1)dp[i]=3;
				else if(i==2)dp[i]=11;
				else {//그냥 몇개해보니까 총 수로 구한 식 ,,, 
				dp[i]=dp[i-1]*4-dp[i-2];}
			}
			System.out.println(dp[N/2]);
		}
	}
}

//2줄
//ㅣㅣ   ㅡ  
// ㅡ   ㅣㅣ

// ㅡ
// ㅡ
// ㅡ

//4줄=>+2가지    
// ㅡ ㅡ
//ㅣㅡㅢ
//6개도 +2가지 8개도 +2가지..............
