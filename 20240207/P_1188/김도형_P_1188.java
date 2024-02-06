package algo_study;

import java.util.Scanner;

public class BOJ_Q1188_음식_평론가 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //소시지 수
		int M = sc.nextInt(); //평론가 수
		System.out.println(M-gcd(N,M));
		
	}//main
	static int gcd(int a,int b) {
		if(b==0)return a;
		return gcd(b,a%b);
	}
}//class

/*
 * 
4 6  => 4

111
111
111
111

9개를 6명이 나눠먹기?

111111 ㅇ
111111 ㅇ
111111 ㅇ
111111 ㅇ
111111 ㅇ
111111 ㅇ
111/111 => 6명이 3개 나눠먹기랑 동일 => 3
111/111
111/111

4 7  => 6

1111/111
1111/111
1111/111
1111/1/1/1

4명치 썰어서 주고   3명이서 남은거 4개 나눠먹기 => 6번썰어

평론가 수 - 최소공약수 = 정답..

*/
