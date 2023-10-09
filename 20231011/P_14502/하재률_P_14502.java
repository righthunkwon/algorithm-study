package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
   3개의 벽을 세워야 한다
   '0'을 3개 뽑아 벽을 세우는 dfs
   '2'일때 bfs 돌려서 바이러스 구역을 만들고
   0의 개수를 세어서 최대인걸 찾아보자
*/
public class BOJ_14502_연구소 {
	static int N, M, res;
	static int[][] map, tmp; // 벽 3개 뽑을때마다 bfs 돌려야하기 때문에 map을 복사한 tmp필요
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1}; // delta 상하좌우
	
	// queue에 넣을 좌표를 위해 class생성
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로크기
		M = Integer.parseInt(st.nextToken()); // 가로크기
		map = new int[N][M];
		res = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(res);
	}
	
	// 벽 3개를 세우는 dfs
	static void dfs(int depth) {
		if(depth == 3) { // 3개가 되면 bfs돌려서 안전구역 최댓값을 구해보자
			bfs();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(depth + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	// 바이러스 확산을 위한 bfs
	static void bfs() {
		// 모든 경우의 수에 bfs를 돌려야 해서 매번 복사해주자
		tmp = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		Queue<Node> q = new LinkedList<>();
		
		// '2'인것들(바이러스) 찾아서 queue에 넣어주고
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 2) q.add(new Node(i, j));
			}
		}
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			for(int d = 0; d < 4; d++) {
				int nx = poll.x + dx[d];
				int ny = poll.y + dy[d];
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) { // 범위를 벗어나지 않고
					if(tmp[nx][ny] == 0) { // '0'이라면
						tmp[nx][ny] = 2; // 바이러스 확산
						q.add(new Node(nx, ny)); // 다음 진행
					}
				}
			}
		}
		count(tmp);
	}
	
	// 안전구역 카운트
	static void count(int[][] tmp) {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tmp[i][j] == 0) cnt++;
			}
		}
		
		res = Math.max(res, cnt);
	}
}
