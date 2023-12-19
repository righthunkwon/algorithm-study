package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q11066_파일_합치기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테케 수
		for(int tc=1;tc<=T;tc++) {
			int K = Integer.parseInt(br.readLine()); //장의 수(3~500)
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[]arr = new int[K+1]; //입력 받는 숫자들 배열
			int[][]dp = new int[K+1][K+1]; //dp배열( dp[a][b] -> a~b까지의 파일을 합치는 최소비용 )
			int[]nu=new int[K+1]; //누적합 배열
			for(int i=1;i<=K;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				nu[i]=nu[i-1]+arr[i]; //누적합 구해주기
			}
			
			//이거 필요 없음..
//			for(int i=1;i<K;i++) {
//				dp[i][i+1]=arr[i]+arr[i+1];
//			}
			for(int i=1;i<=K;i++) {//합칠 파일 수 1~K개까지..
				for(int a=1;a+i<=K;a++) {
					dp[a][a+i]=987654321; //일단 큰 수로 초기화
					for(int j=a;j<a+i;j++) { //반복문 돌리면서 dp[a][a+i]의 최소를 구하려고함!
						//dp[a][j]+dp[j+1][a+i] -> a~j합치는 최소값 + j+1~a+i합치는 최소값
						//nu[a+i]-nu[a-1] -> a~a+i까지의 구간합
						dp[a][a+i]=Math.min(dp[a][a+i], dp[a][j]+dp[j+1][a+i]+nu[a+i]-nu[a-1]);
					}
				}
			}
      
			System.out.println(dp[1][K]); 
		}
	}//main
}//class
