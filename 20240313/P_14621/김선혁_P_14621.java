import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class node implements Comparable<node>{
		int end;
		int dis;
		
		public node(int end, int dis) {
			super();
			this.end = end;
			this.dis = dis;
		}
		@Override
		public int compareTo(node o) {
			return (this.dis - o.dis);
		}

	}
	static int N;
	static ArrayList<node>[] ar;
	static int flag[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		ar = new ArrayList[N+1];
		// 초기화
		// 먼저 남자 / 여자 확인
		flag = new int[N+1];
		for(int i = 1;i<=N;i++) {
			ar[i] = new ArrayList<>();
			if(sc.next().equals("W")) {
				flag[i] = -1;
			}
			// 여자는 1기록
		}
		// 각자 다 시작점에서 연결해서 리스트 추가할건데
		for(int i = 0 ;i< M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(flag[a] == flag[b]) {
				continue;
			}
			ar[a].add(new node(b,c));
			ar[b].add(new node(a,c));
		}
		
		// flag로 방문처리 확인하고
		// 하나씩 쭉 연결해보자
		// (1,0)에서 시작
		System.out.println(solve());
		
		
		
	}
	public static int solve() {
		int ans = 0;
		int cnt = 0;
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(1,0));
		while(true) {
			if(pq.size()==0) {
				break;
			}
			node n = pq.poll();
			if(flag[n.end] > 0) {
				continue;
			}
			// 현재지점이 방문되었으면 continue하고
			// 아니면 방문처리 + ans에 값 더해줌
			flag[n.end] = 1;
			cnt++;
			ans += n.dis;
			// end점으로 향하는 것들 모두 꺼냄
			for(int i = 0; i<ar[n.end].size();i++) {
				// 0 또는 -1이면 아직 방문x
				if(flag[ar[n.end].get(i).end]>0) {
					continue;
				}
				// 아니면 큐에 게속 추가
				pq.add(new node(ar[n.end].get(i).end , ar[n.end].get(i).dis));
			}
		}
		if(cnt != N) {
			return -1;
		}
		return ans;
		
	}
	


}
