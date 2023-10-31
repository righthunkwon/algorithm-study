package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/* 프림 알고리즘을 통해 최소 스패닝트리를 구하고, 그 중 가중치가 가장 큰 하나만 빼주면 정답이 나올듯하다
 * 
 * */
public class BOJ_Q1647_도시_분할_계획 {
	static final int INF = Integer.MAX_VALUE;
	
	
	static class Edge implements Comparable<Edge> {   //정렬 기준이 필요하다(나와 쟤 비교)
		int st, ed, w;

		public Edge(int st, int ed, int w) {  //생성자도 만들어주고~
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {   //Edge o가 나와 비교 대상
			return Integer.compare(this.w, o.w);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //N개의 집(노드) (2~100000)
		int M = Integer.parseInt(st.nextToken()); //M개의 길(간선) (1~1000000)
		
		List<Edge>[] adjList = new ArrayList[N+1];
		
		for (int i = 1; i < N+1; i++)
			adjList[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); //A번 집
			int B = Integer.parseInt(st.nextToken()); //B번 집
			int C = Integer.parseInt(st.nextToken()); //A-B 길 유지비용 (1~1000)
			
			adjList[A].add(new Edge(A,B,C));
			adjList[B].add(new Edge(B,A,C));
		} //입력 끝
		
		boolean[] visited = new boolean[N+1]; //마을 방문 체크용 배열
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		visited[1]=true;
		
		for(int i = 0 ; i<adjList[1].size(); i++) {
			pq.add(adjList[1].get(i));
		}
		
		int pick = 1; //이미 1개 뽑았으니까
		int ans = 0;
		int maxCost = 0;  //선정된 길 중 가장 비용이 많이 드는 길의 비용
		
		while(pick !=N) {   
			Edge e = pq.poll();
			
			if(visited[e.ed])
				continue;
			
			ans += e.w;
			maxCost = Math.max(maxCost, e.w);  //가장 큰 비용 갱신
			
			pq.addAll(adjList[e.ed]);
			visited[e.ed]=true;
			pick++;
			
		}
		
		System.out.println(ans - maxCost); //집을 모두 연결하는 비용 중 가장 큰 비용이 드는 길의 비용 제외
		
	}

}
