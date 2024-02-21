package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4889_안정적인문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> s = new Stack<>();
		int tc = 1;
		
		while(true) {
			int cnt = 0;
			String input = br.readLine();
			if(input.contains("-")) break;
			
			for(int i = 0; i < input.length(); i++) {
				// '{' 일때
				if(input.charAt(i) == '{') s.add('{');
				// '}' 일때
				else {
					if(s.isEmpty()) {
						cnt++;
						s.add('{');
					} else if(s.peek() == '{') s.pop();
				}
			}
			System.out.println(tc + ". " + (s.size()/2 + cnt));
//			System.out.println(s.size());
			
			s.clear();
			tc++;
		}
		
		
	}
}
