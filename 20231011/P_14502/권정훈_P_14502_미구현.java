package level_31_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연구소
// (1) 벽을 3개를 dfs로 세운다.
// (2) 바이러스는 시작점마다 bfs를 돌린다.
// (1) -> (2)로 어떻게 구현해야 할지 감이 안 잡힌다.
public class P_14502 {
	private static int n, m, ans;
	private static int[][] map;
	private static boolean[][] visited;
	
	// 상하좌우
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	ans = Integer.MAX_VALUE;
    	map = new int[n][m];
    	visited = new boolean[n][m];
    	for (int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < m; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	dfs(0); // 벽 세우기
    	System.out.println(ans); // 정답 출력
	}
	
	private static void dfs(int depth) {
    	if (depth == 3) {
    		return;
    	}
    	
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < m; j++) {
    			if (!visited[i][j]) {
    				visited[i][j] = true;
    				dfs(depth + 1);
    				visited[i][j] = false;
    			}
    		}
    	}
    }
}
