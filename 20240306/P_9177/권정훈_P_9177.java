package level_31_dfs_bfs;

import java.io.*;
import java.util.*;

// 단어 섞기
// 각 단어의 순서를 지키면서 두 단어를 섞는 문제
// 백트래킹을 사용하면 계속 2^n으로 분기하므로 시간초과
// 첫 번째 단어와 두 번째 단어를 교차축으로 섞어 세 번째 단어와 일치하는 경로를 찾는 느낌으로 풀이
public class P_9177 {
	static char[] carr1, carr2, carr3;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			carr1 = st.nextToken().toCharArray(); // 첫번째 단어
			carr2 = st.nextToken().toCharArray(); // 두번째 단어
			carr3 = st.nextToken().toCharArray(); // 세번째 단어(결과)
			visited = new boolean[carr3.length][carr3.length]; // 세번째 단어 길이만큼 방문처리
			if (bfs()) {
				System.out.println("Data set " + i + ": yes");
			} else {
				System.out.println("Data set " + i + ": no");
			}
		}
	}

	private static boolean bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 0 });
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int idx1 = q.peek()[0]; 
			int idx2 = q.peek()[1];
			int idx3 = q.peek()[2];
			q.poll();

			// 종료조건
			if (idx3 == carr3.length) {
				return true;
			}

			// 반복수행
			// 첫번째 단어 글자 찾을 경우
			if (idx1 < carr1.length && !visited[idx1 + 1][idx2] && carr1[idx1] == carr3[idx3]) {
				visited[idx1 + 1][idx2] = true; // 방문처리
				q.add(new int[] { idx1 + 1, idx2, idx3 + 1 }); // 다음 탐색
			}
			// 두번째 단어 글자 찾을 경우
			if (idx2 < carr2.length && !visited[idx1][idx2 + 1] && carr2[idx2] == carr3[idx3]) {
				visited[idx1][idx2 + 1] = true; // 방문처리
				q.add(new int[] { idx1, idx2 + 1, idx3 + 1 }); // 다음 탐색
			}
		}
		return false;
	}
}
