package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q27958_사격_연습 {

	static int N, K;
	static int[][] map, hp;
	static int[] power; // 총알의 공격력 저장 배열
	static int maxscore;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		map = new int[N][N];
		hp = new int[N][N];
		power = new int[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				hp[i][j] = map[i][j];
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			power[i] = Integer.parseInt(st.nextToken()); // 총알 공격력 입력
		}
		// 입력 끝

		maxscore = 0;

		for(int i=0;i<N;i++) {
		dfs(i, 0, 0, map, hp);  //@@@@@@@@@@@@@@@@@@@@@@이게 문제였다ㅏㅏ
		}
		
		System.out.println(maxscore);

	}// main
  
		// 0~N-1 줄 0~K-1
		// start:몇번째 줄 쏠지 cnt : 몇발째인지 score:현재 누적 점수 map : 현재 맵 정보 nowhp : 현재 체력 정보
	public static void dfs(int start, int cnt, int score, int[][] nowmap, int[][] nowhp) {


		// 기저
		if (cnt >= K) { // 총알 다썼으면 최대 점수랑 비교해서 갱신
			maxscore = Math.max(maxscore, score);
			return;
		}

		int[][] tmpmap = new int[N][N];
		int[][] tmphp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmpmap[i][j] = nowmap[i][j];
				tmphp[i][j] = nowhp[i][j]; // 복사 끝
			}
		}

		int idx = 0; // 총알 날아가는 위치

		while (idx < N) {

			if (tmpmap[start][idx] != 0) {

				if (tmpmap[start][idx] >= 10) { // 보너스 쏜 경우
					score += tmpmap[start][idx]; // 보너스 점수 획득
					tmpmap[start][idx] = 0;
					tmphp[start][idx] = 0;

					break;
				} else {

					if (tmphp[start][idx] > power[cnt]) { // 공격력이 모자라서 체력 남는 경우
						tmphp[start][idx] -= power[cnt];

						break;
					} else { // 공격력 충분하면
						score += tmpmap[start][idx]; // 초기체력만큼 점수 획득

						for (int i = 0; i < 4; i++) {
							int nx = start + dx[i];
							int ny = idx + dy[i];
							if (nx < 0 || ny < 0 || nx >= N || ny >= N || tmpmap[nx][ny] != 0)
								continue;
							tmpmap[nx][ny] = tmpmap[start][idx] / 4;
							tmphp[nx][ny] = tmpmap[nx][ny];
						}
						tmpmap[start][idx] = 0;
						tmphp[start][idx] = 0;

						break;
					}
				}
			}
			idx++;
		}
		
		cnt++;

		for (int i = 0; i < N; i++) {
			dfs(i, cnt, score, tmpmap, tmphp);
		}

	}// dfs

}// class
