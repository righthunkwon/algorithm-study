package baek;

import java.io.*;
import java.util.*;
//범위 설정이 문제의 포인트 
public class Pro_1697_숨바꼭질2 {
	static int K;
	static int result;
	static boolean[] visited;
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//수빈이 좌표 0<=K<=100000
		K = Integer.parseInt(st.nextToken());//동생이 있는 좌표 0<=N<=100000
		result = 0;
		queue = new LinkedList<int[]>();	//{현재위치,시간(depth)}
		visited = new boolean[200001];	//메모리초과 뜨지 않게 하기 위해 이미 방문했던 좌표는 큐에 담지 않는다.
		if (K != N) {//K랑 N이 같으면 0 출력 
			queue.add(new int[] { N, 0 });
			bfs();
		}

		System.out.println(result);
	}

	

	public static void bfs() {
		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			int N = arr[0];
			int time = arr[1];
			if (N + 1 == K || N - 1 == K || 2 * N == K) {//-1칸 +1칸 *2칸 값이 목표지점인지 확인
				result = time + 1;//맞다면 한번 더 수행했을 때 시간이므로 현재 초 +1해준다.
				return;
			}
			if (N + 1 < 100001&&!visited[N + 1]) {//N+1의 값이 K의 값보다 크다면 더할 이유가 없다.
				visited[N + 1] = true;
				queue.add(new int[] { N + 1, time + 1 });
			}
			if (N - 1 >= 0 && !visited[N - 1]) {//N-1의 값이 음수좌표가 나오면 안된다.
				visited[N - 1] = true;
				queue.add(new int[] { N - 1, time + 1 });
			}
			if ( 2 * N < 200001 && !visited[2 * N]) {//K의 최댓값 100000*2한 것보다 작아야한다.
				visited[2 * N] = true;
				queue.add(new int[] { 2 * N, time + 1 });
			}
		}
	}
}
