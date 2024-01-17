
import java.io.*;
import java.util.*;

public class Pro_1863_스카이라인쉬운거2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());// 버리기
			int y = Integer.parseInt(st.nextToken());
			//높이를 저장해놓기 가장 높은 건물 높이를 기억하기 위해
			while (!stack.isEmpty() && stack.peek() > y) {
				//가장 높은 건물이 현재보다 높다면 그 건물+1 후 빼고 다시 비교
				stack.pop();
				result++;
			}

			if (!stack.isEmpty() && y == stack.peek()) {
				continue;
			}
			stack.add(y);

		}
		while (!stack.isEmpty()) {
			if (stack.pop() > 0)
				result++;
		}
		System.out.println(result);
	}
}
