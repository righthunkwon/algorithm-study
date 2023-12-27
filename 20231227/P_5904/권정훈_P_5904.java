package level_26_divide_and_conquer;

import java.util.Scanner;

// Moo 게임
// 수열의 범위를 나누어 규칙을 파악 후
// n번째의 범위가 어디에 속하는지 판별한 뒤 해당 범위로 재귀호출
// k번째 moo수열 = 이전수열(k-1번째 수열) / moo(m + o(k+2개)) / 이전수열(k-1번째 수열)
public class P_5904 {
	
	private static char ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		moo(n);
		System.out.println(ans);
	}
	
	private static void moo(int n) {
		System.out.println("n: " + n);
		
		int size = 3; // moo수열의 전체 크기
		int cnt = 0; // 추가로 증가된 o의 개수 증가분
		
		// 초기 조건
		// n=1일 때는 m
		// n=2또는3일 때는 o
		if (n == 1) {
			ans = 'm';
		} else if (n == 2 || n == 3) {
			ans = 'o';
		} else {
			// 전체 사이즈 계산
			while (size < n) {
				size = 2 * size + cnt + 4;
				cnt++;
			}
			
			// 왼쪽에 위치한 이전 수열의 끝지점
			int criteria = (size - cnt - 3) / 2; 
			
//			System.out.println(size);
//			System.out.println(criteria);
//			System.out.println(cnt);

			if (size - (criteria + 1) <= n) {
//				System.out.println("여기");
				moo(n - size + criteria); // 작은 범위에서 재탐색
			} else if (n == criteria + 1) {
//				System.out.println("저기");
				ans = 'm'; // 중간 moo 시작점 m
			} else {
//				System.out.println("거기");
				ans = 'o'; // 이외에는 moo의 o
			}
		}
	}
}
 
