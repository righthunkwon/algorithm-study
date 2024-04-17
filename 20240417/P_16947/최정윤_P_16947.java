package study_240417;

import java.io.*;
import java.util.*;

public class Pro_16947_서울지하철2호선 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		// 일단 인접리스트 만들어
		arr = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		q = new LinkedList();
		List<Integer> list = new ArrayList<Integer>(); //3개이상 연결된 것 담아놓는 리스트
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
			if (arr[a].size() >= 3) {
				list.add(a);
			}
			if (arr[b].size() >= 3) {
				list.add(b);
			}
		} // 연결완료
		
		visited = new boolean[N + 1]; //방문배열
		cycle = new boolean[N + 1]; //사이클여부배열
		isCycle = false;
		backStart = false;
		visited[1] = true;
		
		check(1, -1);//사이클 체크하는 메소드
		
		result = new int[N + 1]; //거리측정배열
		for (Integer a : list) {
			if (!cycle[a])
				continue;
			q.add(new int[] { a, 0 });
		}
		
		bfs();//거리 측정하는 메소드
		
		for (int i = 1; i < N + 1; i++) {
			System.out.print(result[i] + " ");
		}
	}
	
	private static void check(int i, int ex) {
		if (isCycle) return;
	
		for (Integer ed : arr[i]) {
			if (ed == ex) //바로 전 노드는 사이클 X
				continue;
			if (visited[ed]) {
				start = ed; //방문되어있다면 사이클이다.
				isCycle = true;
				cycle[ed] = true;
				return;
			} else {
				if (!isCycle)
					visited[ed] = true;
				check(ed, i);
				if (isCycle && !backStart && visited[ed])
					cycle[ed] = true;
				if (i == start)//사이클 시작지점까지만 돌아올때 true처리
					backStart = true;
			}
		}
	}
	
	private static void bfs() {
		while (!q.isEmpty()) {
			int[] n = q.poll();
			for (Integer a : arr[n[0]]) {
				if (cycle[a] || result[a] != 0)	continue; //사이클이면 추가 X, 이미 거리가 측정되었다면 넘어가라
				result[a] = n[1] + 1; //거리 저장
				q.add(new int[] { a, n[1] + 1 });
			}
		}
	}
	
	static Queue<int[]> q;
	static boolean[] visited, cycle;
	static List<Integer>[] arr;
	static boolean isCycle, backStart;
	static int start;
	static int[] result;
}
