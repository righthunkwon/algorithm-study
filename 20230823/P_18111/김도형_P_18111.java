package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q18111_마인크래프트 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 세로길이
		int M = Integer.parseInt(st.nextToken()); // 가로길이
		int B = Integer.parseInt(st.nextToken()); // 인벤토리에 있는 블록 수

		int[] arr = new int[N * M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i * M + j] = Integer.parseInt(st.nextToken()); // 모든 땅의 높이를 1차원 배열에 입력
			}
		}

		Arrays.sort(arr); // 오름차순으로 정리

		int minTime = 192000000; // 걸리는 최소 시간 초기화(256*500*500*3)
		int maxHeight = 0; // 평탄화 가능한 최대 높이
		int minH = arr[0]; // 최소높이
		int maxH = arr[N * M - 1]; // 최대높이

		for (int height = maxH; height >= minH; height--) { // 최종 땅의 높이가 될 수 있는 범위만큼 반복
			int inven = B; // 인벤토리 초기화
			int T = 0; // 걸리는 시간 초기화
			for (int i = N * M - 1; i >= 0; i--) { // 모든 땅을 순회하면서 (높은땅부터)

				if (arr[i] > height) { // 해당 땅의 높이가 목표 높이보다 높으면 깎아서 인벤에 넣기

					inven += (arr[i] - height); // 인벤에 블록 증가

					T += ((arr[i] - height) * 2); // 제거시간 블록당 2초씩 추가

				} else if (arr[i] < height) { //// 해당 땅의 높이가 목표 높이보다 낮으면 인벤에서 빼서 쌓기

					inven -= (height - arr[i]); // 차이만큼 인벤에서 빼기

					T += (height - arr[i]); // 쌓은 블록당 1초씩 추가

				}
				

			} // 모든 땅 순회 for문
			

			if (inven >= 0) { // 인벤이 0 이상인 경우만 가능한 높이가 됨

				if (T < minTime) {
					minTime = T; // 걸리는 최소시간
					maxHeight = height; // 그 때의 높이가 최대높이로 갱신
										// 뒤에서 부터 탐색했기 때문에 minTime이
										// 더 짧아지지 않는 한 갱신 안됨
				}
			} // if inven>=0

		} // minH ~ maxH for문
		
		System.out.println(minTime+" "+maxHeight);
		

	}// main

}
