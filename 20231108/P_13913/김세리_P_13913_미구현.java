package _20231108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _13913_숨바꼭질4 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈이 현재 위치 
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치
        
        int MAX = 2 * Math.max(N, K) + 1;

        //만약에 동생이 수빈이 뒤에 있으면 한칸씩 뒤로 가서 만나야 한다
        if(K<=N) {
            System.out.println(N-K); // 걸리는 시간
            for(int i=0;i<=N-K;i++) {
            	System.out.print(N-i+ " ");
            }
        }
        // K>N 일 경우
        else {
            int[][] dp = new int [2][MAX]; //0행은 최단시간, 1행은 그 전 경로 저장
            for(int i=0;i<=N;i++) {
                dp[0][i] = N-i;
            }
            for(int i=N+1;i<=K;i++) {
                if(i%2==0) {
                    int a = dp[0][i/2]+1;
                                 
                    dp[0][i]= a;
                    dp[1][i]= i/2;

                }else {
                    int b = dp[0][(i-1)/2]+2;
//                    int c = dp[0][(i+1)/2]+2; 
//                    dp[0][i]= Math.min(b, c);
                    dp[0][i]= b; dp[1][i]=i-1;
//                    if(dp[0][i]==b) dp[1][i]=i-1;
//                    if(dp[0][i]==c) dp[1][i]=i+1;
                }

            }
            System.out.println(Arrays.deepToString(dp));
            sb.append(dp[0][K]+"\n");

//            while(K != N) {
//            	sb.append(dp[1][K]+" ");
//            	K = dp[1][K];
//            }
        }
//        sb.append(N);
        System.out.println(sb.reverse());
        


    }//main
}

