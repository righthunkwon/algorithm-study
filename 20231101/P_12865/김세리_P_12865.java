package _20231101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 준서가 버틸 수 있는 무게
        int[] Ws = new int [N+1];
        int[] Vs = new int [N+1];
        int[][] dp = new int[N+1][K+1];
        
        for(int i=1;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            Ws[i] = Integer.parseInt(st.nextToken());
            Vs[i] = Integer.parseInt(st.nextToken());
        }
    }//main

}
