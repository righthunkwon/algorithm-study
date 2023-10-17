package baek;

import java.util.Scanner;

public class Pro_2502_떡먹는호랑이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int D = sc.nextInt();
		int K = sc.nextInt();
		int[] dp = new int[D + 1];
		dp[1] = dp[2] = 1;
		for (int i = 3; i < D; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		a:for (int two = 1; two <= 100000; two++) {//완전탐색을 통해 one 과 two 찾기
			for (int one = 1; one <= two; one++) {
				if (dp[D - 2] * one + dp[D - 1] * two == K) {
					System.out.println(one);
					System.out.println(two);
					break a;
				}

			}
		}

	}
}
//16=2/+7/+2+7/+7+2+7+/2+2+7+7+7/22277777/22222 77777777/
//27
//10 1
//01 2
//11 3 
//12 4
//23 5
//35 6
//58 7  =>dp[5]*one+dp[6]*two
