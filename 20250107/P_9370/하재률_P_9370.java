import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        while(T-- > 0){
            String[] nmts = br.readLine().split(" ");
            int n = Integer.parseInt(nmts[0]); // 노드
            int m = Integer.parseInt(nmts[1]); // 간선
            int t = Integer.parseInt(nmts[2]); // 목적지 후보

            String[] sgh = br.readLine().split(" ");
            int s = Integer.parseInt(sgh[0]); // 시작점
            int g = Integer.parseInt(sgh[1]); // g 노드
            int h = Integer.parseInt(sgh[2]); // h 노드

            List<List<int[]>> graph = new ArrayList<>();
            for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());

            for(int i = 0; i < m; i++) {
                String[] edge = br.readLine().split(" ");
                int a = Integer.parseInt(edge[0]);
                int b = Integer.parseInt(edge[1]);
                int d = Integer.parseInt(edge[2]);

                graph.get(a).add(new int[]{b, d});
                graph.get(b).add(new int[]{a, d});
            }

            int[] xx = new int[t]; // 목적지 후보들
            for(int i = 0; i < t; i++) xx[i] = Integer.parseInt(br.readLine());

            int[] SS = dijkstra(s, graph, n); // 시작점에서 모든 노드까지 거리
            int[] GG = dijkstra(g, graph, n); // g에서 모든 노드까지 거리
            int[] HH = dijkstra(h, graph, n); // h에서 모든 노드까지 거리

            // g - h 길 지나는 목적지 찾기
            List<Integer> result = new ArrayList<>();
            for(int x : xx) {
                int sToX = SS[x];
                int path1 = SS[g] + GG[h] + HH[x]; // s -> g -> h -> x
                int path2 = SS[h] + HH[g] + GG[x]; // s -> h -> g -> x

                if(sToX == path1 || sToX == path2) result.add(x);
            }

            Collections.sort(result);
            for(int x : result) sb.append(x).append(" ");
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    // 다익스트라
    public static int[] dijkstra(int start, List<List<int[]>> graph, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.offer(new int[]{0, start}); // {거리, 노드}

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currDist = curr[0];
            int currNode = curr[1];

            if(currDist > dist[currNode]) continue;

            for(int[] edge : graph.get(currNode)) {
                int nextNode = edge[0];
                int weight = edge[1];
                int newDist = currDist + weight;

                if(newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.offer(new int[]{newDist, nextNode});
                }
            }
        }

        return dist;
    }
}
