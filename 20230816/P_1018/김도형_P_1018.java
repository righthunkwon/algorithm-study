q1080체스판

package silver;

import java.util.Arrays;
import java.util.Scanner;

public class Q1018_RePaint_ChessBoard {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);  

		int N = sc.nextInt();
		int M = sc.nextInt();

		char[][] arr = new char[N][M]; // N*M 빈 배열 생성

		int min = 64;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.next().toCharArray();
		}
//		System.out.println(Arrays.deepToString(arr)); // 출력확인용

		
		
		// 시작점이 흑돌인 경우 카운트

		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				int cnt = 0;
				
				for (int x = i; x < i+8; x++) {
					for (int y = j; y < j+8; y++) {
						if ((x + y) % 2 == 0 && arr[x][y] == 'W') {
							cnt++;
							
						} else if ((x + y) % 2 == 1 && arr[x][y] == 'B') {
							cnt++;
						} else
							continue;
					}
				}
				if (cnt < min) {
					min = cnt;
				}
			}
		}

		// 시작점이 백돌인 경우 카운트

		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				int cnt = 0;
				for (int x = i; x < i+8; x++) {
					for (int y = j; y < j+8; y++) {
						if ((x + y) % 2 == 0 && arr[x][y] == 'B') {
							cnt++;
						} else if ((x + y) % 2 == 1 && arr[x][y] == 'W') {
							cnt++;
						} else
							continue;
					}
				}
				if (cnt < min) {
					min = cnt;
				}
			}
		}
		
		System.out.println(min);
		

	}

}
