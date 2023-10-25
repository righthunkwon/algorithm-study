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
		if (iTOi()) {//모든 선이 본인으로 돌아간다면
			iToi = true; //true로 바꿔서 main 끝내라
			return;
		}
		if (count == cnt)
			return;
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (go[i][j] == 0&&go[i][j+1]==0) {//그 지점과 이을 지점에 이미 사다리가 없다면 
					go[i][j] = j + 1;//j 와 j+1을 잇는 사다리 생성
					go[i][j + 1] = j;
					dfs(count + 1);//사다리개수 +1하고
					go[i][j] = 0;//다시 사다리 없애기
					go[i][j + 1] = 0;
				}

			}
		}
	}
	private static boolean iTOi() {
		for (int i = 1; i <= N; i++) {//시작선
			int now = i;//저장 후 
			for (int j = 1; j <= H; j++) {//가로선 가로선에 사다리가 그려져 있는지 확인
				if (go[j][now] != 0) {//0이 아니면 배열에 저장된 선으로 가야한다.
					now = go[j][now];//now값 바꾸기 바꾼값으로 j for문 반복하면 된다.
				}
			}
			if (now != i) {//현재 값이랑 시작선이랑 다르면 i에서 i로 온 것이 아니므로 false반환
				return false;
			}
		}
		return true;
	}
}
