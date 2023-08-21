package gold;

import java.util.Arrays;
import java.util.Scanner;

public class Q2212_센서 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 센서의 개수 (1~10000)
		int K = sc.nextInt(); // 집중국의 개수 (1~1000)
		int min = 0; //정답이 될 변수
		

		int[] point = new int[N]; // 센서의 좌표 입력받을 배열

		for (int i = 0; i < N; i++) {
			point[i] = sc.nextInt(); // 센서 좌표 입력
		}

		if (K >= N) // 집중국이 센서보다 많은 경우 뒤에 더 할 필요 없이 0이 답이 됨
			min = 0;
		else {

			Arrays.sort(point); // 센서 좌표 오름차순 정렬

			min = point[N - 1] - point[0]; // 집중국 수신가능 영역 길이 최소값 초기화
												// 집중국이 1개일 경우로..

			int[] distance = new int[N - 1]; // 다음 좌표까지 거리의 배열

			for (int i = 0; i < N - 1; i++) {
				distance[i] = point[i + 1] - point[i]; // 다음 좌표까지의 거리를 입력
			}

			Arrays.sort(distance); // 거리차이 오름차순 정렬

			for (int i = 0; i < K - 1; i++) { // K-1 회 반복

				min = min - distance[N - 2 - i]; // 거리차이 가장 큰거부터 K-1회동안 차례대로 빼줌
	
			}
			
		
		}
		
		System.out.println(min); //정답 출력
	}

}
