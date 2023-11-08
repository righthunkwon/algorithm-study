package _20231108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1103_게임 {
	static int N, M, max;
	static char[][] arr;
	static int[][] dp;
	static boolean[][] visited;
	static boolean infinite;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		N = Integer.parseInt(s.split(" ")[0]); // 세로 크기
		M = Integer.parseInt(s.split(" ")[1]); // 가로 크기
		arr=new char[N][M]; // 직사각형 보드
		dp=new int[N][M]; // 카운트를 저장하는 dp배열
		visited = new boolean[N][M]; // 무한루프 체크를 위한 방문체크 배열
		infinite = false; // 무한루프에 해당하면 true로 바꾼다
		max=0;

		for(int i=0;i<N;i++) {
			s = br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j]=s.charAt(j);
			}
		}//입력끝
//		System.out.println(Arrays.deepToString(arr));

		visited[0][0]=true; // 처음 시작점은 0,0 고정이므로 여길 true로 바꾸고 시작
		moving(0,0,1); // 시작하면서 cnt 1로 카운트해준다

		if(infinite) System.out.println(-1); // 동전을 무한번 움직일 수 있으므로  -1 출력한다
		else System.out.println(max); // 이외의 경우엔 최대 움직일 수 있는 횟수를 출력한다

	}
	static void moving(int x, int y, int cnt) { // dfs를 이용해 탐색
		if(cnt > max) { // 가장 큰 cnt값을 max로 갱신한다
			max = cnt;
		}
		dp[x][y]=cnt; // dp에 cnt값을 저장한다
		
		for(int i=0;i<4;i++) {
			
			int nr = x + dr[i] * (arr[x][y]-'0');
			int nc = y + dc[i] * (arr[x][y]-'0');

			// 범위를 벗어나지 않고, 구멍에 빠지지 않았을 경우에 지속한다
			if(nr>=0 && nc>=0 && nr<N && nc<M && arr[nr][nc]!='H') {

				if(visited[nr][nc]) { // 방문했던 곳 다시 방문하면 무한루프이므로 infinite를 true로 바꿔준다
					infinite =true;
					return;
				}
				
				// dp를 이용해 가지치기
				// 현재 위치에서 다음 위치로 이동할 때, 이동할 곳의 dp값이 cnt보다 큰 값이라면 이미 방문했다는 의미이다
				// 이미 방문한 곳을 재방문하는 것은 어차피 문제에서 원하는 답(최대 움직임 횟수)을 구하는데 무의미한 행위이다.
				// 따라서 이 곳은 다시 방문하지 않도록 하여 다른 곳으로 이동하게끔 한다.
				// 이렇게 하면 가지치기를 통해 탐색을 줄일 수 있다.
				if(dp[nr][nc]>cnt) {
					continue;
				}
				visited[nr][nc]=true; // 방문한 위치는 true로 바꿔준다
				moving(nr, nc, cnt+1); // 그 다음 위치로 이동을 계속하고, cnt를 1 증가시켜준다
				visited[nr][nc]=false; // visited배열을 다시 되돌린다

			}
			continue;
		}

	}//moving

}
