import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = " " + br.readLine();
		String b = " " + br.readLine();
		int[][] dp = new int[a.length()][b.length()];
		for (int i = 1; i < a.length(); i++) {
			for (int j = 1; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j)) dp[i][j] = dp[i - 1][j - 1] + 1;
				 else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		System.out.println(dp[a.length() - 1][b.length() - 1]);
	}
}
