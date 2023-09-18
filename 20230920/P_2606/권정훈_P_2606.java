package dfs_bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 바이러스(dfs)
// 인접리스트로 풀이
public class P_2606_dfs {
	private static int n,m,ans;
	private static boolean visited[];
	private static List<Integer>[] list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 컴퓨터의 수
		m = sc.nextInt(); // 연결된 컴퓨터 쌍의 수
		list = new ArrayList[n + 1]; // 인접리스트
		visited = new boolean[n + 1]; // 방문배열
		
		// Null Pointer Exception을 방지하기 위한 배열 초기화
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}

		// 간선의 정보 입력
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt(); // 시작 정점
			int y = sc.nextInt(); // 끝 정점

			// 무방향그래프
			list[x].add(y);
			list[y].add(x);
		}
		System.out.println(dfs(1)); // 1번 컴퓨터
		sc.close();
	}

	private static int dfs(int i) {
		visited[i] = true; // 방문 처리
		for(int j : list[i]) {
			// 방문하지 않았을 경우
			if(visited[j] == false) {
				ans++;
				dfs(j);
			}
		}
		return ans;
	}
}
