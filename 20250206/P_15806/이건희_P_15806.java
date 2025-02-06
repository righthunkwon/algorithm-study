import java.util.*;

/*
 * 나이트 이동은 홀짝이 번갈아 바뀌므로 초기 곰팡이 위치에 따라 evenArr / oddArr에 BFS 수행하여 최소 이동 횟수를 계산한다.
 * 같은 연결 컴포넌트 내에서 싸이클이 있는지 BFS로 탐색하여 판별한다.
 * 검사 좌표(x, y)에 대해:
 *  - T일에 정확히 도달하면 "YES"
 *  - T일 이전에 도달했더라도 싸이클이 존재하면 "YES"
 *  - 그 외는 "NO"
 */

public class Main {
    static int N, M, K, T;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        T = sc.nextInt();

        int[][] evenArr = new int[N + 1][N + 1];
        int[][] oddArr  = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(evenArr[i], -1);
            Arrays.fill(oddArr[i], -1);
        }

        Queue<int[]> evenQ = new LinkedList<>();
        Queue<int[]> oddQ  = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if ((x + y) % 2 == 0) {
                if (evenArr[x][y] == -1) {
                    evenArr[x][y] = 0;
                    evenQ.offer(new int[]{x, y});
                }
            } else {
                if (oddArr[x][y] == -1) {
                    oddArr[x][y] = 0;
                    oddQ.offer(new int[]{x, y});
                }
            }
        }

        bfs(evenArr, evenQ);
        bfs(oddArr, oddQ);

        boolean[][] reachable = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (evenArr[i][j] != -1 || oddArr[i][j] != -1)
                    reachable[i][j] = true;
            }
        }

        int[][] comp = new int[N + 1][N + 1];
        int compId = 0;
        boolean[] compCycle = new boolean[N * N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (reachable[i][j] && comp[i][j] == 0) {
                    compId++;
                    boolean cycleFound = false;
                    Queue<int[]> q = new LinkedList<>();
                    comp[i][j] = compId;

                    q.offer(new int[]{i, j, 0, 0});

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int cx = cur[0], cy = cur[1];
                        int px = cur[2], py = cur[3];

                        for (int k = 0; k < 8; k++) {
                            int nx = cx + dx[k], ny = cy + dy[k];
                            if (nx < 1 || nx > N || ny < 1 || ny > N)
                                continue;
                            if (!reachable[nx][ny])
                                continue;
                            if (comp[nx][ny] == 0) {
                                comp[nx][ny] = compId;
                                q.offer(new int[]{nx, ny, cx, cy});
                            } else {
                                if (nx == px && ny == py)
                                    continue;
                                cycleFound = true;
                            }
                        }
                    }
                    compCycle[compId] = cycleFound;
                }
            }
        }

        String answer = "NO";
        int Tmod = T % 2;
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d;

            if ((x + y) % 2 == Tmod)
                d = evenArr[x][y];
            else
                d = oddArr[x][y];

            if (d == -1 || d > T)
                continue;
            if (d == T) {
                answer = "YES";
                break;
            }

            int cid = comp[x][y];
            if (cid != 0 && compCycle[cid]) {
                answer = "YES";
                break;
            }
        }
        System.out.println(answer);
    }

    static void bfs(int[][] arr, Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 1 || nx > N || ny < 1 || ny > N)
                    continue;
                if (arr[nx][ny] == -1) {
                    arr[nx][ny] = arr[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}