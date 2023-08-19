package level_12_bruteforce;

import java.util.Scanner;

public class P_17252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (isSamSam(n)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static boolean isSamSam(int n) {
		// 문제에서 삼삼한 수는 3의 거듭제곱인 수를 반드시 하나 이상
		// 포함해야 한다고 했으므로, n = 0일 경우 삼삼한 수가 아니라고 판단
		if (n == 0) {  
			return false;
		}
		
		int k = 0; // n보다 작은 가장 큰 3의 배수의 지수
		while (true) {
			if (n >= Math.pow(3, k)) {
				k++;
			} else {
				// k는 n보다 큰 3의 배수 중 가장 작은 3의 배수의 지수이므로
				// -1을 해주어 k를 n보다 작은 가장 큰 3의 배수의 지수로 만듦
				k -= 1; 
				break;
			}
		} 

		while (true) {
			// n이 현재 3의 k제곱값 이상이면 
			// n에서 3의 k제곱수를 빼며 이 과정을 반복
			if (n >= Math.pow(3, k)) {
				n -= Math.pow(3, k);
			}

			// n이 0일 경우 이는 삼삼한 수
			if (n == 0) {
				return true;
			}

			// k가 0일 경우 이는 삼삼한 수가 아님
			if (k == 0) {
				return false;
			}
			k--;
		}
	}
}
