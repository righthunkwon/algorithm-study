package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		// 입력 완료
		
		int ans = Integer.MAX_VALUE;
		int sum = 0;
		int l = 0;
		int r = N - 1;
		int a = arr[l];
		int b = arr[r];
		
		while(l < r) {
			sum = arr[l] + arr[r];
			// 0에 가까운 정답 찾으면 a, b 갱신
			if(Math.abs(sum) < ans) {
				ans = Math.abs(sum);
				a = arr[l]; b = arr[r];
			}
			// l과 r 한 칸씩 옮겨보기
			if(sum == 0) break;
			else if(sum > 0) r--;
			else l++;
		}
		System.out.println(a + " " + b);
	}
}
