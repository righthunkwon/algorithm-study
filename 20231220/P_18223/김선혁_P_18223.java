import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;
	static int K; 
	static ArrayList<node> arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		int ans = sc.nextInt();
		boolean flag = false; 
		// 만약 가는길에 ans를 지나면 flag를 true로 바꾼다.

		arr = new ArrayList[N+1]; // arr생성
		for(int i=0; i<=N; i++){
			arr[i] = new ArrayList<>();
		}

		for(int i =0;i<K;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c=  sc.nextInt();
			arr[a].add(new node(b,c));
			arr[b].add(new node(a,c));
			// 입력되는대로 값을 그대로
			// arr에 추가해버린다.
		}
		// 만약 ans를 지나는지 알고싶으면 
		// 전체를 돈 값이 ans에서 시작해서 끝까지 돈거랑
		// 1에서 시작해서 ans까지간 값+ ans에서 끝까지 간값이랑 같아야 한다.
		int[] dist1 = solve(1);
		int[] dist2 = solve(ans); // dist2는 ans에서 시작해서 끝까지 간값만 본다.
		if(dist1[N] >= dist1[ans] + dist2[N]) {
			// 두개가 값에서 들리는게 작거나 같으면 구할 수 있다는 뜻
			System.out.println("SAVE HIM");
		}
		else {
			System.out.println("GOOD BYE");
		}
		
	}
	public static int[] solve(int st) {
		int[] dist = new int[N+1];

		PriorityQueue<node> pq = new PriorityQueue<>();
		// 일단 시작하는위치 1부터 pq에다가 넣어놓고
		// 1에서 선분을 다 넣어서
		// 다익스트라 만족하는 애들 구해보자
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.offer(new node(st, 0));
		dist[st] = 0;
		while (!pq.isEmpty()) {
			node now = pq.poll();
			for (node next : arr[now.en]) {
				// 현재 다음으로 갈 값이 지금 값에서 다음거 가격보다 크다면
				// 그 값은 교체
				if (dist[next.en] > dist[now.en] + next.cost) {
					dist[next.en] = dist[now.en] + next.cost;
					pq.offer(new node(next.en, dist[next.en]));
				}
			}
		}
		return dist;
	}

	static class node implements Comparable<node> {		
		int en;
		int cost;
		public node(int en, int cost) {
			this.en = en;
			this.cost= cost;
		}
	    @Override
		public int compareTo(node e){
			return cost - e.cost;
		}


	}

}	

