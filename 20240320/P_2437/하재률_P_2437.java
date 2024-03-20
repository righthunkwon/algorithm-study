package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2437_저울 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int tmp = arr[0];
		if(tmp != 1) {
			System.out.println(1);
			System.exit(0);
		}
		for(int i = 1; i < N; i++) {
			if(tmp + 1 < arr[i]) {
				System.out.println(tmp+1);
				System.exit(0);
			}
			else tmp += arr[i];
		}
		System.out.println(tmp+1);
	}
}
