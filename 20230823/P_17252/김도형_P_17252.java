package BaekJoon;

import java.util.Scanner;

public class Q17252_삼삼한수 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		if (!(N == 0)) {     //음이 아닌 정수 N이 입력되는데 0도 포함되니까 예외처리를 위해 조건문 걸어줌

			while (N > 0)
				if (N % 3 == 0) {
					N = N / 3;
					continue;
				} else if (N % 3 == 1) {
					N = (N - 1) / 3;        //3으로 안나눠 떨어졌을 때 3으로 1을 빼고 3으로 나눠 떨어지는지 확인
					continue;         
				} else if (N % 3 == 2) {
					System.out.println("NO");
					break;
				}
			if (N == 0) {           // N이 0이 됐다는 건 3의 거듭제곱의 합으로 표현이 가능하다는 얘기!
				System.out.println("YES");
			}

		} else
			System.out.println("NO");

	}

}
