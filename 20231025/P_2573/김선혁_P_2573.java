import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] flag; // 방문했는지 확인
	static int day;
	static int[] dx = {-1,1,0,0};
	static int[] dy=  {0,0,1,-1};
	static int cnt;
	static Queue<Integer> qx;
	static Queue<Integer> qy;
	static ArrayList<Integer> arx;
	static ArrayList<Integer> ary;
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		N  =sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		arx = new ArrayList<Integer>();
		ary = new ArrayList<Integer>();
		// 먼저 빙산을 저장해줄 arx ary배열을 선언
		// for문을 통해
		// 입력받는중에 빙산을만나게 되면
		// 리스트에 저장한다.
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] != 0) {
					arx.add(i);
					ary.add(j);
				}
			}
		}
		// 입력완료

		qx = new LinkedList<Integer>();
		qy = new LinkedList<Integer>();
		day = 0; // 걸리는 년도
		// for문을 통해 빙산 하나를 시작으로 
		// 빙산 전체에 공기만큼 - 해주고 
		// 현재 빙산이 2개이상으로 이루어져있는지 check 메서드 실행하여
		// 2개면 break ;
		for(int i =0;i<arx.size();i++) {
			flag = new boolean[N][M];
			// 빙산이면서 아직 방문하지 않은것 확인
			// 만약 빙산이 하나로 이루어져있다면 for문은 한번만 돌게 된다.
			if(arr[arx.get(i)][ary.get(i)] != 0 && !flag[arx.get(i)][ary.get(i)]) {
				solve(arx.get(i),ary.get(i));		
				day++; // 1년 플러스 
				// 몇개로 이루어져있는지 판단
				if(!check()) {
					break;
				}
				i -= 1;
			}			
		}

		System.out.println(day);

	}
	public static void solve(int ax, int ay) {
		qx.add(ax);
		qy.add(ay);
		// 큐에 시작점을 추가하고 true 처리
		flag[ax][ay] = true;
		while(true) {
			int x = qx.poll();
			int y = qy.poll();
			int tmp = 0;
			// 주변에 빙산이 아닌것 개수 tmp
			for(int in= 0;in<4;in++) {
				int nx = x+dx[in];
				int ny = y+dy[in];
				if(nx>=0 && ny>=0 && nx<N && ny<M) {
					// 먼저 범위를 만족하고 
					// if문에서는 빙산이면서(방문한 빙산 제외하기 위해)
					// else if에서는 빙산이 아니면서(방금 녹은것 제외)
					if(arr[nx][ny] !=0 && !flag[nx][ny]) {
						qx.add(nx);
						qy.add(ny);
						// 큐에 추가하고 방문처리
						flag[nx][ny] = true;
					}
					else if(arr[nx][ny] == 0 && !flag[nx][ny]) {
						// 나중에 tmp만큼 뺴줄거임 
						tmp++;	
					}					
				}

			}
			arr[x][y] -= tmp;
			// 주변에 빙산아닌것의 개수만큼 -해주고
			// 만약 음수가 나오면 0으로 교체
			if(arr[x][y]<0) {
				arr[x][y] = 0;
			}
			// 큐에 사이즈가 0이면 break
			if(qx.size()==0) {
				break;
			}
		}

	}
	// 빙산의 개수가 몇개인지 확인
	// 1개이면 true
	// 2개이면 false
	public static boolean check() {
		Queue<Integer> tmpqx = new LinkedList<Integer>();
		Queue<Integer> tmpqy = new LinkedList<Integer>();
		for(int i =0;i<arx.size();i++) {
			// 빙산이였던것 중 아직 유효한 빙산을 
			// 큐에다가 추가하고 break
			// 큐로 bfs 돌거기때문에 1개만필요하다.
			if(arr[arx.get(i)][ary.get(i)] != 0 ) {
				tmpqx.add(arx.get(i));
				tmpqy.add(ary.get(i));
				break;
			}
		}
		// 만약 모든 빙산이 녹은것이라면
		// day를 0으로 바꾸고 false출력
		if(tmpqx.size()==0) {
			day = 0;
			return false;
		}
		boolean[][] tmp = new boolean[N][M];
		tmp[tmpqx.peek()][tmpqy.peek()] = true;
		while(true) {
			int x = tmpqx.poll();
			int y = tmpqy.poll();
			for(int in= 0;in<4;in++) {
				int nx = x+dx[in];
				int ny = y+dy[in];
				if(nx>=0 && ny>=0 && nx<N && ny<M) {
					// 범위를 만족하고 현재 빙산이 아니면서 방문하지 않았던것은
					// 큐에다가 추가 후 방문처리
					if(arr[nx][ny] !=0 && !tmp[nx][ny]) {
						tmpqx.add(nx);
						tmpqy.add(ny);
						tmp[nx][ny] = true;
					}		
				}
			}
			// 큐 사이즈가 0이면 끝
			if(tmpqx.size()==0) {
				break;
			}
		}
		// while문을통해서 현재
		// 빙산이 하나로 이루어진것들을
		// 모두 방문처리 하여서 true로 되어있다.

		for(int i =0;i<arx.size();i++) {
			if(arr[arx.get(i)][ary.get(i)] !=0 && !tmp[arx.get(i)][ary.get(i)]) {
				// 만약 true로 처리된 것이 아닌게 존재하면
				// 2개 이상으로 빙산이 이루어진 것으로
				// false를 출력
				return false;
			}
		}
		return true;

	}

}
