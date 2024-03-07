import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class node implements Comparable<node>{
		int end;
		int cnt;
		public node(int end, int cnt) {
			super();
			this.end = end;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Main.node o) {
			return this.cnt - o.cnt;
		}

	}
	static int N;
	static int P;
	static int K;
	static ArrayList<node>[] arr;
	static int[] flag;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		P = sc.nextInt();
		K = sc.nextInt();
		// 1. 먼저 arr에 양방향으로 입력받음 
		// 2. 최대점을 구한다음에 이분탐색으로 중간점 잡고
		// 3. bfs 돌면서 flag에 값 입력받고
		// 4. flag에 입력된 값보다 작은 값이 나올때만 갱신
		// 5. 중간에 mid보다 큰 값이 나올때마다 1씩 ++
		// ->
		// 6. mid보다 큰 값이 K개보다 작을떄는 계속 반복해서
		// 7. mid값이 제일 작을 때를 구함
		arr = new ArrayList[N+1];
		for(int i = 1;i<N+1;i++) {
			arr[i] = new ArrayList<Main.node>();
		}
		// arr리스트 초기화 완료
		int max = 0;
		for(int i = 0;i < P;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c= sc.nextInt();
			// 양방향으로 리스트에 추가해줌
			arr[a].add(new node(b,c));
			arr[b].add(new node(a,c));
			max = Math.max(max, c);
		}

		// 최대점과 0에서 계속 이분탐색 진행
		int left = 0;
		int right = max;
		ans =-1;
		while(true) {
			int mid = (left+right)/2;
			// 만약 mid값을 최대값으로 정했을 때
			// mid보다 큰값의 개수가 K보다 작다면
			// right를 땡기고 다시반복 
			if(solve(mid) <= K) {
				ans = mid;
				right = mid -1;
			}
			// K개보다 많으면 mid를 올려서 다시 진행
			else {
				left = mid+1;
			}
			// left가 right보다 크면 종료
			if(left > right) {
				break;
			}
		}
		System.out.println(ans);

	}
	public static int solve(int mid) {
		// 먼저 큐와 flag를 초기화하고
		// 1 , 0 을 넣고 시작
		PriorityQueue<node> pq = new PriorityQueue<Main.node>();
		flag = new int[N+1];
		// 1은 어차피 0이라 2부터
		for(int i = 2;i<=N;i++) {
			flag[i] = 987654321;
		}
		pq.add(new node(1,0));
		while(true) {
			if(pq.size()==0) {
				break;
			}
			node n = pq.poll();
			// 가장 값이 작은것을 꺼내서 시작
			// end점으로 향해있는 좌표에서 뻗어있는 모든 지점들 큐에 추가
			// 단, 향한 지점의 flag값보다 지금값 + 향한 지점의 값이 더 작을때만
			// 크면 어차피 반복이라 필요 x
			for(int i = 0;i<arr[n.end].size();i++) {
				node tmp = arr[n.end].get(i);
				int plus = 0;
				// mid 보다 크면 1 아니면 0
				if(tmp.cnt > mid){
					plus = 1;
				}
				// 값 비교
				if(flag[tmp.end] <= flag[n.end] + plus) {
					continue;
				}
				// 조건만족하면 큐에 추가 + 값 갱신
				pq.add(new node(tmp.end , tmp.cnt));
				flag[tmp.end] = flag[n.end] + plus;
			}


		}

		return flag[N];
	}

}
