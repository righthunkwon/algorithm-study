package algo_study;

import java.io.*;
import java.util.*;

public class BOJ_Q4889_안정적인_문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while (true) {
			String str = new String(br.readLine());
			if(str.contains("-")) break;
			Stack<Character> stack = new Stack<Character>();
			int ans = 0;
			int tmp = 0;
			for (int i = 0; i <= str.length(); i++) {
				if(i==str.length()) {
					while(!stack.isEmpty()) {
						stack.pop();
						stack.pop();
						ans++; // {{ 두개면 {} 로 1번만 바꿔주면 되니까
					}
					System.out.println(tc+". "+ans);
					tc++;
					break;
				}
				if (stack.isEmpty()) {
					if (str.charAt(i) == '{') {
						stack.add(str.charAt(i));
					} else {
						ans++;
						stack.add('{'); //비어있는데 '}'면 바꿔서 넣어줌
					}
				} else {
					if (str.charAt(i) == '{') {
						stack.add(str.charAt(i));
					} else {
						stack.pop();
					}
				}
			}

		} // while
	}// main
}// class

/*
 * 짝수 => 세트 만들어짐
 * <>><
 */
