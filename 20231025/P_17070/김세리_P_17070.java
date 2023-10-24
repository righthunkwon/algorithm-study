package _20231025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17070_파이프옮기기1 {
	static int N,ans;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		// 문제에서 제시된 파이프 위치가 (0,0),(0,1)이라 생각하고 배열을 만든다
		// 배열 크기를 늘리면 빈 공간 0과 늘린 배열 부분이 구분되지 않기 때문
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 끝
		
		ans = 0;
		
		// 처음에 가로로 시작하니까 파이프 오른쪽 기준으로 dfs시작한다
		// type는 0-가로, 1-세로, 2-대각선으로 구분한다
		dfs(0,1,0);
		
		System.out.println(ans);
		
	}//main
	
	static void dfs(int x, int y, int type) {
		if(x==N-1 && y==N-1) { //끝에 도달하면 개수 하나 증가
			ans++;
			return;
		}
		// 가로일 경우 : 가로, 대각선으로 이동 가능하다
		if(type==0) { 
			// 가로 이동
			if(y+1<N && arr[x][y+1]==0) { 
				dfs(x,y+1,0);
			}
			// 대각선 이동
			if(x+1<N && y+1<N && arr[x][y+1]==0 && arr[x+1][y]==0 && arr[x+1][y+1]==0) {
				dfs(x+1,y+1,2);
			}
		}
		// 세로일 경우 : 세로, 대각선으로 이동 가능하다
		if(type==1) {
			// 세로 이동
			if(x+1<N && arr[x+1][y]==0) { 
				dfs(x+1,y,1);
			}
			// 대각선 이동
			if(x+1<N && y+1<N && arr[x][y+1]==0 && arr[x+1][y]==0 && arr[x+1][y+1]==0) {
				dfs(x+1,y+1,2);
			}
		}
		// 대각선일 경우 : 가로, 세로, 대각선으로 이동 가능하다
		if(type==2) {
			// 가로 이동
			if(y+1<N && arr[x][y+1]==0) { 
				dfs(x,y+1,0);
			}
			// 세로 이동
			if(x+1<N && arr[x+1][y]==0) { 
				dfs(x+1,y,1);
			}
			// 대각선 이동
			if(x+1<N && y+1<N && arr[x][y+1]==0 && arr[x+1][y]==0 && arr[x+1][y+1]==0) {
				dfs(x+1,y+1,2);
			}
		}

	}//dfs

}
