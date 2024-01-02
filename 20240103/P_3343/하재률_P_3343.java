package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3343_장미 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		long D = Integer.parseInt(st.nextToken());
		
		// 가성비 안조은거
		long tmp1 = 0;
		long tmp2 = 0;
		// 가성비 조은거
		long tmp3 = 0;
		long tmp4 = 0;
		long res = Long.MAX_VALUE;
		if(A*D < C*B) {
			tmp1 = A;
			tmp2 = B;
			tmp3 = C;
			tmp4 = D;
		}else {
			tmp1 = C;
			tmp2 = D;
			tmp3 = A;
			tmp4 = B;
		}
		
		for(int i = 0; i < tmp3; i++) {
			long price = 0;
			long tmpN = N;
			tmpN -= tmp1 * i;
			long tmp = (long) Math.ceil((double) tmpN / tmp3);
			if(tmp < 0) tmp = 0;
			price += tmp2 * i;
			price += tmp4 * tmp;
			
			res = res < price ? res : price;
		}
		
		System.out.println(res);
	}
}
