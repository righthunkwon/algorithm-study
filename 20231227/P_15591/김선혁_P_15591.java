import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static ArrayList<node>[] ar;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			M = sc.nextInt();
			ar = new ArrayList[N+1]; // 0부터 n까지의 간선마다 리스트 추가
			for(int i =1;i<=N;i++) {
				ar[i] = new ArrayList<>();
			}
			// 1부터 N까지 리스트 초기화
			for(int i=0; i<N-1; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				// 각 a에서 b까지 c의 값을 가짐
				//a와 b로 시작하는 간선 모두 추가
				ar[a].add(new node(b,c));
				ar[b].add(new node(a,c));
			}
			// 밑에부터는 값구함
			for(int i =0;i<M;i++) {
				int ans = 0;
				int k = sc.nextInt();
				int v = sc.nextInt();
				// k값 이상 v에서 시작
				Queue<Integer> q = new LinkedList<>(); 
				boolean[] flag = new boolean[N+1]; // 1부터 N까지 
				// 방문했던거는 추가하면 안되서 flag 선언
				q.add(v);
				flag[v] = true;
				// while문을 통해 큐에서 v시작으로 연결된 다른 점들 다 확인
				while(true) {
					if(q.size()==0) {
						break;
					}
					// 만약 더 연결된 선이 없으면 break
					int tmp = q.poll(); 
					// tmp에서 시작한 점들 모두 탐색
					for(int j=0;j<ar[tmp].size();j++) {
						// ar[tmp]에서 시작한 선이 향한 곳과의 값이
						// 만약 k보다 값이 크고
						// 향한 곳이 방문하지 않았다면 큐에다가 그 점 추가
						if(ar[tmp].get(j).price >= k && !flag[ar[tmp].get(j).x]) {
							flag[ar[tmp].get(j).x] = true;
							q.add(ar[tmp].get(j).x);
							ans++;
						}
					} // j for
				}
				System.out.println(ans);
			}


}

	// x와 y좌표와 사람이 지나가는거면 human true 변수를 하나 만듬
	static class node{
		private int x;
		private int price;
		public node(int x, int price) {
			super();
			this.x = x;
			this.price = price;
		}		

	}
}	

