package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력 완
		
		// 가로 : 0, 세로 : 1, 대각선 : 2
		int[][][] dp = new int[N][N][3];
		// 파이프 끝부분이 도달할 수 있는 경우의 수를 dp테이블에 저장할것임(초기상태)
		dp[0][1][0] = 1;
		
		/*
		 *  대각선 : 왼 위 대각선(i-1, j-1), 왼(i, j-1), 위(i-1, j)가 벽이 아닐 때
		 *  		왼 위 대각선(i-1, j-1)칸에 있는 dp테이블의 가로 + 세로 + 대각선
		 *  가로 : 왼(i, j-1)이 벽이 아닐 때
		 *  		왼(i, j-1)칸에 있는 dp테이블 가로 + 대각선
		 *  세로 : 위(i-1, j)가 벽이 아닐 때
		 *  		위(i-1, j)칸에 있는 dp테이블 세로 + 대각선
		*/
		for(int i = 0; i < N; i++) {
			for(int j = 1; j < N; j++) { // 맨 왼쪽줄은 죽어도 못가
				if(i == 0 && j == 1) continue; // 이거 초기값 설정해뒀음
				if(map[i][j] == 1) continue; // 벽은 못가
				// 대각선
				if(i >= 1 && map[i-1][j-1] == 0 && map[i][j-1] == 0 && map[i-1][j] == 0)
					dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
				// 가로
				if(map[i][j-1] == 0)
					dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
				// 세로
				if(i >= 1 && map[i-1][j] == 0)
					dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
			}
		}
		int res = 0;
		// 가로 세로 대각선 경우의 수를 더해주면 답이다
		for(int i = 0; i < 3; i++) res += dp[N-1][N-1][i];
		
		System.out.println(res);
		
	}
}
