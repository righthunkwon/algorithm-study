package baek;
import java.io.*;
import java.util.*;

public class Pro_17135_캐슬디펜스 {
  
	static boolean[][] visited;
	static int M, N, D, cnt, max;
	static int[] select, dr, dc;
	static int[][] map, map2;
	static PriorityQueue<Node> q;
	static List<int[]> list;
	static class Node implements Comparable<Node> {
		int r, c, dist;

		public Node(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node o) {//거리순으로, 거리가 같다면 제일 왼쪽꺼부터 꺼냄
			if (this.dist - o.dist == 0) {
				return this.c - o.c;
			} else
				return this.dist - o.dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		max = 0;
		map = new int[N][M];
		select = new int[3];
		dr = new int[] { 0, -1, 1, 0, -1, 1, -1, 1 };//앞 4개는 상하좌우 뒤는 대각선으로 더해지는 길이 다름
		dc = new int[] { -1, 0, 0, 1, -1, -1, 1, 1 };
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력끝

		// 궁수 3명 배치 
		dfs(0, 0);
		System.out.println(max);
	}

	private static void dfs(int cnt, int idx) {
		if (cnt == 3) {//궁수 3명이 모였다면 
			gameStart();
			return;
		}
		if (idx == M)
			return;
		select[cnt] = idx;//선택한 궁수 위치 저장
		dfs(cnt + 1, idx + 1);
		dfs(cnt, idx + 1);

	}

	private static void gameStart() {
		map2 = new int[N][M];//새로운 배열 생성해서 깊은복사하자
		for (int i = 0; i < N; i++) {
			map2[i] = map[i].clone();
		}
		int remove = 0;//몇명을 제거했는지 찾아보자
		cnt = 0;//몇바퀴도는지 저장하자 한바퀴돌때마다 적들이 한칸 앞으로 오니까 배열 움직이지 말고 공격할 수 있는 최대거리를 +1해주기 위해서 저장
		while (!finish()) {//모든 배열이 0인지 확인해주고 아니라면 진행
			list = new ArrayList<int[]>();
			for (int i = 0; i < 3; i++) {
				q = new PriorityQueue<Node>();
				visited = new boolean[N][M];
				q.add(new Node(N, select[i], 0));//N번째 궁수위치 담아서  가장 가까운 적을 찾아서 list에 담아준다.
				bfs();
			}
			for (int i = 0; i < list.size(); i++) {//같은 적을 공격할 수 있으므로 0이 아닐 때만 제거한 적의 수를 플러스해준다.
				int[] arr = list.get(i);
				if (map2[arr[0]][arr[1]] != 0) {
					map2[arr[0]][arr[1]] = 0;
					remove++;
				}
			}
			Arrays.fill(map2[N - (cnt + 1)], 0);//적이 한칸 다가오기 때문에 N열을 벗어난 것은 0으로 모두 바꿔줌, cnt로 몇바퀴째인지 알기 때문에 
												//ex)5바퀴째라면 밑에서 5번째줄을 0으로 처리해줘야함 
			cnt += 1;
		}
		max = Math.max(max, remove);//제거한 적의 최댓값 저장
	}

	private static boolean finish() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map2[i][j] != 0)
					return false;
			}
		}
		return true;
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			//우선순위 큐이기 때문에 dist가 짧은 것부터 , 왼쪽부터 나오게 된다.
			Node curr = q.poll();
			if (curr.dist > D + cnt)//꺼냈을 때 공격가능한 거리보다 크다면 이번에 죽일 수 있는 적은 없음. 
				break;
			if (curr.r >= 0 && curr.c >= 0 && curr.r < N && curr.c < M && map2[curr.r][curr.c] == 1) {//범위 안에 들고 적이 있다면 제거가능 , list에 적의 위치를 담아주자
				list.add(new int[] { curr.r, curr.c });
				return;
			}
			for (int i = 0; i < 8; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc])
					continue;
				if (i < 4)//상하좌우는 거리 1
					q.add(new Node(nr, nc, curr.dist + 1));
				else//대각선은 거리 2
					q.add(new Node(nr, nc, curr.dist + 2));
				visited[nr][nc] = true;
			}

		}
	}
}
