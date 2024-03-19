package level_16_stack_queue_deque;

import java.io.*;
import java.util.*;

// 옥상 정원 꾸미기
// 최악의 경우에 총 80000개의 빌딩이 1번부터 내림차순으로 나열되어 있다면 
// 80000, 79999, ... , 1이므로 총 경우의 수는 80000*80001 / 2 이라 
// 약 32억회의 연산이라 3초 정도가 걸려 시간초과 문제가 발생하므로 다른 방법을 활용하여 풀이 필요(스택)

// 또한, 초기 빌딩의 높이가 1억이라면 마지막 빌딩의 높이는 1억-79999이므로
// 빌딩 높이의 합은 1억*(1억-79999) / 2 이므로 int 범위를 초과하므로 정답은 long으로 선언 필요
public class P_6198 {
	static long N, ans;
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(br.readLine());

			// 입력받은 빌딩의 높이보다 높이가 작거나 같은 이전 빌딩들은 
			// 해당 빌딩의 높이에서는 이번 빌딩을 확인할 수 없으므로 스택에서 삭제
			while (!stack.isEmpty() && stack.peek() <= height) {
				stack.pop();
			}
			
			// 윷놀이처럼 빌딩들을 쌓아가며
			// 해당 번째의 빌딩을 볼 수 있는지를 판단하고 이를 누적합
			ans += stack.size(); // +1, +1, +2, +1, ...
			stack.push(height); // 다음 빌딩 높이 추가
		}
		System.out.println(ans);
	}
}
