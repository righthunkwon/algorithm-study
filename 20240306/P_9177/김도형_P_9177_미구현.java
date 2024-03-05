package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간초과 fail..
public class BOJ_Q9177_단어_섞기 {
	static String str1,str2,str3;
	static int totalLength;
	static String ans;
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			str1=st.nextToken(); //첫번째 단어
			str2=st.nextToken(); //두번째 단어
			str3=st.nextToken(); //목표 단어
			ans = "no"; 

			totalLength= str3.length();
			recur(0,0,0);
			System.out.println("Data set "+ tc+": "+ans);
			
		}
		
	}//main
	public static void recur(int x1,int x2,int x3) {
		if(x3==totalLength) {
			ans = "yes";
			return;
		}
		
		if(x1==str1.length() && str2.charAt(x2)==str3.charAt(x3)) {
			recur(x1,x2+1,x3+1);
		}else if(x1==str1.length() && str2.charAt(x2)!=str3.charAt(x3)) {
			return;
		}else if(x2==str2.length() && str1.charAt(x1)==str3.charAt(x3)) {
			recur(x1+1,x2,x3+1);
		}else if(x2==str2.length() && str1.charAt(x1)!=str3.charAt(x3)) {
			return;
		}else 
		
		
		
		//둘다 가능하면 두가지 분기
		if(str3.charAt(x3)==str1.charAt(x1) &&str3.charAt(x3)==str2.charAt(x2)) {
			recur(x1+1,x2,x3+1);
			recur(x1,x2+1,x3+1);
		}else if(str3.charAt(x3)==str1.charAt(x1)) {
			recur(x1+1,x2,x3+1);
		}else if(str3.charAt(x3)==str2.charAt(x2)) {
			recur(x1,x2+1,x3+1);
		}else return;
		
		
	}
}//class
