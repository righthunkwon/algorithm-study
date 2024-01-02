package _20240103;

import java.util.*;
import java.io.*;

public class _3343_장미 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		long D = Long.parseLong(st.nextToken());
		
		long good =0, goodp=0, bad=0, badp=0;
		
		// B/A > D/C 이면 C묶음으로 사는게 가성비가 좋다
		// < 이면 A묶음으로 사는게 가성비가 좋다
		
		// 가성비 좋은 세트
		// 수량: good 가격: goodp
		// 가성비 안좋은 세트
		// 수량: bad 가격: badp 로 한다
		if(B*C>D*A) {
			good=C; goodp=D; bad=A; badp=B;
		} else {
			good=A; goodp=B; bad=C; badp=D;
		}
		
		long ans =Long.MAX_VALUE;
		
		// 결국 가성비 안좋은 세트는 가성비 좋은 세트의 개수보다 크게 살 일이 없다
		// 그 수를 넘어가면 가성비 좋은 세트를 살 것이기 때문이다
		// 그러므로 가성비 좋지 않은 세트를 0개부터 가성비 좋은 세트-1개 까지 사는 경우를 구해서
		// 이 중에 가장 최솟값을 출력하면 된다
		
		for(long i=0;i<good;i++) {
			long cost =i*badp;
			long leftN = N-i*bad;
			// 남은 장미 개수가 0이상일 때 가성비 좋은 세트 추가로 구매한다
			if(leftN>=0) {
				if(leftN%good==0) {
					cost += goodp*(leftN/good);
				} else {
					cost += goodp*((leftN/good)+1);
				}
			}
			ans = Math.min(ans, cost);
		}
		System.out.println(ans);
		
		
	}//main

}
