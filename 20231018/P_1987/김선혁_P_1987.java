import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[] flag;
	static int ans;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for(int i =0;i<N;i++) {
			String tmp = sc.next();
			for(int j =0;j<M;j++) {
				arr[i][j] = tmp.charAt(j)-'A';
			}
		}
		// 입력 끝
		// 다 숫자로 바꿔줌
		flag = new boolean[26]; // 방문했는지 확인
		
		// 0,0에서시작
		// 0,0에서 계속 나가면서
		// dfs하면서 방문처리해주면서 새로운것만 개수세줌
		ans = 0;
		solve(0,0,0);
		System.out.println(ans);
	}
	public static void solve(int x,int y, int cnt) {
		if(flag[arr[x][y]]) {
			// 방문했던거 만나면 이제 끝
			if(ans < cnt) {
				ans = cnt;
			}
			// cnt가 ans보다 큰지 확인
			return;			
		}
		flag[arr[x][y]] = true;
		// 현재 위치 방문처리 후
		for(int in=0;in<4;in++) {
			int nx = x+dx[in];
			int ny = y+dy[in];
			if(nx>=0 && ny>=0 && nx<N && ny<M) {
				solve(nx,ny,cnt+1);
				// 조건만족하면 cnt+1해주고 dfs 더돌기
			}
		}
		
		flag[arr[x][y]] = false; 
		// 끝나면 다시 false로
		// for문안에 넣으면 스택오버플로우
	}

}
