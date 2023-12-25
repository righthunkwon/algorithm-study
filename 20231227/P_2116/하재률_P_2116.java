package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2116_주사위쌓기 {
	// 맨 밑 주사위.. 여섯가지 경우 중 젤 큰거 구하기
	// 옆면중 젤 큰거 더해주면 될듯 6, 5, 4 순으로.
	// 위 아래가 6,5 면 4, 하나라도 6이면 5 아니면 6 선택
	// 0 - 5, 1 - 3, 2 - 4 가 짝
	// 5, 3, 4, 1, 2, 0
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 주사위 개수
		int[][] dice = new int[N][6];
		int[] pair = {5, 3, 4, 1, 2, 0}; // 반대편 위치 미리저장
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력 완
		
		int res = 0;
		// 맨 밑 주사위 6가지 경우의 수를 구하자 ㅎ
		for(int i = 0; i < 6; i++) {
			int bot = dice[0][i];
			int top = dice[0][pair[i]];
			int side = sol(bot, top);
			// N개 주사위 side 합 구하기
			for(int j = 1; j < N; j++) {
				// 먼저 아래 주사위 윗 면과 맞닿은 아랫면 구해주자
				for(int k = 0; k < 6; k++) {
					if(dice[j][k] == top) {
						bot = dice[j][k]; // 아래 주사위 윗 면으로 아랫면 초기화
						top = dice[j][pair[k]]; // 윗면 초기화
						break;
					}
				}
				side += sol(bot, top);
			}
			res = res > side ? res : side;
		}
		System.out.println(res);
		
	}
	// 옆 면중 가장 큰 값 구하기
	static int sol(int bot, int top) {
		if(bot + top == 11) return 4;
		else if(bot == 6 || top == 6) return 5;
		else return 6;
	}
}
