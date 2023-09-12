package level_16_stack_queue_deque;

import java.util.Scanner;
import java.util.Stack;

// 도키도키 간식드리미
public class P_12789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 학생 수
		int arr[] = new int[n]; // 학생 번호 배열
		
		// 배열 요소 입력
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		// 판단은 총 두 번
		// (1) 배열 & 스택
		// (2) 나머지 스택
		
		// 순서에 해당하면 빠지고,
		// 순서에 해당하지 않으면 stack의 맨 위 요소와 비교하여 판단한다.
		int order = 1;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			// 배열 요소가 순서일 경우
			// 해당 사람은 순서에 맞게 들어갔으므로 다음 순서를 판단한다.
			if (arr[i] == order) {
				order++;
			} 
			
			// 배열 요소가 순서가 아닐 경우
			// 스택의 맨 위 요소와 비교하여 순서와 일치하면 꺼내고 다음 순서를 판단한다.
			// 만약 스택의 맨 위 요소가 순서와 일치하지 않는다면 스택에 해당 요소를 넣는다.
			else {
				if (!stack.isEmpty() && stack.peek() == order) {
					stack.pop();
					order++;
					i--; // 다음 순서로 넘어갈 때 현재 학생의 순서를 다시 확인
				} else {
					stack.push(arr[i]);
				}
			}
		}
		
		// 스택에 남아있는 요소들 판단
		boolean flag = true;
		for (int i = 0; i < stack.size(); i++) {
			if (stack.pop() == order) {
				order++;
			} else {
				flag = false;
				break;
			}
		}
		
		// 출력
		if (flag) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
	}
}
