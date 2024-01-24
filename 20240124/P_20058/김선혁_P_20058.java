import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static Queue<Integer> q;
	static int num;
	static int sum;
	static boolean[][] flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = (int) Math.pow(2,sc.nextInt());
		M = sc.nextInt();
		arr = new int[N][N];
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 입력끝
		for(int i = 0;i<M;i++) {
			// 명령을 실행할 때마다 
			// 입력받는 즉시 메서드 돌려서
			// arr변화시킴
			// 그리고 크기에 따라서 
			// 한쪽면에 있는 것들을 위부터 
			// 쭉 큐에다가 넣고
			// 맨위 오른쪽부터 할당하면 될듯
			int tmp = (int)Math.pow(2 , sc.nextInt());
			solve(0,0,tmp);
			// tmp에 해당하는 만큼 메서드
		}
		// 명령 다끝나면 이제 dfs를 통해서
		// 얼음 덩어리 개수 구하자
		 sum = 0;
		 num = 0;
		 flag = new boolean [N][N];
		 for(int i = 0;i<N;i++) {
			 for(int j = 0;j<N;j++) {
				 if(arr[i][j]>0 && !flag[i][j]) {
					 find(i, j);
				 }
			 }
		 }
		System.out.println(sum);
		System.out.println(num);

	}
	public static void solve(int x, int y,int size) {
		// 내가 작성한 메서드의 경우
		// x랑 y둘다 N-size가기전에 
		// x가 초기화되고 y가 N가서 다르게 작성
		if(y == N) {
			// 회전이후에 얼음 확인
			ice();
			return;
		}

		Queue<Integer> q = new LinkedList<>();
		for(int i = y;i<y +size;i++) {
			for(int j = x;j< x +size;j++) {
				// 순서대로 큐에다가 다 추가
				q.add(arr[i][j]);
			}
		}
		// 이제 오른쪽위부터 왼쪽아래로 큐숫자 대입
		for(int j =x + size-1;j>=x; j--) {
			for(int i=y;i<y+size;i++) {
				// 큐에서 하나씩 꺼내서 쭉 넣음
				arr[i][j] = q.poll();
			}
		}
		// 이제 한조각 끝 dfs 돌자
		// 만약 오른쪽 끝이었을 경우
		// x는 0, y는 size더해서
		if(x+size==N) {
			solve(0,y+size,size);
		}
		else {
			solve(x+size, y,size);
		}
	}

	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};

	public static void ice() {
		// 얼음은 한번에 동시에 녹아야하므로
		// 다음거에 반영안미치게
		// 녹아야할것들은 큐에다가 좌표 넣어놓자
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				// notice변수로 두어서 
				// 만약 주변에 없을경우
				// notIce +1
				int notIce = 0;
				for(int in = 0;in<4;in++) {
					int nx = i + dx[in];
					int ny = j + dy[in];
					// 범위 벗어난거랑 얼음이 아닌곳까지 확인
					if(nx>=N || ny>=N || nx<0 || ny<0 || arr[nx][ny]<=0) {
						notIce++;
					}
				}
				// 만약 1이상이 되면 이 칸의 얼음은 
				// 다 큐에다가 추가
				if(notIce>1) {
					qx.add(i);
					qy.add(j);
				}
			}
		} // i for
		while(true) {
			if(qx.size()==0) {
				break;
			}
			// 큐에 들어가 있는것들을
			// 좌표에서 다 -1 해주는데 
			// 음수는 안되도록
			arr[qx.peek()][qy.peek()] = Math.max(0, --arr[qx.poll()][qy.poll()]);
		}


	}
	
	public static void find(int i, int j) {
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.add(i);
		qy.add(j);
		flag[i][j] =true;
		// bfs를 통해 얼음 개수랑 합 구하자
		int tmpnum =0;
		int tmpsum = 0;
		while(true) {
			if(qx.size()==0) {
				break;
			}
			int x = qx.poll();
			int y = qy.poll();
			tmpsum += arr[x][y];
			tmpnum ++;
			for(int in=0;in<4;in++) {
				int nx = x +dx[in];
				int ny = y +dy[in];
				if(nx>=N || ny >=N || nx<0 || ny<0 || arr[nx][ny] ==0 || flag[nx][ny]) {
					continue;
				}
				qx.add(nx);
				qy.add(ny);
				flag[nx][ny] = true;
			}
			// 큐에 다 추가하고 bfs 다돌고			
		}
		// while문이 끝나면 변수 갱신
		num = Math.max(tmpnum, num);
		// 덩어리 합이아니라... 남아있는거합이네..ㅂㄷㅂㄷ
		sum += tmpsum;
	}

}
