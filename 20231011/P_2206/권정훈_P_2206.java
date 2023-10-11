
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기
// 최단거리 구하기이므로 bfs 사용
// 벽을 안 부수는 경우 + 벽을 벽마다 한 번씩 부수는 경우로 브루트포스로 풀 경우 시간초과 발생
// 결국에는 벽을 부수는 경우와 안 부수는 경우를 나누어 bfs를 한 결과를 가져오는 것이 풀이의 핵심

// 방문 배열을 3차원으로 표현하여 
// visited[0][][]의 경우에는 벽을 부수지 않은 경로로, 
// visited[1][][]의 경우에는 벽을 부순 경로의 방문배열로 활용하면
// 벽을 부순 경우와 부수지 않은 경우의 방문배열이 꼬이지 않고 잘 해결된다.
public class P_2206 {
	private static int n, m, ans;
	private static int[][] map;
	private static int[][] dist; // 거리 측정 배열
	private static boolean[][][] visited; // 벽을 부순 여부에 따라 방문 여부 기록
	
	// 상하좌우
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 행
        m = Integer.parseInt(st.nextToken()); // 열
        ans = -1; // 가지 못하는 경우로 초기화
        map = new int[n][m]; // 지도
        dist = new int[n][m]; // 거리
        visited = new boolean[2][n][m]; // 방문처리배열

        // 시작지점과 도착지점이 같을 경우
        if (n - 1 == 0 && m - 1 == 0) {
            System.out.print(1); // 정답 출력후
            System.exit(0); // 종료 
        }

        // 지도 배열 요소 입력
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(ans);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0}); // 시작지점을 큐에 넣음
        map[0][0] = -1; // 시작지점 방문처리

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0]; // 시작좌표
            int y = tmp[1]; // 시작좌표
            int z = tmp[2]; // 벽을 부쉈는지 유무(0: 안부숨, 1: 부숨)

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 배열 범위 벗어나면 스킵
                if (nx < 0 || ny < 0 || n <= nx || m <= ny) {
                    continue;
                }

                // 벽이 있는 경우
                if (map[nx][ny] == 1) {
                	// 벽을 부수지 않았고, 아직 방문하지 않았다면
                    if (z == 0 && !visited[1][nx][ny]) {
                        visited[z][nx][ny] = true; // 방문 처리
                        dist[nx][ny] = dist[x][y] + 1; // 거리 측정
                        q.offer(new int[]{nx, ny, 1});
                    }
                } 
                
                // 벽이 없는 경우에(벽이 없었을 수도 벽을 부쉈을 수도 있음)
                else {
                	// 아직 방문하지 않았다면
                    if (!visited[z][nx][ny]) {
                        visited[z][nx][ny] = true; // 방문 처리
                        dist[nx][ny] = dist[x][y] + 1; // 거리 측정
                        q.offer(new int[]{nx, ny, z}); // 다시 큐에 넣고 탐색
                    }
                }

                // 목적지에 도달했을 경우 누적된 거리를 더하고 리턴 
                if (nx == n - 1 && ny == m - 1) {
                    ans = dist[nx][ny] + 1;
                    return;
                }
            }
        }
    }
}
