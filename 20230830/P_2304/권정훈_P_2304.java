package level_12_bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 창고 다각형
public class P_2304 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 기둥의 개수
		int[][] arr = new int[n][2]; // 위치 & 높이 2차원배열
		int height = 0; // 최대 높이

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 위치
			arr[i][1] = Integer.parseInt(st.nextToken()); // 높이

			// 최대 기둥 높이
			height = Math.max(arr[i][1], height);
		}

		// 이차원 배열 정렬
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				if(arg0 == arg1) {
					return arg0[1] - arg1[1];
				}else {
					return arg0[0] - arg1[0];
				}
			}
		});

		// 가장 큰 기둥 중 제일 왼쪽에 있는 기둥
		int start = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i][1] == height)
				start = i;
		}

		// 최고로 높은 기둥은 제일 처음에 삽입
		int size = height;

		// 첫 기둥
		int prevX = arr[0][0];
		int prevH = arr[0][1];

		// 왼쪽 탐색
		for (int i = 0; i <= start; i++) {
			// 이전 기둥보다 큰 기둥이 나타나면 넓이 구하기
			if (arr[i][1] >= prevH) {
				size += (arr[i][0] - prevX) * prevH;
				// 현재 기둥 정보 갱신
				prevX = arr[i][0];
				prevH = arr[i][1];
			}
		}

		// 마지막 기둥
		int nextX = arr[n - 1][0];
		int nextH = arr[n - 1][1];

		// 오른쪽 탐색
		for (int i = n - 1; i >= start; i--) {
			// 이전 기둥보다 큰 기둥이 나타나면 넓이 구하기
			if (arr[i][1] >= prevH) {
				size += (nextX - arr[i][0]) * nextH;
				// 현재 기둥 정보 갱신
				nextX = arr[i][0];
				nextH = arr[i][1];
			}
		}

		System.out.println(size);
	}
}
