import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 두 동전
// 동전들을 이동하다가 하나의 동전을 떨어뜨리는 최소값을 찾으므로 BFS 탐색
// 동전을 동시에 2개 관리하기 위한 방문처리 배열을 구현하는 방법들을 고민하여 풀이하자(4차원배열, HashSet 등)
public class P_16197 {
	private static class Coin {
		int x;
		int y;

		Coin(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int N, M;
	private static char[][] map;
	private static Coin coin1, coin2;
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		map = new char[N][M]; // 지도

		// 지도 배열 요소 입력
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				
				// 코인 객체 저장
				if (map[i][j] == 'o') {
					if (coin1 == null) {
						coin1 = new Coin(i, j);
					} else {
						coin2 = new Coin(i, j);
					}
				}
			}
		}
		System.out.println(bfs(coin1, coin2));
	}

	public static int bfs(Coin coin1, Coin coin2) {
		Queue<Coin[]> q = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();
		q.add(new Coin[] { coin1, coin2 });
		String start = "";
		start += coin1.x;
		start += coin1.y;
		start += coin2.x;
		start += coin2.y;
		visited.add(start);
		int ans = 1; // 버튼을 누른 횟수

		while (!q.isEmpty()) {
			
			// 종료 조건
			if (ans > 10) {
				return -1;
			}
			int len = q.size();
			for (int l = 0; l < len; l++) {
				Coin[] curr = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx1 = curr[0].x + dx[i];
					int ny1 = curr[0].y + dy[i];
					int nx2 = curr[1].x + dx[i];
					int ny2 = curr[1].y + dy[i];

					// 하나만 나갔을 경우 정답 반환
					if ((!isInMap(nx1, ny1) && isInMap(nx2, ny2)) || (isInMap(nx1, ny1) && !isInMap(nx2, ny2))) {
						return ans;
					}
					
					// 둘 다 나갔을 경우 패스
					if ((!isInMap(nx1, ny1) && !isInMap(nx2, ny2))) {
						continue;
					}

					// 다음 좌표가 둘 다 벽이면 패스
					if (map[nx1][ny1] == '#' && map[nx2][ny2] == '#') {
						continue;
					}

					// 둘 중 하나만 벽에 막히면
					// 첫번째 코인이 벽에 막혔을 경우
					if (map[nx1][ny1] == '#' && map[nx2][ny2] != '#') {
						// 만약 첫번째 동전이 두 번째 동전이 이동하려는 위치에 있으면 패스
						if (curr[0].x == nx2 && curr[0].y == ny2) {
							continue;
						}
						nx1 = curr[0].x;
						ny1 = curr[0].y;
					} 
					// 두 번째 코인이 벽에 막혔을 경우
					else if (map[nx1][ny1] != '#' && map[nx2][ny2] == '#') {
						// 만약 두 번째 동전이 첫 번째 동전이 이동하려는 위치에 있으면 패스
						if (curr[1].x == nx1 && curr[1].y == ny1) {
							continue;
						}
						nx2 = curr[1].x;
						ny2 = curr[1].y;
					}
					String next = "";
					next += nx1;
					next += ny1;
					next += nx2;
					next += ny2;

					// 이미 방문했을 경우 패스
					if (visited.contains(next)) {
						continue;
					}
					
					// 방문하지 않았을 경우 방문처리
					visited.add(next);
					
					// 다음 탐색
					q.add(new Coin[] { new Coin(nx1, ny1), new Coin(nx2, ny2) });
				}
			}
			ans++;
		}
		return -1;
	}

	public static boolean isInMap(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
}
