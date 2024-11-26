import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// p1, p2 ,p3를 차례로 이은 선분이 반시계이면 1, 시계이면 1, 직선이면 0
		
		// 각도가 90도 보다 적으면 시계, 넓으면 반시계?
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();
		// 검색해보니 Counter Clockwise이라는 알고리즘이 존재
		// (x1y2 + x2y3 + x3y1) - (x2y1 + x3y2 + x1y3) 의 결과로
		// 양수면 반시계, 음수면 시계이다
		int answer = (a*d + c*f + e*b) - (c*b + e*d + a*f);
		if(answer > 0) {
			answer = 1;
		}
		else if(answer <0) {
			answer = -1;
		}
		
		System.out.println(answer);
	}
	

}
