package _20240117;

import java.util.*;
import java.io.*;

public class _12904_A와B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문자열 1, 2를 저장하고, 각각의 문자열 길이도 저장한다
		String s1 = br.readLine();
		int a = s1.length();

		String s2 = br.readLine();
		int b = s2.length();
		
		int ans =0;
		while(b>a) {
			// 마지막 문자가 A일 경우 그 문자를 빼준다
			if(s2.charAt(b-1)=='A') {
				s2=s2.substring(0,b-1);
				b=s2.length();
			}else {
				// 마지막 문자가 B일 경우 그 문자를 빼고 반대로 해준다
				char[] temp = s2.toCharArray();
				s2 ="";
				for(int i=b-2;i>=0;i--) {
					s2 += String.valueOf(temp[i]);
				}
				b=s2.length();
			}
			if(b==a) break;
		}//while
		
		// A와 B가 일치할 경우 1을 출력하도록 한다
		if(s1.equals(s2)) ans=1;
		
		System.out.println(ans);
	}//main
}
