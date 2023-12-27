package level_00_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주사위 쌓기
// 첫번째 주사위를 기준으로 재귀함수 호출하면서 완전탐색
public class P_2116 {
	private static int n, max;
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine()); // 주사위 개수
		arr = new int[n][7]; // 주사위 배열
		max = 0; // 옆면의 최대값
		
		// 주사위 배열 요소 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 6; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 첫번째 주사위 상태에 따른 재귀 탐색 진행
		for (int i = 1; i <= 6; i++) {
			recur(i, 1, 0);
		}
		
		// 정답 출력
		System.out.println(max);
	}

	// 주사위 쌓기
	private static void recur(int bottom, int cnt, int sum) {
		
		// 윗면 구하기
		int top = getTop(bottom);
		
		// 옆면의 최대값 구하기
		int tmp = -1;
		for (int i = 1; i <= 6; i++) {
			if (i == bottom || i == top) continue; // 아래나 위면 패스
			tmp = Math.max(tmp, arr[cnt-1][i]);
		}
		
		// 최대값 계산
		sum += tmp; 
		
		// 주사위를 모두 다 쌓았을 때
		if (cnt == n) {
			max = Math.max(max, sum); // 최대값 비교
			return;
		}
		
		// 다음 주사위 쌓기 진행
		for (int i = 0; i < 6; i++) {
			if (arr[cnt-1][top] == arr[cnt][i]) {
				recur(i, cnt+1, sum);
				break;
			}
		}
	}

	// 주사위의 법칙에서 벗어난 주사위...
	private static int getTop(int n) {
		if (n == 1) return 6;
		else if (n == 2) return 4;
		else if (n == 3) return 5;
		else if (n == 4) return 2;
		else if (n == 5) return 3;
		else return 1;
	}
}
