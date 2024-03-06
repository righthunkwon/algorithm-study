package study_240306;

import java.io.*;
import java.util.*;

public class Pro_9177_단어섞기 {
	static char[] a, b, c;
	static boolean isYes;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Set<Character> set;
		StringTokenizer st;
		t: for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			a = st.nextToken().toCharArray();
			b = st.nextToken().toCharArray();
			c = st.nextToken().toCharArray();
			set = new HashSet<Character>();
			for (int i = 0; i < a.length; i++) {
				set.add(a[i]);
			}
			for (int i = 0; i < b.length; i++) {
				set.add(b[i]);
			}
			for (int i = 0; i < c.length; i++) {
				if (!set.contains(c[i])) { // a,b에 없는 거니까 절대 못만듬
					System.out.println("Data set " + tc + ": no");
					continue t;
				}
			}
			isYes = false;
			dfs(0, 0, 0);
			if (isYes)
				System.out.println("Data set " + tc + ": yes");
			else
				System.out.println("Data set " + tc + ": no");
		}
	}

	private static void dfs(int a_idx, int b_idx, int c_idx) {
		if (c_idx == c.length) {//만들어질 수 있다
			isYes = true; //tc 때문에 exit 못해서 
			return;
		}
		if (isYes) return;
		if (a_idx == a.length && b_idx == b.length) return;   //두 단어 다 봤는데 X 
		if (a_idx < a.length && c[c_idx] == a[a_idx]) { //a에 있다면
			dfs(a_idx + 1, b_idx, c_idx + 1);
		}
		if (b_idx < b.length && c[c_idx] == b[b_idx]) { //b에 있다면
			dfs(a_idx, b_idx + 1, c_idx + 1);
		}
	}
}
