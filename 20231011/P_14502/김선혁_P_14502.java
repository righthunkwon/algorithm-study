import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int N; // NxN
	static int M; // NxN
	static int[][] arr;
	static ArrayList<Integer> vx;
	static ArrayList<Integer> vy; // 바이러스 좌표
	static boolean[][] flag;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int count;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				arr[i][j] = sc.nextInt();		
			}
		}
		// 입력끝 
		min = 0;
		choice(0,0,0);
		System.out.println(min);
		

	}
	// 이제 벽 3개를 더 구해보자
	// 벽 3개를 더 구하는 메서드
	public static void choice(int cnt,int x, int y) {
		if(cnt ==3) {
			// 3개를 다 구하면
			// 이제 바이러스 좌표를 큐에다 다 넣고 시작할거임
			// 먼저 flag 초기화를 시키고
			// 메서드 실행
			flag = new boolean[N][M];		
			count = 0;
			solve();
			return;
		}
		for(int i =x;i<N;i++) {
			for(int j=0;j<M;j++) {
				// 방금전 돌았던 좌표 이후로만 돌기위해
				// 범위선정
				if(i==x && j<=y) continue;				
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					// 해당 좌표 선정
					choice(cnt+1,i,j);
					arr[i][j] = 0;
				}				
			}
		}
		
	}
	public static void solve() {
		Queue<Integer> ax = new LinkedList<>();
		Queue<Integer> ay  = new LinkedList<>();
		// 바이러스 좌표를 넣을 ax와 ay를 선언해주고
		// for문을 통해서
		// 바이러스를 만나면 큐에다가 넣어준다.
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(arr[i][j]==2) {
					ax.add(i);
					ay.add(j);					
				}
			}
		}
		// 이제 바이러스 좌표를 큐에다 다 넣었으니
		// bfs 시작
		while(true) {
			int x = ax.poll();
			int y = ay.poll();
			for(int in =0;in<4;in++) {
				int nx = x+dx[in];
				int ny = y+dy[in];
				// 범위를 만족하고 벽이며 현재 방문하지 않았으면 
				if(nx>=0 && ny>=0 && nx<N && ny<M && arr[nx][ny]==0 && !flag[nx][ny]) {
					ax.add(nx);
					ay.add(ny);
					flag[nx][ny] = true;
					// 큐에다가 현재 위치를 넣어주고
					// 현재 위치는 방문처리 해줌
				}				
			}
			
			if(ax.size()==0) {
				break;
				// 큐에 넣은게 다 없어지면
				// break 해준다.
			}
		}
		// 이제 바이러스처리를 다 했으므로 
		// 방문이 안되고 0인 것들의 개수를 count한다.
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(arr[i][j]==0 && !flag[i][j]) {
					count++;
				}
			}
		}
		// 만약 현재 안전지역이 
		// min보다 크다면
		// 교체
		if(count>min) {
			min = count;
		}
		
	}


}
