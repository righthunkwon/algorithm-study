package _20240117;

import java.util.*;
import java.io.*;

public class _24513_좀비바이러스 {
	static int N,M;
	static int[][] map,mapclone;
	static Queue<int[]> q1 = new LinkedList<>();
	static Queue<int[]> q2 = new LinkedList<>();
	static Queue<int[]> q3 = new LinkedList<>();
	static Queue<int[]> zero = new LinkedList<>();

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		mapclone = new int[N][M];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if(tmp==1) {
					q1.add(new int[] {i,j});
				}
				else if(tmp==2) q2.add(new int[] {i,j});
				else if(tmp==0) zero.add(new int[] {i,j});
			}
		}
		while(!zero.isEmpty()) {
			spread();
			int q1size = q1.size();
			for(int i=0;i<q1size;i++) {
				int[] temp = q1.poll();
				if(map[temp[0]][temp[1]]==1 && !q1.contains(new int[] {temp[0],temp[1]})) {
					q1.add(temp);
					System.out.println("q1: "+temp[0]+" "+temp[1]);
				}
			}
			
			System.out.println();
			int zerocnt = zero.size();
			for(int i=0;i<zerocnt;i++) {
				int[] temp = zero.poll();
				if(map[temp[0]][temp[1]]==0) {
					zero.add(temp);
				}
			}
		}
		System.out.println(q1.size()+" "+q2.size()+" "+q3.size());


	}//main
	static void spread() {
		int q1size = q1.size();
		int q2size = q2.size();
		//		mapclone = map.clone();
		// 깊은 복사
		mapclone = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, mapclone[i], 0, M);
		}
		for(int i=0;i<q1size;i++) {
			int[] temp = q1.poll();
			q1.add(temp);
			for(int j=0;j<4;j++) {
				int nr = temp[0]+dr[j];
				int nc = temp[1]+dc[j];
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				if(map[nr][nc]==0) {
					mapclone[nr][nc]=1;
					q1.add(new int[] {nr,nc});
				}
			}
		}
		for(int i=0;i<q2size;i++) {
			int[] temp = q2.poll();
			q2.add(temp);
			for(int j=0;j<4;j++) {
				int nr = temp[0]+dr[j];
				int nc = temp[1]+dc[j];
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				if(mapclone[nr][nc]==0) {
					mapclone[nr][nc]=2;
					q2.add(new int[] {nr,nc});
				}else if(mapclone[nr][nc]==1 && map[nr][nc]==0) {
					System.out.println("여기");
					mapclone[nr][nc]=3;
					q3.add(new int[] {nr,nc});
				}
			}
		}
		// 결과 갱신
		for (int i = 0; i < N; i++) {
			System.arraycopy(mapclone[i], 0, map[i], 0, M);
		}		System.out.println(Arrays.deepToString(map));
	}

}
