package level_19_combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 로또
public class P_6603 {
	private static int n;
	private static int[] arr, result;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0) break; // 0일 경우 종료
			
			// 배열 요소 입력
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			result = new int[6]; // 정답배열 
			visited = new boolean[n]; // 방문처리배열
			back(0, 0); // 백트래킹
			sb.append("\n"); // case마다 줄바꿈
		}
		System.out.println(sb); // 정답출력
	}
	
	private static void back(int st, int depth) {
		// 1. 기저부분(종료조건)
		if (depth == 6) {
			for (int tmp : result) {
				sb.append(tmp).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 2. 재귀부분(반복수행)
		for (int i = st; i < n; i++) {
			// 방문하지 않았을 경우
			if (!visited[i]) {
				visited[i] = true; // 방문처리
				result[depth] = arr[i];
				back(i, depth + 1);
				visited[i] = false; // 방문처리 해제
			}
		}
	}
}
