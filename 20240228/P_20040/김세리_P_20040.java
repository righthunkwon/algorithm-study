package _20240228;

import java.util.*;
import java.io.*;

public class _20040_사이클게임 {
	
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n];
		// 일단 parent 배열을 채운다
		for(int i=0;i<n;i++) {
			parent[i]=i;
		}
		
		int ans = 0;
		out: for(int i=1;i<=m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 연결된 선이 이미 같은 union에 포함되어 있다면 출력한다
			if(find(a)==find(b)) {
				ans = i;
				break out;
			}
			union(a,b);
		}
		System.out.println(ans);
		
	}//main
	
	static int find(int x) {
		// x의 부모노드 값을 구한다
		if(parent[x]==x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}//find
	
	static void union(int x, int y) {
		// x, y는 같은 union에 포함되고, 부모 노드의 값을 같게 바꾼다
		x = find(x);
		y = find(y);
		
		if(x != y) {
			parent[y]=x;
		}
	}//union
	
}
