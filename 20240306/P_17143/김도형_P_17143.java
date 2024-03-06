package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_Q17143_낚시왕 {

	static class Shark {
		int x, y, s, d, z;

		public Shark(int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // 상어의 수
		int[][] map = new int[R + 1][C + 1]; // (1,1) ~ (R,C)의 맵 생성
		Map<Integer, Shark> sharks = new HashMap<>();

		
		int eatenShark = 0; // 먹힌 상어 수 => 한번 이동하고 먹힌 상어 수 임시 저장용 => 마지막 상어 이동 후 매번 초기화 필요

		// 상어 입력
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sharks.put(i, new Shark(x, y, s, d, z)); // i번째 상어 hashmap에 추가
			map[x][y] = i; // 맵에 상어 입력
		}

		int ans = 0; // 잡은 상어 크기 합
		int kingPos = 0; // 낚시왕 위치

		for (int t = 0; t < C; t++) { // 1초 동안 일어나는 일 수행
			// 1.낚시왕 이동 후 상어 잡기
			kingPos++; // 낚시왕 1칸 이동
			for (int i = 1; i <= R; i++) {
				if (map[i][kingPos] == 0)
					continue; // 상어 없는 칸 패스
				int sharkNum = map[i][kingPos]; // 잡은 상어 인덱스
				ans += sharks.get(sharkNum).z; // 잡은 상어 크기 더해주기
				map[i][kingPos] = 0;// 칸 비워주기
				sharks.remove(sharkNum);// hashmap에서 상어 제거
				break;
			}

			// 2.상어 이동
			// 방향 d => 1:위 / 2:아래 / 3:오른쪽 / 4:왼쪽

			Map<Integer, Shark> temp = new HashMap<>(); // 임시 hashmap 생성 @@@@@@

			for (int key : sharks.keySet()) { // 모든 상어에 대해 반복
				Shark nowSh = sharks.get(key); // 현재 상어 객체 꺼냄
				map[nowSh.x][nowSh.y] = 0; // 현재 있던 자리 비우기
				int moveCnt = 0;
				int moveGoal = nowSh.s;//목표 이동횟수
				if(nowSh.d==1||nowSh.d==2) { //움직여서 같은위치 같은방향이 되는 경우 제거
					moveGoal = moveGoal%((R-1)*2);
				}else {
					moveGoal = moveGoal%((C-1)*2);
				}
				
				
				while (moveCnt != moveGoal) { // moveGoal만큼 이동할때까지 반복
					if (nowSh.d == 1) {
						if (nowSh.x == 1) { // 맵 맨 위면 방향전환 후 이동
							nowSh.d = 2;
							nowSh.x++;
						} else {
							nowSh.x--;
						}
					} else if (nowSh.d == 2) {
						if (nowSh.x == R) { // 맵 맨 아래면 방향전환 후 이동
							nowSh.d = 1;
							nowSh.x--;
						} else {
							nowSh.x++;
						}
					} else if (nowSh.d == 3) {
						if (nowSh.y == C) { // 맵 맨 오른쪽이면 방향전환 후 이동
							nowSh.d = 4;
							nowSh.y--;
						} else {
							nowSh.y++;
						}

					} else if (nowSh.d == 4) {
						if (nowSh.y == 1) { // 맵 맨 왼쪽이면 방향전환 후 이동
							nowSh.d = 3;
							nowSh.y++;
						} else {
							nowSh.y--;
						}
					}
					moveCnt++;
				}
				// 이동 끝 
				temp.put(key, nowSh);
			}

			// sharks 바꿔주기
			for (int key : temp.keySet()) {
				sharks.put(key, temp.get(key));
			}

			// 3.겹치는 상어있으면 작은 상어 죽음
			List<Integer> eatenSharks = new ArrayList<>(); //먹히는 상어의 인덱스 저장용
			for (int key : sharks.keySet()) {
				Shark nowSh = sharks.get(key);

				if (map[nowSh.x][nowSh.y] == 0) { // 이동할 곳 비어있으면..
					map[nowSh.x][nowSh.y] = key;
				} else { // 이동한 곳에 상어가 있으면
					int vsIdx = map[nowSh.x][nowSh.y]; // 원래 있던 상어 인덱스
					Shark vsSh = sharks.get(vsIdx); // 이동할 곳에 있던 상어 객체
					if (nowSh.z > vsSh.z) { // 원래 있던 상어보다 크면
						map[nowSh.x][nowSh.y] = key;
						eatenSharks.add(vsIdx);
					} else {// 원래 있던 상어가 더 크면
						eatenSharks.add(key);
					}
				}
			}
			for(int i=0;i<eatenSharks.size();i++) {
				int x = eatenSharks.get(i);
				sharks.remove(x);
			}

		} // for t

		System.out.println(ans);

	}// main
}// class
