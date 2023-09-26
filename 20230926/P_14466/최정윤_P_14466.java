package baek;


import java.io.*;
import java.util.*;
//길이 있는 곳은 연결하지 않게 한 뒤, bfs를 진행하면 연결된 공간끼리만 담기고 종료될 것이다. 
//종료되었을 때 그 구간에 있는 소를 카운트 한 뒤 저장해놓고 
//다른 구간에 있는 소들을 조합하여 몇쌍인지 센다.

public class Pro_소가길을건너간이유 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		road = new int[R][4]; //길을 건너야만 갈 수 있는 곳 배열로 저장
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				road[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cow = new boolean[N + 1][N + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			cow[r][c] = true; //소 있는 곳은 true
		} // 입력끝
		
		
		ex = 0;
		visited = new boolean[N + 1][N + 1];
		queue = new LinkedList<int[]>();
		list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (!visited[i][j]) {
					count = 0;
					queue.add(new int[] { i, j });
					visited[i][j] = true;
					bfs();
				}
			}
		}
		int result = 0;
      //여러구간에 소가 따로 담겨있으면 다 곱해본다.
		if (list.size() > 1) {
			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) {
					result += list.get(i) * list.get(j);
				}
			}
		} else if (list.size() == 1)
			result = list.get(0);

		System.out.println(result);
	}

	static boolean[][] visited;
	static Queue<int[]> queue;
	static int[] dr;
	static int[] dc;
	static int N;
	static int R;
	static int[][] road;
	static boolean[][] cow;
	static List<Integer> list;
	static int count;
	static int ex;

	public static void bfs() {
		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			check: for (int i = 0; i < 4; i++) {//4방향 탐색
				int nr = arr[0] + dr[i];
				int nc = arr[1] + dc[i];
				if (nr < 1 || nc < 1 || nr >= N + 1 || nc >= N + 1 || visited[nr][nc])//구간 안넘어가고 방문안했다면
					continue;
				for (int j = 0; j < R; j++) {// 큐에 넣으려고 하는데 길이 이어진거라면 그 방향으로 진행하면  X
					if (road[j][0] == arr[0] && road[j][1] == arr[1] && nr == road[j][2] && nc == road[j][3]) {//현재 좌표와 진행할 좌표가 길이 있는 곳인지 체크
						continue check;
					} else if (road[j][2] == arr[0] && road[j][3] == arr[1] && nr == road[j][0] && nc == road[j][1]) {//현재 좌표와 진행할 좌표가 길이 있는 곳인지 체크
						continue check;
					}
				}
				visited[nr][nc] = true;
				queue.add(new int[] { nr, nc });
			}
		}
		//큐 다 비웠으면 visited된 곳에서 소 몇마리인지 센다. 
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
					if (visited[i][j] && cow[i][j]) {
						count += 1;
					}
			}
		}
		//visited는 유지해주어야하기 때문에 2번째 구간부터는 누적이 되므로 예전까지 소 몇마리 있었는지 빼주고 담기
		list.add(count - ex);
		ex = count;//이번 소 몇마리 있었는지 담아놓기
	}
}
