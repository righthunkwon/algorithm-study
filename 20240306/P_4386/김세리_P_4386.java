
import java.util.*;
import java.io.*;

public class _4386_별자리만들기 {
	
	static int parent[];
	
	static class Star{
		int number;
		double x, y;
		
		Star(int n, double x, double y) {
			number = n;
			this.x = x;
			this.y = y;
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        
        Star star[] = new Star[n];
        parent = new int[n];
        
        for(int i = 0; i < n; i++) {
        	parent[i] = i;        	
        }
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            
            star[i] = new Star(i, a, b);
        } // 입력끝
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        // 공식 이용해서 거리 계산 후 pq에 넣음
        for(int i = 0; i < n-1; i++)
            for(int j = i+1; j < n; j++) {
            	pq.offer(new Edge(i, j, Math.sqrt(Math.pow(star[i].x - star[j].x, 2) + Math.pow(star[i].y - star[j].y, 2))));
        }
        
        double weight = 0;
        // 거리 가까운 순으로 꺼내서 계산
        while(!pq.isEmpty()) {
        	
            Edge now = pq.poll();
            
            // 이미 같은 집합에 속했는지 확인
            if(find(now.v1) != find(now.v2)) {
            	// 아닌 경우에 합친다
                union(now.v1, now.v2);
                // 가중치도 합친다
                weight += now.weight;
            }
        }
        // 출력 조건에 맞춰 수정(반올림해서 소수점 두자리까지)
        System.out.println(Math.round(weight*100)/100.0);
        
    }//main
    
    public static void union(int n1, int n2) {
    	// 하나 루트 노드에 속하도록 만듦
        int p1 = find(n1);
        int p2 = find(n2);
        
        if(p1 > p2)
            parent[p1] = p2;
        else
            parent[p2] = p1;
    }
    
    public static int find(int n) {
    	// 대표 노드 찾음
        if(parent[n] == n)
            return n;
        
        return parent[n] = find(parent[n]);
    }
    
    
    static class Edge implements Comparable<Edge> {
        int v1, v2; // 별
        double weight; // 별 사이 거리(가중치)
        
        Edge(int v1, int v2, double weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
        
        // 가중치에 따라 간선 비교(가장 가중치 낮은게 먼저 나오도록)
        public int compareTo(Edge e) {
            return Double.compare(weight, e.weight);
        }
	}
}
