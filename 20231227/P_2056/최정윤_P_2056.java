import java.io.*;
import java.util.*;
public class Pro_2056_작업 {
	static int[] time;
	static List<Integer>[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = new ArrayList<Integer>();// 선행되어야하는 것 담기 
		}
		time = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				arr[i].add(Integer.parseInt(st.nextToken()));
			}
		} // 입력끝

		int dp[] = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			for (Integer a : arr[i]) {
				dp[i] = Math.max(dp[i], dp[a]);
			}
			dp[i] += time[i];
		}
		int result = 0;
		for (int i = 1; i < N + 1; i++) {
			result = Math.max(dp[i], result);
		}
		System.out.println(result);
	}
}
