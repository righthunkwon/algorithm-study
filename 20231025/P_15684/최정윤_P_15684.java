package baek;

import java.io.*;
import java.util.*;

public class Pro_15684_사다리조작2 {
	static boolean iToi;
	static int cnt, N, H, result;
	static int[][] go;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		if (M == 0)
			System.out.println(0);
		else {
			go = new int[H + 1][N + 1];// 가로선 수 , 세로선 수 
			//연결되어있는 세로선 번호를 넣음
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// a가로줄에 b와 b+1선이 연결
				go[a][b] = b + 1;
				go[a][b + 1] = b;
			} // 입력 끝
			result = -1;
			//가로선 수 0~3 계산 넘어가면 그냥-1출력
			iToi = false;
			for (int i = 0; i <= 3; i++) {
				cnt = i;
				dfs(0);
				if (iToi) {
					result = i;
					break;
				}

			}
			System.out.println(result);
		}
	}

	private static void dfs(int count) {
		if (iTOi()) {
			iToi = true;
			return;
		}
		if (count == cnt)
			return;
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (go[i][j] == 0&&go[i][j+1]==0) {
					go[i][j] = j + 1;
					go[i][j + 1] = j;
					dfs(count + 1);
					go[i][j] = 0;
					go[i][j + 1] = 0;
				}

			}
		}
	}
	private static boolean iTOi() {
		for (int i = 1; i <= N; i++) {
			int now = i;
			for (int j = 1; j <= H; j++) {
				if (go[j][now] != 0) {
					now = go[j][now];
				}
			}
			if (now != i) {
				return false;
			}
		}
		return true;
	}
}
