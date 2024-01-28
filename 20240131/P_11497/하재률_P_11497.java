package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11497_통나무건너뛰기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(arr);
			
			// 정규분포의 형태로 정렬시켜보자
			int[] tmp = new int[N];
			int l = 0;
			int r = N-1;
			for(int i = 0; i < N; i++) {
				if(i % 2 != 0) {
					tmp[l] = arr[i];
					l++;
				} else {
					tmp[r] = arr[i];
					r--;
				}
			}
//			System.out.println(Arrays.toString(tmp));
			
			// 0번과 N-1 차이를 포함한 연속된 수 차이 중 가장 큰 거 구하기
			int res = Math.abs(tmp[N-1] - tmp[0]);
			
			for(int i = 1; i < N; i++)
				res = res > Math.abs(tmp[i] - tmp[i-1]) ? res : Math.abs(tmp[i] - tmp[i-1]);
			
			System.out.println(res);
		}
	}
}
