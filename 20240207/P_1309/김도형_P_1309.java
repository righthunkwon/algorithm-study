import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); 
		int [][] dp = new int[N+1][3];
		dp[1][0] = 1;  //1열 사자 x 경우의수
		dp[1][1] = 1;  //1열 사자 왼쪽
		dp[1][2] = 1;  //1열 사자 오른쪽
		for(int i = 2;i<=N;i++) {
			dp[i][0]= dp[i-1][0] + dp[i-1][1]+ dp[i-1][2]; //전꺼에서 안넣었으면 안넣거나 오른쪽, 왼쪽 넣기 가능
			dp[i][1]= dp[i-1][0] + dp[i-1][2]; //전에 왼쪽에 사자 있으니 안넣거나 오른쪽만 가능
			dp[i][2]= dp[i-1][0] + dp[i-1][1]; //전에 오른쪽에 사자 있으니 안넣거나 왼쪽만 가능
			dp[i][0] %= 9901;
			dp[i][1] %= 9901;
			dp[i][2] %= 9901;
		}
		int ans = dp[N][0]+dp[N][1]+dp[N][2];
		System.out.println(ans%9901);
	}
}
