package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16943_숫자재배치 {
	
	static String A, C;
	static int a, b, res, len;
	static boolean[] chk;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = st.nextToken();
		len = A.length();
		chk = new boolean[len];
		b = Integer.parseInt(st.nextToken());
		C = "";
		
		res = -1;
		dfs(0);
		
		System.out.println(res);
	}
	
	static void dfs(int depth) {
		if(depth == len) {
//			System.out.println(C + " : C입니다");
			
			if(Integer.parseInt(C) < b) {
				res = Math.max(res, Integer.parseInt(C));
//				System.out.println(res + " : res 입니다");
				return;
			}
		}
		for(int i = 0; i < len; i++) {
			if(chk[i]) continue;
			if(depth == 0 && A.charAt(i) == '0') continue;
			chk[i] = true;
			C += A.charAt(i);
			dfs(depth+1);
			chk[i] = false;
			C = C.substring(0, C.length()-1);
		}
		
	}
}
