package 백준;

import java.util.*;

public class Main {
	static class node {
		int en;
		int cost;
		node(int en, int cost){
			this.en = en;
			this.cost = cost;
		}
	}
	static int N;
	static boolean[] flag;
	static ArrayList<node>[] ar;
	static int max;
	static int maxi;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 모두 입력받은 다음 하나의 점을 잡으면 그 점에서 가장 먼 점을 구한다.
		// 그점은 지름을 구성하는 두개의 점중 하나로 
		// 그 점에서 또 시작해서 가장 먼 점을 구하게 되면 지름을 구할 수 있음
		N = sc.nextInt();
		ar = new ArrayList[N+1];
		for(int i = 0;i<=N;i++) {
			ar[i] = new ArrayList<Main.node>();
		}
		// 각 간선을 이제 리스트에 추가
		for(int i = 0;i<N-1;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c= sc.nextInt();
			ar[a].add(new node(b,c));
			ar[b].add(new node(a,c));
		}
		// 이제 하나의 점에서 시작해보자
		// 1에서 시작해서 최대의 cnt가 나올때의 index를 구해보자
		flag = new boolean[N+1];
		max = 0;
		maxi = 0;
		flag[1] = true;
		dfs(1,0);
		// 이 과정을 거치면 maxi에 지름 두점중 하나가 저장되어있음
		// 이제 maxi를 기준으로 가장 먼 max값을 구하면된다.
		// 어차피 지름이 max보다 크기때문에 0으로 안바꿔도 됨
		flag = new boolean[N+1];
		flag[maxi] = true;
		dfs(maxi, 0);
		System.out.println(max);
	}
	public static void dfs(int index, int cnt) {
		if(max < cnt) {
			max = cnt;
			maxi = index;
		}
		
		
		for(int i = 0 ; i< ar[index].size();i++) {
			node n = ar[index].get(i);
			if(flag[n.en]) {
				continue;
			}
			flag[n.en] = true;
			dfs(n.en, cnt + n.cost);
			// 어차피 1회용이라 false 안해도 된다.
		}
		return;
	}

}
