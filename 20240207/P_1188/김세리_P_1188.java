package _20240207;

import java.util.*;
import java.io.*;

public class _1188_음식평론가 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 최대공약수 만큼의 그룹을 만들면, 각 그룹은 최대공약수를 곱한 수만큼의 사람이 들어갈 수 있다.
		// 각 그룹 내에 소시지를 커팅할 때 각 그룹의 사람 수 -1 번 커팅을 하면 된다.
		// 전체 커팅 수는 결국 M/gcd(N,M) * (gcd(N,M)-1)과 같다.
		//  = 각 그룹이 받는 소시지의 조각 수 * 각 그룹에서 필요한 커팅 횟수
		// 따라서 M-gcd(N,M)이 답이 된다
		
		System.out.println(M-gcd(N,M));
		
	}//main
	
	public static int gcd(int a, int b) {
		while(b !=0) {
			int r = a % b;
			a=b;
			b=r;
		}
		return a;
	}

}
