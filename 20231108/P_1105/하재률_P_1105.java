package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1105_팔 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 각 자리를 비교하는 문제니까 String으로 받아서 비교하는게 좋겠다
		String L = st.nextToken();
		String R = st.nextToken();
		
		int ans = 0;
		// 자리수가 다르면 8의 최소 개수는 무조건 0개
		// 자리수가 같을때만 찾아보자
		if(L.length() == R.length()) {
			for(int i = 0; i < L.length(); i++) {
				if(L.charAt(i) == R.charAt(i)) {
					if(L.charAt(i) == '8') ans++; // 앞 자리부터 똑같이 8이 나오는 개수만 세어주면 될듯
				}else {
					break;
				}
			}
		}
		
		System.out.println(ans);
		
	}
}
