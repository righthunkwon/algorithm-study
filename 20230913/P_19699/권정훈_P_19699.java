package level_22_backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// 소-난다!

// 자료구조에 대한 이해
// (1) List	: 순서 O, 중복 O
// (2) Set	: 순서 X, 중복 X
// (3) Map	: 순서 X, 중복 X, Key-Value 쌍
// 중복을 제거해야 할 때는 Set을 활용하면 편리하다.
// 중복을 제거하면서 빈도와 같이 특정 값을 갱신해야 할 때는 Map을 활용하면 편리하다.

// 기능별 메소드를 분리
// (1) 백트래킹
// (2) 소수판별

public class P_19699 {
	// 중복 제거를 위해 HashSet 사용
	private static Set<Integer> set = new HashSet<>();
	private static int n, m;
	private static int[] arr;
	private static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 소의 수
		m = sc.nextInt(); // 선별할 소의 수
		arr = new int[n]; // 소의 배열
		visited = new boolean[n]; // 중복 방지 방문 판정

		// 배열 요소 입력
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		// 깊이우선탐색 & 백트래킹
		dfs(0, 0, 0);

		// HashSet에 저장된 소수인 몸무게의 합을 ArrayList에 복사
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list); // 정렬

		// 정답 출력
		if (list.size() == 0) {
			System.out.println(-1);
		} else {
			for (int i = 0; i < list.size(); i++)
				System.out.print(list.get(i) + " ");
		}
	}

	// 깊이우선탐색 & 백트래킹
	private static void dfs(int start, int sum, int depth) {
		// 기저부분(종료조건)
		// m마리의 소를 선택했을 때 몸무게의 합이 소수인지 판별하고 return;
		if (depth == m) {
			if (isPrime(sum)) {
				set.add(sum); // 몸무게의 합이 소수라면 HashSet에 몸무게 삽입
			}
			return;
		}

		// 재귀부분
		// 중복 제거를 위해 탐색 인덱스 조정(start 부터 탐색) 
		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true; // 방문처리
				dfs(i + 1, sum + arr[i], depth + 1); // 방문하면, 다음 요소로 넘어가고, 해당 요소를 합에 더하고, 깊이를 하나 증가시킨다.  
				visited[i] = false; // 방문처리 해제
			}
		}
	}

	// 소수 판별
	private static boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			// 나누어 떨어지면 소수
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
