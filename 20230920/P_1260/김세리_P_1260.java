package _20230920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1260_DFS와BFS {
	static int N, M, V, idx, nodeIndex;
	static int arr[][];
	static boolean[] check;
	static boolean[] visited;
	static StringBuilder sb;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		V = Integer.parseInt(str.nextToken());

		arr = new int [N+1][N+1];
		check = new boolean [N+1];
		visited = new boolean [N+1];
		sb = new StringBuilder();
		
		// 연결된 두 정점의 좌표에 따라 배열을 1로 채운다
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b]=arr[b][a]=1;
		}
		
		dfs(V);
		
		sb.append("\n");
		
		bfs(V);
		
		System.out.println(sb);
	}//main
	
	public static void dfs(int start) {
		check[start]=true;
		sb.append(start+" ");
		
		for(int i=0;i<=N;i++) {
			if(arr[start][i]==1 && !check[i]) {
				dfs(i);
			}
			
			
		}
	}//dfs

	
	public static void bfs(int start) {
		// 시작을 queue에 넣는다
		q.add(start);
		// 방문처리를 한다
		visited[start] = true;
		
		//큐가 공백이 될 때까지 반복문 수행한다
		while(!q.isEmpty()) {
			//위에 있는걸 꺼내고
			int t = q.poll();
			sb.append(t +" ");
			
			//나와 연결되어 있으면서 방문하지 않은 애들을 queue에 넣고 방문처리를 한다
			for(int i=1;i<=N;i++) {
				if(arr[t][i]==1 && !visited[i]) {
					q.add(i);
					visited[i] =true;
				}
			}
		}
	}//bfs

}
