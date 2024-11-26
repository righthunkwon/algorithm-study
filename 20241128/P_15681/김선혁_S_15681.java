package 백준;

import java.util.*;

public class Main {
	static int[] cnt;
	static int N;
	static ArrayList<Integer>[] ar; // 배열로하면 메모리초과
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int R = sc.nextInt();
		int Q = sc.nextInt();
		
		// 각 모든 선들이 방향이 없기때문에
		// 양방향으로 등록
		ar = new ArrayList[N+1];
		for(int i = 1;i<=N;i++) {
			ar[i] = new ArrayList<Integer>();
		}
		for(int i = 0 ; i < N-1;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			ar[a].add(b);
			ar[b].add(a);
		}
		// 이제 모든 정점을 기준으로 
		// 각 번호마다 몇개의 정점이 있는지 미리 계산해놓는다.
		cnt = new int[N+1];
		// dfs를 통해서 거슬러 내려가는 과정
		dfs(R, 0);
		
		for(int i = 1;i<=Q;i++) {
			System.out.println(cnt[sc.nextInt()]);
		}
		
		
	}
	public static void dfs(int index, int prev) {
		// 한 방향으로 진행하면서 해당 index에서 연결된 개수를 count해서
		// cnt배열에 넣어놓고 dfs가 종료된 후 그 밑에있는 간선들의 개수를 +해준다
		cnt[index] ++;
		for(int i = 0 ; i<ar[index].size();i++) {
			int tmp = ar[index].get(i);
			if(tmp != prev) {
				dfs(tmp, index);
				// dfs를 통해 i에 속하는 간선의 개수를 구한다음
				// i에서 해당하는 것만큼 +진행
				cnt[index] += cnt[tmp];
			}
		}
		return;
	}

}
