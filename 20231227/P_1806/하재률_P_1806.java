package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int idx1 = 0;
		int idx2 = 0;
		int sum = 0;
		int res = N+1;
		
		while(idx1 <= idx2 && idx2 <= N) {
			if(sum <= S) sum += arr[idx2++];
			else sum -= arr[idx1++];
			
			if(sum >= S) res = res < idx2 - idx1 ? res : idx2 - idx1;
		}
		System.out.println(res == N+1 ? 0 : res);
		
	}
}
