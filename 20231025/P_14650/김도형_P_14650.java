package AlgoStudy;

import java.util.Scanner;

public class BOJ_Q14650_걷다보니_신천역_삼 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double N = sc.nextInt();
		int ans = 0;
		if(N>=2) {
			ans = (int) (2*Math.pow(3, N-2));
		}	
		System.out.println(ans);
		
/* 규칙 2 이상부터는 2*3^(N-2)
	1 0
	2 2	(2*1)
	3 6 (2*3)
	4 18(2*9)
	5 54(2*27)
	6 162(2*81)
	7 486(2*243)
	8 1458(2*729)
	9 4374(2*2187)
 * */		
		
//      //노가다 시간초과 ver
//		int N = sc.nextInt();
//		int cnt = 0;
//
//		if (N != 1) {
//
//			for (int i = (int)Math.pow(10, N - 1)-1; i < Math.pow(10, N); i += 3) {
//
//				String str = String.valueOf(i);
//				boolean flag = true;
//				for (int j = 0; j < str.length(); j++) {
//					
//					if (str.charAt(j) == '0' || str.charAt(j) == '1' || str.charAt(j) == '2') continue;
//					else { 
//						flag = false;
//						break;
//					}
//
//				}
//				if (flag == true) cnt++;
//
//			}
//		}
//		System.out.println(cnt);

	}// main

}// class
