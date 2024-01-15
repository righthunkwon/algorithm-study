package level_05_string;

import java.io.*;
import java.util.*;

// A와 B
// 연산 과정을 거꾸로 뒤집어 생각
public class P_12904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String T = br.readLine();
		br.close();
		
		// 역으로 계산(S를 T로가 아니라 T를 S로)
		for (int i = T.length() - 1; i >= S.length(); i--) {
			char ch = T.charAt(i); // 마지막 문자
			T = T.substring(0, i); // 마지막 문자 제거(A는 그냥 제거해도 되고, B는 제거한 뒤 문자열을 뒤집어야 함)
			if (ch == 'B') {
				// 문자열 뒤집기
				StringBuilder sb = new StringBuilder();
				for (int j = i - 1; j >= 0; j--) {
					sb.append(T.charAt(j));
				}
				T = sb.toString();
			}
		}
		if (S.equals(T)) System.out.println(1);
		else System.out.println(0);
	}
}
