package level_27_binary_search;

import java.io.*;
import java.util.*;

// 접두사 찾기
// 사전에 요소들을 세팅해두는 방식으로 시간초과를 방지할 수도 있다
public class P_14426 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 1; j <= str.length(); j++) {
				set.add(str.substring(0, j));
			}
		}

		int ans = 0;
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (set.contains(str)) {
				ans++;
			}
		}

		System.out.println(ans);
	}

}
