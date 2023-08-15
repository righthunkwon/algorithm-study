package level_25_greedy;

import java.util.Arrays;
import java.util.Scanner;

public class P_2012 {
	public static void main(String[] args) {
		// 실제 등수는 1, 2, 3, 4, 5, ...로 구성
		// 예상 등수를 정렬한 뒤 실제 등수와 비교하여 절댓값의 합을 구한다.
		// N의 범위가 500,000인데, 만약 모든 학생이 자신의 등수를 1로 예상할 경우 int의 범위를 초과한다.
		// 알고리즘 문제풀이에서 자료형과 관련한 실수를 줄이기 위해서 정수형을 long으로 선언하는 습관을 들이는 게 좋다.
		Scanner sc = new Scanner(System.in);
		
		// 예상 등수 입력 및 정렬
		int n = sc.nextInt(); 
		int[] arr = new int[n]; 
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		// 실제 등수와 비교후 절댓값의 합 출력
		long ans = 0; // 절댓값의 합
		for (int i = 0; i < n; i++) {
			ans += Math.abs(arr[i] - (i+1)); // 등수이므로 i + 1
		}
		System.out.println(ans);
	}
}
