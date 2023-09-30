package baek;

import java.io.*;
import java.util.*;

public class Pro_1049_기타줄 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] six = new int[M];
		int[] one = new int[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			six[i] = Integer.parseInt(st.nextToken());
			one[i] = Integer.parseInt(st.nextToken());
		}//입력끝
		
		//1.낱개 가격 중 가장 싼 것으로 N개 사는 것.
		//2.6개 가격중 가장 싼것으로 N개 사는 것.
		//3.6개 가격 중 가장 싼 것으로 6의 배수 사고 나머지 낱개로 사는 것
		//3가지 비교 
		Arrays.sort(six);
		Arrays.sort(one);
		
		int min=Integer.MAX_VALUE;
		min=Math.min(min, one[0]*N);
		if(N%6==0) {//6의 배수이면 낱개로 사는 것 할 필요없음
		min=Math.min(min, six[0]*(N/6));
		}else {
			min=Math.min(min, six[0]*(N/6+1)); //6개 세트로만 살 것이므로 몫+1만큼 사야함
			min=Math.min(min, six[0]*(N/6)+one[0]*(N%6));
		}				
		System.out.println(min);		
	}
}
