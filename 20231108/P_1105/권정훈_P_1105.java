package level_25_greedy;

import java.util.Scanner;

// 팔
// LR의 자리수가 같은 경우에
// 가장 큰 자리 수부터 같은 자리에 있는 수가 달라질 때까지의 8은 무조건 포함된다.
public class P_1105 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String l = sc.next();
		String r = sc.next();
		int len = r.length(); // 자리수
		int diff = r.length() - l.length(); // 자리수의 차이
		int ans = 0; // 8의 최소 개수


		// 자리수가 같을 경우
		if (diff == 0) {
			char[] arrL = new char[len];
			char[] arrR = new char[len];

			// l배열
			for (int i = 0; i < len; i++) {
				arrL[i] = l.charAt(i);
			}

			// r배열
			for (int i = 0; i < len; i++) {
				arrR[i] = r.charAt(i);
			}

			// 검사
			int idx = 0; 
			while (arrL[idx] == arrR[idx]) {
				if (arrL[idx] == '8' || arrR[idx] == '8') ans++;
				if (idx == len - 1) break;
				idx++;
			}
			System.out.println(ans);
		}

		// 자리수가 다를 경우
		else {
			System.out.println(0);
		}
	}
}
