package baek;
import java.io.*;
import java.util.*;

//두개로 나눌 수 있는 조합을 모두 찾아서 (0,1)로 나눠서 표시한 뒤
//bfs를 돌면서  0끼리 연결되어있는지 , 1끼리 연결되어있는지 확인
//연결되어있다면 인구 수의 차이를 구하자 

public class Pro_17471_게리멘더링 {
	static Queue<Integer> q;
	static boolean[] visited;
	static int N, min;
	static int[] select, p;
	static List<Integer>[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		p = new int[N];
		min = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		// 인접리스트로 이어진 것 표시해놓겠다.
		arr = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				arr[i].add(Integer.parseInt(st.nextToken()) - 1);//1번마을부터 시작이므로 입력받을때 1빼서 넣어둠
			}
		} // 입력끝

		// 구역 조합 ㄱㄱ
		// 1개 고를때랑 N-1개 고를 때랑 똑같다
		for (int i = 1; i <= N / 2; i++) {
			select = new int[N];
			select(0, 0, i);
		}
		
		//결과출력
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	private static void select(int idx, int sidx, int i) {
		if (sidx == i) {
			if (div()) {// true라면 두 선거구를 나눈 조합이 가능한 방법이므로 두 선거구에 포함된 인구의 차이를 구한다.
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if (select[j] == 0)
						sum += p[j];
					else
						sum -= p[j];
				}
				if (min > Math.abs(sum)) {
					min = Math.abs(sum);
				}
			}
			return;
		}
		if (idx == N)
			return;
		
		select(idx + 1, sidx, i);
		select[idx] = 1;// 선택되면 1로 바꾸기
		select(idx + 1, sidx + 1, i);
		select[idx] = 0;// 선택안된것으로 되돌리기
	}

	private static boolean div() {
		visited = new boolean[N];
		q = new LinkedList<Integer>();
		boolean zero = true;
		boolean one = true;
		for (int i = 0; i < N; i++) {
			// 0인 마을 서로 연결되어있나 체크 ㄱㄱ 한번만 체크해야하니까 tf변수 선언
			if (select[i] == 0 && zero) {
				zero = false;
				visited[i] = true;
				q.add(i);
				bfs(0);
			}
			// 1인 마을 서로 연결되어있나 체크 ㄱㄱ
			else if (select[i] == 1 && one) {
				one = false;
				visited[i] = true;
				q.add(i);
				bfs(1);
			}
		}
		// 둘다 연결되어있나 체크돌았으면 모두 visited=true 되어있어야 서로 연결되어있는 것이다.
		// 확인
		for (int i = 0; i < N; i++) {
			if (!visited[i]) //한개라도 방문처리가 안되어있다면 그 선거구끼리 연결이 안되어있었다는 뜻
				return false;
		}
		return true;
	}

	private static void bfs(int i) {
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (Integer a : arr[curr]) {//현재 마을의 인접리스트를 꺼내서 연결된 마을 체크
				if (!visited[a] && select[a] == i) {//아직 방문 X, 같은 선거구이면 q에 더해주고 방문처리해라
					q.add(a);
					visited[a] = true;
				}
			}
		}
	}

}
