package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1043_거짓말 {
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사람 수
		int M = Integer.parseInt(st.nextToken()); // 파티 수
		parent = new int[N+1];
		for(int i = 1; i <= N; i++) parent[i] = i; // 부모 노드 초기화
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int[] tmp = new int[K];
		int a = 51;
		for(int i = 0; i < K; i++) {
			tmp[i] = Integer.parseInt(st.nextToken()); // 진실 아는 사람들
			a = a < tmp[i] ? a : tmp[i];
			parent[tmp[i]] = a;
		}
		
		List<Integer>[] arr = new ArrayList[M];
		
		for(int i = 0; i < M; i++) {
			arr[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int input1 = Integer.parseInt(st.nextToken());
			arr[i].add(input1);
			while(st.hasMoreTokens()) {
				int input2 = Integer.parseInt(st.nextToken());
				arr[i].add(input2);
				union(input1, input2);
			}
		}
//		for(int i = 0; i <= N; i++) System.out.print(parent[i] + " ");
		
		int res = 0;
		for(int i = 0; i < M; i++) {
			boolean flag = false;
			for(int  j = 0; j < arr[i].size(); j++) {
				for(int k = 0; k < tmp.length; k++) {
					if(find(tmp[k]) == find(parent[arr[i].get(j)])) {
						flag = true;
						break;
					}
				}
			}
			if(!flag) res++;
		}
		System.out.println(res);
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return false;
		
		if(x <= y) parent[y] = x;
		else parent[x] = y;
		return true;
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		return find(parent[x]);
	}
	
	
		
		
}
