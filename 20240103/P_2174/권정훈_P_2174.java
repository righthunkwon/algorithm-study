package level_00_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 로봇 시뮬레이션
// xy좌표 바뀌어있음에 유의
// 해시맵 형태로 움직임 저장하는 거 봐두기
public class P_2174 {

	private static class Robot {
		int x, y;
		char dir;

		public Robot(int x, int y, char dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	private static HashMap<Character, int[]> move; // 방향별 움직임
	private static Robot[] robots; // 로봇들 정보 저장 리스트
	private static int A, B, N, M; // 좌표의 크기 관련 변수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken()); // 가로
		B = Integer.parseInt(st.nextToken()); // 세로

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 로봇 개수
		M = Integer.parseInt(st.nextToken()); // 명령 수

		robots = new Robot[N + 1]; // 로봇 배열
		moveInit(); // 방향 초기화
		
		// 로봇 정보 저장
		// xy 좌표가 반대로 되어있으므로 유의
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			robots[i] = new Robot(x, y, st.nextToken().charAt(0));
		}
		
		boolean endFlag = false; // 프로그램 종료 여부
		// 명령어 실행
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int robotNumber = Integer.parseInt(st.nextToken()); // 명령을 받는 로봇 번호
			char command = st.nextToken().charAt(0); // 명령 종류
			int cnt = Integer.parseInt(st.nextToken()); // 명령 반복 회수
			Robot curr = robots[robotNumber]; // 현재 명령을 수행할 로봇
			
			// 왼쪽으로 회전
			if (command == 'L') {
				for (int j = 0; j < cnt; j++) {
					leftRotate(curr);
				}
			}
			// 오른쪽으로 회전
			else if (command == 'R') {
				for (int j = 0; j < cnt; j++) {
					rightRotate(curr);
				}
			}
			// 앞으로 이동
			else {
				int[] direction = move.get(curr.dir);
				// 반복 횟수만큼 앞으로 이동
				for (int j = 0; j < cnt; j++) {
					int nx = curr.x + direction[0];
					int ny = curr.y + direction[1];
					boolean crashFlag = false; // 충돌 여부 변수
					
					// 벽에 충돌하지 않았을 경우
					if (isInMap(nx, ny)) { 
						// 다른 로봇과 충돌하는지 확인
						for (int k = 1; k <= N; k++) {
							// 동일한 로봇일 때
							if (robotNumber == k) { 
								continue;
							}
							// 다른 로봇과 충돌했을 때
							if (robots[k].x == nx && robots[k].y == ny) {
								crashFlag = true; // 충돌 여부 변경
								sb.append("Robot ").append(robotNumber).append(" crashes into robot ").append(k);
								break;
							}
						}
					} 
					
					// 벽에 충돌했을 경우
					else { 
						crashFlag = true; // 충돌 여부 변경
						sb.append("Robot ").append(robotNumber).append(" crashes into the wall");
					}
					
					// 충돌하지 않았을 경우 로봇 이동
					if (!crashFlag) { 
						curr.x = nx;
						curr.y = ny;
					} 
					// 충돌했을 경우 프로그램 종료
					else { 
						endFlag = true;
						break;
					}
				}
			}
			// 충돌 발생시 명령 종료
			if (endFlag) {
				break;
			}
		}
		
		// 프로그램이 정상 실행되었을 경우 OK
		if (!endFlag) {
			sb.append("OK");
		}
		System.out.println(sb);
		br.close();
	}

	// 방향별 좌표 초기화
	private static void moveInit() {
		move = new HashMap<>();
		move.put('N', new int[] { 1, 0 });
		move.put('E', new int[] { 0, 1 });
		move.put('S', new int[] { -1, 0 });
		move.put('W', new int[] { 0, -1 });
	}

	// 벽 충돌 여부 확인
	private static boolean isInMap(int x, int y) {
		if (x > 0 && y > 0 && x <= B && y <= A) {
			return true;
		}
		return false;
	}

	// 오른쪽 90도 방향 전환
	private static void rightRotate(Robot robot) {
		if (robot.dir == 'N') {
			robot.dir = 'E';
		} else if (robot.dir == 'E') {
			robot.dir = 'S';
		} else if (robot.dir == 'S') {
			robot.dir = 'W';
		} else {
			robot.dir = 'N';
		}
	}

	// 왼쪽 90도 방향 전환
	private static void leftRotate(Robot robot) {
		if (robot.dir == 'N') {
			robot.dir = 'W';
		} else if (robot.dir == 'E') {
			robot.dir = 'N';
		} else if (robot.dir == 'S') {
			robot.dir = 'E';
		} else {
			robot.dir = 'S';
		}
	}
}
