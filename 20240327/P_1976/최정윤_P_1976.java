package study_240410;

import java.io.*;
import java.util.*;

//N은 200이하 M은 1000이하
//union find
public class Pro_1976_여행가자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) { //연결해라
					union(i, j);
				}
			}
		}
		int[] travel = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			travel[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		for (int i = 0; i < M- 1; i++) {
			if (find(travel[i]) != find(travel[i + 1])) { //연결이 안되어있다면
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
	}

	static int[] parent;

	public static void union(int a, int b) {
		int x = find(a), y = find(b);
		if (x > y) {
			parent[x] = y;
		} else {
			parent[y] = x;
		}
	}

	public static int find(int a) {
		if (a != parent[a])
			parent[a] = find(parent[a]);
		return parent[a];
	}
}
