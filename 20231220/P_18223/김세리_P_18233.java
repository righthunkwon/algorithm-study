package _20231220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _18223_민준이와마산그리고건우 {
	
    // Node 클래스 안에서
    // vertex 필드는 그래프 내의 특정 정점을 나타내고,
    // weight 필드는 시작 정점으로부터 해당 정점까지의 현재 계산된 최단 거리를 나타낸다

    static class Node {
    	int vertex;
    	int weight;
    	
    	Node(int vertex, int weight) {
    		this.vertex = vertex;
    		this.weight = weight;
    	}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        // Node 리스트를 만든다
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 각 노드의 정보를 입력한다
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        
        // 시작점에서 끝까지의 최단거리를 구하고
        // 시작점에서 P까지의 최단거리 + P에서 끝까지의 최단거리가  같으면
        // 건우를 구하러 간다(SAVE HIM)
        int SToEnd = dijkstra(1, V, graph);
        int SToP = dijkstra(1, P, graph);
        int PToEnd = dijkstra(P, V, graph);

        if (SToEnd == SToP + PToEnd) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }
    }

    static int dijkstra(int start, int end, List<List<Node>> graph) {
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            // 현재 노드의 정점이 끝(목적지)과 같으면 distance[end]를 반환한다
            if (current.vertex == end) {
                return distance[end];
            }
            
            // 현재 노드의 거리가 이미 최단 거리보다 긴 경우 넘어간다(어차피 할필요 없음)
            if (current.weight > distance[current.vertex]) {
                continue;
            }
            
            // 인접 노드를 탐색해서 거리를 업데이트 해준다
            for (Node next : graph.get(current.vertex)) {
            	// 현재 노드 거쳐서 인접노드로 가는 거리가 기존에 알려진 인접노드까지의 거리보다 짧다면
            	// 이걸 distance에 업데이트 해주고 인접 노드를 pq에 추가해준다
                if (distance[next.vertex] > distance[current.vertex] + next.weight) {
                    distance[next.vertex] = distance[current.vertex] + next.weight;
                    pq.add(new Node(next.vertex, distance[next.vertex]));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

}
