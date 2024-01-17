
import java.io.*;
import java.util.*;
//5퍼 시간초과, 로직을 bfs한번에 다 확인하는 걸로 바꿔야할 것 같음 ..
public class Pro_24513_좀비바이러스 {
	static Queue<int[]> q1, q2;
	static int[] dr, dc;
	static int N, M;
	static int[][] town;
	static int one, two, three;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		town = new int[N][M];
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
		one = 0;
		two = 0;
		three = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				town[i][j] = Integer.parseInt(st.nextToken());
				if (town[i][j] == 1) {
					one++;
					q1.add(new int[] { i, j });
				} else if (town[i][j] == 2) {
					q2.add(new int[] { i, j });
					two++;
				}

			}
		}
		bfs(1, 1);
	}

	private static void bfs(int q1_size, int q2_size) {
		if (q1_size == 0 && q2_size == 0) {
			System.out.println(one + " " + two + " " + three);
			return;
		}
		int cnt1 = 0;
		boolean[][] visited = new boolean[N][M];
		while (q1_size > 0) {
			int[] curr = q1.poll();
			if(town[curr[0]][curr[1]]==3)continue;
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || town[nr][nc] != 0||visited[nr][nc])
					continue;
				q1.add(new int[] { nr, nc });
				visited[nr][nc] = true;
				town[nr][nc] = 1;
				cnt1++;
				one++;
			}
			q1_size--;
		}
		int cnt2 = 0;
		while (q2_size > 0) {
			int[] curr = q2.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if (town[nr][nc] == 1 && visited[nr][nc]) {
					town[nr][nc] = 3;
					one--;
					three++;
					cnt1--;
				} else if (town[nr][nc] == 0) {
					town[nr][nc] = 2;
					q2.add(new int[] { nr, nc });
					cnt2++;
					two++;
				}
			}
			q2_size--;
		}
	
		bfs(cnt1, cnt2);
	}

}
