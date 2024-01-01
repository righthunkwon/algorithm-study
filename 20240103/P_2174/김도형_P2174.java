package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q2174_로봇_시뮬레이션 {
	static int A, B, N, M;
	static int[][] map;
	static int[] robotx, roboty, robotd;
	static int[] dy = { 1, 0, -1, 0 }; // 북동남서 순서
	static int[] dx = { 0, 1, 0, -1 }; // 북과 남만 방향 바꿔주면 됨(로봇 위치 입력방식때문에)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken()); // 가로
		B = Integer.parseInt(st.nextToken()); // 세로
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 로봇 수
		M = Integer.parseInt(st.nextToken()); // 명령 수
		/*
		 * 로봇 맵에 로봇이 있으면 로봇 숫자를 저장 현재 로봇이 향하고 있는 방향 정보 저장(1:N(북)/2:E(동)/3:S(남)/4:W(서))
		 * 로봇 숫자별로 위치 정보 저장할 배열 생성 명령 주어지면 로봇 위치정보와 방향 정보 업데이트 충돌 발생시 충돌 내역 출력하고 끝내기
		 */
		map = new int[B + 1][A + 1];
		robotx = new int[N + 1];// 로봇 x좌표 정보
		roboty = new int[N + 1];// 로봇 y좌표 정보
		robotd = new int[N + 1];// 로봇 방향 정보
		for (int i = 1; i <= N; i++) { // 1번 로봇부터 입력..
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			map[y][x] = i; // 맵에 로봇 번호 저장
			robotx[i] = x;
			roboty[i] = y; // 로봇 위치 정보 저장
			if (dir == 'N')robotd[i] = 0;
			else if (dir == 'E')robotd[i] = 1;
			else if (dir == 'S')robotd[i] = 2;
			else if (dir == 'W')robotd[i] = 3; // 로봇 방향 정보 저장
		} // 로봇 정보 입력 끝

		for (int i = 0; i < M; i++) { // 명령 입력
			st = new StringTokenizer(br.readLine());
			int robotNum = Integer.parseInt(st.nextToken()); // 로봇 넘버
			char command = st.nextToken().charAt(0); // 명령 종류
			int repeatNum = Integer.parseInt(st.nextToken()); // 명령 반복 횟수
			for (int j = 0; j < repeatNum; j++) { // 명령 수행
				if (command == 'L') {// 반시계방향 90도 회전
					robotd[robotNum] = (robotd[robotNum] + 3) % 4;
				} else if (command == 'R') {// 시계방향 90도 회전
					robotd[robotNum] = (robotd[robotNum] + 1) % 4;
				} else if (command == 'F') {// 앞으로 전진
					int newx = robotx[robotNum] + dx[robotd[robotNum]];
					int newy = roboty[robotNum] + dy[robotd[robotNum]];
					// 앞이 벽이면
					if (newx > A || newx < 1 || newy > B || newy < 1) {
						System.out.println("Robot " + robotNum + " crashes into the wall");
						return;
					}
					// 앞이 로봇이면
					if (map[newy][newx] != 0) {
						System.out.println("Robot " + robotNum + " crashes into robot " + map[newy][newx]);
						return;
					}
						// 앞이 벽,로봇 아니면 전진
						map[roboty[robotNum]][robotx[robotNum]] = 0;// 원래자리 0으로
						map[newy][newx] = robotNum;
						robotx[robotNum] = newx;
						roboty[robotNum] = newy;
				}	
			}
		}//명령 i for문
		System.out.println("OK");
	}//main
}
