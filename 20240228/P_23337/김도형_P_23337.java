package algo_study;

import java.util.Scanner;

public class BOJ_Q23337_Drunk_Passenger {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double a = n;
		double b = (n-1)*2;
		double ans = a/b;
		System.out.println(ans);
	}
}


/* A : 마지막 탑승객    X : 취객
 * A가 자기자리 앉을 확률을 1에서 빼주면 자기자리 못앉을 확률! 
n=3
A  b  X
o  o  o 

A  X  b    ->  1/2 * 1/2 = 0.25      1-0.25 = 0.75

n=4
A  b   c   X
O  O  O  O

A   X  b   c   ->  1/3 *  1/3   * 1/2        1/18
A   X  c   b   ->  1/3 *  1/3                2/18   ->   1/3    1-1/3 = 0.66666666
A   b  X   c   ->  1/3 *  1/2                3/18  

n=5
A  b   c   d  X
O  O  O  O  O
A   X  b   c  d   -> 1/4 *  1/4 * 1/3 * 1/2       1/96  
A   X  b   d  c   -> 1/4 *  1/4 * 1/3             2/96
A   X  c   b  d   -> 1/4 *  1/4 * 1/2             3/96
A   X  c   d  b   -> 1/4 *  1/4                   6/96    ->    3/8   ->  1-3/8 =  5/8
A   b  X   c  d   -> 1/4 *  1/3 * 1/2             4/96              
A   b  X   d  c   -> 1/4 *  1/3                   8/96               
A   b  c   X  d   -> 1/4 *  1/2                  12/96




n=2      1   =  2/2
n=3               3/4
n=4      2/3 =  4/6
n=5               5/8
n=6               ?/? 
 * */
 
