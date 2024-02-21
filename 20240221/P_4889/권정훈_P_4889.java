package level_16_stack_queue_deque;

import java.io.*;
import java.util.*;

// 안정적인 문자열
// 괄호 문제는 일단 스택을 생각해보자
public class P_4889 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while (true) {
			String s = br.readLine();

			// 종료 조건
			if (s.charAt(0) == '-') {
				break;
			}

			char[] carr = s.toCharArray();
			Stack<Character> stack = new Stack<>();

			int ans = 0;
			for (int i = 0; i < carr.length; i++) {
				char ch = carr[i];

				// 여는 괄호일 경우
				// 스택에 그냥 추가
				if (ch == '{') {
					stack.add(ch);
				}
				// 닫는 괄호일 경우
				else {
					// 스택이 비어있으면
					// 여는 괄호로 바꿔주고 추가
					if (stack.isEmpty()) {
						ans++;
						stack.add('{');
						continue;
					}
					// 스택이 비어있지 않으면
					// 여는 괄호가 있다는 것이므로 한 세트가 되므로 요소 하나를 제거
					else {
						stack.pop();
					}
				}
			}
			// 스택이 비어있지 않다면
			// 괄호의 전체 개수의 절반만큼을 닫는 괄호로 바꿔준다
			if (!stack.isEmpty()) {
				ans += stack.size() / 2;
			}
			System.out.println(tc++ + ". " + ans);
		}
	}
}
