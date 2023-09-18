import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int L;
	static int R;
	static int[][] arr;
	static boolean[][] flag;
	static int cnt; // 땅의 개수
	static int day;
	static int sum;
	static boolean tmp;
	static Queue<Integer> qx = new LinkedList<>();
	static Queue<Integer> qy = new LinkedList<>();
	static ArrayList<Integer> arx = new ArrayList<>();
	static ArrayList<Integer> ary = new ArrayList<>();
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	public static void main(String[] args) {
		// 일단 한곳을 지정해서 
		// 그 곳을 중심으로 bfs를 통해 인구이동이 일어날 곳을 정하자
		// 그곳들의 합을 개수로 나눈다음, 그곳 이외에도 인구이동이 일어날 곳들을
		// 메인함수 안에서 다 지정 -->(bfs 다돌음 그곳도)
		// 다 한번 인구이동 하고나면 
		// 다시 이동한 값들을 중심으로 또 일어날 수 있는지 메인함수 내에서 while문 돌림
		// 만약 일어날 곳있으면 계속돌리고 없으면 break
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N][N];
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		flag = new boolean[N][N];
		cnt =0;
		day = 0;
		while(true) {
			// tmp는 그 지점을 중심으로 bfs를 통해 인구이동이 일어날 수 있는지 판단하는 변수
			tmp = false;
			flag = new boolean[N][N];
			for(int i =0;i<N;i++) {
				for(int j =0;j<N;j++) {
					if(!flag[i][j]) {
						qx.add(i);
						qy.add(j);
						flag[i][j] = true; // flag는 그 지점이 한번의 인구이동 속에 포함되었는지 확인
						bfs();
						arx = new ArrayList<>(); // 얘네는 초기화
						ary = new ArrayList<>();
					}
				}
			}
			day++;
			// day는 만약 위의 2중포문에서 break가 뜰 시에도 +1이 더해지기 때문에
			// sysout에서 -1을 해준다.
			if(!tmp) { // tmp가 false라는 뜻은 개수가 1개로 이동 못함!!
				break;
			}		
		}
		System.out.println(day-1);
//		for(int i =0;i<N;i++) {
//			for(int j =0;j<N;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
	}	

	public static void bfs() {
		cnt =0; // 임시 개수
		sum=0; // 임시 합
		while(qx.size()!=0) {
//			System.out.println(qx.size());
			int x = qx.poll();
			int y = qy.poll();
			sum+= arr[x][y];
			cnt++; // 개수 ++ 
			arx.add(x); // 인구이동 할 수 있는 곳을 저장하기 위해 
			ary.add(y); // arraylist로 다 더해줌 --> 얘는 한 덩어리 끝날때마다 초기화
			// 일단 돌려서 범위 내 숫자 초기화
			for(int in =0;in<4;in++) {
				int ax = x+dx[in];
				int ay = y+dy[in];
				if(ax<0 || ax>=N|| ay<0 || ay>=N) {
					continue;
					// 범위에 속하지 않으면 in++로 continue;
				}
				if(Math.abs(arr[x][y]-arr[ax][ay])>=L &&Math.abs(arr[x][y]-arr[ax][ay])<=R && !flag[ax][ay]) {
//					System.out.println(qx+" "+qy+" "+x+" "+ y);
					qx.add(ax);
					qy.add(ay);
					tmp = true;
					flag[ax][ay] = true;
				}

			}

		}
		// 한번의 루트 끝나면 계산
		if(tmp) {
		solve();
		}
	}
	// solve는 임시합을 구한것들 arx ary좌표에서 꺼내서
	// 다시 평균 구하는 메서드 
	public static void solve() {
//		System.out.println(sum);
//		System.out.println(cnt);
		for(int i =0;i<arx.size();i++) {
			arr[arx.get(i)][ary.get(i)] = sum/cnt;
		}	
	}

}
