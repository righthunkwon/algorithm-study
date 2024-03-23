import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static String N;
	static String arr[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.next();
		String a = sc.next();
		String b = sc.next();
		// 일단 시작이 위냐 아래냐에 따라 2가지 경유의 수 가능
		long[][][] dp = new long[2][N.length()][b.length()];

		// 우선 시작지점이 첫번째 돌다리랑 같으면 1 설정
		if(N.substring(0,1).equals(a.substring(0,1))) {
			dp[0][0][0] = 1;
		}
		if(N.substring(0,1).equals(b.substring(0,1))) {
			dp[1][0][0] = 1;
		}
		// 1부터 이제 시작하면서 
		// a를 하나씩 찾다가
		// 만약 n에서 해당하는 글자번쨰 수가 나오면 +1씩 해주면서 구함
		for(int i = 1 ; i<a.length();i++) {
			// a와 b에서 i번째 글자를 먼저 빼서
			dp[0][0][i] = dp[0][0][i-1];
			dp[1][0][i] = dp[1][0][i-1];
			// N에서 0번째 글자가 일치하면 각항에서 +1씩해줌
			// 1번부터 확인하기 위해
			String tmp = N.substring(0,1);
			if(tmp.equals(a.substring(i,i+1))) {
				dp[0][0][i] += 1;
			}
			if(tmp.equals(b.substring(i,i+1))) {
				dp[1][0][i] += 1;
			}
			// 이제 각 1번항부터 서로 확인
			for(int j = 1; j<N.length();j++) {
				dp[0][j][i] += dp[0][j][i - 1];
				dp[1][j][i] += dp[1][j][i - 1];
				// 전항값 미리 가져오고 
				// 확인해서 같으면 반대쪽에 있는 
				// 전항의 개수만큼 가능해서 +해줌
				tmp = N.substring(j,j+1);
				if(tmp.equals(a.substring(i,i+1))) {
					dp[0][j][i] += dp[1][j-1][i-1];
				}
				if(tmp.equals(b.substring(i,i+1))) {
					dp[1][j][i] += dp[0][j-1][i-1];
				}
			} // for j
		} // for i
		
		// 이제 끝에 두개를 더함
		System.out.println(dp[0][N.length()-1][a.length()-1] + dp[1][N.length()-1][a.length()-1]);

	}

}
