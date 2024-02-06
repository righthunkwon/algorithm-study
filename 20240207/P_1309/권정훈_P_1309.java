
import java.io.*;
import java.util.*;

// 동물원
// 점화식 직접 나열해보면서 규칙을 찾은 뒤 유형 분류 
public class P_1309 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N
		int[][] dp = new int[N + 1][3];
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901; // 다음줄 X
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][0]) % 9901; // 다음줄 첫번째 칸
			dp[i][2] = (dp[i - 1][1] + dp[i - 1][0]) % 9901; // 다음줄 두번째 칸
		}
		System.out.println(Arrays.stream(dp[N]).sum() % 9901);
	}
}
