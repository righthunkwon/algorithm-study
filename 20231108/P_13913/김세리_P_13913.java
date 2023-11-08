package _20231108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _13913_숨바꼭질4 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈이 현재 위치 
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치
        
        // dp배열 크기를 임의의 수 MAX를 구해 정한다
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
            int[] dp = new int [MAX]; // dp에 최단시간 저장
            // 0부터 N까지는 하나씩 뒤로가는 걸 계산해서 채워준다
            for(int i=0;i<=N;i++) {
                dp[i] = N-i;
            }
            //N+1부터 임의로 만든 MAX까지 조건에 따라 채워준다
            for(int i=N+1;i<MAX;i++) {
            	
            	// i가 2의 배수일 때 i에 도달할 수 있는 방법 중 최소르 구한다
                if(i%2==0) {
                    int a = dp[i/2]+1; // i/2지점에서 두배로 i에 도달하는 방법
                    dp[i]= Math.min(a,dp[i-1]+1); // i 한칸 앞에서 i로 움직이는 방법 중 최소값을 저장한다

                }else {
                	// i가 홀수 일 때
                    int b = dp[(i-1)/2]+2; // (i-1)/2 지점에서 두배로 i-1에 도달하고, i로 한 칸 움직이는 방법
                    int c = dp[(i+1)/2]+2; // (i+1)/2 지점에서 두배로 i+1에 도달하고, i로 한 칸 움직이는 방법
                    int d = dp[i-1]+1; // i 한칸 앞에서 i로 움직이는 방법
                    dp[i]= Math.min(Math.min(b, c),d); // 위 세가지 방법중에 최소값을 구한다
                }

            }
            System.out.println(dp[K]); // 일단 최단시간을 출력한다
            
            // dp배열을 다 채운 다음에, 현재 위치에서 그 전 지점으로 가는 것을 역으로 구해서 stack에 저장하고, 출력한다
            Stack<Integer> s = new Stack<>();
            
            s.add(K); // 현재 지점 stack 추가
            
            // 여러 경우의 수 중에 하나만 출력하면 되므로 
            // 최단시간인 dp[K]에서 1초씩 빼가면서 그 수에 해당하는 위치를 구하고,
            // stack에 추가한 후에
            // K를 그 위치로 바꿔주고,
            // K가 N(처음 시작점)이 되기 전까지 이 행위를 반복한다.
            while(K != N) {
            	if(dp[K]-1==dp[K-1]) {
            		s.add(K-1);
            		K = K-1;
            	}
            	else if(dp[K]-1==dp[K+1]) {
            		s.add(K+1);
            		K = K+1;
            	}
            	else if(dp[K]-1==dp[K/2] && K%2==0) {
            		s.add(K/2);
            		K = K/2;
            	}
            	else if(dp[K]-2==dp[(K-1)/2] && K%2==1) {
            		s.add((K-1)/2);
            		K = (K-1)/2;
            	}
            	else if(dp[K]-2==dp[(K+1)/2] && K%2==1) {
            		s.add((K+1)/2);
            		K = (K+1)/2;
            	}
            	
            }//while
            
            // N=K가 되어서 필요한 값이 stack에 다 저장되었으므로
            // stack에 있는 값을 하나씩 빼서 출력한다
            while(!s.isEmpty()) {
            	System.out.print(s.pop()+" ");
            }
        }

    }//main
}

