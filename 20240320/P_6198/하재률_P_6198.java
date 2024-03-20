package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_6198_옥상정원꾸미기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<Integer>();
		Long res = 0L;
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			
			// tmp를 관찰할 수 있는 녀석들 빼고 pop
			while(!s.isEmpty()) {
				if(s.peek() <= tmp) s.pop();
				else break;
			}
			
			// stack에 있는 녀석들 +
			res += s.size();
			s.add(tmp);
		}
		
		System.out.println(res);
	}
}
