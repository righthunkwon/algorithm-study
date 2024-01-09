package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Q5582_공통_부분_문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//4000*4000=16,000,000 
		String st1=br.readLine();
		String st2=br.readLine();
		int len1=st1.length();
		int len2=st2.length();
		int maxlen = 0; //정답 0으로 초기화
		int [][]dp = new int[len1+1][len2+1];
		
		for(int i=1;i<=len1;i++) {
			for(int j=1;j<=len2;j++) {
				if(st1.charAt(i-1)==st2.charAt(j-1)) { //1부터 시작했으니 i-1, j-1 비교 후 같으면
					dp[i][j]=dp[i-1][j-1]+1; 
					maxlen = Math.max(maxlen, dp[i][j]); //더 높은 값 나오면 갱신
				}
			}
		}
		System.out.println(maxlen);
		
	}//main
}//class
