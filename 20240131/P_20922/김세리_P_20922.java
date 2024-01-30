package _20240131;

import java.io.*;
import java.util.*;


public class _20922_겹치는건싫어 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 수열의 길이
		int K = Integer.parseInt(st.nextToken()); // 포함 가능한 같은 정수 최대 개수
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		// HashMap에 각 숫자를 키로 해서 개수를 기록한다
		HashMap<Integer, Integer> countMap = new HashMap<>();
		
		int start=0; int max=0;
		// 시작점을 0, 끝점을 0으로 하고
		// 끝을 하나씩 옆으로 늘려나간다
		
		for(int end=0;end<N;end++) {
			// 그때마다 HashMap에 등록된 arr[end] 값의 갯수를 꺼내서 1을 추가해준다
			countMap.put(arr[end], countMap.getOrDefault(arr[end], 0)+1);
			
			// 만약에 숫자의 개수가 K개를 넘어가면
			// start를 K개가 넘지 않을 때까지 옆으로 이동해준다
			// 그리고 arr[start] 값에 대응하는 개수를 꺼내서 -1 해준다
			while(countMap.get(arr[end])>K) {
				countMap.put(arr[start], countMap.get(arr[start])-1);
				start++;
			}
			// 그렇게 처음부터 끝까지 나아가면서 max길이를 계속 갱신해준다
			max = Math.max(max, end-start+1);
		}
		System.out.println(max);
		
		
	}//main

}
