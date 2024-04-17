import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class node {
		int x;
		int y;
		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static int M;
	static int[][] arr;
	static Queue<node> me;
	static Queue<node> you;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		me = new LinkedList<Main.node>();
		you = new LinkedList<Main.node>();
		// 내위치는 큐에 넣고 매번 도전
		// 미친 아두이노 위치도 따로 큐에 넣고
		// 매번 실행하며
		// 다음이동에 1이 입력되어있으면 그 두개는 파괴되고
		// 이동하기전에 현재 좌표가 1일때만 이동하게 함(0이면 파괴된경우)
		// 만약 다음이동에서 10이면 게임 끝(반대로도 )
		for(int i = 0 ; i<N;i++) {
			String line = sc.next();
			for(int j = 0;j<M;j++) {
				String tmp = line.substring(j,j+1);
				if(tmp.equals("I")) {
					me.add(new node(i,j));
					arr[i][j] = 1000;
				}
				else if(tmp.equals("R")) {
					arr[i][j] = 1;
					you.add(new node(i,j));
				}
			}
		}
		// 입력 끝
		String move = sc.next();
		for(int i = 0 ;i<move.length();i++) {

			// 먼저 종수먼저 움직이고 
			// 이동하는 좌표가 1인지 확인
			meMove(Integer.parseInt(move.substring(i,i+1)), i+1);
			// 이제 아두이노들 이동시작
			youMove(i+1);
		}
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				if(arr[i][j] == 0) {
					System.out.print(".");
				}
				else if(arr[i][j] ==1) {
					System.out.print("R");
				}
				else {
					System.out.print("I");
				}
			}
			System.out.println();
		}



	}
	static int[] dx = {0,1,1,1,0,0,0,-1,-1,-1};
	static int[] dy = {0,-1,0,1,-1,0,1,-1,0,1};

	public static void meMove(int a, int cnt) {
		node n = me.poll();
		int x = n.x;
		int y = n.y;
		arr[x][y] = 0;
		// a기준으로 큐에서 좌표꺼내서 움직임
		me.add(new node(x+dx[a], y+dy[a]));
		//이미 미친아두이노가 있는경우
		// 출력하고 종료
		if(arr[x+dx[a]][y+dy[a]] >= 1) {
			System.out.println("kraj "+cnt);
			System.exit(0);
		}
		// 아니면 1000으로 바꿔줌
		arr[x+dx[a]][y+dy[a]] = 1000;
	}

	public static void youMove(int cnt) {
		// 하나씩 이동 시작
		ArrayList<Integer> ax = new ArrayList<Integer>();
		ArrayList<Integer> ay = new ArrayList<Integer>();
		int size = you.size();
		for(int i = 0; i<size ;i++) {
			node n = you.poll();
			arr[n.x][n.y]-= 1;
			// 이동하면서 현재좌표는 -1해줌
			// 가장 가까운 좌표로 이동 시작
			int min = 987654321;
			int[] moving = new int[2];
			for(int in = 0 ;in<dx.length;in++) {
				int x = n.x + dx[in];
				int y = n.y + dy[in];
				if(x>=N || y>=M || x<0 || y<0) {
					continue;
				}
				node m = me.poll();
				me.add(new node(m.x, m.y));
				// 거리 구해보자 
				// 만약 최소값일 경우 moving 교체
				int dis = Math.abs(m.x - x) + Math.abs(m.y - y);
				if(dis < min) {
					min = dis;
					moving[0] = x;
					moving[1] = y;
				}
			}
			// 이제 최소거리는 구했고 
			// 범위검사하고 이동할 좌표가 1000인경우 끝내고
			// 일단 나오는 개수대로 +1해줌
			int nx = moving[0];
			int ny = moving[1];
			if(arr[nx][ny] == 1000) {
				System.out.println("kraj "+cnt);
				System.exit(0);
			}
			arr[nx][ny] += 1;
			you.add(new node(nx,ny));
			// 모든 아두이누 반복
		}
		// 이제 1보다 큰값들의 좌표들을 구해보자(여러대인곳)
		for(int i = 0 ; i<N;i++) {
			for(int j = 0;j<M;j++) {
				if(arr[i][j] >1 && arr[i][j] < 100) {
					ax.add(i);
					ay.add(j);
					arr[i][j] = 0;
				}
			}
		}
		// 큐를 한번 돌리면서
		// 겹치는 애들은 저장안함
		int tmpSize = you.size();
		for(int i = 0;i<tmpSize;i++) {
			node n = you.poll();
			if(arr[n.x][n.y] !=0) {
				you.add(new node(n.x,n.y));
			}
		}
//		
//		for(int i = 0;i<N;i++) {
//			for(int j = 0;j<M;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();


	}
}
