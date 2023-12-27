package _20231227;

import java.util.*;
import java.io.*;

public class _15591_MooTube_Silver {
	static List<int[]>[] graph;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			graph[p].add(new int[] {q,r});
			graph[q].add(new int[] {p,r});
		}
		
		for(int tc=1;tc<=Q;tc++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			visited = new boolean[N+1];
			dfs(a,K);
			
			// 마지막에 처음 자기 자신을 빼준다
			System.out.println(cnt-1);
		}//Q
		
	}//main
	static int dfs(int v, int K) {
		visited[v] = true;
		// 조건 만족하는 노드의 수를 센다
		// 자기 자신부터 포함하므로 1부터 시작
		cnt = 1;
		
		for(int[] tmp : graph[v]) {
			// v에 연결된 인접 노드를 하나씩 꺼내서
			if(!visited[tmp[0]] && tmp[1]>=K) {
				// 방문한 적이 없고 K이상이면 cnt에 추가해준다
				// 그리고 인접 노드를 전부 세기 위해서 그 인접 노드를 다시 dfs 함수에 넣는다
				cnt += dfs(tmp[0],K);
			}
		}
		return cnt;
		
		
	}//dfs

}
