package level_15_divisor_multiple_2;

import java.util.Scanner;

// 소수 구하기
// 에라토스테네스의 체
// n이라는 값이 소수인지를 판단하려고 할 때 
// 하나씩 반복하며 소수인지를 판별하는 것이 아니라
// n의 루트를 씌운 값의 배수까지만 확인하면 된다는 소수 판별법
public class P_1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int m = sc.nextInt();
		int n = sc.nextInt();

		boolean flag[] = new boolean[n + 1]; // 숫자 판단 배열
		flag[1] = true; // 1은 소수에서 제외
		
		// n까지의 숫자 판단
		// 2부터 소수의 제곱과 그 이후 배수들을 제거(true: 소수가 아닌 수, false: 소수인 수)
		int sqrt = (int) Math.sqrt(n); // 제곱근
		for (int i = 2; i <= sqrt; i++) {
			for (int j = 2; j <= n / i; j++) {
				if (flag[i * j] == true) continue;
				else flag[i * j] = true;
			}
		}

		for (int i = m; i <= n; i++) {
			if (flag[i] == false) sb.append(i+"\n");
		}
		System.out.println(sb);
	}

}
