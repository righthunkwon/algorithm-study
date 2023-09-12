package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Pro_12789_도키도키간식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}//입력끝
		
		String result = "Nice";
		int snack = 1;

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == snack) {//내 순서
				snack++;//받고 다음 번호로 바꿈, 바꾼 뒤 스택에 저장해놓은 사람들 번호인지 확인
				while (!stack.isEmpty() && stack.peek() == snack) {//저장해둔 사람이라면 스택에서 빼고 번호 증가
					stack.pop();
					snack++;
				}
			} else if (!stack.isEmpty()) {//스택에 저장조건 1.저장된 번호보다 작은 경우만 stack에 저장될 수 있다
				if (stack.peek() > arr[i]) {
					stack.add(arr[i]);
				} else {//아니라면 순서가 잘못됨
					result = "Sad";
					break;
				}
			} else {//내 순서 아닌데 stack에 아무것도 없는 경우 그냥 추가
				stack.add(arr[i]);
			}
		}
		System.out.println(result);
	}
}
