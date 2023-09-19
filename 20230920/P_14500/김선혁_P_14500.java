

import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static boolean flag[][];
	static int max;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j =0;j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 입력완료

		// 재귀를 통해서 각 4개 블록을 재귀를 통해서 방문처리 해서
		// 각 값을 더해서 최대값 만족하는지
		// 숫자의 최대값을 반환 
		max = 0;
		flag = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j =0;j<M;j++) {
				flag[i][j] =true;
				solve(i,j,0,arr[i][j]); // 각 좌표마다 재귀 돌리기
				flag[i][j] =false;

			}
		}
		System.out.println(max);
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	// 상하우좌 순서 -- 좌우를 원래하지만 바꾸기 귀찮

	// 4개를 이동해서 각 값을 더해서 max를 구하는 메서드
	public static void solve(int x, int y ,int cnt, int sum) {
		if(cnt == 3) {
			if(max<sum) {
				max = sum;
			}
			sum=0;
			return;
		}
		for(int in=0;in<4;in++) {
			int nx = x+dx[in];
			int ny = y+dy[in];
			if(nx>=0 && nx<N && ny>=0 && ny<M && !flag[nx][ny]) {
				flag[nx][ny] = true;
				solve(nx,ny,cnt+1,sum+arr[nx][ny]);
				//				if(cnt==1) { 
				// 바로전 좌표에서 수직으로 가는 방향
				solve(x,y,cnt+1,sum+arr[nx][ny]);
				//				}
				flag[nx][ny] = false;
			}
		}


	}


}
