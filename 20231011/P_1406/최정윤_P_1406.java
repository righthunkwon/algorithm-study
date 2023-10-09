import java.io.*;
import java.util.*;

public class Pro_1406_에디터 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		Stack<Character> result = new Stack<>();
		char[] arr = br.readLine().toCharArray();
		for (int i = 0; i < arr.length; i++) {
			stack.add(arr[i]);
		}
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			switch (cmd) {
			case "L":
				if (!stack.isEmpty()) {
					result.add(stack.pop());
				}
				break;
			case "D":
				if (!result.isEmpty()) {
					stack.add(result.pop());
				}
				break;
			case "B":
				if (!stack.isEmpty()) {
					stack.pop();
				}
				break;
			case "P":
				char a = st.nextToken().charAt(0);
				stack.add(a);
				break;
			}
		}
		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}
		while (!result.isEmpty()) {
			sb.append(result.pop());
		}
		System.out.println(sb);
	}
}
