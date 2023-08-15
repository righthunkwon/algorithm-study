package level_25_greedy;

import java.util.Arrays;
import java.util.Scanner;

public class P_12788 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // CTP의 회원수
		int m = sc.nextInt(); // 대회 참가 팀의 수
		int k = sc.nextInt(); // 대회 팀원 수
		int tot = m * k; // 펜을 빌리는 전체 인원 수
		int ans = 0; // 빌린 회원의 수
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		for (int i = n - 1; i >= 0; i--) {
			if (tot <= 0) {
				break;
			} else {
				tot -= arr[i];
				ans++;
			}
		}
		if (tot > 0) {
			System.out.println("STRESS");
		} else {
			System.out.println(ans);
		}
	}
}
