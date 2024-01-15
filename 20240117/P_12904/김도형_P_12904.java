import java.io.*;
import java.util.*;

public class BOJ_Q12904_A와B {
	static String S,T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();

		/* 문자열 뒤집는 방법
		 * StringBuffer sb = new StringBuffer(T);
		 * String reverse = sb.reverse().toString();
		 * */ 
		
		//T -> S로 거꾸로 만들기 시도
		while(S.length()<T.length()) {
			if(T.charAt(T.length()-1)=='B') {//마지막 글자 B면
				StringBuffer sb = new StringBuffer(T);
				String reverse = sb.reverse().toString(); //뒤집고
				T = reverse.substring(1, reverse.length()); //맨앞글자 떼기
			}else if(T.charAt(T.length()-1)=='A') { //마지막 글자 A면
				T = T.substring(0,T.length()-1); //맨뒤 글자 떼기
			}
			if(S.length()==T.length()) { //길이 같아지면 while문 종료
				break;
			}
		}
		
		if(T.equals(S)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	
	}//main
	
}
