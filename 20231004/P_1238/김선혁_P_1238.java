import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
	static class pos implements Comparable<pos> {
		int end;
		int cost;	 
		pos(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}	 
		@Override
		public int compareTo(pos arg0) {
			return cost - arg0.cost;
		}
	}	 
	static int N;
	static int M;
	static int X;
	static ArrayList<ArrayList<pos>> arr; 
	static ArrayList<ArrayList<pos>> arr2;
	static boolean flag;
	static int[] dist, dist2;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		M = sc.nextInt(); 
		X = sc.nextInt();

		arr = new ArrayList<>(); // 갈때 배열
		arr2 = new ArrayList<>(); // 올때 배열
		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<>());
			arr2.add(new ArrayList<>());
		}
		dist = new int[N + 1];
		dist2 = new int[N + 1];
		Arrays.fill(dist, 987654321);
		Arrays.fill(dist2, 987654321);
		for(int i=0; i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			arr.get(a).add(new pos(b,c));
			arr2.get(b).add(new pos(a,c));
		}
		// 일단 모든 도로 정보 입력 완료
		// 이제 1번부터 가는길의 최단 거리를 구해보 자
		// 최단거리를 구하는 중간마다 각 거리를 저장해서
		// 최대값 출력
		max = 0;
		dijkstra(arr, dist, X);
		dijkstra(arr2, dist2, X);
		int ans = -1;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, dist[i] + dist2[i]);
			// 배열에 저장되어있는 값중에서 두개의 합이
			// 최단거리중 가장 오래걸리는 애의 값을
			// ans에 저장한다.
		}
		System.out.println(ans);
	}

	static void dijkstra(ArrayList<ArrayList<pos>> list, int[] cost, int start) {
		boolean[] flag = new boolean[N+1];
		PriorityQueue<pos> pq = new PriorityQueue<>();
		pq.add(new pos(start, 0));
		// 일단 시작점 qp에다 넣어주고 시작

		cost[start] = 0;

		while (true) {
			// 끝좌표 마다 각각
			// 방문한적이 없으면
			// 방문해주고 true로 교체해줌
			int idx = pq.poll().end;

			if (flag[idx]) {
				continue;
			}
			flag[idx] = true;
			// 현재있는 비용보다 큰값이
			// 이미 기록되어있으면
			// 작은값으로 교체하여 준다.
			// 교체한 후에는 누적합 더한것 qp로
			for (pos pos : list.get(idx)) {
				if (cost[pos.end] > cost[idx] + pos.cost) {
					cost[pos.end] = cost[idx] + pos.cost;
					pq.add(new pos(pos.end, cost[pos.end]));
				}
			}
      // 이제 더이상 없으면 break
			if(pq.size()==0) {
				break;
			}

		}
	}



}
