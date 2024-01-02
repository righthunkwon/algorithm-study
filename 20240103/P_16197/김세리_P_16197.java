package _20240103;

import java.util.*;
import java.io.*;

public class _16197_두동전 {
	static int N,M;
	static char[][] arr;
	static boolean[][] visited;
	static Queue<int[]> coin = new LinkedList<>();
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j]= s.charAt(j);
				// 동전의 위치 queue에 추가
				if(arr[i][j]=='o') coin.add(new int[] {i,j});
			}
		}
		
		// 기본값으로 cnt(버튼 누르는 횟수)는 0, ans=-1(실패했을 때 출력할 값)으로 한다
		int cnt=0, ans=-1;
		
		out: while(!coin.isEmpty()) {
			int coinsize = coin.size();
			// 버튼을 누른다
			cnt++;
			// 버튼 누른 횟수가 10이상이면 답은 -1이고, while문을 나간다
			if(cnt>10) {
				ans=-1;
				break out;
			}
			// coin 큐에는 동전 두개가 들어있으므로 /2 만큼 반복한다
			for(int i=0;i<coinsize/2;i++) {
				int[] coin1 = coin.poll();
				int[] coin2 = coin.poll();
				
				for(int j=0;j<4;j++) {
					
					int nr1 = coin1[0]+dr[j];
					int nc1 = coin1[1]+dc[j];
					int nr2 = coin2[0]+dr[j];
					int nc2 = coin2[1]+dc[j];
					// coin1이 나가면 out1을 true로 바꾸고,
					// coin2가 나가면 out2를 true로 바꾼다
					boolean out1 =false, out2=false;
					if(nr1<0 || nr1>=N || nc1<0 || nc1>=M) {
						out1=true;
					}
					if(nr2<0 || nr2>=N || nc2<0 || nc2>=M) {
						out2=true;
					}
					// 둘다 떨어졌을 경우 원하는 답이 아니므로 다른 방향을 다시 탐색하도록 continue를 한다
					if(out1 && out2) continue;
					// 둘중에 하나가 떨어졌을 경우 원하는 답이므로
					// cnt값을 ans에 저장하고 while문을 나간다
					if(out1 || out2) {
						ans=cnt;
						break out;
					}
					// 이동할 곳이 벽일 경우 원래 위치로 돌아간다
					if(arr[nr1][nc1]=='#') {
						nr1 = coin1[0];
						nc1 = coin1[1];
					}
					if(arr[nr2][nc2]=='#') {
						nr2 = coin2[0];
						nc2 = coin2[1];
					}
					// 동전의 위치를 다시 coin queue에 넣는다
					coin.add(new int[] {nr1,nc1});
					coin.add(new int[] {nr2,nc2});
				}
				if(ans != -1) break out;
			}
			if(ans != -1) break out;

		}//while
		
		System.out.println(ans);
		
		
		
	}//main
}
