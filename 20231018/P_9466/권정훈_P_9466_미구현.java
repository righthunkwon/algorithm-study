
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 텀 프로젝트
// 구현은 어려워...
public class P_9466 {
	private static int n, cnt;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// test case
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine()); // 학생의 수
			cnt = 0; // 프로젝트 팀에 속한 학생들의 수
			arr = new int[n+1]; // 학생들의 번호
			visited = new boolean[n+1]; // 선택처리 배열

			// 배열 요소 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < n; i++) {
				if (!visited[i]) dfs(i);
			}
		}
	}

	public static void dfs(int n) {
		// 선택했을 때는 팀에 속한 학생 수 증가
		if (visited[n]) {
			cnt++;
		} 

		visited[n] = true; // 방문처리
		dfs(arr[n]);
		visited[n] = false; // 방문처리 해제
	}
}
