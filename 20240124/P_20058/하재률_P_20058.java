package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1. 2^L x 2^L 크기 격자로 나누기
// 2. 나눈거 시계방향으로 90도 회전
// 3. 특정 칸에 얼음 3개 이상 인접해있지 않다면 얼음 -1 (상하좌우)
// 4. Q번 반복
// 5. 남은 얼음 구하기 + 가장 큰 덩어리 bfs로 구하기
public class BOJ_20058_마법사상어와파이어스톰 {
	
	static int N, Q;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int res, big;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 한 변은 2^N
		Q = Integer.parseInt(st.nextToken()); // Q번 시전
		
		N = (int) Math.pow(2, N); // 한 변의 개수
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 맵 입력 완
		
		int[] L = new int[Q]; // 한 변이 2^L인 격자로 나눌겨
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < Q; i++) L[i] = Integer.parseInt(st.nextToken());
		
		// Q번 스킬 시전
		for(int i = 0; i < Q; i++) {
			// 나누고 돌리기
			map = div(L[i]);
			// 녹이기
			melt();
		}
		
		// 얼음 총 개수 구하기 + 가장 큰 얼음덩이
		res = 0; big = 0;
		
		dung2();
		System.out.println(res);
		System.out.println(big);
		
	}
	
	// 쪼개는 메서드
	static int[][] div(int l) {
		l = (int) Math.pow(2, l);
		
		// 배열 복사
		int[][] tmp = new int[N][N];
		for(int i = 0; i < N; i++) tmp[i] = Arrays.copyOf(map[i], N);
		
		// 한 변 l 로 쪼개서 돌리기
		for(int i = 0; i < N; i += l) {
			for(int j = 0; j < N; j += l) {
				turn(i, j, l, tmp);
			}
		}
		return tmp;
		
	}
	
	// 돌리는 메서드
	static void turn(int a, int b, int l, int[][] tmp) {
		for(int i = 0; i < l; i++) {
			for(int j = 0; j < l; j++) {
				tmp[a + i][b + j] = map[a + l - 1 - j][b + i];
			}
		}
	}
	
	// 녹이는 메서드
	static void melt() {
		// 녹이는건 배열 복사해서
		int[][] tmp = new int[N][N];
		for(int i = 0; i < N; i++) tmp[i] = Arrays.copyOf(map[i], N);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int cnt = 0;
				if(map[i][j] != 0) { // 얼음 칸일때
					// 사방 탐색해서
					for(int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
							if(map[nx][ny] > 0) cnt++;
						}
					}
					// 얼음칸이 3개 이상 인접해있지 않으면 얼음 -1
					if(cnt < 3) tmp[i][j]--;
				}
			}
		}
		// 원본에 덮어씌우기
		for(int i = 0; i < N; i++) map[i] = Arrays.copyOf(tmp[i], N);
	}
	
	// 얼음 총 개수 + 가장 큰 덩이 구하는 bfs
	static void dung2() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] chk = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// 얼음 총 개수 구하면서
				res += map[i][j];
				int cnt = 0;
				
				if(map[i][j] > 0 && !chk[i][j]) {
					q.add(new int[] {i, j});
					chk[i][j] = true;
					cnt++;
					
					while(!q.isEmpty()) {
						int[] poll = q.poll();
						
						for(int d = 0; d < 4; d++) {
							int nx = poll[0] + dx[d];
							int ny = poll[1] + dy[d];
							if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
								if(map[nx][ny] > 0  && !chk[nx][ny]) {
									q.add(new int[] {nx, ny});
									chk[nx][ny] = true;
									cnt++;
								}
							}
						}
					}
					big = big > cnt ? big : cnt;
				}
			}
		}
		
	}
}
