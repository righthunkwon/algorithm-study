package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Q17070_파이프_옮기기1 {

	static int N;
	static int[][] map;
	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N]; // 집의 상태
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); //집 상태 입력
			}
		}
		cnt = 0; // 이동 방법 카운트

		dfs(0, 1, 0);

		System.out.println(cnt);

	}// main

	// 끝부분의 현 x좌표, 현y좌표, 현재 파이프의 방향 (0:가로 , 1:세로, 2:대각선)
	public static void dfs(int nx, int ny, int direction) {

		if (nx == N || ny == N || map[nx][ny] == 1) //범위를 벗어나거나 벽이면 return
			return;

		if (nx == N - 1 && ny == N - 1) { // 목적지 도착했으면
			cnt++; 
			return;
		}

		if (direction == 0) { // 현재 가로방향이면
			dfs(nx, ny + 1, 0); //오른쪽 이동
			if (nx+1<N && ny+1<N && map[nx + 1][ny] != 1 && map[nx][ny + 1] != 1 && map[nx + 1][ny + 1] != 1) { //범위 벗어나지 않고 경로에 벽이 없으면
				dfs(nx + 1, ny + 1, 2); //대각선 이동
			}
		} else if (direction == 1) { // 현재 세로방향이면
			dfs(nx + 1, ny, 1); //아래쪽 이동
			if (nx+1<N && ny+1<N && map[nx + 1][ny] != 1 && map[nx][ny + 1] != 1 && map[nx + 1][ny + 1] != 1) { //범위 벗어나지 않고 경로에 벽이 없으면
				dfs(nx + 1, ny + 1, 2); //대각선 이동
			}
		} else { // 현재 대각선 방향이면
			dfs(nx, ny + 1, 0); //오른쪽 이동
			dfs(nx + 1, ny, 1); //아래족 이동
			if (nx+1<N && ny+1<N && map[nx + 1][ny] != 1 && map[nx][ny + 1] != 1 && map[nx + 1][ny + 1] != 1) { //범위 벗어나지 않고 경로에 벽이 없으면
				dfs(nx + 1, ny + 1, 2); //대각선 이동
			}
		}

	}

}// class
