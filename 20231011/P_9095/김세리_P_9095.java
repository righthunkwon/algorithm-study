import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095_123더하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder s = new StringBuilder();
		// n이 11보다 작다고 했으므로 dp배열을 11로 한다
		int[] dp = new int[11];
		
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			for(int i=1;i<=n;i++) {
				// 숫자 1, 2, 3 을 가지고 수를 만드는 것이므로
				// dp[3]까지는 결과값을 채워준다
				if(i<=3) {
					dp[1]=1;
					dp[2]=2;
					dp[3]=4;
				}else {
					// dp[i]의 값을 dp를 이용해서 식을 만들어준다
					dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
				}
			}
			// stringbuilder를 이용해서 답을 저장한다
			s.append(dp[n] + "\n");
			
		}//T
		System.out.println(s);
	}//main

}
