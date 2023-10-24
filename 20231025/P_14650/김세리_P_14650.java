package _20231025;

import java.util.Scanner;

public class _14650_걷다보니신천역삼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		// 나머지 개수를 세보면 N=1일때를 제외하고
		// 나머지 0, 1, 2 인 수의 개수가 동일하다
		// 따라서 주어진 수를 가지고 만들 수 있는 수의 총 개수를 구하고, 나누기 3을 해주면 된다.
		
		int ans=1; // 곱해줄 거니까 처음 값을 1로 잡는다
		if(N==1) ans = 0;
		else {
			for(int i=0;i<N-1;i++) {
				ans = ans*3;
			}
			ans = ans *2 /3;
		}
		System.out.println(ans);
	}//main

}
