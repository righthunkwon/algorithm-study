package _20240110;

import java.util.*;
import java.io.*;

public class _1253_좋다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] arr = new long[N];
		for(int i=0;i<N;i++) {
			long a = Long.parseLong(st.nextToken());
			arr[i] = a;
		}
		
		Arrays.sort(arr);
		
		int ans =0;
		for(int i=0;i<N;i++) {
			int left = 0;
			int right = N-1;
			
			while(true) {
				if(left==i) left++;
				else if(right==i) right--;
				
				if(left>=right) break;
				
				if(arr[left]+arr[right]>arr[i]) right--;
				else if(arr[left]+arr[right]<arr[i]) left++;
				else {
					ans++;
					break;
				}
			}
		}
		System.out.println(ans);
	}//main

}
