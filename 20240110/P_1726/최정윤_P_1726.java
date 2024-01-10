import java.io.*;
import java.util.*;
//그냥 로봇이 갈 수 있는 곳 모두 q에 담자
//최소 구해야하니까 cnt가장 작은 것부터 빼자 (우선순위 큐)
//방향도 있으니까 3차원배열로 방문체크하자
public class 로봇 {
	public static class Robot implements Comparable<Robot> {
		int r, c, dir, cnt;
		public Robot(int r, int c, int dir, int cnt) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Robot o) {
			return this.cnt - o.cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());// 세로
		N = Integer.parseInt(st.nextToken());// 가로

		arr = new int[M][N];
		dr = new int[] { 0, 1, 0, -1 };
		dc = new int[] { 1, 0, -1, 0 };
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		dir = Integer.parseInt(st.nextToken());
		if (dir == 2) dir = 3;
		else if (dir == 3) dir = 2;
		Robot robot_st = new Robot(r, c, dir, 0);
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		dir = Integer.parseInt(st.nextToken());
		if (dir == 2) dir = 3;
		else if (dir == 3) dir = 2;
		// 입력끝

		q = new PriorityQueue<Robot>();
		q.add(robot_st);
		visited = new boolean[M][N][5];

		visited[robot_st.r][robot_st.c][robot_st.dir] = true;
		bfs();
	}

	static PriorityQueue<Robot> q;
	static int[][] arr;
	static int M, N, r, c, dir;
	static int[] dr, dc;
	static boolean[][][] visited;

	private static void bfs() {
		while (!q.isEmpty()) {
			Robot curr = q.poll();
			if (curr.r == r && curr.c == c && curr.dir == dir) {//나오는 좌표, 방향이라면 바로 출력
				System.out.println(curr.cnt);
				System.exit(0);
			}
			// 1,2,3칸 전진하는 것 q에 담기
			// 범위가 벗어나거나 , 1인 거,visited 는 버려
			for (int i = 1; i <= 3; i++) {
				int nr = curr.r + dr[curr.dir - 1] * i;
				int nc = curr.c + dc[curr.dir - 1] * i;
				if (nr < 0 || nc < 0 || nc >= N || nr >= M || arr[nr][nc] == 1)
					break;//벽이 있거나 1이라면 그 뒤도 전진 불가
				if (visited[nr][nc][curr.dir])// 이거는 그 칸만 전진 불가
					continue;
				q.add(new Robot(nr, nc, curr.dir, curr.cnt + 1));
				visited[nr][nc][curr.dir] = true;
			}

			// 3방향으로 회전하는 것 q에 담기
			for (int i = 1; i <= 4; i++) {
				if (curr.dir == i || visited[curr.r][curr.c][i]) {
					continue;
				} else if (Math.abs(i - curr.dir) == 2) { //180도 방향이면 2번 돌아야하니까 cnt+2함
					q.add(new Robot(curr.r, curr.c, i, curr.cnt + 2));
					visited[curr.r][curr.c][i] = true;
				} else {
					q.add(new Robot(curr.r, curr.c, i, curr.cnt + 1));
					visited[curr.r][curr.c][i] = true;
				}
			}

		}
	}

}
