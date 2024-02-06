package algo_study;

import java.io.*;
import java.util.*;

public class BOJ_Q2665_미로만들기 {
	
	static int N;
	static int[][]map;
	static int [] dx = {0,0,1,-1};
	static int [] dy = {1,-1,0,0};
	static int[][]changes;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		changes = new int[N][N];  //그 위치로 가려면 필요한 변경 횟수 저장 
		for(int i=0;i<N;i++) {
			String str = new String(br.readLine()); 
			for(int j=0;j<N;j++) {
				map[i][j]=str.charAt(j)-'0';
				changes[i][j]=100; //100보다 클수 없으므로
			}
		}//입력 끝
		
		changes[0][0]=0;
		bfs(0,0);
		System.out.println(changes[N-1][N-1]);
	}//main
	
	
	public static void bfs(int x,int y) {
		
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.add(x);
		qy.add(y);
		
		while(!qx.isEmpty() || !qy.isEmpty()) {
			int nowx = qx.poll();
			int nowy = qy.poll();
			for(int i=0;i<4;i++) {
				int nx = nowx+dx[i];
				int ny = nowy+dy[i];
				//범위 밖이면 pass
				if(nx<0||ny<0||nx>=N||ny>=N)continue;
				if(changes[nx][ny]>changes[nowx][nowy]) {
					if(map[nx][ny]==1) {
						changes[nx][ny]=changes[nowx][nowy];
					}else {
						changes[nx][ny]=changes[nowx][nowy]+1;
					}
					qx.add(nx);
					qy.add(ny);
				}else continue;
			}
		}
	}
	
}
