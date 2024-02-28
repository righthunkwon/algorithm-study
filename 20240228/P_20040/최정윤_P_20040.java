import java.io.*;
import java.util.*;

public class Pro_20040_사이클게임2 {
	static int[] parents;
	static int n;
	public static void main(String[] args) throws IOException {
		// 선 홀수 후 짝수 (사실 중요하지 않음!)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 점의 개수
		int m = Integer.parseInt(st.nextToken()); // 차례의 수
		parents = new int[n];
		for (int i = 0; i < n; i++) {// 본인의 부모 본인 설정
			parents[i] = i;
		}
		// 양방향
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (isCycle(a, b)) { // union
				System.out.println(i + 1);
				System.exit(0);
			}
		}
		System.out.println(0);
	}

	private static boolean isCycle(int a, int b) {
		// a,b 부모 찾아서 비교
		int a_parent = find(a);
		int b_parent = find(b);
		if(a_parent==b_parent) return true;
		parents[a_parent]=b_parent;//연결
		return false;
	}

	private static int find(int b) {
		if (b == parents[b]) return b;
		parents[b] = find(parents[b]);
		return parents[b];
	}
}
