package AlgoStudy;

import java.util.Scanner;

public class BaekJoon_Q1722_순열의_순서 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int Q = sc.nextInt();

		if (Q == 1) { // 1이면 k번째 수열 출력
			long k = sc.nextLong();

		} else if (Q == 2) {

			int[] arr = new int[N]; // 새 배열에 넣기

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

		}

	}

	
	
	
	
	
	
	
	//팩토리얼 메서드
	public static int fact(int n) {
		if (n <= 1)
			return n;
		else
			return fact(n - 1) * n;
	}

}
