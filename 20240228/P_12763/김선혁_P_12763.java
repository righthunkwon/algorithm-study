import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class node{
		int end;
		int times;
		int moneys;
		public node(int end, int times, int moneys) {
			super();
			this.end = end;
			this.times = times;
			this.moneys = moneys;
		}
	}
	
	static int N;
	static int anst;
	static int ansm;
	static int[] ans;
	static ArrayList<node>[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 첫번째항 시간 , 두번째항 돈
		
		// 이거는 처음에 시간이 적게걸리는 방향이 돈을 더 쓸수도있어
		// 각 지점마다 dfs를 통해서 확인을 하고
		// 한번 돌때마다 걸리는 비용을 기준으로 
		arr = new ArrayList[N+1];
		for(int i = 1;i<arr.length;i++) {
				arr[i] = new ArrayList<node>();
		}
		// 초기화 완료
		anst = sc.nextInt();
		ansm = sc.nextInt();
		int cnt = sc.nextInt();
		for(int i =0;i<cnt;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			// 양방향
			int c = sc.nextInt();
			int d = sc.nextInt();
			arr[a].add(new node(b,c,d));
			arr[b].add(new node(a,c,d));
			// 역방향까지 시간과 돈 모두 더해줌
		}
		ans = new int[N+1];
		for(int i = 2;i<N+1;i++) {
			ans[i] = 987654321;
		}
		// 일단 1부터 dfs시작해서 시간, 돈 계산시작
//		for(int i = 0;i<arr[1].size();i++) {
//			node n = arr[1].get(i);
//			// 현재 1에서 연결시작된 것들을 모두 시작점으로
//			// 시작을 해보자
//			solve(n.end, n.times, n.moneys);
//		}
		solve(1,0,0);
		if(ans[N] == 987654321) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans[N]);
		}
		
	}
	// dfs를 돌면서 현재의 좌표에서 이어진 점이
	// 조건을 만족하고 있으면 그 다음점으로 이동
	public static boolean solve(int a, int time, int money) {
		// 목적지 다간경우
		// N번째 좌표에 최소값 갱신하고 true반환
		if(a == N) {
			ans[a] = Math.min(ans[a], money);
			return true;
		}
		boolean flag = false;
		// a에서 연결된 모든 점에서 
		// 뻗어나간 지점의 flag값이 없으면 넣고
		// 있으면 두개가 다 모두 적을 경우에만 갱신?
//		System.out.println(a+" "+time+" "+money);
		for(int i = 0;i<arr[a].size();i++) {
			flag = false;
			node n = arr[a].get(i);
			// 현재 연결된 점으로 갈때 시간과 돈 둘중 하나라도 넘으면
			// 다음 점계산
			if(time+n.times > anst || money+ n.moneys > ansm) {
				continue;
			}
			// 백트래킹
			if(ans[n.end] < money+n.moneys) {
				continue;
			}	
			flag = solve(n.end, time+n.times, money+ n.moneys);
			
			// 만약 목적지까지 갔으면 현재지점의 money 최소값으로 갱신
			if(flag) {
				ans[a] = Math.min(ans[a], money);
			}
		}
		
		return flag;
	}

}
