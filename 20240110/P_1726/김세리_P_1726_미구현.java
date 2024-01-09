package _20240110;

import java.util.*;
import java.io.*;

public class _1726_로봇 {
	static int M,N,stx,sty,std,desx,desy,desd;
	static int[][] map;
	static boolean[][] visited;
	static int[] dir = {1,2,3,4};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		stx = Integer.parseInt(st.nextToken())-1;
		sty = Integer.parseInt(st.nextToken())-1;
		std = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		desx = Integer.parseInt(st.nextToken())-1;
		desy = Integer.parseInt(st.nextToken())-1;
		desd = Integer.parseInt(st.nextToken());
		
		moving(stx,sty,std);
		
	}//main
	static void moving(int x, int y, int dir) {
		visited[x][y]=true;
		for(int i=0;i<4;i++) {
			
		}
	}//moving

}
