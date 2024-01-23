package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
	
	static int N, r, c, res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		res = 0;
		
		// N = 1, r = 0, c = 0 -> 0
		// N = 1, r = 0, c = 1 -> 1
		// N = 1, r = 1, c = 0 -> 2
		// N = 1, r = 1, c = 1 -> 3
		
		// N = 2, 0, 2 -> 4
		
		sol(N, r, c);
		
		System.out.println(res);
		
	}
	static void sol(int N, int r, int c) {
		if(N == 0) return;
		
		int tmp = (int) Math.pow(2, N-1);
		
		if(tmp > r && tmp > c) {
			sol(N-1, r, c);
		}else if(tmp > r && tmp <= c) {
			res += tmp * tmp;
			sol(N-1, r, c - tmp);
		}else if(tmp <= r && tmp > c) {
			res += tmp * tmp * 2;
			sol(N-1, r - tmp, c);
		}else {
			res += tmp * tmp * 3;
			sol(N-1, r - tmp, c - tmp);
		}
		
	}
}
