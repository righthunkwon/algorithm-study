
import java.io.*;
import java.util.*;

public class Pro_4889_안정적인문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] input;
		Stack<Character> stack;
		int result;
		int tc = 1;
		while (true) {
			result = 0;
			input = br.readLine().toCharArray();
			if (input[0] == '-') {
				System.out.println(sb);
				System.exit(0);
			}
			// { 이면 stack에 넣고 }이면 pop 짝수 맞추기
			// 뺄게 없는데 }면 정답 +1
			stack = new Stack<>();
			for (int i = 0; i < input.length; i++) {
				if (input[i] == '{') {
					stack.add('{');
				} else if (input[i] == '}') {
					if (stack.isEmpty()) {
						result++;
					} else {
						stack.pop();
					}
				}
			}
			result=(result+1)/2;
			//2개면 한개만 바꾸면 되니까
			if(stack.size()!=0)result += (stack.size()+1)/2;
			sb.append(tc + ". " + result+"\n");
			tc++;
		}

	}
}
