package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16947_서울지하철2호선 {
	
	static int N;
	static int start = -1;
	static ArrayList<Node>[] map;
	static boolean[] cycle, chk;
	static int[] res;
	
	static class Node {
		int v, cnt;

		public Node(int v, int cnt) {
			this.v = v;
			this.cnt = cnt;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) map[i] = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a].add(new Node(b, 0));
			map[b].add(new Node(a, 0));
		}
		
		cycle = new boolean[N+1];
		chk = new boolean[N+1];
		
		// 순환선에 해당하는 역들만 true로 바꾸기 dfs(시작역, 부모노드)
		for(int i = 1; i <= N; i++) dfs(i, -1);
		
//		for(int i = 1; i <= N; i++) System.out.print(cycle[i]+" ");
		
		res = new int[N+1];
		for(int i = 1; i <= N; i++) {
			chk = new boolean[N+1];
			if(!cycle[i]) res[i] = bfs(i);
		}
		
		for(int i = 1; i <= N; i++) System.out.print(res[i] + " ");
	}
	
	static int bfs(int x) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, 0));
		chk[x] = true;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			// 순환선 발견하면 cnt 리턴
			if(cycle[poll.v]) return poll.cnt;
			
			for(Node n : map[poll.v]) {
				if(!chk[n.v]) {
					chk[n.v] = true;
					q.add(new Node(n.v, poll.cnt + 1));
				}
			}
		}
		return 0;
	}
	
	static boolean dfs(int x, int p) {
		chk[x] = true;

		for(Node n : map[x]) {
			if(!chk[n.v]) {
				if(dfs(n.v, x)) {
					cycle[x] = true;
					// 사이클 시작 역에 도달하면 사이클 완성하고 종료
					if(x == start) return false;
					return true;
				}
			// 현재역의 부모가 아닌데 이미 방문했다면 순환선 && 사이클 시작점 찾기
			} else if(n.v != p && start == -1) {
				// 시작역 설정
				start = n.v;
				cycle[x] = true;
				return true;
			}
		}
		return false;
	}
}
