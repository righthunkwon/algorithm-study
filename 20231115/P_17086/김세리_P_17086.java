package _20231115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17086_아기상어2 {
	static int N,M,ans;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	// 위, 아래, 왼쪽, 오른쪽, 좌상, 우상, 좌하, 우하
	static int[] dr = {-1,1,0,0,-1,-1,1,1};
	static int[] dc = {0,0,-1,1,-1,1,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		N = Integer.parseInt(s.nextToken());
		M = Integer.parseInt(s.nextToken());
		map = new int[N][N];
		visited = new boolean[N][M];

		for(int i=0;i<N;i++) {
			s = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int a = Integer.parseInt(s.nextToken());
				map[i][j] = a;
				if(a==1) q.add(new int[] {i,j});
			}
		}//입력끝
		bfs();

	}//main
	static void bfs() {
		int cnt =0;
		while(!q.isEmpty()) {
			int[]now = q.poll();
			for(int i=0;i<8;i++) {
				int nr = now[0]+dr[i];
				int nc = now[1]+dc[i];
				if(nr>=0 && nc>=0 && nr<N && nc<M && !visited[nr][nc]) {
					visited[nr][nc]=true;
					q.add(new int[] {nr,nc});
					map[nr][nc] = map[now[0]][now[1]]+1;
					cnt = Math.max(cnt, map[nr][nc]);

				}
			}

		}
		System.out.println(cnt-1);
	}//bfs
}
