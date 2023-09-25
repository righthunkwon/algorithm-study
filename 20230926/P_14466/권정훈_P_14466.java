package level_31_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 소가 길을 건너간 이유 6
// 길 안 건너고는 만나지 못하는 소 = 모든 소 - 길 안 건너거도 만날 수 있는 소

// 예제 이해
// .   .   .
//
// .   X - X
//         |
// .   . - X

// 중간에 다리가 있다면 다리를 건너서 가야 한다.
// 일반 목초지 사이는 상하좌우 모두 움직일 수 있다.
// 소(2,2)는 소(2,3)까지 다리를 건널 수도, (2,2) (1,2) (1,3) (2,3)의 경로로 갈 수도 있다.
// 소(3,3)은 다른 목초지에 가려면 무조건 다리를 건너야 하므로, 모든 소와 유효한(길을 건너지 않으면 만날 수 없는 소)가 된다.
public class P_14466 {

	private static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int n, k, r;
	private static int[][] map;
	private static boolean[][] visited;
	private static ArrayList<Node>[][] list;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 농장의 크기
		k = Integer.parseInt(st.nextToken()); // 소의 마리수
		r = Integer.parseInt(st.nextToken()); // 길의 수

		map = new int[n + 1][n + 1]; // 소의 위치정보 배열
		list = new ArrayList[n + 1][n + 1]; // 길 정보 배열

		// 각 노드의 ArrayList 초기화
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				list[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < r; i++) {
			// 길의 좌표
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			// 두 노드를 서로 연결
			list[x1][y1].add(new Node(x2, y2));
			list[x2][y2].add(new Node(x1, y1));
		}

		// 소의 위치정보를 입력받고 배열 요소로 등록
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
		}
		
		// 모든 소의 위치에서 너비 우선 탐색을 시작하여 만날 수 있는 소의 쌍을 계산
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		
		// 정답 출력(A소와 B소 만나는 경우 모두를 세었기 때문에 2로 나눈다.)
		System.out.println(ans / 2);
	}

	public static void bfs(int x, int y) {
		visited = new boolean[n + 1][n + 1]; // 방문 확인 배열 초기화
		visited[x][y] = true; // 방문처리
		
		Queue<Node> q = new LinkedList<>(); // 큐를 위한 LinkedList
		q.add(new Node(x, y)); // 소의 좌표 추가
		
		int cnt = -1; // 자기 자신(소)을 세지 않기 위해 초기값을 -1로 설정
		while (!q.isEmpty()) {
			
			// 큐에서 노드를 하나 빼고,
			// 현재 위치에 소가 있을 경우 cnt 증가
			Node node = q.poll(); // 소를 빼내고
			if (map[node.x][node.y] == 1) { // 방문한 위치가 소면
				cnt++; // 소 마리수 증가
			}
		
			// 현재 노드(소)와 상하좌우로 인접한 노드를 확인하고 방문 여부를 확인
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				boolean flag = true; // 다음 노드 방문 가능 여부
				
				// 범위 내부에 있고 아직 방문하지 않았다면
				if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && !visited[nx][ny]) {
					
					for (Node tmp : list[node.x][node.y]) { 
						// 새로 방문하는 곳이 다리의 좌표와 동일하다면, 즉 다리를 건넜다면
						if (tmp.x == nx && tmp.y == ny) {
							flag = false; // 다리를 건넜으므로 false 처리하여 안 가는 걸로 처리
							continue;
						}
					}

					// 다리가 필요하지 않다면 간다
					if (flag) {
						q.add(new Node(nx, ny)); // 다음 노드를 큐에 추가하고
						visited[nx][ny] = true; // 다음 노드를 방문처리
					}
				}
			}
		}
		// 모든 소(k) 중 다리를 안 건너고도 만날 수 있는 소(cnt)와 자기 자신(1)을 제외한 소를 더한다.
		ans += (k - cnt - 1);
	}
}


