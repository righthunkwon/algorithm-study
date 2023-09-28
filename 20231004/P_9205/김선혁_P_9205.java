import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[] flag;
	static Queue<Integer> qx;
	static Queue<Integer> qy;
	static boolean ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			qx = new LinkedList<>();
			qy = new LinkedList<>();
			N = sc.nextInt();			
			qx.add(sc.nextInt());
			qy.add(sc.nextInt());
			// 시작화는 좌표 그대로
			// 큐에 넣고 시작한다.
			
			arr = new int[N+1][2];
			// x좌표 y좌표 저장 (도착지 포함)
			for(int i =0;i<=N;i++) {
				for(int j =0;j<2;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// 편의점, 도착지 좌표 입력 끝
			
			flag = new boolean[N]; // 편의점 방문 여부
			ans = false;
			
			solve();
			if(ans) {
				System.out.println("happy");
			}
			else {
				System.out.println("sad");
			}
			
		}
		
		
		
	}
	public static void solve() {
		while(true) {
			int nx = qx.poll();
			int ny = qy.poll();
			// 큐에 있는 좌표를 꺼내서
			// 1000거리 이하의 좌표를 모두 큐에 넣는다.
			// 이 과정을 반복하는 과정중에
			// 도착지와의 거리가 1000이하면
			// ans를 true로 바꿔주고 
			// return // 아니면 큐가 비어서 false
			if(Math.abs(nx-arr[N][0])+Math.abs(ny-arr[N][1])<=1000) {
				ans = true;
				return;
				// 도착지와 거리가 1000이하면 true
			}
			// 편의점 거리 1000이하 탐색 
			for(int i =0;i<N;i++) {
				if(!flag[i] && (Math.abs(nx-arr[i][0])+Math.abs(ny-arr[i][1])<=1000)) {
					flag[i] =true;
					qx.add(arr[i][0]);
					qy.add(arr[i][1]);
					// 1000이하 거리에 아직 방문안했으면 flag true로하고 큐에 추가
				}
			}
			if(qx.size()==0) {
				// 더이상 갈곳이 없을때
				return;
			}
			
		}
		
	}
	
	
	
}
