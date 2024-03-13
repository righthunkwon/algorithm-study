package _20240313;

import java.util.*;
import java.io.*;

public class _14621_나만안되는연애 {

	static class Node {
		// 시작점, 끝점, 거리
		int home, target, dist;

		public Node(int home, int target, int dist){
		    this.home = home;
		    this.target = target;
		    this.dist = dist;
		}
	}

	static List<Node> list = new ArrayList<>();
	
	// 남초 대학인지 여초 대학인지
	static boolean[] univ = new boolean[1001];
	// 부모 저장
	static int[] parent = new int[1001];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			// 남초 대학교이면 true로 저장
			univ[i] = st.nextToken().equals("M");
			// 일단 부모 전부 i값으로 저장
			parent[i] = i;
		}

		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());

			int h = Integer.parseInt(st.nextToken()); // 출발
			int t = Integer.parseInt(st.nextToken()); // 도착
			int d = Integer.parseInt(st.nextToken()); // 거리
			// 남-여, 여-남인 경우만 리스트에 추가
			if (univ[h] != univ[t])
				list.add(new Node(h, t, d));
		}
		// 거리에 따라 오름차순 정렬
		Collections.sort(list, (a, b) -> a.dist - b.dist);

		int sum = 0;

		for(Node e : list)
			// 부모 다르면 연결하고 비용 sum에 추가
			if(!findParent(e.home, e.target)){
				sum += e.dist;
				union(e.home, e.target);
			}

		boolean flag = true;
		// 모두 다 연결되었는지 확인하고, 아닐땐 flag false로 바꾼다
		for(int i=1;i<=n;i++)
			if(parent[1] != getParent(parent[i])) {
				flag = false;
				break;
			}
		
		// 그래서 flag true일 땐 sum 출력하고, 아닐땐 -1 출력한다
		System.out.println(flag? sum : -1);
		
	}//main
	
	// 부모 구하기
	static int getParent(int x){
		if(parent[x] == x) {
			return x;
		}
		return parent[x] = getParent(parent[x]);
	}
	
	// 찾은 부모 같으면 true 반환
	static boolean findParent(int a, int b){
		a = getParent(a);
		b = getParent(b);

		return a == b;
	}
	
	// 한 그룹으로 합치기
	static void union(int a, int b){
		a = getParent(a);
		b = getParent(b);

		if(b < a)
			parent[a] = b;
		else
			parent[b] = a;
	}
}
