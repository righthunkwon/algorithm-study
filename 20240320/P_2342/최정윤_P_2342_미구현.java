package study_240320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro_2342_DDR {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int left = 0, right = 0;
		int left2 = 0, right2 = 0;
		int[][] dp = new int[100001][2];// left로 밟았을때와 right로 밟았을때?
		dp[1][0] = dp[1][1] = 2;
		int cmd = 0;
		while (true) {
			cmd++;
			int input = Integer.parseInt(st.nextToken());
			if (input == 0)
				break;
			// 같은 수 연속되면 무조건 +1
			// 1-3/2-4가 힘 4
			// 나머지 3
			// 0포함 2
			if (left == input) {
			}

		}

	}
}
