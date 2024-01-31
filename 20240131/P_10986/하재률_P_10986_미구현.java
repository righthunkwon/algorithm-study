package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10986_나머지합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		Long[] nu = new Long[N];
		Long tmp = 0L;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			tmp += arr[i];
			nu[i] = (long) (tmp % M);
		}
		
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(nu));
		
		int[] res = new int[N];
		if(nu[0] == 0) res[0] = 1;
		
		for(int i = 1; i < N; i++) {
			res[i] = res[i-1];
			if(nu[i] == 0) {
				res[i]++;
				for(int j = 0; j < i; j++) if(nu[j] == 0) res[i]++;
			}
			else {
				for(int j = i-1; j >= 0; j--) {
					if(nu[j] == 0) continue;
					else if(nu[j] != nu[i]) break;
					else if(nu[j] == nu[i]) {
						res[i]++;
						break;
					}
				}
			}
		}
		
//		System.out.println(Arrays.toString(res));
		System.out.println(res[N-1]);
		
		
		
	}
}
