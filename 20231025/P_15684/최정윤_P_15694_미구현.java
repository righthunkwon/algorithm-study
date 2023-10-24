//규칙찾아서 풀려다가 실패 완탐으로 다시 도전하기
// package baek;

// import java.io.*;
// import java.util.*;

// public class Pro_15684_사다리조작 {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringTokenizer st = new StringTokenizer(br.readLine());
// 		int N = Integer.parseInt(st.nextToken());
// 		int M = Integer.parseInt(st.nextToken());
// 		int H = Integer.parseInt(st.nextToken());
// 		if (M == 0)
// 			System.out.println(0);
// 		else {
// 			int[][] go = new int[H + 1][N + 1];
// 			for (int i = 0; i < M; i++) {
// 				st = new StringTokenizer(br.readLine());
// 				int a = Integer.parseInt(st.nextToken());
// 				int b = Integer.parseInt(st.nextToken());
// 				// a가로줄에 b와 b+1선이 연결
// 				go[a][b] = b + 1;
// 				go[a][b + 1] = b;
// 			} // 입력 끝
// 			int cnt = 0;

// 			int[] line = new int[N + 1];
// 			for (int i = 1; i <= N; i++) {
// 				int now = i;
// 				for (int j = 1; j <= H; j++) {
// 					if (go[j][now] != 0) {
// 						now = go[j][now];
// 					}
// 				}
// 				if (now != i) {
// 					cnt++;
// 					line[i] = now;
// 				}
// 			}
// 			if (cnt == 4 || cnt == 6) {
// 				int con = 0;
// 				for (int i = 1; i < line.length; i++) {
// 					if (line[i] != 0&&line[line[i]]==i) {
// 						con++;
// 					}
// 				}
// 				if (con == 4 && cnt == 4)
// 					System.out.println(2);
// 				else if (con == 6 && cnt == 6)
// 					System.out.println(3);
// 				else if (cnt == 4) {
// 					System.out.println(3);
// 				} else {
// 					System.out.println(-1);
// 				}
// 			} else if (cnt > 4)
// 				System.out.println(-1);
// 			else
// 				System.out.println(cnt - 1);
// 		}
// 	}
// }








package baek;

import java.io.*;
import java.util.*;

public class Pro_15684_사다리조작2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		if (M == 0)
			System.out.println(0);
		else {
			go = new int[H + 1][N + 1];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// a가로줄에 b와 b+1선이 연결
				go[a][b] = b + 1;
				go[a][b + 1] = b;
			} // 입력 끝
			int result = -1;
			// 가로선 수 0~2계산 넘어가면 그냥 -1출력
			iToi = false;
			for (int i = 0; i < 3; i++) {
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
		if (iTOi())
			iToi = true;
		if (count == cnt)
			return;

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

	static boolean iToi;
	static int cnt, N, H;
	static int[][] go;
}
