import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class node implements Comparable<node>{
		int x;
		int y;
		int s;
		int d;
		int z;
		public node(int x, int y, int s, int d, int z) {
			super();
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		@Override
		public int compareTo(node o) {
			return this.z - o.z;
		}

	}
	static int R;
	static int C;
	static int M;
	static int ans;
	static ArrayList<node>[][] ar;
	static PriorityQueue<node> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		M = sc.nextInt();
		ar = new ArrayList[R][C];
		for(int i = 0;i<R;i++) {
			for(int j =0;j<C;j++) {
				ar[i][j] = new ArrayList<Main.node>();
			}
		}
		ans = 0;
		// ar먼저 초기화 진행
		for(int i = 0;i<M;i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int s = sc.nextInt();
			int d = sc.nextInt();
			int z = sc.nextInt();
			// s를 미리 나눌 수 있음
			if(d ==1 || d==2) {
				// 4일경우 6 ,  3일경우4 -> 위아래로는 1번 사이는 2번들어감
				s %= (R*2 -2);
			}
			else {
				s %= (C*2 -2);
			}
			ar[x][y].add(new node(x, y,s,d,z));
		}
		// 입력받는 즉시 바로 리스트에 추가

		// 1. ar에 상어 그대로 입력받는다.
		// 2. 메서드는 어부의 위치를 기준으로 실행
		// 3. 어부가 상어를 먼저잡고 상어의 위치 변화 시작
		// 4. 상어가 다 움직인 후 2이상인 것들 큰거 뺴고 다 제거
		// 5. 다돌렸을 때 끝
		for(int line = 0;line<C;line++) {
			// 농부가 먼저 상어를 잡고
			catching(line);
			// 잡은 후에 상어의 이동 시작
			move();
		}
		System.out.println(ans);

	}
	public static void catching(int index) {
		// 일단 가까운 상어만 찾아서 잡기
		for(int i = 0;i<R;i++) {
			if(ar[i][index].size() == 1) {
				// 가까운 상어를 발견하면
				// 크기만큼 ans에 더하고 제거하고 break
				ans += ar[i][index].get(0).z;
//				System.out.println(index+" "+ans);
				ar[i][index].remove(0);
				break;
			}
		}
		return;
	}

	public static void move() {
		// 일단 우선 리스트에 있는
		// 상어들을 모두 q로 이동
		q = new PriorityQueue<node>();
		for(int i = 0;i<R;i++) {
			for(int j =0;j<C;j++) {
				// 큐에추가하고 제거
				if(ar[i][j].size()==1) {
					q.add(new node(i, j, ar[i][j].get(0).s , ar[i][j].get(0).d, ar[i][j].get(0).z));
					ar[i][j].remove(0);
				}
			}
		}
		// 모두 이동 끝 ( 크기가 작은거부터 나열)
		// 이제 상어 이동 하자
		while(q.size()>0) {
			node n = q.poll();
			int tmp = n.s;
			// 방향별로 나눠줌
			while(tmp>0) {
				tmp--;
				// 위
				if(n.d == 1) {
					// 맨위면 1로 이동+ 방향전환, 아니면 -1
					if(n.x == 0) {
						n.d = 2;
						n.x =1;
					}
					else {
						n.x--;
					}
				}
				// 아래
				else if(n.d == 2) {
					if(n.x == R-1) {
						n.d =1;
						n.x = R-2;
					}
					else {
						n.x++;
					}
				}
				// 우측
				else if(n.d == 3) {
					if(n.y == C-1) {
						n.d = 4;
						n.y = C-2;
					}
					else {
						n.y ++;
					}
				}
				// 좌측
				else {
					if(n.y == 0) {
						n.d =3;
						n.y = 1;
					}
					else {
						n.y--;
					}
				}
			}
			// 이동 끝
			// 이제 ar에 다시 넣는데
			// 만약 상어가 있으면 제거
			if(ar[n.x][n.y].size()==1) {
				ar[n.x][n.y].remove(0);
			}
			ar[n.x][n.y].add(new node(n.x, n.y, n.s , n.d, n.z));
			

		}


	}



}
