package AlgoStudy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_Q2638_치즈 {
	static int N, M;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] arr;
	static boolean[][] visit;
	static Queue<Integer> qx, qy;
	static Stack<Integer> sx, sy;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 세로
		M = sc.nextInt(); // 가로
		arr = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 입력 끝

		qx = new LinkedList<>();
		qy = new LinkedList<>();
		sx = new Stack<>();
		sy = new Stack<>();

		bfs(0, 0); //외부공기를 -20으로 바꿔줌

		while(findcheese()) { //배열 돌다가 치즈를 찾았으면
			meltcheese();  //치즈 녹이기 ㄱㄱ
		}
		
		System.out.println(count);
		/*
		 * 1. 일단 외부공기를 전부 -20으로 바꿔줌(by BFS) 
		 * 2. 배열 탐색하다가 치즈 만나면 사방의 합을 구해보고 -30보다 작으면 스택에 위치정보 넣기 
                 *     (외부공기와 내부공기 구별..외부 2개가 주변에 있으면 합이-30보다 작을 수밖에 없다!)
		 * 3. 탐색 다 했으면 스택에 들어간 위치들 빼면서 다 -20으로 바꿔주고 녹을 위치 주변에 0이 있다면 BFS를 통해 -20으로 만들어주고 count +1 
		 * 4. count 출력
		 * 
		 */
	}// main

	public static void meltcheese() {
		int cnt = 0; // 녹일 치즈 수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 일단 1인지 확인해서 치즈면, 주변의 합을 구해서 합이 -30보다 작으면 녹일 치즈가 된다.
				if (arr[i][j] == 1 && arr[i + 1][j] + arr[i - 1][j] + arr[i][j + 1] + arr[i][j - 1] < -30) {
					sx.add(i); //녹일 치즈 위치정보 스택에 넣어줌
					sy.add(j);
					cnt++; //녹일 치즈 수 카운트
				}
			}
		}
		if (cnt != 0) { //
			while (!sx.isEmpty() || !sy.isEmpty()) {
				int x = sx.pop();
				int y = sy.pop();
				arr[x][y] = -20;
				for (int i = 0; i < 4; i++) {
					if (arr[x + dr[i]][y + dc[i]] == 0) {		
						bfs(x + dr[i],y + dc[i]);   //치즈가 녹았을때 주변에 0이 있으면, 그건 내부공기이므로 외부공기(-20)로 바꿔주는 작업을 해준다.
					}
				}
			}
			count++;
		}
	}

	public static boolean findcheese() { //배열중에 치즈가 있는지 확인용
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]==1) 
					return true;	
			}
		}
		return false;
	}

	public static void bfs(int nx, int ny) {
		arr[nx][ny] = -20; // 외부공기로 바꾸고
		qx.add(nx);
		qy.add(ny);
		while (!qx.isEmpty() || !qy.isEmpty()) {
			nx = qx.poll();
			ny = qy.poll();
			for (int i = 0; i < 4; i++) { // 사방탐색
				int newx = nx + dr[i];
				int newy = ny + dc[i];
				if (newx >= 0 && newy >= 0 && newx < N && newy < M && arr[newx][newy] == 0) { //인접해있는 공기도 다 외부공기가 된다
					arr[newx][newy] = -20;
					qx.add(newx);
					qy.add(newy);
				}
			}
		} // while

	}
}// class
