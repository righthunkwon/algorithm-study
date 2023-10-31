package _20231101;

import java.io.*;
import java.util.*;

// 클래스 Edge는 Comparable<Edge>를 구현하고 있다.
// Comparable은 자바에서 제공하는 인터페이스로, 정렬 기능을 활용할 때 사용한다.
// 이걸 이용해서 클래스의 객체들을 서로 비교한다.
// 간선의 정보를 담고, 가중치를 기준으로 정렬할 수 있도록 한다.
//  -> 크루스칼 알고리즘과 같은 그래프 알고리즘에서 간선 처리하는데 유용함.
class Edge implements Comparable<Edge> {
	int start, end, cost; // 시작점, 끝점, 가중치
	
	// Edge 클래스 생성자
	// 생성자는 클래스 객체가 생성될 때 호출되는 메서드로, 객체 초기화를 담당한다.
	// 여기서는 시작점, 끝점, 가중치를 받아와서 해당 객체의 멤버 변수에 초기화한다.
	public Edge(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
	// Comparable 인터페이스의 메서드인 compareTo를 구현하고 있다.
	// 두 개의 Edge 객체를 비교하여 순서를 정하는 역할을 한다.
	// 여기선 가중치를 기준으로 비교하며, 오름차순으로 정렬한다.
	// 현재 객체의 가중치에서 다른 객체의 가중치를 뺀 값을 반환하고, 작은 순서대로 정렬.
	@Override
	public int compareTo(Edge other) {
		return this.cost - other.cost;
	}
}

public class _1647_도시분할계획 {

	static int[] parent;
	// 부모 노드 찾기
	// 크루스칼 알고리즘에서 각 노드를 찾아 집합을 구분하고, 싸이클을 방지하기 위해 사용된다
	public static int findParent(int x) {
		if (x == parent[x]) return x; // 자기자신이 부모인 경우 그대로 반환
		//아닌 경우엔 재귀호출을 통해 부모를 재귀적으로 찾아 대표 노드를 찾아서 반환함.
		return parent[x] = findParent(parent[x]);
	}
	
	// 크루스칼 알고리즘에서 합집합 연산을 수행하는 메서드, 간선을 선택하고 신장 트리를 만들 때 사용된다.
	// 두 개의 정점이 주어졌을 때 부모 노드를 찾아 서로 연결한다
	// 두 노드가 속한 집합을 합칠 수 있다
	public static void union(int a, int b) {
		a = findParent(a); // a의 부모노드를 찾아 변수 a에 저장
		b = findParent(b); // b의 부모노드를 찾아 변수 b에 저장
		// 두 개의 부모 노드를 연결
		if (a < b) parent[b] = a; // b의 부모가  a로 설정되어 같은 집합에 속하게 된다.
		else parent[a] = b; // a의 부모가 b로 설정되어 같은 집합에 속하게 된다.
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Edge> edges = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			edges.add(new Edge(A, B, C));
		}

		// 간선을 가중치 오름차순으로 정렬
		Collections.sort(edges);

		// 부모 배열 초기화
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		int maxCost = 0; // 현재까지 선택한 간선 중 가장 큰 가중치를 저장
		int totalCost = 0; // 최소 신장 트리의 가중치를 저장
		
		// 가중치 오름차순으로 정렬한 간선 리스트를 순회하면서 크루스칼 알고리즘을 수행
		for (Edge edge : edges) {
			// 현재 간선의 시작점과 끝점이 서로 같은 집합에 속해 있다면 싸이클이 형성되므로 선택하지 않는다.
			if (findParent(edge.start) != findParent(edge.end)) {
				union(edge.start, edge.end); // 선택한 두 간선의 노드를 하나의 집합으로 합친다.
				totalCost += edge.cost; // 선택한 간선의 가중치를 totalCost에 더한다.
				maxCost = Math.max(maxCost, edge.cost); // 현재까지 선택한 간선들 중 가장 큰 가중치를 저장한다.
			}
		}

		// 가장 큰 유지비를 가진 간선을 뺀다.
		totalCost -= maxCost;

		System.out.println(totalCost);
	}
}
