package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q1103_게임 {
	
	static int[][]map,dp;
	static int N,M;
	static boolean [][]visit;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1}; 
	static int maxMoveCnt;
	static boolean flag=false;
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp= new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String a = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=a.charAt(j)-'0'; //이렇게 입력받으면 H는 24가 됨
				
			}
		}
		
//		System.out.println(Arrays.deepToString(map));
		
//		System.out.println('1' - 48);
		
		maxMoveCnt = -1; //정답 초기화
		
		visit[0][0]=true;
		dfs(0,0,1);
		
//		System.out.println(Arrays.deepToString(dp));
		
		if(flag) { //무한루프면 -1 출력
			System.out.println(-1);
		}else {
			System.out.println(maxMoveCnt);
		}
		
	}
	
	//x : 출발 행   y : 출발 열   depth : 이동횟수
	public static void dfs(int x,int y,int depth) {
		
		if(flag)return; //무한루프 됐으면 dfs 더 해볼 필요 x
		
		if(depth > maxMoveCnt)maxMoveCnt=depth; //최대이동횟수 갱신
		
		for(int i=0; i<4; i++) {
			//map에 써있는 숫자만큼 사방으로 이동하면서 탐색
			int nx = x + (map[x][y])*dx[i]; 
			int ny = y + (map[x][y])*dy[i];
			
			//범위밖이거나 구멍이면 pass
			if(nx<0 || ny<0 || nx>=N || ny>=M || map[nx][ny]==24) { 
				continue;
			}
			
			if(visit[nx][ny]) { //방문했던곳 또가면 무한루프..
				flag = true;  //플래그 바꾸고 리턴
				return;
			}
			
			//이미 더 많은 경로를 거쳐서 왔던 자리면
			if(dp[nx][ny]>depth) continue;
			
			
			//위에서 안걸러졌으면 nx,ny로 이동 가능하다
			dp[nx][ny]=depth+1;
			visit[nx][ny]=true;
			dfs(nx,ny,depth+1);
			visit[nx][ny]=false;
			
			
		}
		
		
	}
	
}
