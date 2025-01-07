package 백준;

import java.util.*;

public class Main {
	static int n;
	static int m;
	static int t;
	static int s;
	static int g;
	static int h;
	 static class Node implements Comparable<Node>{
	        int node, weight;
	 
	        public Node(int node, int weight) {
	            this.node = node;
	            this.weight = weight;
	        }
	       // 오름차순 정렬
	        @Override
	        public int compareTo(Node o) {
	            return this.weight - o.weight;
	        }
	    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			for(int tc = 0 ; tc< T; tc++) {
				n = sc.nextInt(); 
	            m = sc.nextInt();
	            t = sc.nextInt();

	            s = sc.nextInt();
	            g = sc.nextInt();
	            h = sc.nextInt();
			}
	
			// 다익스트라 문제 
			// 경로를 지나면서 최단거리를 구하는 방식으로 
			// 우선 순위 큐를 이용해서 이미 방문한 곳은 패스
			// -> 계속 최단거리 갱신
			
			
			
			
	}
	
}
