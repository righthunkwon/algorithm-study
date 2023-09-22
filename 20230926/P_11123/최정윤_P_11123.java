package baek;

import java.io.*;
import java.util.StringTokenizer;

public class Pro_11123_양한마리양두마리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			arr = new char[H][W];
			visited = new boolean[H][W];

			dr = new int[] { -1, 1, 0, 0 };
			dc = new int[] { 0, 0, -1, 1 };
			for (int i = 0; i < H; i++) {
				arr[i] = br.readLine().toCharArray();
			} // 입력끝
			int count = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (arr[i][j] == '#' && !visited[i][j]) {//양이 있고 방문하지 않은 곳만 들어가라
						dfs(i, j);//인접한 양이 있어서 같은 무리가 되면 방문체크가 되서 
						count++; //여기서 count 가능!
					}
				}
			}
			System.out.println(count);
		}
	}

	static int[] dr;
	static int[] dc;
	static int H;
	static int W;
	static boolean[][] visited;
	static char[][] arr;

	public static void dfs(int r, int c) {//같은 무리 묶어주기 메소드
		for (int i = 0; i < 4; i++) {//4방향 탐색해보기
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= H || nc >= W || visited[nr][nc])//범위 밖이거나 이미 무리 지어져있는 것이면 넘어가라
				continue;
			if (arr[nr][nc] == '#') {//양이면 방문처리해줘서 같은 무리로 인식
				visited[nr][nc] = true;
				dfs(nr, nc);//그 지점부터 4방향 탐색 반복
			}
		}
	}
}
