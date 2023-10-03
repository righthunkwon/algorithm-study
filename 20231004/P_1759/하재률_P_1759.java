package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	static int L, C;
	static char[] input, pwd;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken()); // 암호 자릿수
		C = Integer.parseInt(st.nextToken());
		
		pwd = new char[L];
		input = new char[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			input[i] = st.nextToken().charAt(0);
		}// 입력 완
		
		Arrays.sort(input); // 사전순 정렬
		sol(0, 0);
		
	}
	
	// 모든 암호 조합을 찾는데, chk메서드로 모음1개이상 자음2개이상만 출력
	static void sol(int cnt, int st) {
		if(cnt == L) { // 암호의 길이가 L이 되면 조건에 맞는지 체크하고, 맞으면 출력 후 리턴
			if(chk(pwd)) {
				for(char c : pwd) System.out.print(c);
				System.out.println();
			}
			return;
		}
		
		// 모든 암호 조합을 찾아보자
		for(int i = st; i < C; i++) {
			pwd[cnt] = input[i];
			sol(cnt + 1, i + 1);
		}
	}
	
	// 모음 1개이상 자음 2개이상이면 true 반환
	static boolean chk(char[] pwd) {
		int a = 0; // 모음 개수
		int b = 0; // 자음 개수
		for(int i = 0; i < pwd.length; i++) {
			if(pwd[i] == 'a' || pwd[i] == 'e' || pwd[i] == 'i' || pwd[i] == 'o' || pwd[i] == 'u') a++;
			else b++;
		}
		if(a >= 1 && b >= 2) return true;
		else return false;
	}
}
