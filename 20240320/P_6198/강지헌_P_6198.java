import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		long ans=0;
		for (int i = 0; i < N; i++) {
			int t = Integer.parseInt(br.readLine());
			while (!st.isEmpty()) {
				if (st.peek() <= t) st.pop();
				else break;
			}
			ans += st.size();
			st.push(t);
		}
		System.out.println(ans);
	}
}
