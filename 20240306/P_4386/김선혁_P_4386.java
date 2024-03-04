import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class pos{
		double x;
		double y;
		public pos(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	// 거리가 가까운것부터 보이게
	static class node implements Comparable<node>{
		int end;
		double dis;
		
		public node(int end, double dis) {
			super();
			this.end = end;
			this.dis = dis;
		}
		@Override
		public int compareTo(node o) {
			return (int) (this.dis - o.dis);
		}

	}
	static int N;
	static ArrayList<pos> arr;
	static ArrayList<node>[] ar;
	static double ans;
	static PriorityQueue<node> q;
	static boolean[] flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 각각의 거리의 차이를 구해서
		// 리스트에 추가해 놓는다.
		
		arr= new ArrayList<>();
		for(int i = 0;i<N;i++) {
			arr.add(new pos(sc.nextDouble(), sc.nextDouble()));
		}
		// 모두 리스트 추가 완료
		// 이제 ar에 시작점을 기준으로 거리를 모두 기록
		ar = new ArrayList[N];
		for(int i = 0 ;i<N;i++) {
			ar[i] = new ArrayList<>();
		}
		for(int i = 0;i<N-1;i++) {
			for(int j = i+1;j<N;j++) {
				// 각 좌표의 차이의 제곱의 합의 제곱근
				// 양방향으로 추가
				double dis = Math.sqrt(Math.pow(arr.get(i).x -arr.get(j).x , 2) + Math.pow(arr.get(i).y -arr.get(j).y , 2));
				ar[i].add(new node(j,dis));
				ar[j].add(new node(i,dis));
			}
		}
		// 이제 0부터 시작해서 (상관없음 어차피 q에서 작은순서대로 나와서)
		// 큐에서 하나씩 꺼내서 
		// 방문이 안된 end점을 가면서 최소의 비용을 더해가면서 
		// 전체가 다 방문될떄까지 ㄱㄱ
		q = new PriorityQueue<>();
		flag = new boolean[N];
		q.add(new node(0,0));
		
		solve();
		System.out.println(ans);
	}
	
	public static void solve() {
		while(true) {
			if(q.size()==0) {
				break;
			}
			node n = q.poll();
			// 큐에서 하나 꺼내서
			// end로 이어진 점들중 방문안된곳
			// 큐에다가 추가해서 하나씩꺼내기 반복
			if(flag[n.end]) {
				continue;
			}
			// 여기서 확인하는 이유는 아직 안나온 선들중에서 혹시
			// 더 거리가 짤은게 있을 수 있어서 q에서 꺼낸 후에 방문확인
			flag[n.end] = true;
			ans += n.dis;
			for(int i = 0;i<ar[n.end].size();i++) {
				// 현재 끝점에서 연결된 곳이 방문처리 안됬을 떄만 추가
				if(!flag[ar[n.end].get(i).end]) {
					q.add(new node(ar[n.end].get(i).end, ar[n.end].get(i).dis));
				}
			}
		}
		
	}
	


}
