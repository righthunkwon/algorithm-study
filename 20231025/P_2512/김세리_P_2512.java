package _20231025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2512_예산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		long sum=0;
		int max=0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			// 아래 식으로 풀면 메모리 초과남...
			// split[] 이런식으로 푸는게 for문 돌때마다 반복되는거라
			// 생각보다 메모리 많이 든다고 한다
//			arr[i] = Integer.parseInt(st.split(" ")[i]);
			if(arr[i]>max) max = arr[i];
		}
		int tBud = Integer.parseInt(br.readLine());
			int lo = 1;
			int hi = max;
			int mid =0; int ans=0;
			while(lo<=hi) {
				mid = (lo + hi)/2;
				sum=0;
				for(int i=0;i<N;i++) {
					if(arr[i]<mid) {
						sum += arr[i];
					}else {
						sum += mid;
					}
				}
				
				if(sum>tBud) hi = mid-1;
				if(sum<=tBud) {
					ans = mid; lo = mid+1;
				}
			}
			System.out.println(ans);
	}//main
}
