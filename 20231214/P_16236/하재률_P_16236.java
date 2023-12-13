package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[] baby = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					baby = new int[] {i, j}; // 아기상어 초기위치 저장하고
					map[i][j] = 0; // 0으로 바꿔주기
				}
			}
		}
		int size = 2; // 아기상어 크기
		int cnt = 0; // 잡아먹은 수
		int res = 0; // 시간
		int[] dx = {-1, 0, 1, 0}; // 델타 상 좌 하 우
		int[] dy = {0, -1, 0, 1};
		
		while(true) {
			boolean[][] chk = new boolean[N][N];
			boolean flag = false; // 먹을 먹이가 있는지?
			
			// 아기상어 이동 후 먹이 찾아가는 로직
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
			pq.add(new int[] {baby[0], baby[1], 0});
			chk[baby[0]][baby[1]] = true;
			int eatX = N, eatY = N, eatDist = Integer.MAX_VALUE;
			
			while(!pq.isEmpty()) {
				int[] poll = pq.poll();
				if (map[poll[0]][poll[1]] != 0 && map[poll[0]][poll[1]] < size) {
					// 먹이 찾았고, 크기가 작은 경우
			        if (poll[2] < eatDist) {
			            eatX = poll[0];
			            eatY = poll[1];
			            eatDist = poll[2];
			        // 거리가 같으면 poll[0] ( 행 ) 이 작은거 선택
			        } else if (poll[2] == eatDist && poll[0] < eatX) {
			            eatX = poll[0];
			            eatY = poll[1];
			        // 행도 같으면 poll[1] ( 열 ) 이 작은거 선택
			        } else if (poll[2] == eatDist && poll[0] == eatX && poll[1] < eatY) {
			            eatY = poll[1];
			        }
			    }
				for(int d = 0; d < 4; d++) {
					int nx = poll[0] + dx[d];
					int ny = poll[1] + dy[d];
					if(nx >= 0 && nx < N && ny >= 0 && ny < N && !chk[nx][ny] && map[nx][ny] <= size) {
						pq.add(new int[] {nx, ny, poll[2] + 1});
						chk[nx][ny] = true;
					}
				}
			}
			// 먹이를 찾은 경우
			if (eatX != N && eatY != N) {
				cnt++; // 잡아먹고
				flag = true; // flag 바꿔주고
				map[eatX][eatY] = 0; // 0으로 바꾸고
				res += eatDist; // 총 시간 +
				baby[0] = eatX;
				baby[1] = eatY;
			}
			
			if(!flag) break; // 먹이가 없는 경우 종료
			// 크기증가
			if(size == cnt) {
				size++;
				cnt = 0;
			}
		}
		System.out.println(res);
		
	}
}
