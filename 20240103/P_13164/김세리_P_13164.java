package _20240103;

import java.util.*;
import java.io.*;

public class _13164_행복유치원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		// 원생들의 키 차이를 list에 담는다
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<N;i++) {
			list.add(arr[i]-arr[i-1]);
		}
		// 그 키차이를 정렬해준다
		Collections.sort(list);
		
		// 최소비용이 드는 그룹을 만들기 위해서
		// N-K개 만큼 그룹을 합쳐준다
		int ans = 0;
		for(int i=0;i<N-K;i++) {
			ans += list.get(i);
		}
		
		System.out.println(ans);
		
	}//main

}
