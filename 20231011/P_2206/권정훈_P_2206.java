package level_31_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 참고: https://whitetigerlouis.tistory.com/33
// 참고: https://superohinsung.tistory.com/167

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
	private static int[][] arr;
	private static int[][] dist; // 거리 측정 배열
	private static boolean[][][] visited; // 벽을 부순 여부에 따라 방문 여부 기록
	
	// 상하좌우
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = -1;
        arr = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[2][n][m];

        // 시작지점과 도착지점이 같을 경우
        if (n - 1 == 0 && m - 1 == 0) {
            System.out.print(1);
            System.exit(0);
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(ans);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        arr[0][0] = -1;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int z = poll[2]; // 지나온 경로 세기

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || n <= nx || m <= ny) {
                    continue;
                }

                if (arr[nx][ny] == 1) {
                    if (z == 0 && !visited[1][nx][ny]) {
                        visited[z][nx][ny] = true; // 방문 처리
                        dist[nx][ny] = dist[x][y] + 1; // 거리 측정
                        q.offer(new int[]{nx, ny, 1});
                    }
                } else {
                    if (!visited[z][nx][ny]) {
                        // 해당 칸을 방문을 안했을 때!
                        visited[z][nx][ny] = true; // 방문 처리
                        dist[nx][ny] = dist[x][y] + 1; // 거리 측정
                        q.offer(new int[]{nx, ny, z}); // 다시 큐에 넣어줘서 BFS!
                    }
                }

                if (nx == n - 1 && ny == m - 1) {
                    ans = dist[nx][ny] + 1;
                    return;
                }
            }
        }
    }
}
