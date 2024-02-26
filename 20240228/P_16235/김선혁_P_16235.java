import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class node implements Comparable<node>{
		int x;
		int y;
		int age;
		public node(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}
		@Override
		public int compareTo(node o) {
			return this.age - o.age;
		}

	}

	static int N;
	static int M;
	static int K;
	static int[][] arr;
	static int[][] origin; // 첫 입력 저장
	static PriorityQueue<node> q = new PriorityQueue<Main.node>();
	static Queue<node> tmp = new LinkedList<Main.node>();
	static Queue<node> dead = new LinkedList<Main.node>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		// 땅정보 입력
		arr = new int[N][N];
		origin = new int[N][N];
		for(int i = 0;i<N;i++) {
			for(int j =0;j<N;j++) {
				arr[i][j] = 5;
				origin[i][j] = sc.nextInt();
			}
		}
		// 이제 나무정보 입력
		for(int i = 0;i<M;i++) {
			q.add(new node(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt()));
		}

		// 이제 K년동안 반복 
		for(int i =0;i<K;i++) {	
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(q.size());
	}
	public static void spring() {
		while(true) {
			if(q.size()==0) {
				break;
			}
			// 임시로 tmp에 저장했다가 끝나면 q로 이동
			node n = q.poll();
			// 현재 나무의 나이보다 좌표의 값이 많다면
			// 그 값만큼 빼고 나이는 +1해서 큐에 추가
			// 그게 안되면 그대로 버리기
			if(arr[n.x][n.y] >= n.age) {
				arr[n.x][n.y] -= n.age;
				tmp.add(new node(n.x , n.y , n.age+1));
			}
			else {
				// else면 나무 죽음
				dead.add(new node(n.x, n.y, n.age/2));
			}
		}
		// tmp꺼 그대로 옮김
		int size = tmp.size();
		for(int i = 0;i<size;i++) {
			node n = tmp.poll();
			q.add(new node(n.x , n.y , n.age));
		}
	}

	public static void summer() {
		while(true) {
			if(dead.size()==0) {
				break;
			}
			node n = dead.poll();
			// dead에서 하나씩 꺼내서
			// 그대로 양분추가
			arr[n.x][n.y] += n.age; 
		}
	}
	
	static int[] dx = {-1,-1,-1,0,0,+1,+1,+1};
	static int[] dy = {-1,0,+1,-1,+1,-1,0,+1};
	
	public static void fall() {
		while(true) {
			if(q.size()==0) {
				break;
			}
			node n = q.poll();
			tmp.add(new node(n.x, n.y, n.age));
			// 큐에서 하나 꺼내서
			// 5의 배수인지 확인 하고
			// 맞으면 8군데로 퍼져나가게 
			if(n.age%5 != 0) {
				continue;
			}
			for(int in = 0;in<8;in++) {
				int nx = n.x+dx[in];
				int ny = n.y+dy[in];
				// 범위 벗어나는지 확인
				if(nx<0 || ny <0 || nx>=N || ny>=N) {
					continue;
				}
				// 나이가 1인 나무 생성
				tmp.add(new node(nx,ny,1));
			}
		}
		// tmp꺼 그대로 옮김
		int size = tmp.size();
		for(int i = 0;i<size;i++) {
			node n = tmp.poll();
			q.add(new node(n.x , n.y , n.age));
		}
	}
	public static void winter() {
		for(int i = 0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] += origin[i][j];
			}
		}
	}

}
