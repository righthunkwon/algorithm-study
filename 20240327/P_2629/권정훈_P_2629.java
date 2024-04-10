package level_99_kanpsack;

import java.io.*;
import java.util.*;

// 양팔저울
public class P_2629 {
	static int N, M;
	static int[] arr;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 추 배열 요소 입력
		N = Integer.parseInt(br.readLine()); // 추 개수
		arr = new int[N]; // 추 배열
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		

		check = new boolean[N + 1][40001]; // 무게 배열(추개수,무게합)
		dfs(0, 0); // 탐색 시작

		// 구슬 배열 요소 입력
		M = Integer.parseInt(br.readLine()); // 구슬 개수
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int tc = Integer.parseInt(st.nextToken());
			
			// 정답 출력
			if (check[N][tc]) sb.append("Y ");
			else sb.append("N ");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int cnt, int sum) {
		// 종료조건
		if (sum > 500 * 30 || check[cnt][sum]) return;
		
		// 방문처리
		check[cnt][sum] = true;
		
		// 종료조건
		if (cnt == N) return;
		
		dfs(cnt + 1, sum + arr[cnt]); // 구슬 반대편에 추 1개 추가
		dfs(cnt + 1, sum); // 현재 추 그대로
		dfs(cnt + 1, Math.abs(sum - arr[cnt])); // 구슬 쪽에 추 1개 추가
	}
}
