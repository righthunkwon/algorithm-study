package baek;
import java.io.*;
import java.util.*;


public class Pro_1260_DFSBFS {
	static HashMap<Integer, int[]> map;
	static List<Integer> dfs;
	static List<Integer> bfs;
	static int N;
	static Queue<Integer> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		map = new HashMap<Integer, int[]>();//1번이랑 연결되어있는 것을 key 값이 1인 map에 넣겠다 
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[] arr = map.getOrDefault(a, new int[N + 1]);
			arr[b] = 1;
			map.put(a, arr);
			int[] arr2 = map.getOrDefault(b, new int[N + 1]);
			arr2[a] = 1;
			map.put(b, arr2);
		} // 간선입력끝
		queue = new LinkedList<Integer>();
		bfs = new ArrayList<Integer>();//꺼낸 순서대로 담을 리스트
		dfs = new ArrayList<Integer>();
		dfs.add(V);
		dfs(V);
		for (Integer a : dfs) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		queue.add(V);
		bfs.add(V);
		bfs();
		for (Integer a : bfs) {
			System.out.print(a + " ");
		}
		System.out.println();
	}


	public static void dfs(int start) {
		if (dfs.size() >= N)
			return;
		if (map.get(start) != null) {//아무것도 연결안되어 있을 경우 대비
			int[] arr = map.get(start);
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] == 1 && !dfs.contains(i)) {//중복 확인
					dfs.add(i);
					dfs(i);
				}
			}
		}
		return;
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			if (bfs.size() >= N)
				return;
			int start = queue.poll();
			if (map.get(start) != null) {
				int[] arr = map.get(start);
				for (int i = 1; i < arr.length; i++) {
					if (arr[i] == 1 && !bfs.contains(i)) {
						bfs.add(i);
						queue.add(i);
					}
				}
			}
		}
		return;
	}
}
