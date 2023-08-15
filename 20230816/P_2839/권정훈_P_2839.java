package level_25_greedy;

import java.util.Scanner;

public class P_2839 {
	public static void main(String[] args) {
		// 그리디
		// 큰 단위(5kg 봉지)를 최대한 많이, 안되면 작은 단위(3kg 봉지)
		// 5kg로 일단 나누어본 뒤, 나누어 떨어지면 n/5를 기존 봉지 수에 더하고 출력
		// 5kg로 나누어 떨어지지 않으면 3kg 한 번 담아보고 다시 5kg로 나누어 떨어지는지 판단(이 과정을 반복)
		// 만약에 3kg를 담았는데 n이 0보다 작을 경우 나누어 떨어지지 않으므로 -1을 출력
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 설탕 무게
		int ans = 0; // 봉지의 최소 개수
		
		while (true) {
			if (n % 5 == 0) {
				System.out.println(n / 5 + ans);
				break;
			} else if (n < 0) {
				System.out.println(-1);
				break;
			}
			n -= 3;
			ans++;
		}

	}
}
