package Algo_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 하재률_P_1654 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		
		long end = 0;
		
		for(int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > end) end = arr[i];
		}// 입력 하면서 end값 찾아주기
		
		long start = 1;
		long mid = 0;
		
		while(start <= end) {
			long cnt = 0;
			mid = (end + start) / 2;
			
			for(int i = 0; i < arr.length; i++) {
				cnt += (arr[i] / mid);
			}
			
			if(cnt < N) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(start - 1);
		
	}
}
