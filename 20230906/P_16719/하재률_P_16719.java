package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 아스키 코드로 비교

public class BOJ_16719_zoac {
	public static boolean[] chk;
	public static char[] res;
	public static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		chk = new boolean[str.length()];
		
		sol(0, str.length()-1);

	}
	
	public static void sol(int st, int ed) {
		StringBuilder sb = new StringBuilder();
		if(st > ed) return;
		int idx = st;
		
		// a에는 가장 작은 알파벳중에 가장 먼저나온 인덱스다!!
		// a 앞에는 무조건 a인덱스의 알파벳보다 보다 큰 알파벳
		// a 뒤에는 a인덱스 알파벳이랑 같은게 나올수도 ? 있나? 있다.
		
		
		for(int i = st; i <= ed; i++) {
			if(!chk[i] && str.charAt(idx) > str.charAt(i)) {
				idx = i;
			}
		}
		chk[idx] = true;
		for(int i = 0; i < str.length(); i++) {
			if(chk[i]) sb.append(str.charAt(i)); 
		}
		
		System.out.println(sb);
		
		
		sol(idx + 1, ed);
		
		sol(st, idx - 1);
	}
}
