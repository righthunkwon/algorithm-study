package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	static int N, M, cnt;
	static List<Integer>[] list;
	static Queue<Integer> q;
	static boolean[] chk;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		M = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수
		
		list = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}// 리스트 배열을 만들고
		
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); 
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
			list[B].add(A);
		}// 그래프 입력 완료
		
		q = new LinkedList<Integer>(); // queue생성
		chk = new boolean[N+1]; // 방문쳌 boolean배열
		chk[1] = true; // 1번 노드 방문쳌 해주고
		q.add(1); // queue에 1번 삽입
		while(!q.isEmpty()) { // queue가 비면(탐색할 정점이 없으면) while문 탈출
			bfs(q.poll()); // bfs돌리자
		}
		
		System.out.println(cnt); // cnt 출력
	}
	
	// 너비 우선 탐색
	static void bfs(int V) {
		for(int i = 0; i < list[V].size(); i++) { // 각 노드에 연결된 간선 수만큼 for문 돌릴거야
			if(!chk[list[V].get(i)]) { // 방문하지 않았으면
				chk[list[V].get(i)] = true; // 방문쳌 하고
				q.add(list[V].get(i)); // queue에 삽입해서 탐색 (위의 while문으로 인해 bfs함수 안으로 들어옴)
				cnt++; // 그리고 cnt 증가
			}
		}
	}
}
