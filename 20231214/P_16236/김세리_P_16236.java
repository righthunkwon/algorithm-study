package _20231214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _16236_아기상어2 {  // pq사용함
    static int N, size, cnt;
    static int[][] map, time;

    // 상, 좌, 하, 우
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    static class Node {
        int r, c, dist;

        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        Node shark = new Node(-1, -1, 0);
        size = 2;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) { // 상어 위치 shark에 저장
                    shark.r = i;
                    shark.c = j;
                    map[i][j] = 0; // 상어 위치 초기화
                }
            }
        }

        int sum = 0;
        cnt = 0;
        while (true) {
            Node fish = bfs(shark);
            // 물고기 위치가 MAX_VALUE가 아니면 잡아먹을 물고기 위치가 특정되었단 의미이다
            if (fish.r != Integer.MAX_VALUE) {
                cnt++;
                shark = new Node(fish.r, fish.c, 0); // 상어 위치를 방금 먹은 물고기 위치로 바꿔준다
                sum += fish.dist; // 방금 물고기 잡아먹느라 걸린 시간을 총 시간에 더해준다
                
                // 잡아먹은 물고기 수가 현재 상어만해지면 상어 크기를 키워주고 개수를 다시 초기화한다
                if (cnt == size) { 
                    size++;
                    cnt = 0;
                }
            }
            // MAX_VALUE일 경우 잡아먹을 물고기가 없다는 뜻이므로 while문을 나간다
            else break;
        }//while
        System.out.println(sum);
    }

    static Node bfs(Node shark) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.dist != n2.dist) {
                    return n1.dist - n2.dist; // 우선적으로 거리가 짧은 순서
                } else if (n1.r != n2.r) {
                    return n1.r - n2.r; // 거리가 같다면 행 번호가 낮은 순서
                } else {
                    return n1.c - n2.c; // 행 번호도 같다면 열 번호가 낮은 순서
                }
            }
        });

        boolean[][] visited = new boolean[N][N];
        pq.add(new Node(shark.r, shark.c, 0));
        visited[shark.r][shark.c] = true;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (map[cur.r][cur.c] != 0 && map[cur.r][cur.c] < size) {
                map[cur.r][cur.c] = 0; // 물고기 먹혔으니까 0으로 바꿔준다
                return cur; // 먹을 수 있는 물고기를 찾았을 때 반환한다
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc] <= size) {
                    visited[nr][nc] = true;
                    // 조건 만족하면 다시 pq에 추가해준다
                    pq.add(new Node(nr, nc, cur.dist+1));
                }
            }
        }

        return new Node(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE); // 먹을 수 있는 물고기를 찾지 못했을 때
    }


}
