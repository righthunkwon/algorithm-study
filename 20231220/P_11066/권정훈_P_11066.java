import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파일 합치기
public class P_11066 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int ans = 0;
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n + 1];
			int[][] dp = new int[n + 1][n + 1];

			st = new StringTokenizer(br.readLine(), " ");
			arr[1] = Integer.parseInt(st.nextToken()); // 초기값 세팅

			System.out.println(ans);
		}
	}
}
