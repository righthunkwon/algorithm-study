package baek;

import java.io.*;
import java.util.*;

public class Pro_12100_2048 {
	static int[] select;
	static int N, max;
	static int[][] map, inputMap;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		inputMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				inputMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		select = new int[5];
//		left(); :0 right(); :1 up(); :2down();: 3
		// 어디로 움직일지 5번 방향 정하기
		dfs(0);
		System.out.println(max);
	}

	private static void dfs(int cnt) {
		if (cnt == 5) {//5뱡향 다 정해졌으면 
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = inputMap[i].clone();
			}
			//map 깊은 복사
			game();
			return;
		}
		for (int i = 0; i <= 3; i++) {
			select[cnt] = i;
			dfs(cnt + 1);
		}

	}

	private static void game() {
		for (int i = 0; i < 5; i++) {//5방향 선택 한 것으로 감
			switch (select[i]) {
			case 0:
				left();
				break;
			case 1:
				right();
				break;
			case 2:
				up();
				break;
			default:
				down();
				break;
			}
		}
		maxBlock();//5번 이동했으면 가장 큰 값 구하자
	}

	private static void maxBlock() {//전체 블록 중 가장 큰 값 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(map[i][j], max);
			}
		}
	}

	private static void left() {
		// 왼쪽 구현
		//줄별로 다르게 가장 왼쪽부터 겹치는 수 있는지 확인하면 됨
		for (int i = 0; i < N; i++) {	//줄
			int num = 0;				//0제외, 밀었을 때 숫자가 들어가는 것의 인덱스
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					continue;
				int cnt = 1;//바로 다음 거가 0일 수 있어서 카운트한다.
				while (j + cnt < N && map[i][j + cnt] == 0) {
					cnt++;//뒤에가 0이 아닌 수가 나올 때 까지 cnt++
				}
				//0이 아닌 수가 나왔다면 현재 자리와 다음 자리 같은지 확인
				if (j + cnt < N && map[i][j] == map[i][j + cnt]) {
					map[i][num] = map[i][j] * 2;//같다면 2배 해주고 num 칸에 갱신해준다., 무조건 2개의 수가 합쳐지거나 0이 날라가거나, 그냥 그 자리 값이 그대로 가기 때문에 num오로 갱신해놔도 괜찮음
					j += cnt;//다음 칸으로 가자
				} else {
					map[i][num] = map[i][j];//두 칸의 값이 같지 않다면 , 그냥 원래 숫자 넣어줘야함 
				}
				num++;//0은 continue 했기 때문에 항상 그 줄의 채운 숫자 개수 ++
			}
			for (int k = num; k < N; k++) {//숫자가 채워지지 않은 칸 0으로 초기화
				map[i][k] = 0;
			}
		}
	}

	private static void right() {
		// 오른쪽 구현
		for (int i = 0; i < N; i++) {
			int num = N - 1;
			for (int j = N - 1; j >= 0; j--) {
				if (map[i][j] == 0)
					continue;
				int cnt = 1;
				while (j - cnt >= 0 && map[i][j - cnt] == 0) {
					cnt++;
				}
				if (j - cnt >= 0 && map[i][j] == map[i][j - cnt]) {
					map[i][num] = map[i][j] * 2;
					j -= cnt;
				} else {
					map[i][num] = map[i][j];
				}
				num--;
			}
			for (int k = num; k >= 0; k--) {
				map[i][k] = 0;
			}
		}
	}

	private static void up() {
		// 위구현
		for (int j = 0; j < N; j++) {
			int num = 0;
			for (int i = 0; i < N; i++) {
				if (map[i][j] == 0)
					continue;
				int cnt = 1;
				while (i + cnt < N && map[i + cnt][j] == 0) {
					cnt++;
				}
				if (i + cnt < N && map[i][j] == map[i + cnt][j]) {
					map[num][j] = map[i][j] * 2;
					i += cnt;
				} else {
					map[num][j] = map[i][j];
				}
				num++;
			}
			for (int k = num; k < N; k++) {
				map[k][j] = 0;
			}
		}
	}

	private static void down() {
		// 아래 구현
		for (int j = 0; j < N; j++) {
			int num = N - 1;
			for (int i = N - 1; i >= 0; i--) {
				if (map[i][j] == 0)
					continue;
				int cnt = 1;
				while (i - cnt >= 0 && map[i - cnt][j] == 0) {
					cnt++;
				}
				if (i - cnt >= 0 && map[i][j] == map[i - cnt][j]) {
					map[num][j] = map[i][j] * 2;
					i -= cnt;
				} else {
					map[num][j] = map[i][j];
				}
				num--;
			}
			for (int k = num; k >= 0; k--) {
				map[k][j] = 0;
			}
		}
	}

}
