import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class node {
		int x;
		int y;
		int dis;
		public node(int x, int y, int dis) {
			super();
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
		
	}
	static int N;
	static int[][] arr;
	static boolean[][] flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		for(int i = 0 ;i<N;i++) {
			for(int j = 0;j<N;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 입력끝

		// 각 섬을 먼저 번호를 매기고
		// 다른번호가 나올떄까지
		// 그섬의 모든 좌표에서 bfs돌림
		flag = new boolean[N][N];
		int index = 2;
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(arr[i][j] == 1) {
					num( i ,  j , index);
					index++;
				}
			}
		}
		// 번호 매기기 끝
		// 이제 하나씩 bfs 돌리기
		int min =987654321;
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(arr[i][j] > 1) {
					// arr[i][j]랑 다른 섬 좌표의 최소값을
					// 구해서 min이랑 비교
					int tmp = solve( i ,  j , arr[i][j]);
					min = Math.min(min, tmp);
				}
			}
		}

		System.out.println(min);
		
		
	}
	public static int dx[] = {-1,1,0,0};
	public static int dy[] = {0,0,-1,1}; 

	public static void num(int i , int j , int index) {
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.add(i);
		qy.add(j);
		arr[i][j] = index;
		flag[i][j] = true;
		while(true) {
			if(qx.size()==0) {
				break;
			}
			int x = qx.poll();
			int y= qy.poll();
			// 다 꺼낸후에 큐에서
			// 무한적으로 돌림
			for(int in = 0;in<4;in++) {
				int nx = x +dx[in];
				int ny = y +dy[in];
				if(nx<0 || ny <0 || nx>=N || ny>=N || arr[nx][ny]==0 || flag[nx][ny]) {
					continue;
				}
				// 범위 검사하고
				// 방문처리 + index로 값 갱신
				arr[nx][ny] = index;
				flag[nx][ny] = true;
				qx.add(nx);
				qy.add(ny);
			}
		}

	}
	public static int solve(int i , int j , int index) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(i,j,0));
		// 먼저 입력된 점을 추가하고
		// 쭉 bfs 돌리자
		flag = new boolean[N][N];
		flag[i][j] = true;
		while(true) {
			if(q.size()==0) {
				break;
			}
			node n = q.poll();
			for(int in = 0 ; in<4;in++) {
				int x = n.x + dx[in];
				int y = n.y + dy[in];
				if(x>=N || y>=N || x<0 || y<0 || arr[x][y]==index || flag[x][y]) {
					continue;
				}
				// 범위확인
				
				// 이제 0이면 q에 +1해서 추가하고 
				// 다른값 나오면 바로 break
				if(arr[x][y] == 0) {
					q.add(new node(x,y,n.dis+1));
					flag[x][y] = true;
				}
				// 다른값인경우
				else {
					return n.dis;
				}
				
			}
		}
		return 987654321;
	}


}
