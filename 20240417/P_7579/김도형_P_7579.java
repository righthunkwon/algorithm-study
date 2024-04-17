package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Q7579_앱 {
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //현재 활성화된 앱의 수
		int M = Integer.parseInt(st.nextToken()); //추가로 확보해야 될 바이트 양
		st = new StringTokenizer(br.readLine());
		int []memory = new int[N+1];
		for(int i=1;i<=N;i++)memory[i]=Integer.parseInt(st.nextToken()); //각 앱이 사용중인 메모리 입력
		st = new StringTokenizer(br.readLine());
		int []cost = new int[N+1];
		for(int i=1;i<=N;i++)cost[i]=Integer.parseInt(st.nextToken()); //각 앱을 비활성화할때 비용 입력
		
		int [][] dp = new int[N+1][10001];
		
		for(int i=1; i<N+1;i++) {
			for(int j =0;j<=10000;j++) {
				if(j<cost[i]) {
					dp[i][j]=dp[i-1][j];
				}else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-cost[i]]+memory[i]);
				}
			}
		}
		
		for(int i=0;i<=10000;i++) { 
			if(dp[N][i]>=M) { //dp배열 돌면서 필요한 메모리 이상 확보 가능할 경우, 그때의 비용 출력
				System.out.println(i);
				return;
			}
		}
		
		
	}//main
}//class
