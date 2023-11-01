package _20231101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12851_숨바꼭질2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈이 현재 위치 
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치

        //만약에 동생이 수빈이 뒤에 있으면 한칸씩 뒤로 가서 만나야 한다
        if(K<=N) {
            System.out.println(N-K); // 걸리는 시간
            System.out.println(1); // 방법의 수
        }
        // K>N 일 경우
        else {
            int[][] dp = new int [2][100001]; //0행은 최단시간, 1행은 방법 수 저장
            for(int i=0;i<=N;i++) {
                dp[0][i] = N-i;
                dp[1][i] = 1;
            }
            for(int i=N+1;i<=K;i++) {
                if(i%2==0) {
                    int a = dp[0][i/2]+1;
                    int b = dp[0][i-1]+1;
//                    int c = dp[0][i+1]+1;
//                    int d = dp[0][i-1]+1;
//                    int e = dp[0][i+1]+1;
                    
                    dp[0][i]= Math.min(a, b);
                    if(dp[0][i]==a) dp[1][i] += dp[1][i/2];
                    if(dp[0][i]==b) dp[1][i] += dp[1][i-1];
//                    if(dp[0][i]==c) dp[1][i] += dp[1][i+1];
//                    if(dp[0][i]==d) dp[1][i]++;
//                    if(dp[0][i]==e) dp[1][i]++;
//                    System.out.println(a+" "+b+" "+c+" "+d+" ");
                }else {
                    int b = dp[0][(i-1)/2]+2;
                    int c = dp[0][(i+1)/2]+2;
                    int d = dp[0][i-1]+1;
//                    int e = dp[0][i+1]+1;
                    
                    dp[0][i]= Math.min(Math.min(b, c),d);
                    
                    if(dp[0][i]==b) dp[1][i] += dp[1][(i-1)/2];
                    if(dp[0][i]==c) dp[1][i] += dp[1][(i+1)/2];
                    if(dp[0][i]==d) dp[1][i] += dp[1][i-1];
//                    if(dp[0][i]==e) dp[1][i]++;
                    
//                    System.out.println(b+" "+c+" "+d+" ");
                }

            }
            for(int i=1;i<=K;i++) {
                System.out.print(dp[0][i]+" ");               
            }
            System.out.println();
            for(int i=1;i<=K;i++) {
                System.out.print(dp[1][i]+" ");               
            }
            System.out.println();
            System.out.println(dp[0][K]);
            System.out.println(dp[1][K]);


        }




    }
}
