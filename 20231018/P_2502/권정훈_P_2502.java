package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 떡 먹는 호랑이
// 피보나치 떡 먹는 호랑이 

// 	1		2		3		4		5		6	
// 	a		b		a+b		a+2b	2a+3b	3a+5b	

public class P_2502 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // dp
        int[][] dp = new int[31][2];

        // 초기값 세팅
        // 첫째날
        dp[1][0] = 1; // a=1
        dp[1][1] = 0; // b=0
        
        // 둘째날
        dp[2][0] = 0; // a=0
        dp[2][1] = 1; // b=1

        // 셋째날부터 d번째 날까지의 떡의 개수
        for (int i = 3; i <= d; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0]; 
            dp[i][1] = dp[i-1][1] + dp[i-2][1]; 
        }

        // 전체 떡 준 개수 = 계수 * 하루마다 준 개수
        // d번째 날의 떡의 개수(=== 계수)
        int n = dp[d][0]; // dp[d][0] = dp[d-1][0] + dp[d-2][0]
        int m = dp[d][1]; // dp[d][1] = dp[d-1][1] + dp[d-2][1]

        // 첫째날의 떡의 개수(=== 하루마다 준 개수)
        int a = 1; // 첫째날에 준 떡의 개수
        int b = 1; // 둘째날에 준 떡의 개수 

        // 브루트포스로 첫째날의 떡의 개수 탐색
        while (true) {
        	// a와 b의 값을 찾았다면 정답 출력
            if (n*a  + m*b == k) { 
                System.out.println(a);
                System.out.println(b);
                break;
            } 
            // a와 b값이 k보다 작다면 b의 값을 하나 증가시킴
            else if (n*a + m*b < k) { 
                b++;
            } 
            // a와 b의 값이 k보다 크다면 a값을 하나 증가시키고 b는 다시 1부터 탐색
            else { 
                a++;
                b=1;
            }
        }
    }
}
