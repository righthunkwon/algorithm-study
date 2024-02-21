package level_25_greedy;

import java.util.*;

// 지뢰찾기
public class P_9082 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			String num = sc.next();
			String mine = sc.next();

			// 숫자 배열 입력
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(num.substring(i, i + 1));
			}

			// 지뢰 배열 입력
			String[] mines = mine.split("");

			int ans = 0;
			for (int j = 0; j < n; j++) {
				if (j == 0 && nums[j] != 0 && nums[j + 1] != 0) { // 맨 처음 열
					nums[j] -= 1;
					nums[j + 1] -= 1;
					ans++;
				} else if (j == (n - 1) && nums[j - 1] != 0 && nums[j] != 0) { // 맨 끝 열
					nums[j - 1] -= 1;
					nums[j] -= 1;
					ans++;
				} else if (j >= 1 && j <= (n - 2) && nums[j - 1] != 0 && nums[j] != 0 && nums[j + 1] != 0) { // 중간 열
					nums[j - 1] -= 1;
					nums[j] -= 1;
					nums[j + 1] -= 1;
					ans++;
				}
			}
			System.out.println(ans);
		}
	}
}
