import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dp[][][] = new int[100001][5][5];
		int mp[][] ={{0, 2, 2, 2, 2}, {2, 1, 3, 4, 3}, {2, 3, 1, 3, 4}, {2, 4, 3, 1, 3}, {2, 3, 4, 3, 1}};
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				for (int k = 0; k < 100001; k++) dp[k][i][j] = 999999999;
		dp[0][0][0] = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s;
		for(s=1;;s++) {
			int n = Integer.parseInt(st.nextToken());
			if (n == 0) break;
			for (int i = 0; i < 5; i++) {
				if(n == i) continue;
				for(int j = 0; j < 5; j++) {
					dp[s][i][n] = Math.min(dp[s - 1][i][j] + mp[j][n],  dp[s][i][n]);
					dp[s][n][i] = Math.min(dp[s - 1][j][i] + mp[j][n], dp[s][n][i]);
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++) min = Math.min(min, dp[s-1][i][j]);
		System.out.println(min);
	}
}
