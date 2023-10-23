package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {
	static int N, M;
	static int[][] map;
	static boolean[][] chk;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		chk = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력 완
		
		int res = 0; // 몇 년 지났는지 저장할 결과값 변수
		while(true) {
			int dung2Cnt = dung2(); // 몇 덩이로 나누어졌는지 먼저 검사때려
			if(dung2Cnt == 0) { // 빙산이 없다면 0출력
				System.out.println(0);
				break;
			} else if(dung2Cnt >= 2) { // 빙산이 2덩이 이상이 되면 몇 년 지났는지 출력
				System.out.println(res);
				break;
			}
			// 빙산을 녹이자
			polartear();
			res++;
		}
	}
	// 몇덩이인지 체크하는 메서드
	static int dung2() {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] > 0 && !chk[i][j]) { // 빙산이고, 방문하지 않았으면
					bfs(i, j); // bfs돌려서 한 몸을 찾을거야
					cnt++;
				}
			}
		}
		return cnt;
	}
	// 한 몸 찾자
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		chk[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			for(int d = 0; d < 4; d++) {
				int nx = poll[0] + dx[d];
				int ny = poll[1] + dy[d];
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] > 0 && !chk[nx][ny]) {
					q.add(new int[] {nx, ny});
					chk[nx][ny] = true;
				}
			}
		}
	}
	// 빙산을 녹이는 메서드
	static void polartear() {
		int[][] tmp = new int[N][M]; // 원본 배열을 녹이면 0이되면서 그거까지 체크하기때문에 만듬
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] > 0) {
					int sea = 0; // 바다의 개수 저장할 변수
					
					for(int d = 0; d < 4; d++) { // 4방향만 돌면서 바다 개수 찾아서
						int nx = i + dx[d];
						int ny = j + dy[d];
						if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) sea++;
					}
					tmp[i][j] = Math.max(0, map[i][j] - sea); // 0 미만으로 떨어지지 않게
				}
			}
		}
		map = tmp; // 빙산 녹인 배열을 적용시키고
		chk = new boolean[N][M]; // chk 초기화
	}
    
}
