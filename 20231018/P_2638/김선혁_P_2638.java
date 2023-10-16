import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] flag;
	static Queue<Integer> qx; // 공기탐색할 큐
	static Queue<Integer> qy;
	static ArrayList<Integer> ax; // 치즈를 넣어놓을 배열
	static ArrayList<Integer> ay; 
	static int cnt; // 치즈 개수
	static int ans;
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		cnt = 0;
		ax = new ArrayList<>();
		ay = new ArrayList<>();
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 1) {
					ax.add(i);
					ay.add(j);
					cnt++; // 치즈의 개수 count
				}
			}
		}
		// 입력완료
		ans = 0;
		// 그림을 봤을때 한 점을 중심으로
		// 외부에 있는거는 다 값을 바꿔버리면
		// 내부에 있는 공기를 알 수 있지 않을까?

		// 먼저 메서드를 통해
		// 외부에 있는 공기를
		// 2로 바꿔보고 
		// 바꾼후에 치즈위치를 중심으로 
		// 2가 2개이상 존재하면 그 위치 2로 바꾸고 count--
		while(true) {
			// 외부공기 탐색
			// 가장자리는 무조건 외부공기
			flag = new boolean[N][M];
			change();
			// 탐색했으니 끝에 치즈 녹이기
			solve();
			// 녹였으면 이제 치즈가 0개될때까지 무한반복
//			System.out.println(cnt);
			ans ++;
			if(cnt==0) {
				break;
			}
		}
		System.out.println(ans);
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void change() {
		qx = new LinkedList<>();
		qy = new LinkedList<>();
		qx.add(0); // 0,0부터 시작
		qy.add(0);
		arr[0][0] = 2;
		while(true) {
			int x = qx.poll();
			int y = qy.poll();
			for(int in=0;in<4;in++) {
				int nx = x+dx[in];
				int ny = y+dy[in];
				if(nx>=0 && ny>=0 && nx<N && ny<M && !flag[nx][ny] && (arr[nx][ny]==0 || arr[nx][ny]==2)) {
					// 기존의 값이 2로 바뀌어있어서 2또는 0인지 확인
					qx.add(nx);
					qy.add(ny);
					arr[nx][ny] = 2;
					flag[nx][ny] = true;
					// 일단 외부공기는
					// 조건을 만족하고 0이면
					// 2로 바꿔주고 큐에 추가
				}
			}
			if(qx.size()==0) {
				break;
			}
		}
		// 이과정 거치면 외부공기는
		// 모두 2로바뀌어있다.

	}
	public static void solve() {
		for(int i =0;i<ax.size();i++) {
			int x= ax.get(i);
			int y = ay.get(i);
			int tmp = 0; // 외부공기를 count할 tmp 
			// 2개면 녹을거
			for(int in=0;in<4;in++) {
				int nx = x+dx[in];
				int ny = y+dy[in];
				if(arr[nx][ny]==2) {
					tmp++;
					// 외부공기 만나면 tmp++
				}
			} // for 문
			if(tmp>=2) {
				ax.remove(i);
				ay.remove(i);
				arr[x][y] = 0; // 제거 후 0으로 바꿔줌 
				// 2로바꾸면 그 안에있는것까지 바뀔위험 있음
				cnt --; // 치즈개수 --
				i -- ; // 만약 삭제되면 그다음 index를 건너뛰기 때문에
				// i를 -1해준다.
			}
		} // i for
		
	}

}
