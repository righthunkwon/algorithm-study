package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Q2056_작업 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //작업 수
		int dp[] = new int[N];
		int ans = 0; //정답
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int sunNum = Integer.parseInt(st.nextToken());//선행작업 갯수
			dp[i]=time; //일단 선행작업 생각 안하고 시간 입력
			for(int j=0;j<sunNum;j++) { //선행작업 있으면
				int x = Integer.parseInt(st.nextToken())-1; //선행작업의 인덱스 x
				dp[i]=Math.max(dp[i], dp[x]+time); //자기가 걸리는 시간, 선행작업 소요시간+현재작업 소요시간 중 큰걸로 갱신
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
		
	}//main
}//class
