package baek;

import java.util.Scanner;

public class Pro_14650_걷다보니신천역삼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// num 중 중복가능으로 N개 선택시 더한 값이 3의 배수인지 확인하면 됨
		// 0을 포함해서 선택했을 경우 맨 첫자리에 안오게 하는 것이 중요
		result = 0;
		dfs(0, 0);
		System.out.println(result);
	}

	static int N, result;

	static void dfs(int sum, int cnt) {
		if (cnt == N) {
			if (sum % 3 == 0)
				result++;
			return;
		}
		for (int i = 0; i <= 2; i++) {//중복가능
			if (sum == 0 && i == 0)//첫숫자 0 막기위함
				continue;
			dfs(sum +i, cnt + 1);//선택
		}
	}
}
