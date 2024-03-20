package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_Q6198_옥상_정원_꾸미기 {
	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<int[]> stack = new Stack<>();
		long ans = 0;
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if (stack.isEmpty()) { // 처음에 스택 비었으면 넣기
				stack.add(new int[] { a, i }); // {높이,인덱스}스택에 넣기
			} else {// 스택이 안비었으면
				while (true) {
					if (stack.isEmpty()) {
						stack.add(new int[] { a, i });
						break;
					}
					int b = stack.peek()[0];
					if (a>= b) { //현재 스택 맨 위에 있는 건물 높이보다 큰 건물이면
						int[] out = stack.pop();
						ans += (i-out[1]-1);
					} else {
						stack.add(new int[] { a, i });
						break;
					}
				}
			}
		}
		
		while(!stack.isEmpty()) {
			int[]out = stack.pop();
			ans += (N-out[1]-1);
		}

		System.out.println(ans);

	}// main
}// class
