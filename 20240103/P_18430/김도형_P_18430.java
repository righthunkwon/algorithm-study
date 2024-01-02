package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Q18430_무기_공학 {
	static int N,M;
	static int [][]arr;
	static int ans;
	static boolean[][]visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//세로
		M = Integer.parseInt(st.nextToken());//가로
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}//입력 끝
		ans=0;
		visit=new boolean[N][M];
		
		dfs(0,0);
		
		System.out.println(ans);
		
		
	}//main
	public static void dfs(int idx,int total) {
		//기저
		if(idx==N*M) {
			ans=Math.max(ans, total);
			return;
		}
		//재귀
		int x = idx/M;
		int y = idx%M; //idx를 통해 탐색할 위치정보 구하기
		
		if(!visit[x][y]) {//방문한적 없는 곳이면..
			// " ㄱ "모양 - 범위 안이고 방문한적 없으면
			if(y-1>=0 && x+1<N && !visit[x][y-1] && !visit[x+1][y]) {
				visit[x][y]=true;
				visit[x+1][y]=true;
				visit[x][y-1]=true;
				int tmp = arr[x][y]*2+arr[x+1][y]+arr[x][y-1];
				dfs(idx+1,total+tmp);
				visit[x][y]=false;
				visit[x+1][y]=false;
				visit[x][y-1]=false;
			}
			// " 」"모양
			if(x-1>=0 && y-1>=0 && !visit[x-1][y] && !visit[x][y-1]) {
				visit[x][y]=true;
				visit[x-1][y]=true;
				visit[x][y-1]=true;
				int tmp = arr[x][y]*2+arr[x-1][y]+arr[x][y-1];
				dfs(idx+1,total+tmp);
				visit[x][y]=false;
				visit[x-1][y]=false;
				visit[x][y-1]=false;
			}
			// " ㄴ "모양
			if(x-1>=0 && y+1<M && !visit[x-1][y] && !visit[x][y+1]) {
				visit[x][y]=true;
				visit[x-1][y]=true;
				visit[x][y+1]=true;
				int tmp = arr[x][y]*2+arr[x-1][y]+arr[x][y+1];
				dfs(idx+1,total+tmp);
				visit[x][y]=false;
				visit[x-1][y]=false;
				visit[x][y+1]=false;
			}
			// "「 "모양
			if(x+1<N && y+1<M && !visit[x+1][y] && !visit[x][y+1]) {
				visit[x][y]=true;
				visit[x+1][y]=true;
				visit[x][y+1]=true;
				int tmp = arr[x][y]*2+arr[x+1][y]+arr[x][y+1];
				dfs(idx+1,total+tmp);
				visit[x][y]=false;
				visit[x+1][y]=false;
				visit[x][y+1]=false;
			}
		}
		//모양 안만들고 패스하는 경우
		dfs(idx+1,total);
		
	}//dfs
	
}//class
