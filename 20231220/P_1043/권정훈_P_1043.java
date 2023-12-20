package level_31_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 거짓말
// 단순 구현으로 풀어도 가능
// 유니온 파인드를 활용하여 풀이
// 진실을 아는 사람들을 입력받고 그 사람들과 같이 파티에 간 사람들을 union 연산을 통해 통합
// union 연산이 전부 끝난 뒤 진실을 아는 전체 사람들을 대상으로 해당 사람들이 없는 파티의 개수만을 세어 정답 출력

// 유니온 파인드
// 서로소인 부분집합의 표현
// 여러 노드가 있을 때 두 노드가 같은 그래프에 속해있는지 알 수 있음
// 그래프를 합치는 union(x,y) 연산과 어느 그래프에 속해있는지를 찾는 find(x) 연산으로 구성됨

public class P_1043 {

	private static int[] parent; // 부모 노드 배열
	private static List<Integer> ptlist; // 진실을 아는 사람들

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
				
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 사람의 수
		int m = Integer.parseInt(st.nextToken()); // 파티의 수

		// 자기 자신을 가리키도록 부모 노드 배열 초기화
		parent = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int pt = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수
		ptlist = new ArrayList<>(); // 진실을 아는 사람들의 배열
		
		// 진실을 아는 사람들이 없다면
		// 모든 파티에 과장된 이야기를 할 수 있으므로 파티의 수를 출력하고 종료
		if (pt == 0) {
			System.out.println(m);
			System.exit(0);
		}
		
		// 진실을 아는 사람들 입력
		for (int i = 0; i < pt; i++) {
			ptlist.add(Integer.parseInt(st.nextToken()));
		}

		// 파티원의 정보를 저장할 배열 초기화
		List<Integer>[] partyList = new ArrayList[m];
		for (int i = 0; i < m; i++) {
			partyList[i] = new ArrayList<>();
		}

		// 각 파티마다 오는 사람을 저장
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int pn = Integer.parseInt(st.nextToken()); // 이번 파티에 오는 사람의 수

			// 첫 번째 사람 세팅
			int x = Integer.parseInt(st.nextToken());
			partyList[i].add(x);
			
			// 유니온 연산
			for (int j = 1; j < pn; j++) {
				int y = Integer.parseInt(st.nextToken());
				partyList[i].add(y);
				union(x, y);
			}
		}

		// 각 파티마다 판별
		int ans = 0; // 과장을 할 수 있는 파티의 개수
		for (int i = 0; i < m; i++) {
			boolean flag = true; // 과장 가능 여부
			
			// 해당 번째의 파티에 오는 사람들을 판단하여
			for (int tmp : partyList[i]) {
				// 만약 어떤 사람이 진실을 아는 사람의 목록에 속한다면
				if (ptlist.contains(find(parent[tmp]))) {
					flag = false; // 과장을 못 하므로 false로 변경
					break;
				}
			}
			
			// 과장된 이야기를 할 수 있다면 ans 증가
			if (flag) {
				ans++;
			}
		}
		
		// 정답 출력
		System.out.println(ans);
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	private static void union(int x, int y) {
		int rx = find(x);
		int ry = find(y);
		if (ptlist.contains(ry)) {
			int tmp = rx;
			rx = ry;
			ry = tmp;
		}
		parent[ry] = rx;
	}

}
