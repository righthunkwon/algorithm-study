package _20231025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2573_빙산 {
	static int N, M, time;
	static int[][] sea, iceberg;
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sea = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				sea[i][j]=Integer.parseInt(st.nextToken());
				if(sea[i][j]!=0) q.add(new int[] {i,j});
			}
		}//입력 끝
//		visited = new boolean[N][M];
		iceberg = new int [N][M];
		
//		int time=0;
//		while(true) {
//			dfs();
//			if(dung) break;
//			time++;
//		}
		dfs();
		System.out.println(time);
		
	}//main
	
	static void dfs() {
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for(int i=0;i<4;i++) {
				int a = temp[0] + dr[i];
				int b = temp[1] + dc[i];
				if(a<0||b<0||a>=N||b>=M) continue;
				if(sea[a][b]==0) iceberg[a][b]++;
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					sea[i][j]= sea[i][j]-iceberg[i][j];
					if(sea[i][j]!=0) q.add(new int[] {i,j});
				}
			}
			time++;
			if(dung(0,0)>=2) return;
		}
	}//dfs
	static int dung(int x, int y) {
		int cnt = 0;
		visited = new boolean[N][M];
		visited[x][y] = true;
		for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {
	            if (sea[i][j] > 0 && !visited[i][j]) {
	                cnt++;
	                dung(i, j);
	            }
	        }
	    }
	    return cnt;
	}

}
