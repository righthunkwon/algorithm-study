package level_27_binary_search;

import java.util.Scanner;

public class P_1654 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt(); // 가지고 있는 랜선의 개수
		int n = sc.nextInt(); // 새로 필요한 랜선의 개수
		
		// 배열에 값 입력
		int[] arr = new int[k];
		for (int i = 0; i < k; i++) {
			arr[k] = sc.nextInt();
		}
		
		// 총합
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i]; 
		}
		int avg = sum / n;
		
		// 각 배열 요소와 평균의 차이를 구한 다음, 이를 활용하여 정답을 추론하려고 하였으나 실패
		
		
	}
}
