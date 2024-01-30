package _20240131;

import java.io.*;

public class _2631_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] children = new int[N];
        int[] dp = new int[N]; // 가장 긴 부분수열의 길이를 나타낸다

        for (int i = 0; i < N; i++) {
            children[i] = Integer.parseInt(br.readLine());
            dp[i] = 1;  // 각 위치에서의 최소 길이는 1(i에서의 부분수열 최소 길이는 1이므로)
        }
        
        // max는 존재하는 가장 긴 부분수열의 길이를 나타낸다
        int max = 0;
        
        for (int i=0;i<N;i++) {
            for (int j=0;j<i;j++) {
            	// children[i]는 현재위치, children[j]는 이전 위치를 나타냄
            	// 이전 위치보다 현재 위치가 크다면
            	// dp값이 최대가 되는 경우로
            	// 부분수열의 합을 갱신해준다
                if (children[j]<children[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            // dp값 중 가장 큰 값을 max에 넣어준다
            max = Math.max(max, dp[i]);
        }
        // 전체 수에서 가장 긴 증가하는 부분 수열의 길이(max)를 빼서 결과를 구한다
        System.out.println(N-max);
    }
}
