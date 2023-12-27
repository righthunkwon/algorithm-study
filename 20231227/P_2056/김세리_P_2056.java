package _20231227;

import java.util.*;
import java.io.*;

public class _2056_작업 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// dp배열 크기를 N+1로 해서 만든다
		// dp에는 각 일을 할때까지 걸리는 시간을 저장한다(선행되어야 하는 일도 고려)
		int[] dp = new int[N+1];
		dp[0]=0;
		// 일 하는데 가장 오래 걸리는 시간이 결국 전체 일 하는데 걸리는 시간이다
		int max=0;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 해당 일 하는데 걸리는 시간
			int b = Integer.parseInt(st.nextToken()); // 선행되어야 하는 일의 개수
			// 선행되어야 하는 작업 중에서 가장 오래걸리는 시간을 c에 저장한다
			int c = Integer.MIN_VALUE;
			if(b==0) { // 선행되어야 하는 작업이 없다면 c=0이다
				c=0;
			} else if(b>=2) {
				// 선행되어야 하는 작업이 2개 이상이면 비교해서 가장 긴 시간이 걸리는걸 저장한다
				for(int j=0;j<b;j++) {
					int d = Integer.parseInt(st.nextToken());
					c = Math.max(c, dp[d]);
				}
			}else {
				// 선행되어야 하는 작업이 1개라면 c는 그 선행작업을 하는데 걸리는 시간이다
				int d = Integer.parseInt(st.nextToken());
				c = dp[d];
			}
			// dp[i+1] = i+1번째 작업을 하는데 걸리는 시간 + 선행되어야 하는 작업 중 가장 긴 시간
			dp[i+1]=a+c;
			// max값을 계속 갱신해준다
			max = Math.max(max, dp[i+1]);
			
		}
		System.out.println(max);
	}//main

}
