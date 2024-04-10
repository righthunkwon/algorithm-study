package level_36_union_find;

import java.io.*;
import java.util.*;

// 여행가자
// 유니온파인드
// 서로소인 부분집합의 표현(분리집합, 서로소집합, 상호 배타적 집합)
// 여러 노드가 있을 때 두 노드가 같은 그래프에 속해있는지 알 수 있음
// 그래프를 합치는 union(x,y) 연산과 어느 그래프에 속해있는지를 찾는 find(x) 연산으로 구성됨
public class P_1976 {
	private static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 도시 수
		int M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시 수
		parents = new int[N + 1]; // 도시 번호가 1번부터이므로 크기를 N+1로 지정

		// 노드 번호 초기화
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		// 도시 연결 정보 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				int conn = Integer.parseInt(st.nextToken());

				// 연결된 부분은 유니온 연산
				if (conn == 1) {
					union(i, j);
				}
			}
		}
		
		// 여행 가능 여부 판단
		st = new StringTokenizer(br.readLine(), " ");
		int start = find(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < M; i++) {
			int curr = Integer.parseInt(st.nextToken());
			
			// 여행 시작 도시와 연결되어있지 않다면 여행 불가
			if (start != find(curr) ) {
				System.out.println("NO");
				return;
			}
		}
		
		// 조건에 안 걸리면 여행 가능
		System.out.println("YES");
	}

	private static int find(int x) {
		// 현재값이 부모일 경우 현재값 반환
		if (x == parents[x]) return x;

		// 부모를 찾기 위한 재귀호출 후 해당 값 반환
		return parents[x] = find(parents[x]);
	}

	private static void union(int x, int y) {
		// 부모 확인
		x = find(x);
		y = find(y);

		// 부모가 다를 경우 특정 기준을 통해 부모를 설정
		// 일반적으로는 더 작은 값을 기준으로 부모를 설정
		if (x != y) {
			if (x < y) parents[y] = x;
			else parents[x] = y;
		}
	}
}
