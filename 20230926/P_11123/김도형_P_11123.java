package AlgoStudy;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_Q11123_양_한마리_양_두마리 {

	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };  //사방 탐색용 델타

	static boolean[][] visit; // 방문 확인 배열
	static int[][] arr; //양과 풀 정보 받을 배열

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int H = sc.nextInt();
			int W = sc.nextInt();

			int cnt = 0;

			arr = new int[H + 2][W + 2]; //양,풀 배열 초기화(껍데기 씌워줌)

			visit = new boolean[H + 2][W + 2]; // 방문확인용 배열

			for (int i = 0; i < H + 2; i++) {
				for (int j = 0; j < W + 2; j++) {
					arr[i][j] = 1;  //껍데기 풀로 씌워줌
				}
			}

			for (int i = 1; i <= H; i++) {

				String str = sc.next();

				for (int j = 1; j <= W; j++) {

					if (str.charAt(j - 1) == '#') {
						arr[i][j] = 0; //양은 0
					} else
						arr[i][j] = 1; //풀은 1
				}
			}

//			System.out.println(Arrays.deepToString(arr));
			
			for(int i = 1; i<=H; i++) {
				for(int j =1 ;j<=W;j++) {
					
					if(!visit[i][j]&&arr[i][j]==0) {
						dfs(i,j); 
						cnt++; //dfs한번 할때마다 양 무리 1개씩 있는것!
					}
					
				}
			}
			
			System.out.println(cnt);

		} // tc

	}// main

	public static void dfs(int nr, int nc) {

		visit[nr][nc] = true; // 방문처리

		for (int i = 0; i < 4; i++) {
			
			int a = nr + dr[i];
			int b = nc + dc[i];
			

			if (!visit[a][b] && arr[a][b] == 0) {
				visit[a][b] = true;  //방문처리
				
				dfs(a,b);   //재귀

			}

		}

	}

}// class
