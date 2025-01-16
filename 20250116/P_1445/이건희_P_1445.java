import java.util.*;

public class Main {
    static int N, M;
    static int startX, startY, flowerX, flowerY;
    static char[][] forest;
    static int[][] cost;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine();

        forest = new char[N + 1][M + 1];
        cost = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = scanner.nextLine();
            for (int j = 1; j <= M; j++) {
                forest[i][j] = line.charAt(j - 1);
                if (forest[i][j] == 'S') {
                    startX = j;
                    startY = i;
                } else if (forest[i][j] == 'F') {
                    flowerX = j;
                    flowerY = i;
                }
            }
        }

        for (int[] row : cost) {
            Arrays.fill(row, -1); // 미방문 상태 초기화
        }

        Pair<Integer, Integer> result = dijkstra(startX, startY);

        System.out.println(result.first + " " + result.second);
    }

    static Pair<Integer, Integer> dijkstra(int startX, int startY) {
        //쓰레기 개수 및 쓰레기 옆 개수 기준으로 정렬
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startX, startY, 0, 0));
        cost[startY][startX] = 0;

        int minTrash = Integer.MAX_VALUE;
        int minNearTrash = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            // 꽃 위치에 도달하면 갱신 후 종료
            if (current.x == flowerX && current.y == flowerY) {
                minTrash = current.trashCnt;
                minNearTrash = current.nearTrashCnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if (newX < 1 || newX > M || newY < 1 || newY > N || cost[newY][newX] != -1) {
                    continue;
                }

                int newTrashCnt = current.trashCnt;
                int newNearTrashCnt = current.nearTrashCnt;

                // 쓰레기 칸을 지나는 경우
                if (forest[newY][newX] == 'g') {
                    newTrashCnt++;
                } else if (forest[newY][newX] == '.') {
                    // 쓰레기 옆을 지나는 경우 체크
                    boolean isNearTrash = false;
                    for (int j = 0; j < 4; j++) {
                        int adjX = newX + dx[j];
                        int adjY = newY + dy[j];
                        if (adjX >= 1 && adjX <= M && adjY >= 1 && adjY <= N && forest[adjY][adjX] == 'g') {
                            isNearTrash = true;
                            break;
                        }
                    }
                    if (isNearTrash) {
                        newNearTrashCnt++;
                    }
                }

                // 방문 처리 및 큐에 추가
                cost[newY][newX] = cost[current.y][current.x] + 1;
                pq.add(new Node(newX, newY, newTrashCnt, newNearTrashCnt));
            }
        }

        // 결과 반환: 최소 쓰레기 개수, 최소 쓰레기 옆 개수
        return new Pair<>(minTrash, minNearTrash);
    }

    static class Node implements Comparable<Node> {
        int x, y;
        int trashCnt; // 지나간 쓰레기 개수
        int nearTrashCnt; // 지나간 쓰레기 옆 개수

        Node(int x, int y, int trashCnt, int nearTrashCnt) {
            this.x = x;
            this.y = y;
            this.trashCnt = trashCnt;
            this.nearTrashCnt = nearTrashCnt;
        }

        // 우선순위 큐 정렬 기준: 쓰레기 개수 → 쓰레기 옆 개수
        @Override
        public int compareTo(Node other) {
            if (this.trashCnt == other.trashCnt) {
                return Integer.compare(this.nearTrashCnt, other.nearTrashCnt);
            }
            return Integer.compare(this.trashCnt, other.trashCnt);
        }
    }

    static class Pair<F, S> {
        F first;
        S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
