import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 수
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt(); // 교차로 수
            int m = sc.nextInt(); // 도로 수
            int k = sc.nextInt(); // 목적지 후보 수

            int s = sc.nextInt(); // 출발지
            int g = sc.nextInt(); // 도로 시작
            int h = sc.nextInt(); // 도로 끝

            // 그래프 초기화
            List<int[]>[] graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

            // 도로 정보 입력
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int d = sc.nextInt();
                graph[a].add(new int[]{b, d});
                graph[b].add(new int[]{a, d});
            }

            // 목적지 후보 입력
            int[] targets = new int[k];
            for (int i = 0; i < k; i++) {
                targets[i] = sc.nextInt();
            }

            // 다익스트라 계산
            int[] distS = dijkstra(s, n, graph);
            int[] distG = dijkstra(g, n, graph);
            int[] distH = dijkstra(h, n, graph);

            // 목적지 검증
            List<Integer> result = new ArrayList<>();
            for (int target : targets) {
                int distSGH = distS[g] + distG[h] + distH[target];
                int distSHG = distS[h] + distH[g] + distG[target];

                if (distS[target] == distSGH || distS[target] == distSHG) {
                    result.add(target);
                }
            }

            // 결과 출력
            Collections.sort(result);
            for (int r : result) System.out.print(r + " ");
            System.out.println();
        }
    }

    static int[] dijkstra(int start, int n, List<int[]>[] graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);// 더 짧은 경우 갱신이므로 최댓값으로 이동 방지
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currDist = curr[1];

            if (currDist > dist[currNode]) continue;

            for (int[] neighbor : graph[currNode]) {
                int nextNode = neighbor[0];
                int edgeWeight = neighbor[1];

                if (dist[nextNode] > dist[currNode] + edgeWeight) {
                    dist[nextNode] = dist[currNode] + edgeWeight;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        return dist;
    }
}