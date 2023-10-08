import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	static int N; // NxN
	static int M; // 치킨집 개수
	static ArrayList<Integer> chx;
	static ArrayList<Integer> chy; // 치킨집 좌표넣어놓은 배열
	static ArrayList<Integer> ax;
	static ArrayList<Integer> ay; // 집있는 좌표
	static int[][] arr; // 배열
	static boolean[] flag;
	static int min; // 정답
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][N];
		ax = new ArrayList<>();
		ay = new ArrayList<>();
		chx = new ArrayList<>();
		chy = new ArrayList<>();
		
		for(int i =0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] =sc.nextInt();
				// 만약 집을 발견하면
				if(arr[i][j] ==1) {
					ax.add(i);
					ay.add(j);
					// 집이있는 좌표를
					// 미리 배열에 넣는다.
				}
				// 치킨집이 있는 위치를
				// 미리 배열에 넣어놓는다.
				if(arr[i][j] == 2) {
					chx.add(i);
					chy.add(j);
				}
			}
		}
		min = 987654321; // 최소값을 미리 정해놓음
		flag = new boolean[chx.size()]; // 선정할치킨집을 정할 boolean 배열
		choice(0,0);
		
		System.out.println(min);

	}
	// 치킨집을 선정하자
	public static void choice(int idx,int cnt) {
		if(idx==chx.size()) {
			if(cnt==M) {
				// M개의 치킨집
				// 선정이 끝나면
				// 이제 거리계산
				int dis = solve();
				if(min>dis) {
					min = dis;
				}
			}
			return;
		}
		flag[idx] = true;
		choice(idx+1,cnt+1);
		flag[idx] = false;
		choice(idx+1,cnt);


	}
	// m개 만큼의 치킨집을 선정했을때
	// 이제 치킨집과 집의 거리를 구해보자
	public static int solve() {
		int sum = 0;
		for(int i =0;i<ax.size();i++) {		
			int tmpmin = 987654321; // 한개의 집을 기준으로
				// 치킨집과의 거리를 구해서 현재 집 위치에서의 가까운 치킨집 거리
			for(int j=0;j<chx.size();j++) {
				// 현재치킨집과 집사이의 거리
				if(flag[j]) {
					int tmp = Math.abs(chx.get(j)-ax.get(i)) + Math.abs(chy.get(j)-ay.get(i));	
					if(tmpmin>tmp) {
						// 만약 현재집에서 제일 가까운 치킨집을 발견하면
						// tmpmin 값 교체
						tmpmin = tmp;
					}
				}				
			}
			// 현재 집을 기준으로 가장 가까운 치킨집 위치를 발견했으면
			// sum에다가 더해줌
			if(tmpmin != 987654321) {
				sum+= tmpmin;
			}
		}
		return sum;
	}

}
