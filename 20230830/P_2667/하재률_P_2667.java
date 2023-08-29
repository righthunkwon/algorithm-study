package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// DFS(깊이 우선 탐색, Depth-First Search) 를 사용해 풀어보자
// 루트 노드에서 시작하여 해당 분기를 완벽하게 탐색하고 다음 분기로 넘어가는 알고리즘.
// 최대한 한 방향으로 쭉 가다가, 더이상 갈 수 없게되면
// 가장 가까운 갈림길로 되돌아와 다른 방향을 쭉 탐색하는것을 반복
// bfs(너비 우선 탐색) 보다 좀 더 간단하지만 느리다
// 모든 정점을 방문하는 문제 -> dfs / bfs
// 경로의 특징을 저장해야하는 문제 -> dfs
// 최단 경로를 구하는 문제 -> bfs
// dfs는 스택, 재귀함수를 이용하는 방법이 있는데 재귀함수를 이용하겠다
// bfs는 queue를 이용한다

public class BOJ_2667_단지번호붙이기 {
	public static int N; // 지도의 크기 N
	public static int[][] map; // 지도
	public static int[] dc = {-1, 1, 0, 0};
	public static int[] dr = {0, 0, -1, 1}; // 델타 상하좌우
	public static boolean[][] visited; // 방문 여부
	public static int apt; // 아파트 단지 번호
	public static int[] apts; // 단지 내 집의 수
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		apts = new int[N*N]; // 아파트 단지는 최대 N개 있을 수 있어
		apt = 0;
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}// 입력 완료
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) { // map배열을 전체 다 돌거야
				if(map[i][j] == 1 && !visited[i][j]) { // 아파트가 있고, 방문하지 않았다면
					apt++; // 아파트 단지 번호를 지정하고
					dfs(i, j); // dfs를 이용해 끝까지 탐색
				}
			}
		}
		
		System.out.println(apt); // 마지막으로 지정된 아파트 번호 == 총 단지 수
		Arrays.sort(apts); // 단지 내에 아파트 수들을 오름차순 정렬
		
		// 아파트 단지 내의 아파트가 0이 아니라면 출력
		for(int i = 0; i < apts.length; i++) {
			if(apts[i] != 0) {
				System.out.println(apts[i]);
			}
		}
	}
	
	// 재귀 함수를 이용한 dfs
	public static void dfs(int x, int y) {
		visited[x][y] = true; // 방문 했으니 true로 바꿔줘
		apts[apt]++; // 해당 아파트 단지 번호를 인덱스로 가지는 아파트의 수를 +1
		
		for(int i = 0; i < 4; i++) { // 델타 4방 탐색
			int c = x + dc[i];
			int r = y + dr[i];
			
			if(c >= 0 && c < N && r >= 0 && r < N) { // 범위를 벗어나지 않고
				if(map[c][r] == 1 && !visited[c][r]) { // 해당 좌표에 아파트가 존재하고 방문하지 않았다면
					dfs(c, r); // 해당 좌표를 기준으로 dfs를 다시 호출
				}
			}
		}
		
	}
}
