import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class node{
		int x;
		int dis;
		public node(int x, int dis) {
			super();
			this.x = x;
			this.dis = dis;
		}
	}
	static int N;
	static ArrayList<Integer>[] ar;
	static int[] cnt;
	static boolean[] flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 이문제는 보통 부모의 index를 저장하는 거에서 
		// dfs로 만약 순환이 나오면 true로 바꿔버리고
		// 아닌 점들은 bfs로 그대로 cnt에 개수 저장함

		// 문제는 중간의 부모가 새롭게 걸릴경우 그점에서 
		// 이어지는 점 모두 갱신 필요
		N = sc.nextInt();

		// 일단 입력 다 받음
		ar = new ArrayList[N+1];
		for(int i = 1;i<=N;i++) {
			ar[i] = new ArrayList<Integer>();
		}

		for(int i = 1 ; i<=N;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				ar[a].add(b);
				ar[b].add(a);
				// 양방향으로 등록
		}
		cnt = new int[N+1];
		flag = new boolean[N+1];
		// 이제 일단 cycle인지 체크해주자
		for(int i =1 ; i<=N;i++) {
			if(dfs(0,i,i)) {
				break;
			}
			// cycle이 아니면 초기화
			flag = new boolean[N+1];
		}
		// 이제 거리계산
		for(int i = 1;i<=N;i++) {
			// cycle이 아닌경우
			if(!flag[i]) {
				// 큐로 cycle에서 얼마나 떨어져있는지 확인
				cnt[i] = bfs(i);
			}
			System.out.print(cnt[i]+" ");
		}
		System.out.println();

	}
	public static boolean dfs(int st, int en, int origin) {
		// origin이 처음 시작 숫자
		// 일단 true로 flag를 바꾼다음 
		// st에서 연결된 지점이
		// true일경우 방문한 지점 - origin과 일치하면 cycle로 true 리턴
		// false일 경우 방문하지 않은 지점으로 dfs 돌음
		flag[en] = true;
		for(int i = 0;i<ar[en].size();i++) {
			int tmp = ar[en].get(i);
//			System.out.println(en+" "+tmp+" "+flag[tmp]);
			if(flag[tmp]) {
				// 일치하는지 확인
				if(tmp == origin && tmp != st) {
					return true;
				}
			}
			else {
				// cycle인경우 true 출력
				if(dfs(en,tmp,origin)) {
					return true;
				}
			}
		}
		// cycle아닌거로 false로 바꿈
		flag[en] = false;
		return false;
	}

	public static int bfs(int x) {
		Queue<node> q = new LinkedList<>();
		boolean[] visit = new boolean[N+1];
		q.add(new node(x, 0));
		visit[x] = true;
		// x부터 큐에 추가하고 방문처리
		// 이제 하나씩 꺼내서 
		// 사이클을 만낫을 때 그거리만큼 return , 아니면
		// 현재 거리+1로 큐에 추가
		while(!q.isEmpty()) {
			node n = q.poll();
			// 거리만큼 return
			if(flag[n.x]) return n.dis;

			for(int i = 0; i < ar[n.x].size(); i++) {
				int tmp = ar[n.x].get(i);
				if(!visit[tmp]) {
					visit[tmp] = true;
					q.add(new node(tmp, n.dis + 1));
				}
			}
		}
		return 0;


	}

}
