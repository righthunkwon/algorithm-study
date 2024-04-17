package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7579_앱 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] m = new int[N];
		int[] b = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) m[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) b[i] = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[10001];
		for(int i = 0; i < N; i++) {
			for(int j = 10000; j >= 0; j--) {
				if(j-b[i] >= 0)
				dp[j] = Math.max(dp[j], dp[j-b[i]] + m[i]);
			}
//			for(int k = 0; k <= 30; k++) System.out.print(dp[k] + " ");
//			System.out.println();
		}
		
		for(int i = 0; i <= 10000; i++) {
			if(dp[i] >= M) {
				System.out.println(i);
				return;
			}
		}
		
	}
}
