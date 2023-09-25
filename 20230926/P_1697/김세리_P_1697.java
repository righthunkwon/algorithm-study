import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697_숨바꼭질 {
    static int N, K, cnt;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        cnt = 0;
        if (N == K) {
            System.out.println(cnt);
        } else {
            bfs(N);
            System.out.println(cnt);
        }
    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;
        while (!q.isEmpty()) {
            int size = q.size(); // 현재 큐의 크기를 저장
            for (int i = 0; i < size; i++) {
                int t = q.poll();
                if (t == K) {
                    return;
                }
                if (t - 1 >= 0 && !visited[t - 1]) {
                    visited[t - 1] = true;
                    q.add(t - 1);
                }
                if (t + 1 <= 100000 && !visited[t + 1]) {
                    visited[t + 1] = true;
                    q.add(t + 1);
                }
                if (2 * t <= 100000 && !visited[2 * t]) {
                    visited[2 * t] = true;
                    q.add(2 * t);
                }
            }
            cnt++; // 현재 큐에 있는 모든 위치를 탐색한 후에 카운트 증가
        }
    }
}
