package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4307_개미 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int L = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			int center = Integer.MAX_VALUE;
			int centerIdx = 0;
			int max = 0;
			
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				int tmp = L - arr[i] > arr[i] ? L - arr[i] : arr[i];
				max = max > tmp ? max : tmp;
				
				if(center > Math.abs(arr[i] - L/2)) {
					center = Math.abs(arr[i] - L/2);
					centerIdx = i;
				}
				
			}
			
			int min = arr[centerIdx] < L - arr[centerIdx] ? arr[centerIdx] : L - arr[centerIdx];
			Arrays.sort(arr);
			
			System.out.println(min + " " + max);
		}
		
	}
}
