package _20231227;

import java.util.*;
import java.io.*;

public class _1806_부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		Integer[] arr = new Integer[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int ans=Integer.MAX_VALUE;
		int start=0, end=0, sum=0;
		// 시작점이랑 끝 점을 정하고 조건과 비교해서
		// 크면 앞에걸 빼고 작으면 뒤에걸 더하는 식으로 반복해서
		// 답을 구한다
		while(true) {
			if(sum>=S) {
				//조건 만족하는 것중 가장 짧은것을 ans에 저장
				ans = Math.min(ans, end-start);
				// S보다 크면 앞에 있는 애를 빼서 
				sum -= arr[start++];
			} else if(end == N) {
				break;
			} else {
				sum += arr[end++];
			}
		}
		
		// 시간초과 코드
//		int cnt=0;
//		int start=0;
//		while(start<N) {
//			int sum=0;
//			for(int i=start;i<N;i++) {
//				sum += arr[i];
//				if(sum>=S) {
//					cnt = i-start+1;
//					break;
//				}
//			}
//			ans = Math.min(ans, cnt);
//			start++;
//		}
		
		if(ans==Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(ans);
		
	}//main

}
