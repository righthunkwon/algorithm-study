import java.util.Scanner;

public class Main {	
	static int N;
	static int M;
	static int[][] arr;
	static int ans;
	static int[][] dp;
	static boolean[][] flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for(int i =0;i<N;i++) {
			String line = sc.next();
			for(int j =0;j<M;j++) {
				String tmp = line.substring(j,j+1);
				if(tmp.equals("H")) {
					tmp = "0";
					// 만약 구멍이 있는 자리면 
					// 0 으로바꿔서 입력
				}
				arr[i][j] = Integer.parseInt(tmp);
			}
		}
		// 입력 끝
		
		// dfs과정을 통해서 마냥 탐색하면 시간초과
		// dp로 현재 지나가는 위치에 몇번째 cnt인지 기록하자
		dp = new int[N][M];
		flag= new boolean[N][M]; // 지나간곳 지나가면 어차피 무한루프니깐 생성
		ans = 0;
		flag[0][0] = true;
		
		solve(0,0,1);
		System.out.println(ans);
	}
	
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void solve(int x,int y, int cnt) {		
		// 현재 좌표에 cnt 기록
		dp[x][y] = cnt;
		int a = arr[x][y];
		// 현재있는 위치의 값을 a로 넣음
//		System.out.println(x+" "+y+" "+cnt);
		for(int in=0;in<4;in++) {
			int nx = x+ a*dx[in];
			int ny = y+ a*dy[in];
			// 만약 위치가 구멍이거나 범위 벗어나면 ans와 비교하고 return
			if(nx<0 || ny<0 || nx>=N || ny>=M || arr[nx][ny]==0) {
				ans = Math.max(ans, cnt);
				continue;
			}
			// 범위내에 있다면 먼저 dp값이 cnt보다 큰지 확인
			// 만약 dp값이 크다면 볼필요 x-> return
			if(dp[nx][ny] >cnt) {
				continue;
			}
			// 그다음 무한루프가 도는지 보기위해 
			// 현재위치가 true로 되어있는지 확인 -> ans -1로 바꾸고 system.exit(0) 
			if(flag[nx][ny]) {
//				ans = -1;
				System.out.println(-1);
				System.exit(0);
			}
			// 방문도안하고 cnt가 크다면 cnt값 넣고 true처리하고 dfs 
			flag[nx][ny] = true;
			solve(nx,ny,cnt+1);
			// 다시 false처리
			flag[nx][ny] = false;
		}
			
	}

}


// 시간초과 코드
//	public static void solve(int x, int y, int cnt) {
//		
//		if(cnt>100) {
//			ans = -1;
//			System.exit(0);
//		}
//		int a = arr[x][y];
//		// 현재있는 위치의 값을 a로 넣음
////		System.out.println(a+" "+x+" "+y+" "+cnt);
//		// 4방향 탐색 ㄱㄱ
//		for(int in=0;in<4;in++) {
//			int nx = x+ a*dx[in];
//			int ny = y+ a*dy[in];
//			// 만약 위치가 구멍이거나 범위 벗어나면 ans와 비교하여 return
//			if(nx<0 || ny<0 || nx>=N || ny>=M || arr[nx][ny]==0) {
//				ans = Math.max(ans, cnt);
//				continue;
//			}
//			solve(nx,ny,cnt+1);
//		}
//		
//		return;
//	}
