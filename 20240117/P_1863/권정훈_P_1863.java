import java.io.*;
import java.util.*;

// 스카이라인 쉬운거
// 아이디어가 잘 떠오르면 좋겠다
public class P_1863 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[50001]; // 높이

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = y; // 높이 저장
		}
		
		int ans = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i <= n; i++) {
			// 높이가 낮아졌을 경우
			// 스카이라인이 끊기며 건물이 하나 더 있으므로 건물을 더하고 pop 
			while (!stack.empty() && stack.peek() > arr[i]) {
				ans++;
				stack.pop();
			}

			// 높이가 같을 경우
			// 빌딩을 확정할 수 없으므로 패스
			if (!stack.empty() && stack.peek() == arr[i]) {
				continue;
			}

			// 높이가 높아졌을 경우
			// 건물 최고 높이 갱신
			stack.push(arr[i]);
		}
		System.out.println(ans);
	}
}
