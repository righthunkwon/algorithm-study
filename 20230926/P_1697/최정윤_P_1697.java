
import java.io.*;
import java.util.*;

public class Pro_1697_숨바꼭질 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		result = 0;
		queue = new LinkedList<int[]>();
		visited = new boolean[200001];
		if (K != N) {
			queue.add(new int[] { N, 0 });
			bfs();
		}

		System.out.println(result);
	}

	static int K;
	static int result;
	static boolean[] visited;
	static Queue<int[]> queue;

	public static void bfs() {
		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			int N = arr[0];
			int time = arr[1];
			if (N + 1 == K || N - 1 == K || 2 * N == K) {//-1칸 +1칸 *2칸 값이 목표지점인지 확인
				result = time + 1;//맞다면 한번 더 수행했을 때 시간이므로 현재 초 +1해준다.
				return;
			}
			if (N + 1 < 100001&&!visited[N + 1]) {
				visited[N + 1] = true;
				queue.add(new int[] { N + 1, time + 1 });
			}
			if (N - 1 >= 0 && !visited[N - 1]) {
				visited[N - 1] = true;
				queue.add(new int[] { N - 1, time + 1 });
			}
			if ( 2 * N < 200001 && !visited[2 * N]) {
				visited[2 * N] = true;
				queue.add(new int[] { 2 * N, time + 1 });
			}
		}
	}
}
