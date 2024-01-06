package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253_좋다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		// 일단 정렬해주고
		Arrays.sort(arr);
		int cnt = 0;
		
		/*
		 * 마지막 인덱스부터 돌면서 두 포인터를 0, i-1로 잡고 돌렸지만
		 * 음수를 생각해야해서.... 바꾸었습니다
		 */
		
		// 하나씩 확인
		for(int i = 0; i < N; i++) {
			int tmp = arr[i];
			int l = 0;
			int r = N-1;
			
			while(l < r) {
				int sum = arr[l] + arr[r];
				if(tmp == sum) {
					if(l != i && r != i) { // 다른 수 두 개의 합으로 나타내야 하니까
						cnt++;
						break;
					}
					// 인덱스 조정
					if(l == i) l++;
					else r--;
				
				} else if(tmp > sum) l++; // 합이 더 작으면 왼쪽포인터 ++
				else r--; // 합이 더 크면 오른쪽포인터 --
			}
		}
		System.out.println(cnt);
	}
}
