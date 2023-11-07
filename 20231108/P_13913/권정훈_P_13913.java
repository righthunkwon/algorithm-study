package level_31_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 숨바꼭질 4
// 최단거리를 구하므로 bfs로 구현
// 경로를 출력할 때 매번 모든 경로를 저장하면 시간초과 발생
public class P_13913 {
	private static int n, k;
	private static Queue<int[]> q;
	private static int[] parent;
	private static boolean[] visited;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 수빈 위치
		k = Integer.parseInt(st.nextToken()); // 동생 위치
		visited = new boolean[100001]; // 방문체크
		parent = new int[100001]; // 부모 위치만 저장
		
		// BFS 및 최소 시간 출력
		bfs(n); 
		
		// 경로 구하기 및 룰력
		Stack<Integer> stack = new Stack<>(); // 경로를 담을 스택
        stack.push(k); // 동생 위치부터 넣고 스택을 통해 역순으로 출력
        int location = k; // 동생 위치
        while (location != n) {
            stack.push(parent[location]);
            location = parent[location];
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " "); 
        }
	}

	private static void bfs(int n) {
		// 수빈위치와 동생위치가 같을 경우 이미 만났으므로 0초 출력 후 리턴
		if (n == k) {
			System.out.println(0);
			return;
		}

		q = new LinkedList<int[]>(); // 큐 생성 (0: 위치, 1: 시간(초))
		q.add(new int[] { n, 0 }); // 수빈 초기 위치
		visited[n] = true; // 방문처리

		// 풀이 로직
		while (!q.isEmpty()) {
			int[] x = q.poll(); // 큐에서 빼내고

			// 이동한 곳이 동생의 위치라면 시간(초)을 출력하고 리턴
			if (x[0] == k) {
				System.out.println(x[1]);
				return;
			}

			// x-1위치가 범위 내에 있고 방문하지 않았다면
			if (x[0] - 1 >= 0 && !visited[x[0] - 1]) {
				visited[x[0] - 1] = true; // 방문처리하고
                parent[x[0] - 1] = x[0]; // 부모 위치를 저장하고
				q.add(new int[] { x[0] - 1, x[1] + 1 }); // 해당 위치를 큐에 추가
			}

			// x+1 위치가 범위 내에 있고 방문하지 않았다면
			if (x[0] + 1 <= 100000 && !visited[x[0] + 1]) {
				visited[x[0] + 1] = true; // 방문처리하고
                parent[x[0] + 1] = x[0]; // 부모 위치를 저장하고
				q.add(new int[] { x[0] + 1, x[1] + 1 }); // 해당 위치를 큐에 추가
			}

			// 2x 위치가 범위 내에 있고 방문하지 않았다면
			if (x[0] * 2 <= 100000 && !visited[x[0] * 2]) {
				visited[x[0] * 2] = true; // 방문처리하고
                parent[x[0] * 2] = x[0]; // 부모 위치를 저장하고
				q.add(new int[] { x[0] * 2, x[1] + 1 }); // 해당 위치를 큐에 추가
			}
		}
	}

}
