import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static class Robot {
	int x;
	int y;
	int dir;
	Robot(int x, int y, int dir){
		this.x=x;
		this.y=y;
		this.dir=dir;
	}
}
static int N;
static int M;
static int[][] arr;
static Robot robot[];
static ArrayList<Order> ar = new ArrayList<Order>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M+1][N+1];

		int a = sc.nextInt(); // 로봇의 개수
		int b = sc.nextInt(); // 명령의 개수 

		robot = new Robot[a+1]; // a+1개만큼의 로봇 개수
		for(int i = 0;i<a;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int dir = change(sc.next());
			// 좌표를 입력받아서 x좌표만 거꾸로해서 
			// 값을 i+1로 각각 설정해줌(로봇마다 각각 알기위해)
			arr[(M-x)+1][y] = i+1;
			robot[i+1] = new Robot((b-x)+1,y,dir);
		}
		
		for(int i=0; i<b; i++) {
			int x = sc.nextInt();
			String y = sc.next();
			int z = sc.nextInt();
			// 로봇의 번호, 명령종류, 숫자를 입력받아서
			// 리스트에다가 추가
			ar.add(new Order(x,y,z));
		}

		solve();
//		// 전체다 이상없이 수행했으면
//		// ok출력
//		System.out.println("OK");
	}
	static int dx[] = {0,-1,0,1,0};
	static int dy[] =  {0,0,1,0,-1};
	public static void solve() {
		// 명령의 총 개수만큼 i for문 돌림
		for(int i=0; i<ar.size(); i++) {
			int in = ar.get(i).in;    //로봇번호
			String order = ar.get(i).str; // 명령종류
			int cnt = ar.get(i).cnt;  // 반복횟수
			for(int j=0; j<cnt; j++) {
				int x = robot[in].x;
				int y = robot[in].y;
				int dir = robot[in].dir;
				// in번째 로봇의 좌표와 방향을 꺼낸다음
				// 멍령 수행 시작
				
				// 만약 L이면 로봇의 방향만 왼쪽으로 90도 회전
				// dir을 --하고 만약 0이되면 4로 교체
				if(order.equals("L")) {
					dir --;
					if(dir == 0) {
						dir = 4;
					}
					// 로봇의 방향도 다시 교체해줌
					robot[in].dir = dir;
				}
				// 만약 R이면 로봇의 방향 오른쪽으로 90도
				// ++해주고 만약 5되면 1로 교체
				else if(order.equals("R")) {
					dir++;
					if(dir==5) {
						dir=1;
					}
					// 로봇에서도 수정
					robot[in].dir = dir;
				}
				else {
					// 그 외에는 로봇의 dir방향대로 
					// 움직인 다음 범위 벗어나는지
					// 다른 로봇이랑 충돌하는지 판단한다.
					int nx = x+dx[dir];
					int ny = y+dy[dir];
					// 범위 벗어나는경우
					if(!isRange(nx,ny)) {
						System.out.println("Robot "+in+" crashes into the wall");
						System.exit(0);
					}
					// 다른 로봇과 충돌하는 경우
					if(arr[nx][ny]!=0) {
						System.out.println("Robot "+in+" crashes into robot "+arr[nx][ny]);
						System.exit(0);
					}
					// 정상적으로 움직이면 
					// 이전자리는 0으로 교체
					// 움직인 자리는 in으로 교체
					arr[x][y] =0;
					arr[nx][ny] = in;
					robot[in].x = nx;
					robot[in].y = ny;
				}
			}
		}
		 System.out.println("OK");
	}
	// 입력되는 방향을 숫자로 전환
		// 북 동 남 서 순서대로 1234
		public static int change(String dir) {
			if(dir.equals("N")) {
				return 1;
			}
			else if(dir.equals("E")){
				return 2;
			}
			else if(dir.equals("S")) {
				return 3;
			}
			return 4;
		}
		// 로봇의 위치가 범위내에 위치하는지 
		public static boolean isRange(int x, int y) {
			if(x>=1 && y>=1 && x<=M && y<=N) {
				return true;
			}
			return false;
		}
		static class Order{
		int in;
		String str;
		int cnt;
		Order(int in,String str,int cnt){
			this.in=in;
			this.str =str;
			this.cnt=cnt;
		}
	}
		
}
