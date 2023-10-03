package level_99_dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// https://pangtrue.tistory.com/272

// 파티
// 각 마을에서 X번 마을까지의 왕복이므로
// 1) 다른 마을 -> X번 마을의 최단거리와
// 2) X번 마을 -> 다른 마을의 최단거리의 두 거리를 구한다.

// 이때 다른 마을로부터 X번 마을의 최단거리는 그냥 구하면 되지만,
// X번 마을부터 각 마을까지의 최단거리는 n-1번의 연산을 필요로 한다.

// 이때 연산을 효율적으로 하기 위해서는 간선의 방향을 바꾸면 된다.
// X번 마을로부터 다른 마을까지의 최단거리를 간선의 방향을 바꿔서 구하면 한 번의 연산만 해주면 된다.
public class P_1238 {
	 
	    private static final int INF = 1000000000;
	 
	    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    private static int N, M, X;
	    private static List<List<Node>> list, reverseList;
	    private static int[] dist, reverseDist;
	 
	    static class Node implements Comparable<Node> {
	        int index;
	        int distance;
	 
	        public Node(int index, int distance) {
	            this.index = index;
	            this.distance = distance;
	        }
	 
	        public int compareTo(Node n) {
	            return this.distance - n.distance;
	        }
	    }
	 
	    public static void main(String[] args) throws IOException {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        X = Integer.parseInt(st.nextToken());
	 
	        list = new ArrayList<>();
	        reverseList = new ArrayList<>();
	        for (int i = 0; i <= N; i++) {
	            list.add(new ArrayList<>());
	            reverseList.add(new ArrayList<>());
	        }
	 
	        dist = new int[N + 1];
	        reverseDist = new int[N + 1];
	        Arrays.fill(dist, INF);
	        Arrays.fill(reverseDist, INF);
	 
	        for (int i = 1; i <= M; i++) {
	            st = new StringTokenizer(br.readLine());
	            int u = Integer.parseInt(st.nextToken());
	            int v = Integer.parseInt(st.nextToken());
	            int weight = Integer.parseInt(st.nextToken());
	 
	            list.get(u).add(new Node(v, weight));
	            reverseList.get(v).add(new Node(u, weight));
	        }
	 
	        dijkstra(list, dist, X);
	        dijkstra(reverseList, reverseDist, X);
	 
	        print();
	        br.close();
	    }
	 
	    private static void dijkstra(List<List<Node>> list, int[] distance, int start) {
	        boolean[] visited = new boolean[N + 1];
	        PriorityQueue<Node> pq = new PriorityQueue<>();
	        pq.add(new Node(start, 0));
	 
	        distance[start] = 0;
	 
	        while (!pq.isEmpty()) {
	            int idx = pq.poll().index;
	 
	            if (visited[idx]) continue;
	            visited[idx] = true;
	 
	            for (Node node : list.get(idx)) {
	                if (distance[node.index] > distance[idx] + node.distance) {
	                    distance[node.index] = distance[idx] + node.distance;
	                    pq.add(new Node(node.index, distance[node.index]));
	                }
	            }
	        }
	    }
	 
	    private static void print() {
	        int ans = -1;
	        for (int i = 1; i <= N; i++) {
	            ans = Math.max(ans, dist[i] + reverseDist[i]);
	        }
	        System.out.println(ans);
	    }
	}
