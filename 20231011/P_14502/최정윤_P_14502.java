package baek;

import java.io.*;
import java.util.*;
//0인 모든 좌표점을 list에 담고 그 인덱스 3개를 select라는 배열을 통해 선정후, 선정된 인덱스의 좌표점을 1로 바꿔주기 
//그 뒤 bfs..
public class Pro_14502_연구소 {
	static List<int[]> list;
	static List<int[]> list2;
	static int[] select;
	static int[] dr;
	static int[] dc;
	static int[][] map;
	static int[][] map2;
	static boolean[][] visited2;
	static boolean[] visited;
	static int N;
	static int M;
	static int max;
	static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		map = new int[N][M];
		map2 = new int[N][M];
		list = new ArrayList<>();
		list2 = new ArrayList<>();
		q = new LinkedList<>();
		max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					list.add(new int[] { i, j });
				else if (map[i][j] == 2) {
					list2.add(new int[] { i, j });
				}
			}
		} // 입력끝
			// 0중에 3개 1로 바꿀 수 있음
		select = new int[3];
		visited = new boolean[list.size()];
		select(0);
		System.out.println(max);
	}

	private static void select(int idx) {//3개 선정하는 메소드 
		if (idx == 3) {
			visited2 = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				map2[i] = map[i].clone();
			}
			for (int i = 0; i < 3; i++) {
				int[] arr = list.get(select[i]);
				map2[arr[0]][arr[1]] = 1;

			}
			for (int i = 0; i < list2.size(); i++) {
				q.add(list2.get(i));
				int[] arr = list2.get(i);
				visited2[arr[0]][arr[1]] = true;
			}
			bfs();
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map2[i][j] == 0)
						cnt++;
				}
			}
			max = Math.max(max, cnt);
			return;
		}
    
		for (int i = 0; i < list.size(); i++) {
			if (!visited[i]) {
				select[idx] = i;
				visited[i] = true;
				select(idx + 1);
				visited[i] = false;
			}
		}
	}

	static void bfs() {
		while (!q.isEmpty()) {
			int[] arr = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = arr[0] + dr[i];
				int nc = arr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited2[nr][nc] || map2[nr][nc] == 1)
					continue;
				map2[nr][nc] = 2;
				q.add(new int[] { nr, nc });
				visited2[nr][nc] = true;
			}
		}
	}
}
