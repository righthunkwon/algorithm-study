package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_20922_겹치는건싫어 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int res = 0;
		int l = 0;
		int r = 0;
		
		while(l < N) {
			while(r < N) { // 오른쪽 원소들 개수 세다가
				// K 개 초과하면 break하고 왼쪽 원소 빼자
				if(map.getOrDefault(arr[r], 0) + 1 > K) break;
				else map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
				r++;
			}
			
			res = res > r - l ? res : r - l;
			// 왼쪽 원소 개수 하나씩 -1
			map.put(arr[l], map.getOrDefault(arr[l], 0) - 1);
			l++;
				
		}
		System.out.println(res);
	}
}
