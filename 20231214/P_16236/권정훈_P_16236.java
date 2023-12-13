package level_31_dfs_bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 아기 상어
// 최단 경로를 구하므로 bfs 사용
// 상어의 초기 좌표를 저장한 뒤 해당 위치도 탐색하기 위해 해당 위치의 값을 0으로 바꿈
// while문 내의 bfs를 돌 때마다 상어의 위치를 초기화해주며 매번 최단거리를 갱신하며 파악

public class P_16236 {
	private static int n;
	private static int[][] map;
	private static int dx[] = { 0, 0, 1, -1 };
	private static int dy[] = { -1, 1, 0, 0 };
	
	private static class Point {
		int x;
		int y;
		int dist;

		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		map = new int[n][n];
		Queue<Point> q = new LinkedList<>();
		
		// 배열 요소 입력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				
				// 초기 상어 위치를 저장한 뒤 해당 위치를 0으로 바꿈
				if (map[i][j] == 9) {
					q.add(new Point(i, j, 0));
					map[i][j] = 0;
				}
			}
		}

		int eat = 0; // 먹은 물고기 수
		int size = 2; // 상어 크기
		int ans = 0; // 걸린 시간
		
		while (true) {
			List<Point> fish = new LinkedList<>(); // 먹을 수 있는 물고기를 담을 리스트
			int[][] dist = new int[n][n]; // 걸린 시간(거리)를 체크할 배열

			while (!q.isEmpty()) {
				Point curr = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = curr.x + dx[i];
					int ny = curr.y + dy[i];

					// 1. 범위에서 벗어나지 않고 
					// 2. 방문하지 않았으며 (dist[][]에는 좌표마다의 최단거리가 입력되므로 0이 아닌 위치는 이미 방문한 장소)
					// 3. 상어가 이동 가능할 경우 (자기 크기보다 작거나 같을 경우)
					if (nx >= 0 && ny >= 0 && nx < n && ny < n && dist[nx][ny] == 0 && map[nx][ny] <= size) {
						dist[nx][ny] = dist[curr.x][curr.y] + 1; // 거리를 1 증가시키고
						q.add(new Point(nx, ny, dist[nx][ny])); // 증가된 거리를 갱신
						
						// 만약 새로 방문할 곳이 물고기이고 아기 상어보다 크기가 작다면 물고기를 추가
						if (map[nx][ny] >= 1 && map[nx][ny] <= 6 && map[nx][ny] < size) {
							fish.add(new Point(nx, ny, dist[nx][ny]));
						}
					}
				}
			}

			// 더는 먹을 수 있는 물고기가 없다면 정답 출력
			if (fish.size() == 0) {
				System.out.println(ans);
				return;
			}

			// 전체 물고기를 돌며 최단 거리 물고기 찾기(단 위, 왼 순으로 우선)
			Point currFish = fish.get(0);
			for (int i = 1; i < fish.size(); i++) {
				
				// 최단거리 물고기 갱신
				if (currFish.dist > fish.get(i).dist) {
					currFish = fish.get(i);
				} 
				
				// 만약 최소가 되는 거리가 같다면
				else if (currFish.dist == fish.get(i).dist) {
					
					// 위에 있는 물고기를,
					if (currFish.x > fish.get(i).x) {
						currFish = fish.get(i);
					} 
					
					// 같은 위치라면 왼쪽에 있는 물고기를 선택
					else if (currFish.x == fish.get(i).x) {
						if (currFish.y > fish.get(i).y) {
							currFish = fish.get(i);
						}
					}
				}
			}

			eat++; // 먹은 물고기의 수 증가
			ans += currFish.dist; // 거리 누적합
			map[currFish.x][currFish.y] = 0; // 먹은 물고기 자리 초기화
			
			// 만약 먹은 물고기의 수가 아기상어의 크기와 같다면 사이즈를 증가시키고 먹은 물고기의 수를 초기화
			if (eat == size) {
				size++;
				eat = 0;
			}
			
			// 물고기를 먹은 새로운 위치에서 다시 이 작업을 반복
			q.add(new Point(currFish.x, currFish.y, 0));
		}
	}

}
