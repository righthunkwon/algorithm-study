import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	static int K;
	static boolean ans;
	static ArrayList<Integer> ax;
	static ArrayList<Integer> ay;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 감시피하기는 dfs를 통해서 일단
		// 장애물 3개를 먼저 선정하고
		// 그게 실제로 다 가려지는지 판단 ㄱㄱ
		arr = new int[N][N];
		ax = new ArrayList<>();
		ay = new ArrayList<>();
		
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				String tmp = sc.next();
				if(tmp.equals("S")) {
					// 학생은 1로해놓자 
					arr[i][j] = 1;
				}
				else if(tmp.equals("T")) {
					arr[i][j] = 10;
					// 선생은 10으로 해놓고
					// 리스트에 추가하자
					ax.add(i);
					ay.add(j);
				}
			}
		}
		
		// 입력 끝
		ans = false;
		//이제 3개의 벽을 선정해보자
		choice(0,0,0);

		System.out.println("NO");
	}

	public static void choice(int cnt,int x, int y) {
		// 3개 선정이 끝나면
		// 게임 시작 ㄱㄱ
		if(cnt ==3) {
			solve();
			if(ans) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}
		for(int i = x;i<N;i++) {
			for(int j =0;j<N;j++) {
				if(i == x && j <= y) {
					continue;
				}
				// 다음 좌표부터 0인 것만 
				// 0 을 -1로 바꿔준다.
				if(arr[i][j] ==0) {
					arr[i][j] = -1;
					// 선정
					choice(cnt+1,i,j);
					arr[i][j] = 0;
					// 다시 원위치
				}
			}
		}    	
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void solve() {
		for(int i = 0;i<ax.size();i++) {
			int x = ax.get(i);
			int y = ay.get(i);
			// 리스트에서 선생 하나씩 꺼냄
			// 선생의 좌표를 꺼내서 상,하,좌,우 한방향씩
			// while문을 통해 쭉 나감 
			// 그러다가 학생만나면 return
			for(int in=0;in<4;in++) {
				int nx = x+dx[in];
				int ny = y+dy[in];
				while(true) {
					// 범위를 벗어나면 어차피 방법해야해서 break
					// 추가적으로 벽을 만나도 skip
					if(nx<0 || ny<0 || nx>=N || ny>=N || arr[nx][ny] == -1) {
						break;
					}
					// 학생만나면 return
					if(arr[nx][ny] == 1) {
						return;
					}
					nx += dx[in];
					ny += dy[in];
				} // while
			} // in for
		}
		// 모든 선생을 버티고 return 되지않으면
		// 얘는 통과이므로  ans를 true로
		ans = true;
		return;
				

	}

}
