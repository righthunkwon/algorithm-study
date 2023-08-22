package level_12_bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()); // 새로운 줄 읽기
		int n = Integer.parseInt(st.nextToken()); // 세로(행)
		int m = Integer.parseInt(st.nextToken()); // 가로(열)
		int b = Integer.parseInt(st.nextToken()); // 작업 시작 시 블록

		// 맞춰지는 땅의 높이: 1 or 2 or 3
		// 3 2 1
		// 1 2 3
		// 1 3 3
		
		// (1) 배열 요소 입력
		// 블록의 최소 높이와 최대 높이를 찾아 이 범위를 완전 탐색하여 최소시간, 최대높이를 출력
		int max = 0;
		int min = 0;
		int[][] ground = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine()); // 새로운 줄 읽기
			for (int j = 0; j < m; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, ground[i][j]);
				min = Math.min(min, ground[i][j]);
			}
		}

		// (2) 배열 탐색
		int mintime = Integer.MAX_VALUE; // 최소시간
		int maxheight = Integer.MIN_VALUE; // 최소시간에서의 최대높이
		int diff = 0; // 높이차이

		// 블록의 최소와 최대 범위의 모든 경우만큼 배열 전체를 완전탐색
		for (int i = min; i <= max; i++) { // 블록
			int seconds = 0; // 탐색하며 최소시간과 비교할 시간
			int inventory = b; // 블록 담을 인벤토리

			for (int j = 0; j < n; j++) { // 배열
				for (int k = 0; k < m; k++) {
					diff = ground[j][k] - i; // 0인 경우 pass

					if (diff > 0) { // 제거(2초, 인벤에 추가)
						seconds += diff * 2;
						inventory += diff;
					} else if (diff < 0) { // 추가(1초, 인벤에서 삭제)
						seconds += Math.abs(diff);
						inventory -= Math.abs(diff);
					}
				}
			}
			
			// 블록의 경우마다 비교 후 최소시간과 최소시간에 따른 최대높이를 갱신
			if (inventory >= 0) {
				if (seconds <= mintime) {
					mintime = seconds;
					maxheight = i;
				}
			}
			
		}// 블록 반복문
		System.out.println(mintime + " " + maxheight);
	}

}
