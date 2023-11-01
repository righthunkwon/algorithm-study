package _20231101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 준서가 버틸 수 있는 무게
        int[] Ws = new int [N+1]; // 각 물건의 무게
        int[] Vs = new int [N+1]; // 해당 물건의 가치
        int[][] dp = new int[N+1][K+1]; // 가치 최댓값을 입력할 dp배열
        
        for(int i=1;i<N+1;i++) {
            st = new StringTokenizer(br.readLine());
            Ws[i] = Integer.parseInt(st.nextToken());
            Vs[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=1;i<=N;i++) { // 물건을 1개 넣었을 때부터 N개 넣었을 때 까지의 무게
        	for(int j=0;j<=K;j++) { // 0부터 준서가 버틸 수 있는 물건의 무게까지 서서히 증가
        		// 만일 이번 차례에 물건을 넣을 수 있다면
        		// 이번 물건을 넣기 전에 가방에 있는 가치의 합 + 지금 넣을 물건의 가치
        		// 그 전 무게 단계에서 물건의 가치의 합
        		// 이 둘 중에 더 큰 값이 최대 가치의 값이 된다.
        		if(Ws[i]<=j) dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-Ws[i]]+Vs[i]);
        		// 이번 차례에 물건을 넣을 수 없다면
        		// 그 전 단계에서의 가치의 최댓값이 현재에도 이어진다.
        		else dp[i][j] = dp[i-1][j];
        	}
        }
//        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[N][K]);
        
    }//main

}
