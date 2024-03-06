package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9527_1의개수세기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Long A = Long.parseLong(st.nextToken());
		Long B = Long.parseLong(st.nextToken());
		
		System.out.println(sol(B) - sol(A-1));
	}
	
	// 각 비트 위치에서 1의 개수는 패턴을 가짐..
	// 첫번째 자리 : 1 증가할때마다 0 1 반복
	// 두번째 자리 : 2 증가할때마다 0 0 1 1 반복
	// 세번째 자리 : 4 증가할때마다 0 0 0 0 1 1 1 1 반복
	// i 번째 자리 비트는 2^(i-1) 주기로 1이 되고 1이 된 횟수는 2^(i-1)번이다
	// 나머지 계산해서 더해주면 끗
	static long sol(long n) {
		long i = 1;
		long res = 0;
		while(i <= n) {
			res += (n / (i * 2)) * i;
			if(n % (i * 2) - i + 1 > 0) res += n % (i * 2) - i + 1; 
			i *= 2;
		}
		return res;
	}
}
