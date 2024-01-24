package level_42_topological_sorting;

import java.io.*;
import java.util.*;

// 줄세우기
public class P_2252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] rank = new int[N + 1]; // 각 학생 별 앞에 존재하는 학생 수 배열
		ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // 키 비교 리스트
		
		// 초기화
		for (int i = 0; i <= N; i++) { 
			list.add(new ArrayList<>()); 
		}
			
		// 키 비교 케이스 입력 & 각 학생별 앞 학생 수 증가
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list.get(A).add(B); // 키 비교 케이스 입력
			rank[B]++; // 앞 학생 수 증가
		}
		
		// 위상정렬
		// 앞 학생수가 없는 학생들은 진입차수가 0이라는 뜻이므로 모두 큐에 저장(진입차수가 0)
		Queue<Integer> q = new LinkedList<>(); // 줄
		for (int i = 1; i <= N; i++) {
			if (rank[i] == 0) q.add(i); // 줄세우기
		}
		
		// 탐색
		while (!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr).append(" ");

			// 비교 했던 학생들 비교
			for (int next : list.get(curr)) {
				rank[next]--; // 앞 학생이 줄에 포함되었으므로 1 감소 (진입차수 1 감소)
				
				// 만약 해당 학생 앞에 학생이 없다면(진입차수가 0이라면) 줄세우기
				if (rank[next] == 0) { 
					q.add(next);
				}
			}
		}
		
		System.out.println(sb);
	}
}
