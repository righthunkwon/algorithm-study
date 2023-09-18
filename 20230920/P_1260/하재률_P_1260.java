package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	static int N, M, V;
	static List<Integer>[] list; // 리스트 배열로 트리를 구현
	static boolean[] chk; // 방문쳌
	static Queue<Integer> q; // bfs를 위한 queue
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점의 개수 1 <= N <= 1,000
		M = Integer.parseInt(st.nextToken()); // 간선의 개수 1 <= M <= 10,000
		V = Integer.parseInt(st.nextToken()); // 탐색 시작할 정점의 번호
		
		list = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}// 리스트 배열을 만들고
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
			list[B].add(A);
		}// 그래프 입력 완료
		
		for(int i = 0; i < N+1; i++) {
			Collections.sort(list[i]);
		}// 각 노드에 연결된 간선을 정렬해주자
		
		// dfs
		chk = new boolean[N+1]; // 방문체크 boolean배열 초기화
		chk[V] = true; // 탐색 시작 정점 방문쳌
		dfs(V); // dfs돌리기
		System.out.println();
		
		// bfs
		q = new LinkedList<Integer>(); // queue 생성
		chk = new boolean[N+1];// 방문체크 boolean배열 초기화
		q.add(V); // 탐색 시작 정점 queue에 삽입
		chk[V] = true; // 탐색 시작 정점 방문쳌
		while(!q.isEmpty()) { // queue가 비면(탐색할 정점이 없으면) while문 탈출
			bfs(q.poll()); // bfs돌리기
		}
		
	}
	
	// 깊이 우선 탐색
	static void dfs(int V) {
		System.out.print(V + " "); // 출력
		for(int i = 0 ; i < list[V].size(); i++) { // 각 노드에 연결된 간선 수만큼 for문 돌릴거야
			if(!chk[list[V].get(i)]) { // 방문하지 않았으면
				chk[list[V].get(i)] = true; // 방문쳌 하고
				dfs(list[V].get(i)); // 그 노드부터 다시 탐색 시작
			}
		}
	}
	
	// 너비 우선 탐색
	static void bfs(int V) {
		System.out.print(V + " "); // 출력
		for(int i = 0; i < list[V].size(); i++) { // 각 노드에 연결된 간선 수만큼 for문 돌릴거야
			if(!chk[list[V].get(i)]) { // 방문하지 않았으면
				chk[list[V].get(i)] = true; // 방문쳌 하고
				q.add(list[V].get(i)); // queue에 삽입해서 탐색 (위의 while문으로 인해 bfs함수 안으로 들어옴)
			}
		}
	}
}
