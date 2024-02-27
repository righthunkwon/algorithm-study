package level_36_union_find;

import java.io.*;
import java.util.*;

// 사이클 게임
public class P_20040 {
	private static int N, M, ans;
	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 정점 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수

		// 초기화
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i; // 초기에 각 정점은 자기 자신을 가리킴
		}

		// 간선 정보 입력
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 사이클이 형성되었을 경우
			if (!union(a, b)) {
				ans = i; // 간선 번호를 저장
				break;
			}
		}

		System.out.println(ans);
	}

	private static boolean union(int a, int b) {
		int aroot = find(a); // a의 루트노드
		int broot = find(b); // b의 루트노드
		
		// a와 b의 루트노드가 같다면 사이클 형성
		if (aroot == broot) return false;
		
		// a와 b의 루트노드가 다르다면 합쳐줌
		parent[broot] = aroot;
		return true;
	}

	private static int find(int n) {
		if (n == parent[n]) return n;
		return parent[n] = find(parent[n]);
	}

}
