package _20240228;

import java.util.*;
import java.io.*;

public class _16943_숫자재배치 {
	static String A, B;
	static int max = -1;
	static boolean[] used;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = st.nextToken();
		B = st.nextToken();

		// 두 숫자의 길이가 다른경우엔 바로 -1 출력되도록 함.
		if(A.length()<=B.length()) {
			// 숫자 A크기만큼 boolean used 배열을 만든다(사용한 숫자 표시용)
			used = new boolean[A.length()];
			// 순열을 이용해서 숫자를 만든다
			per("", 0);
		}

		System.out.println(max);
	}

	static void per(String current, int depth) {
		// A길이(크기)만큼 depth가 되면 조건을 만족하는지 판단한다
		if (depth == A.length()) {
			if(current.charAt(0)!='0') {
				int num = Integer.parseInt(current);
				// B보다 작으면 조건을 만족하는 것, max와 비교하여 가장 큰 값을 찾는다
				if (num < Integer.parseInt(B)) {
					max = Math.max(max, num);
				}
			}
			return;            	
		}
		// 순열을 이용해 숫자를 조합해 나가고,
		// 선택된 숫자는 current에 추가해준다
		for (int i = 0; i < A.length(); i++) {
			if (!used[i]) {
				used[i] = true;
				per(current + A.charAt(i), depth + 1);
				used[i] = false;
			}
		}
	}
}
