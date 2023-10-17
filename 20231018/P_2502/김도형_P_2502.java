package AlgoStudy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_Q2502_떡_먹는_호랑이 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int D = sc.nextInt(); //할머니가 넘어온 날 (3 ~ 30)
		int K = sc.nextInt(); //그날 호랑이에게 준 떡 개수(10 ~ 100,000)
		
		
		int [] fibo = new int[D+1];
		fibo[1] = 1;
		fibo[2] = 1;
		
		for(int i=3; i<=D;i++) {
			fibo[i] = fibo[i-2]+fibo[i-1];
		}
		
//		System.out.println(Arrays.toString(fibo));
		// K = fibo[D-2]*A + fibo[D-1]*B 이다..
		
		int A=1;
		int B=1;

		
		//위 식 만족하는 A, B 탐색
		i:while(true) {
			
			for (B = 1; (fibo[D - 1] * B) <= K; B++) {
				for(A=1; A<=B; A++) {
					if(K == (fibo[D-2]*A) + (fibo[D-1]*B)) {
						System.out.println(A);
						System.out.println(B);
						break i;
					}
				}
			}
			
		}
		
		
		
	}
	

	
	
}
