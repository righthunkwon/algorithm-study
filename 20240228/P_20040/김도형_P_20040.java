package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_Q20040_사이클_게임 {
	
	static int [] parent; //부모
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		parent = new int[n];
		for(int i=0;i<n;i++) {
			parent[i]=i; //자기자신을 부모로 초기화
		}
		
		for(int i=1;i<=m;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(find(a)==find(b)) { //두 점 부모 동일하다 => 사이클이 존재한다
				ans = i;
				break;
			}
			
			if (parent[a] > parent[b]) { //큰쪽이든 작은쪽이든 일관되게 부모 변경
				parent[parent[b]] = parent[a];
			} else {
				parent[parent[a]] = parent[b];
			} 
		}
		System.out.println(ans);
		
		
	}//main
	
	//부모를 구하는 find 메서드
	public static int find(int num) {
		if (num == parent[num]) {
			return num;
		}

		int result = find(parent[num]);
		parent[num] = result;
		return result;
	}
}
