package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904_A와B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String T = br.readLine();
		
		// T길이가 S길이 될때까지 반복
		while(T.length() > S.length()) {
			// 끝이 A면 삭제
			if(T.charAt(T.length()-1) == 'A') T = T.substring(0, T.length()-1);
			// 끝이 B면 삭제하고 뒤집기
			else {
				T = T.substring(0, T.length()-1);
				StringBuilder sb = new StringBuilder(T);
				T = sb.reverse().toString();
			}
		}
		
		// 같으면 1 아니면 0
		System.out.println(T.equals(S) ? 1 : 0);
	}
}
