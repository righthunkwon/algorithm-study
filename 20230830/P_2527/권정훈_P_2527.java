package level_00_not_classified;

import java.util.Scanner;

// 직사각형
// 조건 처리가 복잡한 걸 나중에 else로 구현하면 편하다.
public class P_2527 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 4번 반복
		for (int i = 0; i < 4; i++) {
			
			// 직사각형 1
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			// 직사각형 2
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();

			// 공통부분이 없을 때
			if (x2 < p1 || y2 < q1 || p2 < x1 || q2 < y1) {
				System.out.println("d");
			} 
			
			// 점에서 만날 때(어느 한 점, 4개의 경우의 수)
			else if ((x1 == p2 && y1 == q2) || (x1 == p2 && y2 == q1) || (x2 == p1 && y2 == q1)
					|| (x2 == p1 && y1 == q2)) {
				System.out.println("c");
			} 
			
			// 선분에서 만날 때(점에서 만날 경우를 위에서 제외하므로 선분 조건 충족)
			else if (x2 == p1 || y2 == q1 || p2 == x1 || y1 == q2) {
				System.out.println("b");
			} 
			
			// 공통 부분이 있을 때(직사각형)
			else {
				System.out.println("a");
			}
		}

	}
}
